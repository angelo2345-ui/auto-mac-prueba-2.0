<template>
  <div class="bg-white rounded-xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:scale-[1.02] group">
    <div class="relative h-48 bg-gray-100 flex items-center justify-center p-4">
      <img :src="product.image" :alt="product.name" class="max-h-full max-w-full object-contain transition-transform duration-300 group-hover:scale-105" />
    </div>
    <div class="p-5">
      <div class="flex items-center justify-between mb-2">
        <h3 class="text-lg font-bold text-gray-900 group-hover:text-blue-800 transition-colors">{{ product.name }}</h3>
        <span class="text-xs font-medium px-2 py-1 rounded-full bg-green-100 text-green-800">
          Disponible
        </span>
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
      <button @click="$emit('show-details', product)" class="w-full bg-blue-800 hover:bg-blue-900 text-white font-medium py-2 px-4 rounded-lg transition-colors duration-300">
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
  