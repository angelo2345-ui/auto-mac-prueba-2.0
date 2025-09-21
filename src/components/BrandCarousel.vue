<template>
  <div class="w-full py-12 px-4 sm:px-6 lg:px-8">
    <!-- Encabezado elegante -->
    <div class="text-center mb-12">
      <div class="inline-flex items-center justify-center w-16 h-16 rounded-full mb-4" style="background-color: var(--color-amarillo);">
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
      <div class="w-24 h-1 mx-auto mt-4 rounded-full" style="background-color: var(--color-amarillo);"></div>
    </div>
    
    <!-- Grid de marcas con diseño profesional -->
    <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-6 gap-6 mb-12">
      <div v-for="(brand, index) in brands" :key="index" 
           class="brand-card group cursor-pointer">
        <div class="bg-white rounded-xl p-6 h-32 flex flex-col items-center justify-center shadow-md hover:shadow-xl transition-all duration-300 hover:-translate-y-2">
          <div class="brand-image-container mb-2">
            <img :src="getImagePath(brand)" :alt="brand" 
                 :class="[
                   'brand-image opacity-80 group-hover:opacity-100 transition-opacity duration-300',
                   {'automann-image': brand === 'automann'}
                 ]" />
          </div>
          <span class="font-semibold text-gray-700 text-sm text-center group-hover:text-yellow-600 transition-colors duration-300">
            {{ brand }}
          </span>
        </div>
      </div>
    </div>
    
    <!-- Sección de valor agregado -->
    <div class=" rounded-2xl p-8 mb-8">
      <div class="flex flex-col items-center text-center">
        <div class="w-12 h-12 rounded-full flex items-center justify-center mb-4" style="background-color: var(--color-amarillo);">
          <svg class="w-6 h-6 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
          </svg>
        </div>
        <h3 class="text-xl font-bold text-gray-900 mb-2">¿No encuentras tu marca?</h3>
        <p class="text-gray-600 mb-6">¡Lo traemos para ti!</p>
       
      </div>
    </div>

    <!-- Estadísticas de confianza -->
  
  </div>
</template>

<script setup>
import { ref } from 'vue'

const brands = ref([
  'pai', 'automann', 'KTC', 'KMP brand', 'N.Y.C Genuine Parts', 'Premier_Manufacturing'
])

// Función para obtener la ruta correcta de la imagen según la marca
const getImagePath = (brand) => {
  // Marcas con extensión .webp
  if (brand === 'automann' || brand === 'Premier_Manufacturing') {
    return `/images/marcas/${brand}.webp`
  }
  // Para el resto de marcas, usar .png
  return `/images/marcas/${brand}.png`
}
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

.automann-image {
  max-height: 70px !important; /* Aumentando el tamaño específicamente para Automann */
  transform: scale(1.3); /* Haciendo la imagen un 30% más grande */
}

.brand-card:hover .brand-image {
  filter: grayscale(0%);
  transform: scale(1.1);
}

.brand-card:hover .automann-image {
  transform: scale(1.4); /* Efecto hover ligeramente más grande para Automann */
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