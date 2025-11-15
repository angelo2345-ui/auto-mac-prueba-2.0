<template>
  <div class="bg-white rounded-xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:scale-[1.02] group">
    <div class="relative h-48 bg-gray-100 flex items-center justify-center p-4">
      <img 
        :src="product.image" 
        :alt="product.name" 
        :class="[
          'max-h-full max-w-full object-contain transition-transform duration-300',
          isLargeProduct(product.name) ? 'scale-[1.35] group-hover:scale-[1.55]' : 'group-hover:scale-105'
        ]" 
      />
    </div>
    <div class="p-5">
      <div class="flex items-center justify-between mb-2">
        <h3 class="text-lg font-bold text-gray-900 group-hover:text-blue-800 transition-colors">{{ product.name }}</h3>
        
      </div>
      <p class="text-sm text-gray-600 mb-3 line-clamp-2">{{ product.description }}</p>
      <button @click="$emit('show-details', product)" class="w-full bg-yellow-600 hover:bg-yellow-900 text-white font-medium py-2 px-4 rounded-lg transition-colors duration-300">
        Ver Detalles
      </button>
    </div>
  </div>
</template>
  
<script>
export default {
  props: {
    product: {
      type: Object,
      required: true
    }
  },
  methods: {
    isLargeProduct(name) {
      const large = [
        'Bolsas de aire',
        'Tensores',
        'Parrillas',
        'Espejos',
        'Radiadores',
        'Depósito de coolant'
      ]
      return large.includes(name)
    }
  }
}
</script>
  