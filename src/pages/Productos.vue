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
            Visite las webs de nuestras <span style="color: var(--color-amarillo);">marcas asociadas</span> para importarla para usted
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
        { id: 'sistemas-electricos', name: 'Sistemas Eléctricos, Sensores e Iluminación' },
        { id: 'mantenimiento-general', name: 'Mantenimiento y Partes Generales' },
        { id: 'frenos', name: 'Frenos' }
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
          image: '/images/productos/motor/Solenoides.png',
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
          image: '/images/productos/Sistema de Enfriamiento/Depósito de coolant.png',
          stock: 'Disponible',
          marca: 'VALEO; GATES; DAYCO; BAND',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Radiadores
        {
          id: 8,
          name: 'Radiadores',
          category: 'Sistema de Enfriamiento',
          description: 'Radiadores para motores diésel y sistemas de transmisión.',
          price: '$250.00',
          image: '/images/productos/Sistema de Enfriamiento/Radiadores.webp',
          stock: 'Disponible',
          marca: 'VALEO; GATES; DAYCO; BAND',
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
          marca: 'VALEO; GATES; DAYCO; BAND',
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
          marca: 'VALEO; GATES; DAYCO; BAND',
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
          marca: 'VALEO; GATES; DAYCO; BAND',
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
          marca: 'VALEO; GATES; DAYCO; BAND',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Suspensión
        //Tensores
        {
          id: 18,
          name: 'Tensores',
          category: 'Suspensión',
          description:'Tensores para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/Suspensión/Tensores.png',
          stock: 'Disponible',
          marca: 'FIRESTONE; AUTOMANN; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Bolsas de aire
        {
          id: 19,
          name: 'Bolsas de aire',
          category: 'Suspensión',
          description:'Bolsas de aire para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/Suspensión/Bolsas de aire.png',
          stock: 'Disponible',
          marca: 'FIRESTONE; AUTOMANN; PREMIER',
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
          marca: 'FIRESTONE; AUTOMANN; PREMIER',
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
          marca: 'FIRESTONE; AUTOMANN; PREMIER',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        //Muelles
        {
          id: 22,
          name: 'Muelles',
          category: 'Suspensión',
          description:'Muelles para motores diésel y sistemas de Suspensión .',
          price: '$250.00',
          image: '/images/productos/Suspensión/Muelles.png',
          stock: 'Disponible',
          marca: 'FIRESTONE; AUTOMANN; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'AUTOMANN; PAI; PREMIER',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
          marca: 'BALDWIN; SAKURA; DONALDSON; FLEETGUARD',
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
        {
          id: 8,
          name: 'Suspensión',
          category: 'chasis-suspension-frenos',
          description: 'Componentes de suspensión de alta durabilidad para todo tipo de terrenos.',
          price: '$280.00',
          image: '/images/productos/Sistema de Enfriamiento/Suspensión.webp',
          stock: 'Disponible',
          marca: 'CONTITECH',
          modelo: 'Para ejes traseros de camiones pesados'
        },
        {
          id: 9,
          name: 'Enganches y arrastre',
          category: 'chasis-suspension-frenos',
          description: 'Sistemas de enganche y arrastre para remolques y equipos de carga.',
          price: '$420.00',
          image: '/images/productos/Enganches y arrastre.png',
          stock: 'Disponible',
          marca: 'JOST',
          modelo: 'Capacidad de carga elevada'
        },
        
        // Sistemas Eléctricos, Sensores e Iluminación
        {
          id: 10,
          name: 'Baterías',
          category: 'sistemas-electricos',
          description: 'Baterías de alto rendimiento para vehículos comerciales y maquinaria pesada.',
          price: '$180.00',
          image: '/images/productos/Baterías.webp',
          stock: 'Disponible',
          marca: 'BOSCH',
          modelo: 'Para arranque en condiciones extremas'
        },
        {
          id: 11,
          name: 'Sensores',
          category: 'sistemas-electricos',
          description: 'Sensores de precisión para monitoreo de sistemas críticos del vehículo.',
          price: '$85.00',
          image: '/images/productos/Sensores.webp',
          stock: 'Disponible',
          marca: 'DELPHI',
          modelo: 'Compatible con sistemas electrónicos modernos'
        },
        {
          id: 12,
          name: 'Iluminación',
          category: 'sistemas-electricos',
          description: 'Sistemas de iluminación LED de alta visibilidad para mayor seguridad.',
          price: '$120.00',
          image: '/images/productos/Iluminación.webp',
          stock: 'Disponible',
          marca: 'HELLA',
          modelo: 'Para condiciones de baja visibilidad'
        },
        {
          id: 13,
          name: 'Repuestos de cabina',
          category: 'sistemas-electricos',
          description: 'Componentes eléctricos y electrónicos para el interior de la cabina.',
          price: '$95.00',
          image: '/images/productos/Repuestos de cabina.png',
          stock: 'Bajo pedido',
          marca: 'CONTINENTAL',
          modelo: 'Para sistemas de confort y control'
        },
        
        // Mantenimiento y Partes Generales
        {
          id: 14,
          name: 'Filtros',
          category: 'mantenimiento-general',
          description: 'Filtros de aire, aceite y combustible de alta eficiencia para motores diésel.',
          price: '$35.00',
          image: '/images/productos/filtros.png',
          stock: 'Disponible',
          marca: 'MANN-FILTER',
          modelo: 'Para mantenimiento preventivo'
        },
        {
          id: 15,
          name: 'Partes hidráulicas',
          category: 'mantenimiento-general',
          description: 'Componentes para sistemas hidráulicos de maquinaria pesada y equipos industriales.',
          price: '$250.00',
          image: '/images/productos/Partes hidráulicas.png',
          stock: 'Disponible',
          marca: 'PARKER',
          modelo: 'Para sistemas de alta presión'
        },
        {
          id: 16,
          name: 'Accesorios',
          category: 'mantenimiento-general',
          description: 'Accesorios y complementos para vehículos comerciales y maquinaria pesada.',
          price: '$75.00',
          image: '/images/productos/Accesorios.jpg',
          stock: 'Disponible',
          marca: 'VARIOS',
          modelo: 'Múltiples aplicaciones'
        },
        {
          id: 17,
          name: 'Sistema de aire',
          category: 'mantenimiento-general',
          description: 'Componentes para sistemas neumáticos de frenos y suspensión.',
          price: '$180.00',
          image: '/images/productos/Sistema de aire.jpg',
          stock: 'Disponible',
          marca: 'WABCO',
          modelo: 'Para sistemas de aire comprimido'
        },
        {
          id: 18,
          name: 'Complementos',
          category: 'mantenimiento-general',
          description: 'Productos complementarios para mantenimiento y reparación de vehículos.',
          price: '$60.00',
          image: '/images/productos/Complementos.jpg',
          stock: 'Disponible',
          marca: 'VARIOS',
          modelo: 'Uso general'
        },
        {
          id: 19,
          name: 'Rodamientos, chumaceras y correas',
          category: 'mantenimiento-general',
          description: 'Componentes de transmisión mecánica para equipos industriales y vehículos.',
          price: '$95.00',
          image: '/images/productos/Rodamientos, chumaceras y correas.webp',
          stock: 'Disponible',
          marca: 'SKF',
          modelo: 'Alta resistencia y durabilidad'
        },


        // Categoria frenos
        //Bandas
        {
          id: 20,
          name: 'Bandas',
          category: 'frenos',
          description: 'Bandas de frenos para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Bandas.png',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
        },
        // Pulmón
        {
          id: 21,
          name: 'Pulmón',
          category: 'frenos',
          description: 'Pulmones de frenos para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Pulmón.png',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
        },
        //Secador
        {
          id: 22,
          name: 'Secador',
          category: 'frenos',
          description: 'Secadores de frenos para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Secador.png',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
        },
        //Tambores
        {
          id: 23,
          name: 'Tambores',
          category: 'frenos',
          description: 'Tambores de frenos para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Tambores.webp',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
        },
        //Válvula de pedal
        {
          id: 24,
          name: 'Válvula de pedal',
          category: 'frenos',
          description: 'Válvula de pedal para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Válvula de pedal.png',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
        },
        //Válvula relay
        {
          id: 25,
          name: 'Válvula relay',
          category: 'frenos',
          description: 'Válvula relay para vehículos comerciales y maquinaria pesada.',
          price: '$250.00',
          image: '/images/productos/frenos/Válvula relay.png',
          stock: 'Disponible',
          marca: 'MERITOR; AUTOMANN; PAI; PREMIER',
          modelo: 'Múltiples aplicaciones'
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
  