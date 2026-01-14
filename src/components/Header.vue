<template class="bg-gray-50">
  <header 
    :class="[
      'fixed w-full top-0 left-0 z-50 transition-all duration-500 ease-in-out',
      !isHeaderVisible ? '-translate-y-full opacity-0' : 'translate-y-0 opacity-100'
    ]"
    :style="{
      background: 'var(--color-fondo-menu)',
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
          <div class="mt-10 mb-10">
            <img 
              src="/images/logos/Automac Imagen.png" 
              alt="Logo Automac" 
              class="h-20 w-20 sm:h-25 sm:w-25 object-contain transition-transform duration-300 group-hover:scale-110 " 
            />
          </div>
          <div class="flex flex-col">
            <span class="text-[color:var(--color-texto-menu)] text-xl sm:text-2xl font-bold tracking-tight" style="font-family: var(--fuente-titulos);">
              Auto<span style="color: var(--color-amarillo);" class="drop-shadow-md">mac</span>
            </span>
            <span class="text-xs text-[color:var(--color-texto-menu)] font-medium tracking-wide -mt-1">Soluciones automotricess</span>
          </div>
        </router-link>

        <!-- Desktop Navigation - Mejorado con indicador activo y mejores transiciones -->
        <nav class="hidden md:flex items-center space-x-6">
          <router-link 
            to="/" 
            exact
            class="relative text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
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
            to="/quienes-somos" 
            class="relative text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
            :class="{ 'text-[var(--color-amarillo)]': $route.path.startsWith('/quienes-somos') }"
          >
            <i class="las la-users"></i>
            Quiénes Somos
            <span 
              class="absolute inset-x-1 -bottom-1 h-0.5 bg-yellow-400 rounded-full transform scale-x-0 transition-transform duration-300 origin-center"
              :class="{ 'scale-x-100': $route.path.startsWith('/quienes-somos') }"
            ></span>
            <span class="absolute inset-0 bg-gradient-to-r from-yellow-400/10 to-amber-500/5 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity duration-300"></span>
          </router-link>

          <router-link 
            to="/productos" 
            class="relative text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
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
            class="relative text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
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
          <router-link 
            to="/blog" 
            class="relative text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 px-4 py-2 rounded-lg group flex items-center gap-2"
            :class="{ 'text-[var(--color-amarillo)]': $route.path.startsWith('/blog') }"
          >
            <i class="las la-rss"></i>
            Blog
            <span 
              class="absolute inset-x-1 -bottom-1 h-0.5 bg-yellow-400 rounded-full transform scale-x-0 transition-transform duration-300 origin-center"
              :class="{ 'scale-x-100': $route.path.startsWith('/blog') }"
            ></span>
            <span class="absolute inset-0 bg-gradient-to-r from-yellow-400/10 to-amber-500/5 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity duration-300"></span>
          </router-link>
        </nav>

       

        <!-- Mobile Menu Button - Corregido -->
        <button
          @click="toggleMenu"
          class="md:hidden relative w-12 h-12 flex items-center justify-center rounded-lg bg-gray-800/80 hover:bg-gray-700 transition-all duration-300 focus:outline-none focus:ring-2 focus:ring-yellow-400/50"
          :class="{ 'bg-yellow-400 hover:bg-yellow-500': menuActive }"
          aria-label="Toggle navigation menu"
          :aria-expanded="menuActive"
        >
          <i v-if="!menuActive" class="las la-bars text-2xl" :class="!menuActive ? 'text-[color:var(--color-texto-menu)]' : ''"></i>
          <i v-if="menuActive" class="las la-times text-2xl" :class="menuActive ? 'text-[color:var(--color-texto-menu)]' : 'text-white'"></i>
        </button>
      </div>

      <!-- Mobile Navigation - Sin opacidad -->
      <div 
        :class="[
          'md:hidden overflow-hidden transition-all duration-300 ease-in-out',
          menuActive ? 'max-h-screen visible' : 'max-h-0 invisible'
        ]"
        style="background: var(--color-fondo-menu);"
      >
        <nav class="py-6 space-y-2 border-t border-gray-700/50 mt-4" style="font-family: var(--fuente-principal);">
          <router-link 
            to="/" 
            exact
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-yellow-400/10': $route.path === '/',
              'hover:bg-white/5': $route.path !== '/'
            }"
            style="font-family: var(--fuente-principal);"
          >
            <div class="flex items-center gap-3">
              <i class="las la-home text-xl"></i>
              <span class="text-lg font-medium">Inicio</span>
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
            to="/quienes-somos" 
            @click="closeMenu"
            class="flex items-center justify-between px-6 py-4 text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-yellow-400/10': $route.path.startsWith('/quienes-somos'),
              'hover:bg-white/5': !$route.path.startsWith('/quienes-somos')
            }"
            style="font-family: var(--fuente-principal);"
          >
            <div class="flex items-center gap-3">
              <i class="las la-users text-xl"></i>
              <span class="text-lg font-medium">Quiénes Somos</span>
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
            class="flex items-center justify-between px-6 py-4 text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-yellow-400/10': $route.path.startsWith('/productos'),
              'hover:bg-white/5': !$route.path.startsWith('/productos')
            }"
            style="font-family: var(--fuente-principal);"
          >
            <div class="flex items-center gap-3">
              <i class="las la-tools text-xl"></i>
              <span class="text-lg font-medium">Productos</span>
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
            class="flex items-center justify-between px-6 py-4 text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-yellow-400/10': $route.path.startsWith('/blog'),
              'hover:bg-white/5': !$route.path.startsWith('/blog')
            }"
            style="font-family: var(--fuente-principal);"
          >
            <div class="flex items-center gap-3">
              <i class="las la-rss text-xl"></i>
              <span class="text-lg font-medium">Blog</span>
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
            class="flex items-center justify-between px-6 py-4 text-[color:var(--color-texto-menu)] hover:text-[color:var(--color-texto-menu)] font-medium transition-all duration-300 rounded-lg mx-2 group"
            :class="{
              'text-yellow-400 bg-yellow-400/10': $route.path.startsWith('/contacto'),
              'hover:bg-white/5': !$route.path.startsWith('/contacto')
            }"
            style="font-family: var(--fuente-principal);"
          >
            <div class="flex items-center gap-3">
              <i class="las la-envelope text-xl"></i>
              <span class="text-lg font-medium">Contacto</span>
            </div>
          
          </router-link>
          
         
        </nav>
      </div>
    </div>
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
