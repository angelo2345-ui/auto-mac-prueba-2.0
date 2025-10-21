<template>
    <Header />
    <router-view />
    <Footer />
    <FloatingWhatsApp />
  </template>
  
  <script>
  import Header from './components/Header.vue'
  import Footer from './components/Footer.vue'
  import FloatingWhatsApp from './components/FloatingWhatsApp.vue'
  
  export default {
    components: { Header, Footer, FloatingWhatsApp }
  }
  </script>
  
  <style>
  
/* Los estilos globales están en main.css */
</style>
  