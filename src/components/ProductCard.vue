<template>
  <div class="bg-white rounded-xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:scale-[1.02] group">
    <div class="relative h-48 bg-gray-100 flex items-center justify-center p-4">
      <img :src="product.image" :alt="product.name" class="max-h-full max-w-full object-contain transition-transform duration-300 group-hover:scale-105" />
    </div>
    <div class="p-5">
      <div class="flex items-center justify-between mb-2">
        <h3 class="text-lg font-bold text-gray-900 group-hover:text-blue-800 transition-colors">{{ product.name }}</h3>
        
      </div>
      <p class="text-sm text-gray-600 mb-3 line-clamp-2">{{ product.description }}</p>
      <div class="flex flex-col space-y-2 mb-4">
        <div class="flex items-center text-xs text-gray-500">
          <span class="font-semibold mr-1">Marca:</span> {{ product.marca }}
        </div>
        <div class="flex items-center text-xs text-gray-500">
          <span class="font-semibold mr-1">Modelo:</span> {{ product.modelo }}
        </div>
      </div>
      <button 
        @click="$emit('show-details', product)" 
        class="w-full text-white font-medium py-2 px-4 rounded-lg transition-all duration-300"
        :style="{
          backgroundColor: 'var(--color-amarillo)',
        }"
        @mouseenter="$event.target.style.backgroundColor = 'var(--color-negro)'"
        @mouseleave="$event.target.style.backgroundColor = 'var(--color-amarillo)'"
      >
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
  }
}
</script>
  