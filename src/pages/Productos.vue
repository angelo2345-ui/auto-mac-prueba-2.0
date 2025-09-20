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
        { id: 'motor-transmision', name: 'Motor y Transmisión' },
        { id: 'chasis-suspension-frenos', name: 'Chasis, Suspensión y Frenos' },
        { id: 'sistemas-electricos', name: 'Sistemas Eléctricos, Sensores e Iluminación' },
        { id: 'mantenimiento-general', name: 'Mantenimiento y Partes Generales' }
      ],
      products: [
        // Motor y Transmisión
        {
          id: 1,
          name: 'Kit de reparación de motor',
          category: 'motor-transmision',
          description: 'Kit completo para reparación de motores diésel. Incluye pistones, anillos, cojinetes y juntas de alta calidad.',
          price: '$850.00',
          image: '/images/productos/Kit de reparación de motor.jpg',
          stock: 'Disponible',
          marca: 'MAHLE',
          modelo: 'Para motores diésel de alto rendimiento'
        },
        {
          id: 2,
          name: 'Sistema de admisión',
          category: 'motor-transmision',
          description: 'Sistema de admisión de aire optimizado para mayor rendimiento y eficiencia del motor.',
          price: '$320.00',
          image: '/images/productos/Sistema de admisión.jpeg',
          stock: 'Disponible',
          marca: 'K&N',
          modelo: 'Compatible con múltiples marcas'
        },
        {
          id: 3,
          name: 'Transmisión',
          category: 'motor-transmision',
          description: 'Componentes de transmisión de alta resistencia para vehículos de carga pesada.',
          price: '$1200.00',
          image: '/images/productos/Transmisión.webp',
          stock: 'Bajo pedido',
          marca: 'ZF',
          modelo: 'Para camiones de carga pesada'
        },
        {
          id: 4,
          name: 'Kit de clutch',
          category: 'motor-transmision',
          description: 'Kit completo de embrague que incluye disco, plato de presión y rodamiento.',
          price: '$450.00',
          image: '/images/productos/Kit de clutch.webp',
          stock: 'Disponible',
          marca: 'SACHS',
          modelo: 'Para vehículos comerciales'
        },
        {
          id: 5,
          name: 'Lubricantes',
          category: 'motor-transmision',
          description: 'Aceites y lubricantes de alta calidad para motores diésel y sistemas de transmisión.',
          price: '$45.00',
          image: '/images/productos/Lubricantes.webp',
          stock: 'Disponible',
          marca: 'SHELL',
          modelo: 'Grado premium para trabajo pesado'
        },
        
        // Chasis, Suspensión y Frenos
        {
          id: 6,
          name: 'Chasis y estructura',
          category: 'chasis-suspension-frenos',
          description: 'Componentes estructurales para chasis de vehículos comerciales y maquinaria pesada.',
          price: '$580.00',
          image: '/images/productos/Chasis y estructura.jpg',
          stock: 'Bajo pedido',
          marca: 'HENDRICKSON',
          modelo: 'Para camiones y remolques'
        },
        {
          id: 7,
          name: 'Sistemas de freno',
          category: 'chasis-suspension-frenos',
          description: 'Sistemas completos de frenos incluyendo discos, pastillas y componentes hidráulicos.',
          price: '$320.00',
          image: '/images/productos/Sistemas de freno.webp',
          stock: 'Disponible',
          marca: 'BREMBO',
          modelo: 'Para vehículos de carga pesada'
        },
        {
          id: 8,
          name: 'Suspensión',
          category: 'chasis-suspension-frenos',
          description: 'Componentes de suspensión de alta durabilidad para todo tipo de terrenos.',
          price: '$280.00',
          image: '/images/productos/Suspensión.jpg',
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
        }
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
  