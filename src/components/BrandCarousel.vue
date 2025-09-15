<template>
  <div class="max-w-6xl mx-auto px-4 py-8">
    <!-- Encabezado -->
    <div class="bg-blue-800 text-white py-6 px-6 text-center rounded-t-xl">
      <h1 class="text-2xl md:text-3xl font-bold uppercase tracking-wide">
        <i class="fas fa-certificate mr-3"></i>Marcas Certificadas
      </h1>
      <p class="mt-2 text-blue-100 font-semibold">Compatibilidad Garantizada</p>
    </div>
    
    <!-- Contenido principal -->
    <div class="bg-white p-6 md:p-8 rounded-b-xl shadow-xl">
      <p class="text-lg text-gray-700 text-center mb-8 font-medium">
        Contamos con repuestos para:
      </p>
      
      <!-- Grid de marcas -->
      <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-6 gap-4 mb-8">
        <div v-for="(brand, index) in brands" :key="index" 
             class="brand-card bg-white rounded-lg p-4 text-center border border-gray-200 flex flex-col items-center justify-center">
          <div class="brand-image-container mb-3">
            <img :src="`/images/marcas/${brand}.png`" :alt="brand" class="brand-image" />
          </div>
          <span class="font-semibold text-gray-800 mt-2">{{ brand }}</span>
        </div>
      </div>
      
      <!-- Llamada a la acción -->
      <div class="bg-yellow-50 border-l-4 border-yellow-400 p-4 rounded-lg mb-6">
        <div class="flex items-start">
          <div class="flex-shrink-0">
            <i class="fas fa-question-circle text-yellow-400 text-xl mt-1"></i>
          </div>
          <div class="ml-3">
            <p class="text-sm text-yellow-700">
              <span class="font-bold">¿No lo ves aquí?</span> ¡Lo traemos para ti!
            </p>
          </div>
        </div>
      </div>
      
      <!-- Botón de contacto -->
      <div class="text-center mt-8">
        <button class="bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 px-8 rounded-full transition duration-300 transform hover:scale-105 flex items-center justify-center mx-auto">
          <i class="fas fa-paper-plane mr-2"></i> Solicitar Repuesto
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MarcasCertificadas',
  data() {
    return {
      brands: [
        'MACK', 'JOHN DEERE', 'FREIGHTLINER', 'NEW HOLLAND', 
        'INTERNATIONAL', 'CATERPILLAR', 'volvo', 'ford', 
        'KENWORTH', 'Case ih Logo', 'SCANIA', 'ZETOR'
      ]
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;700&display=swap');

.brand-card {
  transition: all 0.3s ease;
  font-family: 'Montserrat', sans-serif;
  height: auto;
  padding: 1rem;
}

.brand-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0,0,0,0.1);
}

.brand-image-container {
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.brand-image {
  max-width: 100%;
  max-height: 80px;
  object-fit: contain;
}
</style>