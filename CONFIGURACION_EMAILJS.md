# Configuración de EmailJS para el Formulario de Contacto

## Pasos para configurar EmailJS

### 1. Crear cuenta en EmailJS
1. Ve a [https://www.emailjs.com/](https://www.emailjs.com/)
2. Crea una cuenta gratuita
3. Verifica tu email

### 2. Configurar el servicio de email
1. En el dashboard de EmailJS, ve a "Email Services"
2. Haz clic en "Add New Service"
3. Selecciona tu proveedor de email (Gmail, Outlook, etc.)
4. Configura las credenciales de tu email
5. Anota el **Service ID** (ejemplo: `service_automac`)

### 3. Crear template de email
1. Ve a "Email Templates"
2. Haz clic en "Create New Template"
3. Configura el template con estos campos:

**Template Variables:**
- `{{to_email}}` - Email de destino (info@automacdom.com.do)
- `{{from_name}}` - Nombre del remitente
- `{{from_email}}` - Email del remitente
- `{{phone}}` - Teléfono del remitente
- `{{subject}}` - Asunto del mensaje
- `{{message}}` - Mensaje del remitente
- `{{reply_to}}` - Email para responder

**Ejemplo de template:**
```
Asunto: Nuevo mensaje de contacto - {{subject}}

De: {{from_name}} ({{from_email}})
Teléfono: {{phone}}

Mensaje:
{{message}}

---
Este mensaje fue enviado desde el formulario de contacto de Automac.
```

4. Anota el **Template ID** (ejemplo: `template_automac`)

### 4. Obtener Public Key
1. Ve a "Account" > "General"
2. Copia tu **Public Key**

### 5. Actualizar el código
En el archivo `src/components/ContactForm.vue`, actualiza estas líneas:

```javascript
const serviceID = 'tu_service_id_aqui'
const templateID = 'tu_template_id_aqui'  
const publicKey = 'tu_public_key_aqui'
```

### 6. Configurar el email de destino
El formulario ya está configurado para enviar emails a: **info@automacdom.com.do**

### 7. Probar el formulario
1. Inicia el servidor de desarrollo: `npm run dev`
2. Ve a la página de contacto
3. Llena y envía el formulario
4. Verifica que el email llegue a info@automacdom.com.do

## Notas importantes
- EmailJS tiene un límite de 200 emails gratuitos por mes
- Para más emails, necesitarás un plan de pago
- Asegúrate de que el email de destino esté configurado correctamente
- Puedes ver los logs de envío en el dashboard de EmailJS

## Solución de problemas
- Si no llegan los emails, verifica la configuración del servicio
- Revisa la consola del navegador para errores
- Asegúrate de que las credenciales estén correctas
- Verifica que el template tenga todos los campos necesarios