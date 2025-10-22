package com.automac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicación principal del backend de Automac
 * Maneja el formulario de contacto y envío de correos
 */
@SpringBootApplication
public class AutomacBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomacBackendApplication.class, args);
    }
}