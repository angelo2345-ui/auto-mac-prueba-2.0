<template>
    <form @submit.prevent="submitForm" class="contact-form">
      <div class="form-group">
        <input v-model="form.name" type="text" placeholder="Nombre" required />
      </div>
      <div class="form-group">
        <input v-model="form.email" type="email" placeholder="Correo" required />
      </div>
      <div class="form-group">
        <input v-model="form.phone" type="text" placeholder="Teléfono" />
      </div>
      <div class="form-group">
        <textarea v-model="form.message" placeholder="Mensaje" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Enviar Mensaje</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        form: {
          name: '',
          email: '',
          phone: '',
          message: ''
        }
      }
    },
    methods: {
      submitForm() {
        alert(`Mensaje enviado por ${this.form.name}`)
      }
    }
  }
  </script>
  
  <style scoped>
/* Los estilos principales están en el CSS global */
</style>
  