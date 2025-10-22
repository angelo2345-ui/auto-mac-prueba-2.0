package com.automac.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para recibir los datos del formulario de contacto
 * Contiene validaciones para asegurar la integridad de los datos
 */
public class ContactFormDTO {
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;
    
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El formato del correo no es válido")
    private String correo;
    
    @NotBlank(message = "El mensaje es obligatorio")
    @Size(min = 10, max = 1000, message = "El mensaje debe tener entre 10 y 1000 caracteres")
    private String mensaje;
    
    // Constructor vacío
    public ContactFormDTO() {}
    
    // Constructor con parámetros
    public ContactFormDTO(String nombre, String correo, String mensaje) {
        this.nombre = nombre;
        this.correo = correo;
        this.mensaje = mensaje;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString() {
        return "ContactFormDTO{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}