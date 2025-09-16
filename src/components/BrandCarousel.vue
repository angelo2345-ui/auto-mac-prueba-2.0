<template>
  <div class="w-full py-12 px-4 sm:px-6 lg:px-8">
    <!-- Encabezado elegante -->
    <div class="text-center mb-12">
      <div class="inline-flex items-center justify-center w-16 h-16 bg-yellow-500 rounded-full mb-4">
        <svg class="w-8 h-8 text-white" fill="currentColor" viewBox="0 0 24 24">
          <path d="M12 2L15.09 8.26L22 9L17 14.14L18.18 21.02L12 17.77L5.82 21.02L7 14.14L2 9L8.91 8.26L12 2Z"/>
        </svg>
      </div>
      <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-3">
        Marcas Certificadas
      </h2>
      <p class="text-xl text-gray-600 max-w-2xl mx-auto">
        Repuestos originales y compatibles para las mejores marcas del mercado
      </p>
      <div class="w-24 h-1 bg-yellow-500 mx-auto mt-4 rounded-full"></div>
    </div>
    
    <!-- Grid de marcas con diseño profesional -->
    <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-6 gap-6 mb-12">
      <div v-for="(brand, index) in brands" :key="index" 
           class="brand-card group cursor-pointer">
        <div class="bg-white rounded-xl p-6 h-32 flex flex-col items-center justify-center shadow-md hover:shadow-xl transition-all duration-300 hover:-translate-y-2">
          <div class="brand-image-container mb-2">
            <img :src="`/images/marcas/${brand}.png`" :alt="brand" class="brand-image opacity-80 group-hover:opacity-100 transition-opacity duration-300" />
          </div>
          <span class="font-semibold text-gray-700 text-sm text-center group-hover:text-yellow-600 transition-colors duration-300">
            {{ brand }}
          </span>
        </div>
      </div>
    </div>
    
    <!-- Sección de valor agregado -->
    <div class="bg-gradient-to-r from-gray-50 to-gray-100 rounded-2xl p-8 mb-8">
      <div class="flex flex-col items-center text-center">
        <div class="w-12 h-12 bg-yellow-500 rounded-full flex items-center justify-center mb-4">
          <svg class="w-6 h-6 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
          </svg>
        </div>
        <h3 class="text-xl font-bold text-gray-900 mb-2">¿No encuentras tu marca?</h3>
        <p class="text-gray-600 mb-6">¡Lo traemos para ti!</p>
        <button class="bg-yellow-500 hover:bg-yellow-600 text-white font-bold py-3 px-8 rounded-full transition-all duration-300 transform hover:scale-105 flex items-center shadow-lg">
          <svg class="w-4 h-4 mr-2" fill="currentColor" viewBox="0 0 24 24">
            <path d="M2.01 21L23 12L2.01 3L2 10L17 12L2 14L2.01 21Z"/>
          </svg>
          Contáctanos
        </button>
      </div>
    </div>

    <!-- Estadísticas de confianza -->
  
  </div>
</template>

<script setup>
import { ref } from 'vue'

const brands = ref([
  'MACK', 'JOHN DEERE', 'FREIGHTLINER', 'NEW HOLLAND', 
  'INTERNATIONAL', 'CATERPILLAR', 'volvo', 'ford', 
  'KENWORTH', 'Case ih Logo', 'SCANIA', 'ZETOR'
])
</script>

<style scoped>
.brand-card {
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

.brand-image-container {
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.brand-image {
  max-width: 100%;
  max-height: 50px;
  object-fit: contain;
  filter: grayscale(20%);
  transition: all 0.3s ease;
}

.brand-card:hover .brand-image {
  filter: grayscale(0%);
  transform: scale(1.1);
}

/* Animación sutil para el gradiente */
.bg-gradient-to-r {
  background-size: 200% 200%;
  animation: gradient-shift 8s ease infinite;
}

@keyframes gradient-shift {
  0%, 100% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
}
</style>