<template>
  <section class="bg-gray-100 py-12 pt-32">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <!-- Encabezado de la sección -->
      <div class="text-center mb-12">
        <div class="inline-block p-3 rounded-full text-white mb-4" style="background-color: var(--color-amarillo);">
          <svg class="w-8 h-8" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 11V7a4 4 0 00-8 0v4M5 9h14l1 12H4L5 9z"></path>
          </svg>
        </div>
        <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4">Nuestros Productos</h2>
        <p class="text-lg text-gray-600 max-w-3xl mx-auto">
          Ofrecemos una amplia gama de repuestos de alta calidad para maquinaria pesada, camiones y tractores.
        </p>
      </div>
      
      <!-- Filtros de categorías -->
      <div class="mb-10">
        <div class="flex flex-wrap justify-center gap-3">
          <button @click="selectedCategory = 'todos'" 
                  :class="['px-4 py-2 rounded-lg font-medium transition-all', 
                          selectedCategory === 'todos' ? 'bg-[var(--color-amarillo)] text-white' : 'bg-white text-gray-700 hover:bg-gray-200']">
            Todos
          </button>
          <button v-for="category in categories" :key="category.id"
                  @click="selectedCategory = category.id"
                  :class="['px-4 py-2 rounded-lg font-medium transition-all', 
                          selectedCategory === category.id ? 'bg-[var(--color-amarillo)] text-white' : 'bg-white text-gray-700 hover:bg-gray-200']">
            {{ category.name }}
          </button>
        </div>
      </div>
      
      <!-- Grid de productos -->
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
        <ProductCard
          v-for="product in filteredProducts"
          :key="product.id"
          :product="product"
          @show-details="openProductModal"
        />
      </div>
      
      <!-- Modal de detalles del producto -->
      <ProductModal 
        :show="showModal" 
        :product="selectedProduct" 
        whatsapp-number="18496292974"
        @close="closeProductModal" 
      />
      
      <!-- Sección de marcas asociadas -->
      <div class="mt-16  rounded-2xl  p-8">
        <div class="text-center mb-8">
          <div class="inline-flex items-center justify-center w-12 h-12 rounded-full mb-4" style="background-color: var(--color-amarillo);">
            <svg class="w-6 h-6 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 6H6a2 2 0 00-2 2v10a2 2 0 002 2h10a2 2 0 002-2v-4M14 4h6m0 0v6m0-6L10 14"/>
            </svg>
          </div>
          <h3 class="text-2xl font-bold text-gray-900 mb-4" style="font-family: var(--fuente-titulos);">
            Visite las webs de nuestras <span style="color: var(--color-amarillo);">marcas representadas</span> y contáctenos para más información sobre sus productos.
          </h3>
          <p class="text-gray-600 mb-6">
            Explore directamente los catálogos oficiales de nuestros socios comerciales y solicítenos cualquier producto específico.
          </p>
        </div>
        
        <div class="max-w-4xl mx-auto">
          <ul class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">PAI INDUSTRIES</span>
              <a href="https://www.pai.com/new-pai-products" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://www.pai.com/new-pai-products
              </a>
            </li>
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">AUTOMANN</span>
              <a href="https://www.automann.com/products" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://www.automann.com/products
              </a>
            </li>
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">KTC BROTHERS</span>
              <a href="https://ktcbrothers.com/en/business-lines/" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://ktcbrothers.com/en/business-lines/
              </a>
            </li>
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">KMP BRAND</span>
              <a href="https://www.kmpbrand.com/" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://www.kmpbrand.com/
              </a>
            </li>
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">N.Y.C GENUINE PARTS</span>
              <a href="https://www.nycofamerica.com/" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://www.nycofamerica.com/
              </a>
            </li>
            <li class="flex items-center justify-between p-4 bg-gray-50 rounded-lg hover:bg-gray-100 transition-colors duration-300">
              <span class="font-semibold text-gray-800" style="font-family: var(--fuente-principal);">PREMIER MANUFACTURING</span>
              <a href="https://www.premier-mfg.com/shop/" 
                 target="_blank" 
                 rel="noopener noreferrer"
                 class="text-blue-600 hover:text-blue-800 underline text-sm font-medium">
                https://www.premier-mfg.com/shop/
              </a>
            </li>
          </ul>
        </div>
        
        <div class="text-center mt-8">
          <p class="text-gray-600 text-sm">
            💡 <strong>¿Encontró algo que le interesa?</strong> Contáctenos y nosotros nos encargamos de importarlo para usted.
          </p>
        </div>
      </div>
    </div>
  </section>
</template>
  
<script>
import ProductCard from '../components/ProductCard.vue'
import ProductModal from '../components/ProductModal.vue'

export default {
  components: { 
    ProductCard,
    ProductModal
  },
  data() {
    return {
      selectedCategory: 'todos',
      showModal: false,
      selectedProduct: {
        name: '',
        description: '',
        image: '',
        marca: '',
        modelo: '',
        stock: ''
      },
      categories: [
        { id: 'motor', name: 'Motor' },
        { id: 'Sistema de Enfriamiento', name: 'Sistema de Enfriamiento' },
        { id: 'Transmisión / Cardán', name: 'Transmisión / Cardán' },
        { id: 'Suspensión', name: 'Suspensión' },
        { id: 'Hidráulico', name: 'Hidráulico' },
        { id: 'Filtros', name: 'Filtros' },
        { id: 'Turbo / Admisión', name: 'Turbo / Admisión' },
        { id: 'Rodamientos y Poleas', name: 'Rodamientos y Poleas' },
        { id: 'sistemas-electricos', name: 'Sistemas Eléctricos' },
        { id: 'iluminacion-cabina', name: 'Iluminación / Cabina' },
      ],
      products: [
        // Motor 
        // juego de juntas
        {
          id: 1,
          name: 'Juego de juntas',
          category: 'motor',
          description: 'Juego de juntas para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/motor/Juego de juntas.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Guías de válvulas
        {
          id: 2,
          name: 'Guía de válvulas',
          category: 'motor',
          description: 'Guía de válvulas para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/motor/Guías de válvulas.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Kit reparación motor
        {
          id: 3,
          name: 'Kit reparación motor',
          category: 'motor',
          description: 'Kit reparación motor para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/motor/Kit reparación motor.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Solenoides
        {
          id: 4,
          name: 'Solenoides',
          category: 'motor',
          description: 'Solenoides para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/solenoides_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Sellos de válvula
        {
          id: 5,
          name: 'Sellos de válvula',
          category: 'motor',
          description: 'Sellos de válvula para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/motor/Sellos de válvula.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bomba de combustible
        {
          id: 6,
          name: 'Bomba de combustible',
          category: 'motor',
          description: 'Bomba de combustible para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/motor/Bomba de combustible.png',
          stock: 'Disponible',
          marca: 'PAI; KTC; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        
        // Sistema de Enfriamiento
        //Depósito de coolant
        {
          id: 7,
          name: 'Depósito de coolant',
          category: 'Sistema de Enfriamiento',
          description: 'Depósito de coolant para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/deposito_de_coolant_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Radiadores
        {
          id: 8,
          name: 'Radiadores',
          category: 'Sistema de Enfriamiento',
          description: 'Radiadores para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/radiadores_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Coolers
        {
          id: 9,
          name: 'Coolers',
          category: 'Sistema de Enfriamiento',
          description: 'Coolers para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Sistema de Enfriamiento/Coolers.png',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Abrazaderas
        {
          id: 10,
          name: 'Abrazaderas',
          category: 'Sistema de Enfriamiento',
          description: 'Abrazaderas para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Sistema de Enfriamiento/Abrazaderas.png',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Mangueras de silicona
        {
          id: 11,
          name: 'Mangueras de silicona',
          category: 'Sistema de Enfriamiento',
          description: 'Mangueras de silicona para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Sistema de Enfriamiento/Mangueras de silicona.webp',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bombas de agua
        {
          id: 12,
          name: 'Bombas de agua',
          category: 'Sistema de Enfriamiento',
          description: 'Bombas de agua para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Sistema de Enfriamiento/Bombas de agua.png',
          stock: 'Disponible',
          marca: 'Automann, Pai, KTC, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Transmisión / Cardán
        //Kit de clutch
        {
          id: 13,
          name: 'Kit de clutch',
          category: 'Transmisión / Cardán',
          description: 'Kit de clutch para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Transmisión - Cardán/Kit de clutch.png',
          stock: 'Disponible',
          marca: 'Pai, KTC, LUKE, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Crucetas de cardán
        {
          id: 14,
          name: 'Crucetas de cardán',
          category: 'Transmisión / Cardán',
          description: 'Crucetas de cardán para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Transmisión - Cardán/Crucetas de cardán.png',
          stock: 'Disponible',
          marca: 'Pai, KTC, LUKE, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Gomas de cardán
        {
          id: 15,
          name: 'Gomas de cardán',
          category: 'Transmisión / Cardán',
          description: 'Gomas de cardán para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Transmisión - Cardán/Gomas de cardán.png',
          stock: 'Disponible',
          marca: 'Pai, KTC, LUKE, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Soportes de cardán
        {
          id: 16,
          name: 'Soportes de cardán',
          category: 'Transmisión / Cardán',
          description: 'Soportes de cardán para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Transmisión - Cardán/soportes de cardán.png',
          stock: 'Disponible',
          marca: 'Pai, KTC, LUKE, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Retenedoras
        {
          id: 17,
          name: 'Retenedoras',
          category: 'Transmisión / Cardán',
          description: 'Retenedoras para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Transmisión - Cardán/Retenedoras.png',
          stock: 'Disponible',
          marca: 'Pai, KTC, LUKE, NYC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Suspensión
        //Tensores
        {
          id: 18,
          name: 'Kit de Tensores',
          category: 'Suspensión',
          description:'Tensores para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/tensores_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bolsas de aire
        {
          id: 19,
          name: 'Yoyos',
          category: 'Suspensión',
          description:'Bolsas de aire para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/bolsas_de_aire_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Grapas
        {
          id: 20,
          name: 'Grapas',
          category: 'Suspensión',
          description:'Grapas para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/Suspensión/Grapas.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bujes
        {
          id: 21,
          name: 'Bujes',
          category: 'Suspensión',
          description:'Bujes para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/Suspensión/Bujes.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Muelles
        {
          id: 22,
          name: 'Muelles',
          category: 'Suspensión',
          description:'Muelle, Madre de muelle & Hojas',
          price: '$250.00',
          image: '/images/productos/Suspensión/Muelles.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Hidráulico 
        //Bombas hidráulicas
        {
          id: 23,
          name: 'Bombas hidráulicas',
          category: 'Hidráulico',
          description: 'Bombas hidráulicas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Bombas hidráulicas.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Válvulas de control
        {
          id: 24,
          name: 'Válvulas de control',
          category: 'Hidráulico',
          description: 'Válvulas de control para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Válvulas de control.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Cilindros hidráulicos
        {
          id: 25,
          name: 'Cilindros hidráulicos',
          category: 'Hidráulico',
          description: 'Cilindros hidráulicos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Cilindros hidráulicos.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Mangueras hidráulicas
        {
          id: 26,
          name: 'Mangueras hidráulicas',
          category: 'Hidráulico',
          description: 'Mangueras hidráulicas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Mangueras hidráulicas.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Válvulas de aire 4 y 5 vías
        {
          id: 27,
          name: 'Válvulas de aire 4/5 vías',
          category: 'Hidráulico',
          description: 'Válvulas de aire 4 y 5 vías para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Válvulas de aire 4 y 5 vías.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Gatos hidráulicos
        {
          id: 28,
          name: 'Gatos hidráulicos',
          category: 'Hidráulico',
          description: 'Gatos hidráulicos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Hidráulico/Gatos hidráulicos.png',
          stock: 'Disponible',
          marca: 'Durotruck, Automann, NYC, Pai',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros
        //Filtros Aire
        {
          id: 29,
          name: 'Filtros de Aire',
          category: 'Filtros',
          description: 'Filtros de aire para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros Aire.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros Aceite
        {
          id: 30,
          name: 'Filtros de Aceite',
          category: 'Filtros',
          description: 'Filtros de aceite para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros de aceite.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros de Cabina
        {
          id: 31,
          name: 'Filtros de Cabina',
          category: 'Filtros',
          description: 'Filtros de cabina para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros de cabina.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros Hidráulicos
        {
          id: 32,
          name: 'Filtros Hidráulico',
          category: 'Filtros',
          description: 'Filtros de hidráulico para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros Hidráulicos.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros de Combustible
        {
          id: 33,
          name: 'Filtros de Combustible',
          category: 'Filtros',
          description: 'Filtros de combustible para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros Combustible.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Filtros de Transmisión
        {
          id: 34,
          name: 'Filtros de Transmisión',
          category: 'Filtros',
          description: 'Filtros de transmisión para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Filtros/Filtros Transmisión.png',
          stock: 'Disponible',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Turbo / Admisión
        //Cartucho CHRA
        {
          id: 35,
          name: 'Cartucho CHRA',
          category: 'Turbo / Admisión',
          description: 'Cartucho CHRA para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Cartucho CHRA.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Válvula de control
        {
          id: 36,
          name: 'Válvula de control',
          category: 'Turbo / Admisión',
          description: 'Válvula de control para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Válvula de control.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Abrazadera turbo
        {
          id: 37,
          name: 'Abrazadera turbo',
          category: 'Turbo / Admisión',
          description: 'Abrazadera turbo para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Abrazadera turbo.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Carcasa compresor
        {
          id: 38,
          name: 'Carcasa compresor',
          category: 'Turbo / Admisión',
          description: 'Carcasa compresor para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Carcasa compresor.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Carcasa turbina
        {
          id: 39,
          name: 'Carcasa turbina',
          category: 'Turbo / Admisión',
          description: 'Carcasa turbina para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Carcasa turbina.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Turbo compresor
        {
          id: 40,
          name: 'Turbo compresor',
          category: 'Turbo / Admisión',
          description: 'Turbo compresor para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Turbo y Admisión/Turbo compresor.png',
          stock: 'Disponible',
          marca: 'PAI; PREMIER; KTC',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Rodamientos y Poleas 
        //Rodamientos de bola
        {
          id: 41,
          name: 'Rodamientos de bola',
          category: 'Rodamientos y Poleas',
          description: 'Rodamientos de bola para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Rodamientos y Poleas/Rodamientos de bola.png',
          stock: 'Disponible',
          marca: 'SKF; NTN; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Rodillos cónicos
        {
          id: 42,
          name: 'Rodillos cónicos',
          category: 'Rodamientos y Poleas',
          description: 'Rodillos cónicos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Rodamientos y Poleas/Rodillos cónicos.png',
          stock: 'Disponible',
          marca: 'SKF; NTN; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Chumaceras
        {
          id: 43,
          name: 'Chumaceras',
          category: 'Rodamientos y Poleas',
          description: 'Chumaceras para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Rodamientos y Poleas/Chumaceras.png',
          stock: 'Disponible',
          marca: 'SKF; NTN; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Rodamientos de aguja
        {
          id: 44,
          name: 'Rodamientos de aguja',
          category: 'Rodamientos y Poleas',
          description: 'Rodamientos de aguja para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Rodamientos y Poleas/Rodamientos de aguja.png',
          stock: 'Disponible',
          marca: 'SKF; NTN; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Correas y poleas
        {
          id: 45,
          name: 'Correas y poleas',
          category: 'Rodamientos y Poleas',
          description: 'Correas y poleas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Rodamientos y Poleas/Correas y poleas.png',
          stock: 'Disponible',
          marca: 'SKF; NTN; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },

        // Sistemas Eléctricos, Sensores e Iluminación
        //Ventiladores
        {
          id: 46,
          name: 'Ventiladores',
          category: 'sistemas-electricos',
          description: 'Ventiladores para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Ventiladores.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bombillos
        {
          id: 47,
          name: 'Bombillos',
          category: 'sistemas-electricos',
          description: 'Bombillos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Bombillos.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Fusibles
        {
          id: 48,
          name: 'Fusibles',
          category: 'sistemas-electricos',
          description: 'Fusibles para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Fusibles.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Pitos
        {
          id: 49,
          name: 'Pitos',
          category: 'sistemas-electricos',
          description: 'Pitos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Pitos.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Conectores
        {
          id: 50,
          name: 'Conectores',
          category: 'sistemas-electricos',
          description: 'Conectores para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Conectores.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Switches
        {
          id: 51,
          name: 'Switches',
          category: 'sistemas-electricos',
          description: 'Switches para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/Switches.png',
          stock: 'Disponible',
          marca: 'BOSH; HELLA',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Iluminación / Cabina 
        //Lámparas
        {
          id: 52,
          name: 'Luces',
          category: 'iluminacion-cabina',
          description: 'Lámparas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Lámparas.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Faros
        {
          id: 53,
          name: 'Faroles',
          category: 'iluminacion-cabina',
          description: 'Faros para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Faros.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Lámparas de prevención
        {
          id: 54,
          name: 'Faroles de prevención',
          category: 'iluminacion-cabina',
          description: 'Lámparas de prevención para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Lámparas de prevención.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Lámparas de trabajo
        {
          id: 55,
          name: 'Faroles de trabajo',
          category: 'iluminacion-cabina',
          description: 'Lámparas de trabajo para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Lámparas de trabajo.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Parrillas
        {
          id: 56,
          name: 'Parrillas',
          category: 'iluminacion-cabina',
          description: 'Parrillas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/parrillas_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Lámparas de trabajo
        {
          id: 57,
          name: 'Faroles de trabajo',
          category: 'iluminacion-cabina',
          description: 'Lámparas de trabajo para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Lámparas de trabajo.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Limpiabrisas
        {
          id: 58,
          name: 'Para brisas',
          category: 'iluminacion-cabina',
          description: 'Limpiabrisas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Limpiabrisas.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Espejos
        {
          id: 59,
          name: 'Espejos',
          category: 'iluminacion-cabina',
          description: 'Espejos para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/nuevos cambios img/espejos_2-removebg-preview.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Cornetas
        {
          id: 60,
          name: 'Cornetas',
          category: 'iluminacion-cabina',
          description: 'Cornetas para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Cornetas.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Accesorios de cabina
        {
          id: 61,
          name: 'Accesorios de cabina',
          category: 'iluminacion-cabina',
          description: 'Accesorios de cabina para motores diésel y sistemas de hidráulico.',
          price: '$250.00',
          image: '/images/productos/Iluminación y  Cabina/Accesorios de cabina.png',
          stock: 'Disponible',
          marca: 'KTC, NYC, JPM, Automann',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        // Nuevos productos
        // Amortiguadores (Suspensión)
        {
          id: 62,
          name: 'Amortiguadores',
          category: 'Suspensión',
          description: 'Amortiguadores para sistemas de suspensión de camiones y equipos.',
          price: '$250.00',
          image: '/images/productos/Suspensión/amortiguadores-removebg-preview.png',
          stock: 'Disponible',
          marca: 'Durotruck, Pai, KTC',
          modelo: 'Aplicaciones para vehículos pesados'
        },
        // Sensores (Sistemas Eléctricos)
        {
          id: 63,
          name: 'Sensores',
          category: 'sistemas-electricos',
          description: 'Sensores eléctricos para monitoreo y control de sistemas.',
          price: '$250.00',
          image: '/images/productos/Sistemas Eléctricos/sensores-removebg-preview.png',
          stock: 'Disponible',
          marca: 'BOSCH; HELLA',
          modelo: 'Aplicaciones para vehículos pesados'
        },
      ]
    };
  },
  computed: {
    filteredProducts() {
      if (this.selectedCategory === 'todos') {
        return this.products
      }
      return this.products.filter(product => product.category === this.selectedCategory)
    }
  },
  methods: {
    openProductModal(product) {
      this.selectedProduct = product;
      this.showModal = true;
    },
    closeProductModal() {
      this.showModal = false;
    }
  }
}
</script>
  
<style scoped>
/* Estilos adicionales con Tailwind */
</style>
  
