<template>
  <header 
    :class="[
      'fixed w-full top-0 left-0 z-50 transition-all duration-500 ease-in-out backdrop-blur-md',
      !isHeaderVisible ? '-translate-y-full opacity-0' : 'translate-y-0 opacity-100'
    ]"
    :style="{
      background: scrolled ? 'var(--color-negro)' : 'rgba(0, 0, 0, 0.8)',
      borderBottom: scrolled ? '1px solid rgba(107, 114, 128, 0.5)' : 'none',
      boxShadow: scrolled ? '0 25px 50px -12px rgba(0, 0, 0, 0.25)' : 'none'
    }"
  >
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <div class="flex items-center justify-between h-20 lg:h-24">
        <!-- Logo Section - Mejorado con gradientes y efectos más modernos -->
        <router-link 
          to="/" 
          class="flex items-center space-x-4 group transition-all duration-300 hover:scale-105 ml-2"
          @click="closeMenu"
        >
          <div class="rounded-xl shadow-lg p-2" style="background: linear-gradient(to bottom right, var(--color-amarillo), var(--color-amarillo)); border: 2px solid rgba(var(--color-amarillo), 0.2);">
            <img 
              src="/public/images/logos/Automac Imagen.png" 
              alt="Automac Logo" 
              class="h-8 w-8 sm:h-10 sm:w-10 object-contain transition-transform duration-300 group-hover:scale-110" 
            />
          </div>
          <div class="flex flex-col">
            <span class="text-white text-xl sm:text-2xl font-bold tracking-tight bg-gradient-to-r from-white to-gray-200 bg-clip-text text-transparent">
              Auto<span style="color: var(--color-amarillo);" class="drop-shadow-md">mac</span>
            </span>
            <span class="text-xs text-gray-400 font-medium tracking-wide -mt-1">Soluciones automotrices</span>
          </div>
        </router-link>

        <!-- Desktop Navigation - Mejorado con indicador activo y mejores transiciones -->
        <nav class="hidden md:flex items-center space-x-6">
          <router-link 
            to="/" 
            exact
            class="relative text-gray-300 hover:text-white font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
            :class="{ 'text-[var(--color-amarillo)]': $route.path === '/' }"
          >
            <i class="las la-home"></i>
            Inicio
            <span 
              class="absolute inset-x-1 -bottom-1 h-0.5 rounded-full transform scale-x-0 transition-transform duration-300 origin-center"
              :style="{ backgroundColor: 'var(--color-amarillo)' }"
              :class="{ 'scale-x-100': $route.path === '/' }"
            ></span>
            <span class="absolute inset-0 bg-gradient-to-r from-yellow-400/10 to-amber-500/5 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity duration-300"></span>
          </router-link>

          <router-link 
            to="/productos" 
            class="relative text-gray-300 hover:text-white font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
            :class="{ 'text-[var(--color-amarillo)]': $route.path.startsWith('/productos') }"
          >
            <i class="las la-tools"></i>
            Productos
            <span 
              class="absolute inset-x-1 -bottom-1 h-0.5 bg-yellow-400 rounded-full transform scale-x-0 transition-transform duration-300 origin-center"
              :class="{ 'scale-x-100': $route.path.startsWith('/productos') }"
            ></span>
            <span class="absolute inset-0 bg-gradient-to-r from-yellow-400/10 to-amber-500/5 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity duration-300"></span>
          </router-link>


          <router-link 
            to="/contacto" 
            class="relative text-gray-300 hover:text-white font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
            :class="{ 'text-[var(--color-amarillo)]': $route.path.startsWith('/contacto') }"
          >
            <i class="las la-envelope"></i>
            Contacto
            <span 
              class="absolute inset-x-1 -bottom-1 h-0.5 bg-yellow-400 rounded-full transform scale-x-0 transition-transform duration-300 origin-center"
              :class="{ 'scale-x-100': $route.path.startsWith('/contacto') }"
            ></span>
            <span class="absolute inset-0 bg-gradient-to-r from-yellow-400/10 to-amber-500/5 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity duration-300"></span>
          </router-link>
        </nav>

       

        <!-- Mobile Menu Button - Mejorado con animación más suave -->
        <button
          @click="toggleMenu"
          class="md:hidden relative w-10 h-10 flex items-center justify-center rounded-lg bg-white/5 transition-all duration-300 focus:outline-none focus:ring-2 focus:ring-yellow-400/50"
          :class="{ 'bg-yellow-400/10': menuActive }"
          aria-label="Toggle navigation menu"
          :aria-expanded="menuActive"
        >
          <i class="las la-bars text-2xl" :class="{ 'hidden': menuActive }"></i>
          <i class="las la-times text-2xl" :class="{ 'hidden': !menuActive }"></i>
        </button>
      </div>

      <!-- Mobile Navigation - Mejorado con mejor diseño y animaciones -->
      <div 
        :class="[
          'md:hidden overflow-hidden transition-all duration-500 ease-in-out',
          menuActive ? 'max-h-96 opacity-100' : 'max-h-0 opacity-0'
        ]"
      >
        <nav class="py-6 space-y-3 border-t border-gray-700/50 mt-4">
          <router-link 
            to="/" 
            exact
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-gray-300 hover:text-white font-semibold transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-gradient-to-r from-yellow-400/10 to-orange-500/5': $route.path === '/',
              'hover:bg-gradient-to-r hover:from-white/5 hover:to-white/2': $route.path !== '/'
            }"
          >
            <div class="flex items-center">
              <span class="text-lg">Inicio</span>
            </div>
            <svg 
              class="w-4 h-4 opacity-0 group-hover:opacity-100 transition-all duration-300 transform group-hover:translate-x-1" 
              fill="none" 
              stroke="currentColor" 
              viewBox="0 0 24 24"
            >
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
            </svg>
          </router-link>

          <router-link 
            to="/productos" 
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-gray-300 hover:text-white font-semibold transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-gradient-to-r from-yellow-400/10 to-orange-500/5': $route.path.startsWith('/productos'),
              'hover:bg-gradient-to-r hover:from-white/5 hover:to-white/2': !$route.path.startsWith('/productos')
            }"
          >
            <div class="flex items-center">
              <span class="text-lg">Productos</span>
            </div>
            <svg 
              class="w-4 h-4 opacity-0 group-hover:opacity-100 transition-all duration-300 transform group-hover:translate-x-1" 
              fill="none" 
              stroke="currentColor" 
              viewBox="0 0 24 24"
            >
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
            </svg>
          </router-link>

          <router-link 
            to="/blog" 
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-gray-300 hover:text-white font-semibold transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-gradient-to-r from-yellow-400/10 to-orange-500/5': $route.path.startsWith('/blog'),
              'hover:bg-gradient-to-r hover:from-white/5 hover:to-white/2': !$route.path.startsWith('/blog')
            }"
          >
            <div class="flex items-center">
              <span class="text-lg">Blog</span>
            </div>
            <svg 
              class="w-4 h-4 opacity-0 group-hover:opacity-100 transition-all duration-300 transform group-hover:translate-x-1" 
              fill="none" 
              stroke="currentColor" 
              viewBox="0 0 24 24"
            >
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
            </svg>
          </router-link>

          <router-link 
            to="/contacto" 
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-gray-300 hover:text-white font-semibold transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-gradient-to-r from-yellow-400/10 to-orange-500/5': $route.path.startsWith('/contacto'),
              'hover:bg-gradient-to-r hover:from-white/5 hover:to-white/2': !$route.path.startsWith('/contacto')
            }"
          >
            <div class="flex items-center">
              <span class="text-lg">Contacto</span>
            </div>
          
          </router-link>
          
         
        </nav>
      </div>
    </div>

    <!-- Mobile Menu Overlay - Mejorado con animación de entrada -->
    <div 
      v-if="menuActive"
      @click="closeMenu"
      :class="[
        'md:hidden fixed inset-0 bg-gradient-to-b from-black/50 to-black/70 backdrop-blur-sm transition-opacity duration-500',
        menuActive ? 'opacity-100' : 'opacity-0'
      ]"
    ></div>
  </header>
</template>

<script setup>
import { ref, onMounted, onUnmounted, computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

// Reactive data
const menuActive = ref(false)
const lastScrollPosition = ref(0)
const isHeaderVisible = ref(true)
const currentScrollPosition = ref(0)

// Computed properties
const scrolled = computed(() => currentScrollPosition.value > 50)

// Methods
const toggleMenu = () => {
  menuActive.value = !menuActive.value
  
  // Prevent body scroll when menu is open
  if (menuActive.value) {
    document.body.style.overflow = 'hidden'
    document.documentElement.style.overflow = 'hidden'
  } else {
    document.body.style.overflow = ''
    document.documentElement.style.overflow = ''
  }
}

const closeMenu = () => {
  menuActive.value = false
  document.body.style.overflow = ''
  document.documentElement.style.overflow = ''
}

const handleScroll = () => {
  const scrollPosition = window.pageYOffset || document.documentElement.scrollTop
  currentScrollPosition.value = scrollPosition
  
  if (scrollPosition < 0) return
  
  // Close mobile menu on scroll
  if (menuActive.value) {
    closeMenu()
  }
  
  // Header visibility logic with improved UX
  if (scrollPosition > 100) {
    if (scrollPosition > lastScrollPosition.value + 15) {
      // Scrolling down - hide header
      isHeaderVisible.value = false
    } else if (scrollPosition < lastScrollPosition.value - 10) {
      // Scrolling up - show header
      isHeaderVisible.value = true
    }
  } else {
    // Always show header at top
    isHeaderVisible.value = true
  }
  
  lastScrollPosition.value = scrollPosition
}

// Handle escape key
const handleKeydown = (event) => {
  if (event.key === 'Escape' && menuActive.value) {
    closeMenu()
  }
}

// Handle resize - close menu on large screens
const handleResize = () => {
  if (window.innerWidth >= 768 && menuActive.value) {
    closeMenu()
  }
}

// Lifecycle hooks
onMounted(() => {
  window.addEventListener('scroll', handleScroll, { passive: true })
  document.addEventListener('keydown', handleKeydown)
  window.addEventListener('resize', handleResize)
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
  document.removeEventListener('keydown', handleKeydown)
  window.removeEventListener('resize', handleResize)
  document.body.style.overflow = '' // Clean up body overflow
  document.documentElement.style.overflow = ''
})
</script>
