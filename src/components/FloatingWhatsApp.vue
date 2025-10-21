<template>
  <a
    href="https://wa.me/18496292974?text=Hola%20Automac%2C%20necesito%20informaci%C3%B3n."
    target="_blank"
    rel="noopener noreferrer"
    aria-label="Contactar por WhatsApp"
    class="fixed bottom-4 right-4 md:bottom-6 md:right-6 z-50 inline-flex items-center gap-2 px-4 py-3 rounded-full shadow-lg transition-all duration-300 transform hover:scale-105"
    :style="{
      backgroundColor: '#25D366',
      color: '#ffffff'
    }"
  >
    <i class="lab la-whatsapp la-2x"></i>
    <span class="hidden sm:inline font-bold" style="font-family: var(--fuente-principal);">WhatsApp</span>
  </a>
</template>

<script setup>
// Componente simple sin lógica adicional; visible en todas las páginas
</script>

<style scoped>
/* Sombra y foco accesible */
a {
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.25);
}

a:focus {
  outline: 2px solid rgba(255, 255, 255, 0.9);
  outline-offset: 3px;
}
</style>