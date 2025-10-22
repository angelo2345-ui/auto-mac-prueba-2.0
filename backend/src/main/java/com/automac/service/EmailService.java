package com.automac.service;

import com.automac.dto.ContactFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servicio para el envío de correos electrónicos
 * Maneja el envío automático de mensajes del formulario de contacto
 */
@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    // Correo de destino configurado en application.properties
    @Value("${automac.email.to:info@automacdom.com.do}")
    private String emailDestino;
    
    // Correo de origen configurado en application.properties
    @Value("${automac.email.from:no-reply@automacdom.com.do}")
    private String emailOrigen;
    
    /**
     * Envía un correo con los datos del formulario de contacto
     * 
     * @param contactForm DTO con los datos del formulario
     * @throws Exception si hay error en el envío
     */
    public void enviarCorreoContacto(ContactFormDTO contactForm) throws Exception {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            
            // Configurar destinatario y remitente
            message.setTo(emailDestino);
            message.setFrom(emailOrigen);
            
            // Configurar reply-to para que las respuestas vayan al cliente
            message.setReplyTo(contactForm.getCorreo());
            
            // Configurar asunto
            message.setSubject("Nuevo mensaje de contacto - Automac");
            
            // Configurar cuerpo del mensaje
            String cuerpoMensaje = construirCuerpoMensaje(contactForm);
            message.setText(cuerpoMensaje);
            
            // Enviar el correo
            mailSender.send(message);
            
        } catch (Exception e) {
            throw new Exception("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
    
    /**
     * Construye el cuerpo del mensaje de correo con formato profesional
     * 
     * @param contactForm DTO con los datos del formulario
     * @return String con el cuerpo del mensaje formateado
     */
    private String construirCuerpoMensaje(ContactFormDTO contactForm) {
        StringBuilder mensaje = new StringBuilder();
        
        // Encabezado
        mensaje.append("NUEVO MENSAJE DE CONTACTO - AUTOMAC\n");
        mensaje.append("=====================================\n\n");
        
        // Información del cliente
        mensaje.append("DATOS DEL CLIENTE:\n");
        mensaje.append("------------------\n");
        mensaje.append("Nombre: ").append(contactForm.getNombre()).append("\n");
        mensaje.append("Correo: ").append(contactForm.getCorreo()).append("\n");
        mensaje.append("Fecha: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n\n");
        
        // Mensaje del cliente
        mensaje.append("MENSAJE:\n");
        mensaje.append("--------\n");
        mensaje.append(contactForm.getMensaje()).append("\n\n");
        
        // Pie del mensaje
        mensaje.append("=====================================\n");
        mensaje.append("Este mensaje fue enviado desde el formulario de contacto del sitio web de Automac.\n");
        mensaje.append("Para responder, simplemente responde a este correo.\n");
        
        return mensaje.toString();
    }
}