<template>
  <section class="relative h-screen min-h-[500px] flex items-center overflow-hidden transition-all duration-1000 ease-in-out" 
           :style="{ 
             backgroundImage: `url(${backgroundImages[currentImageIndex]})`,
             backgroundSize: 'cover',
             backgroundPosition: 'center',
             backgroundRepeat: 'no-repeat'
           }">
    <!-- Overlay con gradiente para mejorar legibilidad -->
    <div class="absolute inset-0 bg-gradient-to-r from-gray-900/80 to-gray-900/50 z-0"></div>
    
    <!-- Icono deslizar hacia abajo -->
    <div class="absolute bottom-4 left-0 right-0 flex justify-center z-30">
      <span class="animate-bounce">
        <svg class="w-10 h-10 text-yellow-400 drop-shadow-lg" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7" />
        </svg>
      </span>
    </div>

    <!-- Contenido principal -->
    <div class="container mx-auto px-4 sm:px-6 relative z-10">
      <div class="max-w-3xl mx-auto text-center bg-gray-900/70 backdrop-blur-sm p-8 rounded-2xl border border-white/10">
        <h1 class="text-4xl md:text-5xl lg:text-6xl font-bold text-white mb-6">
          <span class="text-yellow-400">Auto</span>mac - Piezas de Calidad
        </h1>
        <p class="text-xl md:text-2xl text-gray-200 mb-8 leading-relaxed">
          Tu proveedor confiable de repuestos y piezas automotrices. Calidad garantizada y entrega rápida.
        </p>
        <div class="flex flex-col sm:flex-row gap-4 justify-center">
          <a href="/productos" class="px-8 py-3 bg-yellow-500 hover:bg-yellow-600 text-gray-900 font-bold rounded-lg transition-all duration-300 transform hover:scale-105 shadow-lg">
            Ver Catálogo
          </a>
          <a href="/contacto" class="px-8 py-3 bg-transparent border-2 border-white text-white hover:bg-white hover:text-gray-900 font-bold rounded-lg transition-all duration-300">
            Contáctanos
          </a>
        </div>
      </div>
    </div>
  </section>

  <!-- Carrusel de marcas certificadas -->
  <BrandCarousel />

  <!-- Sección Nosotros -->
  <section class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6">
      <div class="max-w-3xl mx-auto text-center bg-gray-100/80 backdrop-blur-sm p-8 rounded-2xl border border-yellow-100 shadow-lg mb-12">
        <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center mx-auto mb-6">
          <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path>
          </svg>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4">Nosotros</h2>
        <p class="text-lg text-gray-700 mb-6 leading-relaxed">
          Somos una empresa dedicada a la importación, exportación y comercialización de partes para camiones, tractores y equipos industriales.
        </p>
        <p class="text-lg text-gray-700 mb-6 leading-relaxed">
          Con 15 años de experiencia en el sector, ofrecemos soluciones confiables para el mantenimiento y reparación de equipos.
        </p>
        <p class="text-lg text-yellow-700 font-semibold leading-relaxed">
          Mantener la excelencia en la distribución y comercialización de todo tipo de repuestos para el sector transporte, industrial, minería, agrícola y construcción, brindándoles el mejor servicio es nuestra misión.
        </p>
      </div>
    </div>
  </section>
  <!-- Sección de Servicios -->
  <section class="py-16 bg-gray-50">
    <div class="container mx-auto px-4 sm:px-6">
      <div class="text-center mb-16">
        <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center mx-auto mb-6">
          <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path>
          </svg>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4">Nuestros Servicios</h2>
        <p class="text-lg text-gray-600 max-w-2xl mx-auto">Ofrecemos soluciones integrales para todas tus necesidades automotrices</p>
      </div>
      
      <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
        <div class="bg-white p-8 rounded-xl shadow-lg text-center transition-transform duration-300 hover:-translate-y-2">
          <div class="w-16 h-16 bg-green-100 rounded-full flex items-center justify-center mx-auto mb-6">
            <svg class="w-8 h-8 text-green-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
            </svg>
          </div>
          <h3 class="text-xl font-bold mb-4 text-gray-900">Calidad Garantizada</h3>
          <p class="text-gray-600">Todas nuestras piezas pasan por rigurosos controles de calidad para garantizar su durabilidad y rendimiento.</p>
        </div>
        
        <div class="bg-white p-8 rounded-xl shadow-lg text-center transition-transform duration-300 hover:-translate-y-2">
          <div class="w-16 h-16 bg-blue-100 rounded-full flex items-center justify-center mx-auto mb-6">
            <svg class="w-8 h-8 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"></path>
            </svg>
          </div>
          <h3 class="text-xl font-bold mb-4 text-gray-900">Entrega Rápida</h3>
          <p class="text-gray-600">Contamos con un sistema logístico eficiente para entregas rápidas y puntuales en todo el país.</p>
        </div>
        
        <div class="bg-white p-8 rounded-xl shadow-lg text-center transition-transform duration-300 hover:-translate-y-2">
          <div class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-6">
            <svg class="w-8 h-8 text-purple-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M18.364 5.636l-3.536 3.536m0 5.656l3.536 3.536M9.172 9.172L5.636 5.636m3.536 9.192l-3.536 3.536M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path>
            </svg>
          </div>
          <h3 class="text-xl font-bold mb-4 text-gray-900">Asesoramiento Técnico</h3>
          <p class="text-gray-600">Nuestros expertos te ayudarán a encontrar la pieza perfecta para tu vehículo y necesidad específica.</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Sección de Por qué elegirnos -->
  <section class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6">
      <div class="text-center mb-16">
        <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center mx-auto mb-6">
          <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path>
          </svg>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4">¿Por qué elegirnos?</h2>
        <p class="text-lg text-gray-600 max-w-2xl mx-auto">Líderes en el sector de repuestos automotrices con años de experiencia</p>
      </div>
      
      <div class="max-w-4xl mx-auto bg-gray-50 p-8 rounded-2xl shadow-md">
        <p class="text-lg text-gray-700 mb-6 leading-relaxed">
          En <span class="font-semibold text-yellow-600">Automac</span>, nos especializamos en proporcionar piezas y repuestos de alta calidad para todo tipo de vehículos. 
          Nuestra amplia gama de productos incluye desde componentes de motor hasta accesorios de carrocería, siempre con los más altos estándares de calidad.
        </p>
        <p class="text-lg text-gray-700 mb-6 leading-relaxed">
          Trabajamos con los principales fabricantes y proveedores para garantizar que recibas productos duraderos y confiables. 
          Nuestro equipo de expertos está siempre disponible para ofrecerte asesoramiento técnico y ayudarte a encontrar exactamente lo que necesitas.
        </p>
        <p class="text-lg text-gray-700 leading-relaxed">
          Ya sea que seas un taller mecánico, un distribuidor o un particular, en Automac encontrarás soluciones a medida, 
          precios competitivos y un servicio al cliente excepcional que nos distingue de la competencia.
        </p>
      </div>
    </div>
  </section>
</template>

<script>
import BrandCarousel from '../components/BrandCarousel.vue'

export default {
  components: {
    BrandCarousel
  },
  data() {
    return {
      backgroundImages: [
        '/images/mechanic.jpg',
        '/images/tractor.jpg',
        '/images/truck.jpg'
      ],
      currentImageIndex: 0,
      intervalId: null
    }
  },
  mounted() {
    this.startSlideshow();
  },
  beforeUnmount() {
    this.stopSlideshow();
  },
  methods: {
    startSlideshow() {
      this.intervalId = setInterval(() => {
        this.nextImage();
      }, 5000);
    },
    stopSlideshow() {
      if (this.intervalId) {
        clearInterval(this.intervalId);
      }
    },
    nextImage() {
      this.currentImageIndex = (this.currentImageIndex + 1) % this.backgroundImages.length;
    }
  }
}
</script>