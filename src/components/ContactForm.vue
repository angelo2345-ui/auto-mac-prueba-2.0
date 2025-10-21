<template>
  <div class="bg-white rounded-xl shadow-lg p-6 mb-4">
    <h3 class="text-2xl font-bold text-gray-800 mb-6">Envíanos un mensaje</h3>
    
    <!-- Mensaje de éxito -->
    <div v-if="showSuccessMessage" class="mb-4 p-4 bg-green-100 border border-green-400 text-green-700 rounded-lg">
      <div class="flex items-center">
        <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
          <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path>
        </svg>
        ¡Mensaje enviado exitosamente! Nos pondremos en contacto contigo pronto.
      </div>
    </div>

    <!-- Mensaje de error -->
    <div v-if="showErrorMessage" class="mb-4 p-4 bg-red-100 border border-red-400 text-red-700 rounded-lg">
      <div class="flex items-center">
        <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
          <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7 4a1 1 0 11-2 0 1 1 0 012 0zm-1-9a1 1 0 00-1 1v4a1 1 0 102 0V6a1 1 0 00-1-1z" clip-rule="evenodd"></path>
        </svg>
        Hubo un error al enviar el mensaje. Por favor, intenta nuevamente.
      </div>
    </div>

    <form @submit.prevent="submitForm" class="space-y-6">
      <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div class="form-group">
          <label for="name" class="block text-sm font-medium text-gray-700 mb-1">Nombre</label>
          <input 
            id="name"
            v-model="form.name" 
            type="text" 
            class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
            placeholder="Tu nombre" 
            required 
            :disabled="isSubmitting"
          />
        </div>
        <div class="form-group">
          <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Correo electrónico</label>
          <input 
            id="email"
            v-model="form.email" 
            type="email" 
            class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
            placeholder="tu@email.com" 
            required 
            :disabled="isSubmitting"
          />
        </div>
      </div>
      <div class="form-group">
        <label for="phone" class="block text-sm font-medium text-gray-700 mb-1">Teléfono</label>
        <input 
          id="phone"
          v-model="form.phone" 
          type="text" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          placeholder="Tu número de teléfono" 
          :disabled="isSubmitting"
        />
      </div>
      <div class="form-group">
        <label for="subject" class="block text-sm font-medium text-gray-700 mb-1">Asunto</label>
        <input 
          id="subject"
          v-model="form.subject" 
          type="text" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          placeholder="Asunto de tu mensaje" 
          required 
          :disabled="isSubmitting"
        />
      </div>
      <div class="form-group">
        <label for="message" class="block text-sm font-medium text-gray-700 mb-1">Mensaje</label>
        <textarea 
          id="message"
          v-model="form.message" 
          rows="5" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          placeholder="¿En qué podemos ayudarte?" 
          required
          :disabled="isSubmitting"
        ></textarea>
      </div>
      <button 
        type="submit" 
        class="w-full py-3 px-6 bg-yellow-600 hover:bg-yellow-700 text-white font-medium rounded-lg transition-colors duration-300 flex items-center justify-center disabled:opacity-50 disabled:cursor-not-allowed"
        :style="{ backgroundColor: 'var(--color-amarillo)' }"
        :disabled="isSubmitting"
      >
        <svg v-if="isSubmitting" class="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
          <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
          <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
        </svg>
        <svg v-else xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 002 2v10a2 2 0 002 2z" />
        </svg>
        {{ isSubmitting ? 'Enviando...' : 'Enviar Mensaje' }}
      </button>
    </form>
  </div>
</template>
  
<script>
import emailjs from '@emailjs/browser'

export default {
  data() {
    return {
      form: {
        name: '',
        email: '',
        phone: '',
        subject: '',
        message: ''
      },
      isSubmitting: false,
      showSuccessMessage: false,
      showErrorMessage: false
    }
  },
  methods: {
    async submitForm() {
      this.isSubmitting = true
      this.showSuccessMessage = false
      this.showErrorMessage = false

      try {
        // Configuración de EmailJS
        const serviceID = 'service_automac' // Necesitarás configurar esto en EmailJS
        const templateID = 'template_automac' // Necesitarás configurar esto en EmailJS
        const publicKey = 'YOUR_PUBLIC_KEY' // Necesitarás obtener esto de EmailJS

        // Preparar los datos del template
        const templateParams = {
          to_email: 'info@automacdom.com.do',
          from_name: this.form.name,
          from_email: this.form.email,
          phone: this.form.phone,
          subject: this.form.subject,
          message: this.form.message,
          reply_to: this.form.email
        }

        // Enviar email usando EmailJS
        await emailjs.send(serviceID, templateID, templateParams, publicKey)
        
        this.showSuccessMessage = true
        
        // Reiniciar el formulario después de 3 segundos
        setTimeout(() => {
          this.form = {
            name: '',
            email: '',
            phone: '',
            subject: '',
            message: ''
          }
          this.showSuccessMessage = false
        }, 3000)

      } catch (error) {
        console.error('Error al enviar el email:', error)
        this.showErrorMessage = true
        
        // Ocultar mensaje de error después de 5 segundos
        setTimeout(() => {
          this.showErrorMessage = false
        }, 5000)
      } finally {
        this.isSubmitting = false
      }
    }
  }
}
</script>
  
<style scoped>
/* Estilos adicionales específicos para el formulario */
.form-group:focus-within label {
  color: var(--color-amarillo);
}
</style>
  