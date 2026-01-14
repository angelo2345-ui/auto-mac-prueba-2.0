<template>
  <div class="bg-white rounded-xl shadow-lg p-6 mb-4">
    <h3 class="text-2xl font-bold text-gray-800 mb-6">Envíanos un mensaje</h3>
    
    <!-- Mensaje de éxito -->
    <div v-if="showSuccessMessage" class="mb-6 p-4 bg-green-100 border border-green-400 text-green-700 rounded-lg">
      <div class="flex items-center">
        <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
          <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path>
        </svg>
        ¡Gracias! Tu mensaje ha sido enviado exitosamente. Nos pondremos en contacto contigo pronto.
      </div>
    </div>

    <!-- Mensaje de error -->
    <div v-if="showErrorMessage" class="mb-6 p-4 bg-red-100 border border-red-400 text-red-700 rounded-lg">
      <div class="flex items-center">
        <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
          <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd"></path>
        </svg>
        {{ errorMessage }}
      </div>
    </div>

    <form ref="form" @submit.prevent="submitForm" class="space-y-6">
      <!-- Campo oculto para el email de destino -->
      <input type="hidden" name="to_email" value="automac.repuestos@gmail.com" />
      
      <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div class="form-group">
          <label for="name" class="block text-sm font-medium text-gray-700 mb-1">Nombre *</label>
          <input 
            id="name"
            name="from_name"
            v-model="form.name" 
            type="text" 
            class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
            placeholder="Tu nombre" 
            required 
            :disabled="isLoading"
          />
        </div>
        <div class="form-group">
          <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Correo electrónico *</label>
          <input 
            id="email"
            name="from_email"
            v-model="form.email" 
            type="email" 
            class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
            placeholder="tu@email.com" 
            required 
            :disabled="isLoading"
          />
        </div>
      </div>
      <div class="form-group">
        <label for="phone" class="block text-sm font-medium text-gray-700 mb-1">Teléfono</label>
        <input 
          id="phone"
          name="phone"
          v-model="form.phone" 
          type="text" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          placeholder="Tu número de teléfono" 
          :disabled="isLoading"
        />
      </div>
      <div class="form-group">
        <label for="subject" class="block text-sm font-medium text-gray-700 mb-1">Asunto</label>
        <select 
          id="subject"
          name="subject"
          v-model="form.subject" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          required
          :disabled="isLoading"
        >
          <option value="" disabled>Selecciona un asunto</option>
          <option value="Consulta General">Consulta General</option>
          <option value="Cotización">Cotización</option>
          <option value="Soporte">Soporte</option>
          <option value="Unete a nuestro equipo">Únete a nuestro equipo</option>
        </select>
      </div>

      <!-- File Input for CV -->
      <div v-if="form.subject === 'Unete a nuestro equipo'" class="form-group">
        <label for="cv_file" class="block text-sm font-medium text-gray-700 mb-1">Adjuntar CV (PDF, Word) *</label>
        <input 
          id="cv_file"
          name="cv_file"
          type="file" 
          accept=".pdf,.doc,.docx"
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          :disabled="isLoading"
          required
        />
        <p class="text-xs text-gray-500 mt-1">Por favor adjunta tu CV para aplicar.</p>
      </div>

      <div class="form-group">
        <label for="message" class="block text-sm font-medium text-gray-700 mb-1">Mensaje *</label>
        <textarea 
          id="message"
          name="message"
          v-model="form.message" 
          rows="5" 
          class="w-full px-4 py-3 rounded-lg border border-gray-300 focus:ring-2 focus:ring-yellow-500 focus:border-transparent transition-all" 
          placeholder="¿En qué podemos ayudarte?" 
          required
          :disabled="isLoading"
        ></textarea>
      </div>
      <button 
        type="submit" 
        class="w-full py-3 px-6 bg-yellow-600 hover:bg-yellow-700 text-white font-medium rounded-lg transition-colors duration-300 flex items-center justify-center disabled:opacity-50 disabled:cursor-not-allowed"
        :style="{ backgroundColor: isLoading ? '#9CA3AF' : 'var(--color-amarillo)' }"
        :disabled="isLoading"
      >
        <!-- Spinner de carga -->
        <svg v-if="isLoading" class="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
          <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
          <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
        </svg>
        <!-- Icono de correo -->
        <svg v-else xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
        </svg>
        {{ isLoading ? 'Enviando...' : 'Enviar Mensaje' }}
      </button>
    </form>
  </div>
</template>
  
<script>
import emailjs from '@emailjs/browser';

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
      isLoading: false,
      showSuccessMessage: false,
      showErrorMessage: false,
      errorMessage: ''
    }
  },
  mounted() {
    if (this.$route.query.subject) {
      this.form.subject = this.$route.query.subject;
    }
  },
  methods: {
    async submitForm() {
      // Resetear mensajes
      this.showSuccessMessage = false;
      this.showErrorMessage = false;
      this.errorMessage = '';
      
      // Validar campos requeridos
      if (!this.form.name.trim() || !this.form.email.trim() || !this.form.message.trim() || !this.form.subject) {
        this.showError('Por favor, completa todos los campos obligatorios.');
        return;
      }

      // Validar archivo si es necesario
      if (this.form.subject === 'Unete a nuestro equipo') {
        const fileInput = this.$el.querySelector('input[type="file"]');
        if (!fileInput || !fileInput.files || fileInput.files.length === 0) {
           this.showError('Por favor, adjunta tu CV.');
           return;
        }
      }

      this.isLoading = true;

      try {
        // Enviar email usando EmailJS sendForm
        // Esto permite enviar archivos adjuntos si el input type="file" está en el formulario
        await emailjs.sendForm(
          'service_f9wl0jh',        // Reemplazar con tu Service ID
          'template_ri35mw6',       // Reemplazar con tu Template ID
          this.$refs.form,          // Referencia al formulario HTML
          'ul8xI6kMa5JdQcuq9'         // Reemplazar con tu Public Key
        );

        this.showSuccess();
        this.resetForm();
        
        // Limpiar el input file si existe manualmente ya que no está ligado a v-model
        const fileInput = this.$el.querySelector('input[type="file"]');
        if (fileInput) fileInput.value = '';

      } catch (error) {
        console.error('Error al enviar el email:', error);
        this.showError('Error al enviar el mensaje. Por favor, intenta nuevamente o contáctanos directamente.');
      } finally {
        this.isLoading = false;
      }
    },

    showSuccess() {
      this.showSuccessMessage = true;
      // Ocultar mensaje después de 5 segundos
      setTimeout(() => {
        this.showSuccessMessage = false;
      }, 5000);
    },

    showError(message) {
      this.errorMessage = message;
      this.showErrorMessage = true;
      // Ocultar mensaje después de 8 segundos
      setTimeout(() => {
        this.showErrorMessage = false;
      }, 8000);
    },

    resetForm() {
      this.form = {
        name: '',
        email: '',
        phone: '',
        subject: '',
        message: ''
      };
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
  