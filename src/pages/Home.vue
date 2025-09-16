<template>
  <!-- Hero Section -->
<section
  class="relative h-[65vh] sm:h-[80vh] lg:h-[85vh] min-h-[500px] max-h-[800px] flex items-center overflow-hidden transition-all duration-1000 ease-in-out"
  :style="{
    backgroundImage: `url(${slides[currentSlideIndex].backgroundImage})`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat'
  }"
  aria-label="Sección principal de Automac"
>
  <!-- Overlay oscuro -->
  <div class="absolute inset-0 bg-gradient-to-r from-gray-900/90 via-gray-900/75 to-gray-900/60 z-0"></div>

  <!-- Contenido -->
  <div class="container relative z-10 px-4 sm:px-6 lg:px-8">
    <div class="max-w-4xl text-left pl-4 sm:pl-10 lg:pl-20">

      <!-- Título -->
      <h1 class="text-3xl sm:text-4xl lg:text-6xl font-extrabold text-white mb-4 sm:mb-6 leading-tight">
        <span class="text-yellow-400">
          {{ slides[currentSlideIndex].title }}
        </span>
        <span class="block text-xl sm:text-2xl lg:text-3xl mt-2 font-normal text-gray-200">
          {{ slides[currentSlideIndex].subtitle }}
        </span>
      </h1>

      <!-- Descripción -->
      <p class="text-base sm:text-lg lg:text-xl text-gray-200 leading-relaxed max-w-2xl">
        {{ slides[currentSlideIndex].description }}
      </p>

    </div>
  </div>

  <!-- Flecha: Slide anterior -->
  <button
    @click="previousSlide"
    class="absolute left-2 sm:left-4 top-1/2 transform -translate-y-1/2 z-30 bg-black/30 hover:bg-black/50 text-white p-1.5 sm:p-2 rounded-full transition-all duration-300"
    aria-label="Slide anterior"
  >
    <svg class="w-5 h-5 sm:w-6 sm:h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7" />
    </svg>
  </button>

  <!-- Flecha: Slide siguiente -->
  <button
    @click="nextSlide"
    class="absolute right-2 sm:right-4 top-1/2 transform -translate-y-1/2 z-30 bg-black/30 hover:bg-black/50 text-white p-1.5 sm:p-2 rounded-full transition-all duration-300"
    aria-label="Slide siguiente"
  >
    <svg class="w-5 h-5 sm:w-6 sm:h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
    </svg>
  </button>
</section>
   <!-- Marcas Certificadas -->

  <!-- Servicios Principales -->
  <section id="servicios" class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="text-center mb-12">
        <div class="inline-flex items-center justify-center w-16 h-16 bg-yellow-500 rounded-full mb-6">
          <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"/>
          </svg>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4">
          Servicios que <span class="text-yellow-600">Nos Destacan</span>
        </h2>
        <p class="text-xl text-gray-600 max-w-3xl mx-auto">
          Contamos con servicios integrales que complementan nuestra oferta de repuestos de alta calidad
        </p>
        <div class="w-24 h-1 bg-yellow-500 mx-auto mt-6 rounded-full"></div>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8 mb-16">
        <div class="group bg-gradient-to-br from-green-50 to-green-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-green-200">
          <div class="w-16 h-16 bg-green-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M20 7l-8-4-8 4m16 0l-8 4m8-4v10l-8 4m0-10L4 7m8 4v10M4 7v10l8 4"/>
            </svg>
          </div>
          <h3 class="text-xl font-bold text-gray-900 mb-3">Stock Inmediato</h3>
          <p class="text-gray-600">Miles de repuestos disponibles en nuestra tienda física</p>
        </div>

        <div class="group bg-gradient-to-br from-blue-50 to-blue-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-blue-200">
          <div class="w-16 h-16 bg-blue-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3.055 11H5a2 2 0 012 2v1a2 2 0 002 2 2 2 0 012 2v2.945M8 3.935V5.5A2.5 2.5 0 0010.5 8h.5a2 2 0 012 2 2 2 0 104 0 2 2 0 012-2h1.064M15 20.488V18a2 2 0 012-2h3.064"/>
            </svg>
          </div>
          <h3 class="text-xl font-bold text-gray-900 mb-3">Importación Directa</h3>
          <p class="text-gray-600">Pedidos especiales y personalizados desde fábrica</p>
        </div>

        <div class="group bg-gradient-to-br from-purple-50 to-purple-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-purple-200">
          <div class="w-16 h-16 bg-purple-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 12a9 9 0 01-9 9m9-9a9 9 0 00-9-9m9 9H3m9 9v-9m0-9v9"/>
            </svg>
          </div>
          <h3 class="text-xl font-bold text-gray-900 mb-3">Comercio Global</h3>
          <p class="text-gray-600">Red internacional de proveedores certificados</p>
        </div>

        <div class="group bg-gradient-to-br from-yellow-50 to-yellow-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-yellow-200">
          <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"/>
            </svg>
          </div>
          <h3 class="text-xl font-bold text-gray-900 mb-3">Atención Inmediata</h3>
          <p class="text-gray-600">Respuesta rápida y asesoría técnica especializada</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Sección Nosotros -->
  <section id="nosotros" class="py-16 bg-gradient-to-b from-gray-50 to-gray-100">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="max-w-6xl mx-auto">
        <!-- Encabezado -->
        <div class="text-center mb-16">
          <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-6">
            <span class="text-yellow-600">COMPROMISO</span>, Respaldo y <span class="text-yellow-600">Calidad</span>
          </h2>
          <p class="text-xl text-gray-600 max-w-3xl mx-auto">
            15 años siendo el socio confiable para el mantenimiento de tu flota
          </p>
        </div>

        <div class="grid grid-cols-1 lg:grid-cols-2 gap-12 items-center">
          <!-- Información de la empresa -->
          <div class="space-y-8">
            <div class="bg-white p-8 rounded-2xl shadow-lg border border-gray-200">
              <div class="flex items-start gap-6">
                <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center flex-shrink-0">
                  <svg class="w-8 h-8 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5M9 7h1m-1 4h1m4-4h1m-1 4h1m-5 10v-5a1 1 0 011-1h2a1 1 0 011 1v5m-4 0h4"/>
                  </svg>
                </div>
                <div>
                  <h3 class="text-2xl font-bold text-gray-900 mb-4">QUIÉNES SOMOS</h3>
                  <p class="text-gray-700 mb-4 leading-relaxed text-lg">
                    Somos especialistas en la <strong class="text-yellow-600">importación, exportación y comercialización</strong> 
                    de repuestos para camiones, tractores y equipos industriales.
                  </p>
                  <p class="text-gray-700 leading-relaxed text-lg">
                    Con <strong class="text-yellow-600">más de 15 años de experiencia</strong>, nos hemos consolidado como 
                    líderes en el sector, ofreciendo soluciones integrales para el mantenimiento preventivo y correctivo.
                  </p>
                </div>
              </div>
            </div>

            <!-- Misión destacada -->
            <div class="bg-gradient-to-r from-gray-900 to-gray-800 text-white p-8 rounded-2xl shadow-xl">
              <div class="flex items-center gap-4 mb-4">
                <svg class="w-8 h-8 text-yellow-400" fill="currentColor" viewBox="0 0 24 24">
                  <path d="M12 2L15.09 8.26L22 9L17 14.14L18.18 21.02L12 17.77L5.82 21.02L7 14.14L2 9L8.91 8.26L12 2Z"/>
                </svg>
                <h3 class="text-2xl font-bold text-yellow-400">NUESTRA MISIÓN</h3>
              </div>
              <p class="text-gray-100 leading-relaxed text-lg">
                Mantener la excelencia en la distribución de repuestos para los sectores de 
                <strong class="text-yellow-400">transporte, industrial, minería, agrícola y construcción</strong>, 
                brindando el mejor servicio y garantizando la continuidad operativa de nuestros clientes.
              </p>
            </div>
          </div>

          <!-- Características destacadas -->
          <div class="space-y-6">
            <div class="bg-yellow-50 border-l-4 border-yellow-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <svg class="w-8 h-8 text-yellow-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M20 13V6a2 2 0 00-2-2H6a2 2 0 00-2 2v7m16 0v5a2 2 0 01-2 2H6a2 2 0 01-2-2v-5m16 0h-2.586a1 1 0 00-.707.293l-2.414 2.414a1 1 0 01-.707.293h-3.172a1 1 0 01-.707-.293l-2.414-2.414A1 1 0 006.586 13H4"/>
                </svg>
                <h4 class="text-xl font-bold text-gray-900">Envíos Nacionales</h4>
              </div>
              <p class="text-gray-700 mt-2">Cobertura completa en todo el territorio nacional</p>
            </div>

            <div class="bg-green-50 border-l-4 border-green-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <svg class="w-8 h-8 text-green-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
                </svg>
                <h4 class="text-xl font-bold text-gray-900">Garantía de Calidad</h4>
              </div>
              <p class="text-gray-700 mt-2">100% repuestos originales y compatibles certificados</p>
            </div>

            <div class="bg-blue-50 border-l-4 border-blue-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <svg class="w-8 h-8 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"/>
                </svg>
                <h4 class="text-xl font-bold text-gray-900">Entrega Rápida</h4>
              </div>
              <p class="text-gray-700 mt-2">Stock disponible y tiempos de entrega optimizados</p>
            </div>

            <div class="bg-purple-50 border-l-4 border-purple-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <svg class="w-8 h-8 text-purple-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z"/>
                </svg>
                <h4 class="text-xl font-bold text-gray-900">Asesoría Técnica</h4>
              </div>
              <p class="text-gray-700 mt-2">Equipo especializado para resolver tus consultas</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
       <BrandCarousel />

  <!-- Call to Action -->
  <section class="py-16 bg-gradient-to-r from-yellow-500 to-yellow-600">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8 text-center">
      <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-6">
        ¿Necesitas un repuesto específico?
      </h2>
      <p class="text-xl text-gray-800 mb-8 max-w-2xl mx-auto">
        Contáctanos ahora y recibe una cotización personalizada. Nuestros expertos te ayudarán a encontrar 
        exactamente lo que necesitas.
      </p>
      <a href="#contacto" 
         class="inline-flex items-center px-8 py-4 bg-gray-900 hover:bg-gray-800 text-white font-bold rounded-lg transition-all duration-300 transform hover:scale-105 shadow-xl">
        <svg class="w-5 h-5 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 12h.01M12 12h.01M16 12h.01M21 12c0 4.418-4.03 8-9 8a9.863 9.863 0 01-4.255-.949L3 20l1.395-3.72C3.512 15.042 3 13.574 3 12c0-4.418 4.03-8 9-8s9 3.582 9 8z"/>
        </svg>
        Solicitar Cotización Gratuita
      </a>
    </div>
  </section>
</template>
<script>
import BrandCarousel from '../components/BrandCarousel.vue'

  
export default {
components: {
    BrandCarousel
  },  
  name: 'HeroCarousel',
  data() {
    return {
      currentSlideIndex: 0,
      autoSlideInterval: null,
      slides: [
        {
          title: 'Compromiso y Calidad',
          subtitle: 'Repuestos Premium Garantizados',
          description: '¡Contamos con servicios que complementan nuestra oferta de repuestos! Compromiso, respaldo y calidad en cada producto que ofrecemos.',
          badge: '15 años de experiencia garantizada',
          primaryButton: 'Ver Catálogo',
          backgroundImage: 'images/tractor.jpg',
          stats: [
            { value: '500+', label: 'Marcas Certificadas' },
            { value: '100%', label: 'Calidad Garantizada' },
            { value: '15+', label: 'Años de Experiencia' }
          ]
        },
        {
          title: 'Stock Disponible',
          subtitle: 'Disponibilidad Inmediata',
          description: 'Stock disponible en tienda con atención INMEDIATA. Mantenemos inventario completo para satisfacer tus necesidades al instante.',
          badge: 'Disponibilidad inmediata',
          primaryButton: 'Ver Stock',
          backgroundImage: 'images/truck.jpg',
          stats: [
            { value: '24/7', label: 'Disponibilidad' },
            { value: '1000+', label: 'Productos en Stock' },
            { value: 'HOY', label: 'Entrega Inmediata' }
          ]
        },
        {
          title: 'Importaciones',
          subtitle: 'Comercio Internacional',
          description: 'Importaciones personalizadas y comercio internacional. Somos especialistas en la importación de repuestos para equipos industriales.',
          badge: 'Importación directa',
          primaryButton: 'Solicitar Importación',
          backgroundImage: 'images/mechanic.jpg',
          stats: [
            { value: '50+', label: 'Países Proveedores' },
            { value: '30 días', label: 'Tiempo de Importación' },
            { value: '100%', label: 'Productos Originales' }
          ]
        },
        
      ]
    }
  },
  mounted() {
    this.startAutoSlide()
  },
  beforeUnmount() {
    this.stopAutoSlide()
  },
  methods: {
    setCurrentSlide(index) {
      this.currentSlideIndex = index
      this.resetAutoSlide()
    },
    nextSlide() {
      this.currentSlideIndex = (this.currentSlideIndex + 1) % this.slides.length
      this.resetAutoSlide()
    },
    previousSlide() {
      this.currentSlideIndex = this.currentSlideIndex === 0 ? this.slides.length - 1 : this.currentSlideIndex - 1
      this.resetAutoSlide()
    },
    startAutoSlide() {
      this.autoSlideInterval = setInterval(() => {
        this.nextSlide()
      }, 5000)
    },
    stopAutoSlide() {
      if (this.autoSlideInterval) {
        clearInterval(this.autoSlideInterval)
        this.autoSlideInterval = null
      }
    },
    resetAutoSlide() {
      this.stopAutoSlide()
      this.startAutoSlide()
    }
  }
}
</script>

<style scoped>
/* Animación personalizada para elementos */


/* Mejoras visuales para el hero */
.hero-content {
  backdrop-filter: blur(10px);
}

/* Optimización de imágenes de fondo */
section[style*="background-image"] {
  background-attachment: fixed;
}

@media (max-width: 768px) {
  section[style*="background-image"] {
    background-attachment: scroll;
  }
}
</style>