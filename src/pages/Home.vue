<template>
  <!-- Hero Section -->
  <section
    class="relative h-[65vh] sm:h-[80vh] lg:h-[85vh] min-h-[500px] max-h-[800px] flex items-center overflow-hidden"
    aria-label="Sección principal de Automac"
  >
    <!-- Capas de fondo precargadas -->
    <div
      v-for="(slide, index) in slides"
      :key="index"
      class="absolute inset-0 bg-cover bg-center bg-no-repeat transition-opacity duration-700 ease-in-out"
      :class="{ 'opacity-100': index === currentSlideIndex, 'opacity-0': index !== currentSlideIndex }"
      :style="{ backgroundImage: `url(${slide.backgroundImage})` }"
    ></div>

    <!-- Overlay oscuro -->
    <div class="absolute inset-0 bg-gradient-to-r from-gray-900/90 via-gray-900/75 to-gray-900/60 z-10"></div>

    <!-- Contenido con transición sincronizada -->
    <div class="container relative z-20 px-4 sm:px-6 lg:px-8">
      <div class="max-w-4xl text-left pl-4 sm:pl-10 lg:pl-20">
        <Transition name="slide-content" mode="out-in">
          <div :key="currentSlideIndex" class="content-wrapper">
            <!-- Título -->
            <h1 class="text-3xl sm:text-4xl lg:text-6xl font-extrabold text-white mb-4 sm:mb-6 leading-tight" style="font-family:var(--fuente-titulos);">
              <span style="color:var(--color-amarillo);">
                {{ slides[currentSlideIndex].title }}
              </span>
              <span class="block text-xl sm:text-2xl lg:text-3xl mt-2 font-normal text-gray-200" style="font-family:var(--fuente-principal);">
                {{ slides[currentSlideIndex].subtitle }}
              </span>
            </h1>

            <!-- Descripción -->
            <p class="text-base sm:text-lg lg:text-xl text-gray-200 leading-relaxed max-w-2xl">
              {{ slides[currentSlideIndex].description }}
            </p>
          </div>
        </Transition>
      </div>
    </div>

    <!-- Indicadores de slides -->
    <div class="absolute bottom-6 left-1/2 transform -translate-x-1/2 z-30 flex space-x-3">
      <button
        v-for="(slide, index) in slides"
        :key="index"
        @click="setCurrentSlide(index)"
        class="w-3 h-3 rounded-full transition-all duration-300"
        :class="{
          'bg-yellow-500 scale-125': index === currentSlideIndex,
          'bg-white/60 hover:bg-white/80': index !== currentSlideIndex
        }"
        :aria-label="`Ir al slide ${index + 1}`"
      ></button>
    </div>

    <!-- Flecha: Slide anterior -->
    <button
      @click="previousSlide"
      class="absolute left-2 sm:left-4 top-1/2 transform -translate-y-1/2 z-30 bg-black/30 hover:bg-black/50 text-white p-2 sm:p-3 rounded-full transition-all duration-300"
      aria-label="Slide anterior"
    >
      <i class="las la-angle-left la-2x"></i>
    </button>

    <!-- Flecha: Slide siguiente -->
    <button
      @click="nextSlide"
      class="absolute right-2 sm:right-4 top-1/2 transform -translate-y-1/2 z-30 bg-black/30 hover:bg-black/50 text-white p-2 sm:p-3 rounded-full transition-all duration-300"
      aria-label="Slide siguiente"
    >
      <i class="las la-angle-right la-2x"></i>
    </button>
  </section>
   <!-- Marcas Certificadas -->

  <!-- Nuestros Valores -->
  <section id="valores" class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="text-center mb-12">
  <div class="inline-flex items-center justify-center w-16 h-16 rounded-full mb-6" style="background-color:var(--color-amarillo);">
          <i class="las la-cogs la-3x text-white"></i>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4" style="font-family:var(--fuente-titulos);">
          Nuestros Valores
        </h2>
        <p class="text-xl text-gray-600 max-w-3xl mx-auto">
          Principios que guían nuestro trabajo y relación con cada cliente.
        </p>
  <div class="w-24 h-1 mx-auto mt-6 rounded-full" style="background-color:var(--color-amarillo);"></div>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8 mb-16">
        <div class="group bg-gradient-to-br from-green-50 to-green-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-green-200">
          <div class="w-16 h-16 bg-green-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <i class="las la-shield-alt la-3x text-white"></i>
          </div>
    <h3 class="text-xl font-bold text-gray-900 mb-3" style="font-family:var(--fuente-titulos);">Integridad</h3>
          <p class="text-gray-600">Ética, transparencia y responsabilidad en cada decisión.</p>
        </div>

        <div class="group bg-gradient-to-br from-blue-50 to-blue-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-blue-200">
          <div class="w-16 h-16 bg-blue-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <i class="las la-award la-3x text-white"></i>
          </div>
    <h3 class="text-xl font-bold text-gray-900 mb-3" style="font-family:var(--fuente-titulos);">Calidad</h3>
          <p class="text-gray-600">Garantizamos repuestos originales y compatibles certificados.</p>
        </div>

        <div class="group bg-gradient-to-br from-purple-50 to-purple-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-purple-200">
          <div class="w-16 h-16 bg-purple-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <i class="las la-handshake la-3x text-white"></i>
          </div>
    <h3 class="text-xl font-bold text-gray-900 mb-3" style="font-family:var(--fuente-titulos);">Compromiso</h3>
          <p class="text-gray-600">Acompañamos a nuestros clientes para asegurar su continuidad operativa.</p>
        </div>

        <div class="group bg-gradient-to-br from-yellow-50 to-yellow-100 p-8 rounded-2xl text-center hover:shadow-xl transition-all duration-300 transform hover:-translate-y-2 border border-yellow-200">
          <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center mx-auto mb-6 group-hover:scale-110 transition-transform">
            <i class="las la-lightbulb la-3x text-white"></i>
          </div>
    <h3 class="text-xl font-bold text-gray-900 mb-3" style="font-family:var(--fuente-titulos);">Innovación</h3>
          <p class="text-gray-600">Mejoramos procesos y soluciones para superar expectativas.</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Sección Nosotros -->
  <section id="nosotros" class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="max-w-6xl mx-auto">
        <!-- Encabezado -->
        <div class="text-center mb-16">
          <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-6" style="font-family:var(--fuente-titulos);">
            Compromiso, Respaldo y Calidad
          </h2>
          <p class="text-xl text-gray-600 max-w-3xl mx-auto">
            15 años siendo el socio confiable para el mantenimiento de tu flota
          </p>
        </div>

        <div class="grid grid-cols-1 lg:grid-cols-2 gap-12 items-start">
          <!-- Información de la empresa -->
          <div class="space-y-8">
            <div class="bg-white p-8 rounded-2xl shadow-lg border border-gray-200">
              <div class="flex items-start gap-6">
                <div class="w-16 h-16 bg-yellow-500 rounded-full flex items-center justify-center flex-shrink-0">
                  <i class="la la-users la-2x text-white"></i>
                </div>
                <div>
                  <h3 class="text-2xl font-bold text-gray-900 mb-4" style="font-family:var(--fuente-titulos);">MISIÓN</h3>
                  <p class="text-gray-700 mb-4 leading-relaxed text-lg">
                    Somos especialistas en la <strong>importación, exportación y comercialización</strong> 
                    de repuestos para camiones, tractores y equipos industriales.
                  </p>
                  <p class="text-gray-700 leading-relaxed text-lg">
                    Con <strong>más de 15 años de experiencia</strong>, nos hemos consolidado como 
                    líderes en el sector, ofreciendo soluciones integrales para el mantenimiento preventivo y correctivo.
                  </p>
                </div>
              </div>
            </div>

            <!-- Misión destacada -->
            <div class="bg-gradient-to-r from-gray-900 to-gray-800 text-white p-8 rounded-2xl shadow-xl">
              <div class="flex items-center gap-4 mb-4">
                <i class="la la-bullseye la-2x" style="color:var(--color-amarillo);"></i>
                <h3 class="text-2xl font-bold" style="font-family:var(--fuente-titulos);">VISIÓN</h3>
              </div>
              <p class="text-gray-100 leading-relaxed text-lg">
                Mantener la excelencia en la distribución de repuestos para el sector de 
                <strong>transporte, industrial, minería, agrícola y construcción</strong>, 
                brindando el mejor servicio y garantizando la continuidad operativa de nuestros clientes.
              </p>
            </div>
          </div>

          <!-- Características destacadas / Valores -->
          <div class="space-y-6">
             <!-- <h3 class="text-3xl md:text-4xl font-bold text-gray-900" style="font-family:var(--fuente-titulos);">Valores</h3>-->
            <div class="bg-yellow-50 border-l-4 p-6 rounded-r-xl" style="border-color:var(--color-amarillo);">
              <div class="flex items-center gap-4">
                <i class="la la-truck la-2x" style="color:var(--color-amarillo);"></i>
                <h4 class="text-xl font-bold text-gray-900" style="font-family:var(--fuente-titulos);">Envíos Nacionales</h4>
              </div>
              <p class="text-gray-700 mt-2">Cobertura completa en todo el territorio nacional</p>
            </div>

            <div class="bg-green-50 border-l-4 border-green-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <i class="la la-certificate la-2x text-green-600"></i>
                <h4 class="text-xl font-bold text-gray-900" style="font-family:var(--fuente-titulos);">Garantía de Calidad</h4>
              </div>
              <p class="text-gray-700 mt-2">100% repuestos originales y compatibles certificados</p>
            </div>

            <div class="bg-blue-50 border-l-4 border-blue-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <i class="la la-shipping-fast la-2x text-blue-600"></i>
                <h4 class="text-xl font-bold text-gray-900" style="font-family:var(--fuente-titulos);">Entrega Rápida</h4>
              </div>
              <p class="text-gray-700 mt-2">Stock disponible y tiempos de entrega optimizados</p>
            </div>

            <div class="bg-purple-50 border-l-4 border-purple-500 p-6 rounded-r-xl">
              <div class="flex items-center gap-4">
                <i class="la la-user-cog la-2x text-purple-600"></i>
                <h4 class="text-xl font-bold text-gray-900" style="font-family:var(--fuente-titulos);">Asesoría Técnica</h4>
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
        <section class="py-16" style="background:linear-gradient(90deg, var(--color-amarillo) 0%, var(--color-amarillo) 100%);">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8 text-center">
  <h2 class="text-3xl md:text-4xl mb-6" style="font-family:var(--fuente-titulos);color:var(--color-negro);font-weight:bold;">
        ¿Quieres ver todos nuestros productos?
      </h2>
      <p class="text-xl text-gray-800 mb-8 max-w-2xl mx-auto">
        Explora nuestro catálogo completo y encuentra el repuesto ideal para tu camión, tractor o equipo industrial.
      </p>
      <a href="/productos"
         class="inline-flex items-center px-8 py-4 text-white font-bold rounded-lg transition-all duration-300 transform hover:scale-105 shadow-xl"
         style="background-color:var(--color-negro);">
        <i class="la la-search la-lg mr-2" style="color:var(--color-amarillo);"></i>
        Ver todos los productos
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
      imagesLoaded: false,
      slides: [
        {
          title: 'Compromiso y Calidad',
          subtitle: 'Suministros para camiones y tractores',
          description: '¡Contamos con servicios que complementan nuestra oferta de suministros para camiones y tractores! Compromiso, respaldo y calidad en cada producto que ofrecemos.',
          badge: '15 años de experiencia garantizada',
          primaryButton: 'Ver Catálogo',
          backgroundImage: 'images/tractor.webp',
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
          backgroundImage: 'images/truck_1.webp',
          stats: [
            { value: '24/7', label: 'Disponibilidad' },
            { value: '1000+', label: 'Productos en Stock' },
            { value: 'HOY', label: 'Entrega Inmediata' }
          ]
        },
        {
          title: 'Importaciones',
          subtitle: 'Comercio Internacional',
          description: 'Importaciones y soluciones en comercio internacional. Contamos con amplia experiencia en repuestos para equipos industriales.',
          badge: 'Importación directa',
          primaryButton: 'Solicitar Importación',
          backgroundImage: 'images/logos/exportaciones.avif',
          stats: [
            { value: '50+', label: 'Países Proveedores' },
            { value: '30 días', label: 'Tiempo de Importación' },
            { value: '100%', label: 'Productos Originales' }
          ]
        },
        {
          title: 'Agricultura',
          subtitle: 'Soluciones para maquinaria agrícola',
          description: 'Suministros y componentes para tractores, cosechadoras y equipos agrícolas. Calidad y respaldo para el campo.',
          badge: 'Sector agrícola',
          primaryButton: 'Conocer más',
          backgroundImage: 'images/mechanic_1.webp',
          stats: [
            { value: '100+', label: 'Referencias agrícolas' },
            { value: '24/7', label: 'Soporte y asesoría' },
            { value: '100%', label: 'Calidad Garantizada' }
          ]
        },
        {
          title: 'Construcción e industria',
          subtitle: 'Soluciones para construcción e industria',
          description: 'Componentes y suministros para equipos de construcción e industria: calidad, respaldo y disponibilidad.',
          badge: 'Sector construcción',
          primaryButton: 'Conocer más',
          backgroundImage: 'images/inicio/construccion.jpg',
          stats: [
            { value: '200+', label: 'Referencias industriales' },
            { value: '24/7', label: 'Soporte y asesoría' },
            { value: '100%', label: 'Calidad Garantizada' }
          ]
        },
        {
          title: 'Minería',
          subtitle: 'Soluciones para equipos de minería',
          description: 'Componentes y suministros resistentes para operaciones mineras. Calidad y respaldo en ambientes extremos.',
          badge: 'Sector minería',
          primaryButton: 'Conocer más',
          backgroundImage: 'images/inicio/vista-de-la-maquinaria-pesada-utilizada-en-la-industria-de-la-construccion.jpg',
          stats: [
            { value: '150+', label: 'Referencias mineras' },
            { value: '24/7', label: 'Soporte y asesoría' },
            { value: '100%', label: 'Calidad Garantizada' }
          ]
        }
      ]
    }
  },
  mounted() {
    this.preloadImages().then(() => {
      this.imagesLoaded = true
      this.startAutoSlide()
    })
  },
  beforeUnmount() {
    this.stopAutoSlide()
  },
  methods: {
    // Precarga todas las imágenes para evitar peticiones durante las transiciones
    preloadImages() {
      const imagePromises = this.slides.map(slide => {
        return new Promise((resolve, reject) => {
          const img = new Image()
          img.onload = resolve
          img.onerror = reject
          img.src = slide.backgroundImage
        })
      })
      
      return Promise.all(imagePromises)
    },
    
    setCurrentSlide(index) {
      if (index !== this.currentSlideIndex) {
        this.currentSlideIndex = index
        this.resetAutoSlide()
      }
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
      if (this.imagesLoaded) {
        this.autoSlideInterval = setInterval(() => {
          this.nextSlide()
        }, 5000)
      }
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
/* Transiciones para el contenido del slide */
.slide-content-enter-active,
.slide-content-leave-active {
  transition: all 0.7s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.slide-content-enter-from {
  opacity: 0;
  transform: translateX(30px);
}

.slide-content-leave-to {
  opacity: 0;
  transform: translateX(-30px);
}

.slide-content-enter-to,
.slide-content-leave-from {
  opacity: 1;
  transform: translateX(0);
}

/* Contenedor del contenido para asegurar transiciones fluidas */
.content-wrapper {
  display: block;
}

/* Optimización de rendimiento para las capas de fondo */
.bg-cover {
  will-change: opacity;
  backface-visibility: hidden;
  -webkit-backface-visibility: hidden;
}

/* Mejoras visuales para el hero */
.hero-content {
  backdrop-filter: blur(10px);
}

/* Preloader para mejorar la experiencia inicial */
.carousel-preloader {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 100;
}

/* Optimización para dispositivos móviles */
@media (max-width: 768px) {
  .slide-content-enter-from,
  .slide-content-leave-to {
    transform: translateY(20px);
  }
  
  .slide-content-leave-to {
    transform: translateY(-20px);
  }
}

/* Mejora de rendimiento para las animaciones */
* {
  -webkit-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
}

/* Suavizado de las transiciones de opacidad */
.transition-opacity {
  transition-property: opacity;
  transition-timing-function: cubic-bezier(0.25, 0.46, 0.45, 0.94);
}
</style>
