<template>
  <div class="bg-white rounded-xl shadow-lg p-6 mb-4">
    <h3 class="text-2xl font-bold text-gray-800 mb-6">Envíanos un mensaje</h3>
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
        ></textarea>
      </div>
      <button 
        type="submit" 
        class="w-full py-3 px-6 bg-yellow-600 hover:bg-yellow-700 text-white font-medium rounded-lg transition-colors duration-300 flex items-center justify-center"
        :style="{ backgroundColor: 'var(--color-amarillo)' }"
      >
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
        </svg>
        Enviar Mensaje
      </button>
    </form>
  </div>
</template>
  
<script>
export default {
  data() {
    return {
      form: {
        name: '',
        email: '',
        phone: '',
        subject: '',
        message: ''
      }
    }
  },
  methods: {
    submitForm() {
      // Aquí se podría implementar la lógica para enviar el formulario a un servidor
      alert(`Gracias ${this.form.name}! Tu mensaje ha sido enviado. Nos pondremos en contacto contigo pronto.`);
      // Reiniciar el formulario
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
  