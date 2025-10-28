package com.automac.controller;

import com.automac.dto.ContactFormDTO;
import com.automac.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST para manejar las solicitudes del formulario de contacto
 * Endpoint: /api/contacto
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "https://automacdom.com.do"})
public class ContactController {
    
    @Autowired
    private EmailService emailService;
    
    /**
     * Endpoint POST para recibir los datos del formulario de contacto
     * y enviar el correo automáticamente
     * 
     * @param contactForm DTO con los datos del formulario (nombre, correo, mensaje)
     * @return ResponseEntity con el resultado de la operación
     */
    @PostMapping("/contacto")
    public ResponseEntity<Map<String, Object>> enviarContacto(@Valid @RequestBody ContactFormDTO contactForm) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Enviar el correo usando el servicio de email
            emailService.enviarCorreoContacto(contactForm);
            
            // Respuesta exitosa
            response.put("success", true);
            response.put("message", "Mensaje enviado correctamente. Nos pondremos en contacto contigo pronto.");
            response.put("timestamp", System.currentTimeMillis());
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            // Manejo de errores
            response.put("success", false);
            response.put("message", "Error al enviar el mensaje. Por favor, inténtalo de nuevo más tarde.");
            response.put("error", e.getMessage());
            response.put("timestamp", System.currentTimeMillis());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    /**
     * Endpoint GET para verificar que el servicio está funcionando
     * 
     * @return ResponseEntity con información del servicio
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Automac Backend");
        response.put("status", "running");
        response.put("version", "1.0.0");
        response.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }
}