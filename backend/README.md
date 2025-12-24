# Automac Backend Service

Backend en Java Spring Boot para manejar el formulario de contacto del sitio web de Automac.

## 🚀 Características

- **API REST** para recibir datos del formulario de contacto.
- **Envío automático de correos** a info@automacdom.com.do
- **Validación de datos** con mensajes de error personalizados
- **CORS habilitado** para integración con el frontend
- **Configuración flexible** de SMTP
- **Logging detallado** para debugging

## 📋 Requisitos

- Java 17 o superior
- Maven 3.6 o superior
- Cuenta de correo con SMTP habilitado (Gmail recomendado)

## 🛠️ Instalación

### 1. Clonar y navegar al directorio

```bash
cd backend
```

### 2. Configurar el correo SMTP

Edita el archivo `src/main/resources/application.properties`:

```properties
# Reemplaza con tus credenciales reales
spring.mail.username=tu_email@gmail.com
spring.mail.password=tu_app_password_de_gmail

# Ajusta los correos de destino y origen
automac.email.to=info@automacdom.com.do
automac.email.from=no-reply@automacdom.com.do
```

### 3. Generar contraseña de aplicación (Gmail)

1. Ve a tu cuenta de Google
2. Seguridad → Verificación en 2 pasos
3. Contraseñas de aplicaciones
4. Genera una nueva contraseña para "Automac Backend"
5. Usa esta contraseña en `spring.mail.password`

### 4. Compilar y ejecutar

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn spring-boot:run
```

El servidor estará disponible en: `http://localhost:8080`

## 🔗 API Endpoints

### POST /api/contacto

Recibe los datos del formulario de contacto y envía el correo automáticamente.

**Request Body:**
```json
{
  "nombre": "Juan Pérez",
  "correo": "juan@ejemplo.com",
  "mensaje": "Necesito información sobre repuestos para mi camión."
}
```

**Response (Éxito):**
```json
{
  "success": true,
  "message": "Mensaje enviado correctamente. Nos pondremos en contacto contigo pronto.",
  "timestamp": 1640995200000
}
```

**Response (Error):**
```json
{
  "success": false,
  "message": "Error al enviar el mensaje. Por favor, inténtalo de nuevo más tarde.",
  "error": "Detalles del error",
  "timestamp": 1640995200000
}
```

### GET /api/status

Verifica que el servicio esté funcionando.

**Response:**
```json
{
  "service": "Automac Backend",
  "status": "running",
  "version": "1.0.0",
  "timestamp": 1640995200000
}
```

## 🌐 Integración con el Frontend

### Actualizar el formulario de contacto

En tu componente Vue.js `ContactForm.vue`, actualiza la función de envío:

```javascript
// Función para enviar el formulario
const enviarFormulario = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/contacto', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        nombre: form.nombre,
        correo: form.correo,
        mensaje: form.mensaje
      })
    });

    const result = await response.json();

    if (result.success) {
      // Mostrar mensaje de éxito
      alert('¡Mensaje enviado correctamente!');
      // Limpiar formulario
      form.nombre = '';
      form.correo = '';
      form.mensaje = '';
    } else {
      // Mostrar mensaje de error
      alert('Error al enviar el mensaje: ' + result.message);
    }
  } catch (error) {
    console.error('Error:', error);
    alert('Error de conexión. Por favor, inténtalo de nuevo.');
  }
};
```

## 🔧 Configuración para Producción

### Variables de Entorno

Para producción, usa variables de entorno en lugar de hardcodear credenciales:

```bash
export SPRING_MAIL_USERNAME=tu_email@gmail.com
export SPRING_MAIL_PASSWORD=tu_app_password
export AUTOMAC_EMAIL_TO=info@automacdom.com.do
export AUTOMAC_EMAIL_FROM=no-reply@automacdom.com.do
export SERVER_PORT=8080
```

### Compilar JAR para producción

```bash
mvn clean package
java -jar target/automac-backend-1.0.0.jar
```

## 📧 Formato del Correo Enviado

El correo que se envía tiene el siguiente formato:

```
Asunto: Nuevo mensaje de contacto - Automac

NUEVO MENSAJE DE CONTACTO - AUTOMAC
=====================================

DATOS DEL CLIENTE:
------------------
Nombre: Juan Pérez
Correo: juan@ejemplo.com
Fecha: 31/12/2023 14:30:25

MENSAJE:
--------
Necesito información sobre repuestos para mi camión.

=====================================
Este mensaje fue enviado desde el formulario de contacto del sitio web de Automac.
Para responder, simplemente responde a este correo.
```

## 🐛 Troubleshooting

### Error de autenticación SMTP

- Verifica que la contraseña de aplicación sea correcta
- Asegúrate de que la verificación en 2 pasos esté habilitada en Gmail
- Revisa que el usuario y contraseña estén bien configurados

### Error de CORS

- Verifica que el frontend esté en la lista de orígenes permitidos
- El controlador ya incluye CORS para localhost:5173, localhost:5174 y automacdom.com.do

### Puerto ocupado

- Cambia el puerto en `application.properties`: `server.port=8081`
- O mata el proceso que usa el puerto 8080

## 📝 Logs

Los logs se muestran en la consola. Para debugging de correos, está habilitado el logging de Spring Mail.

## 🤝 Soporte

Para soporte técnico, contacta al equipo de desarrollo de Automac.
