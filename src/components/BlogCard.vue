<template>
  <article class="bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-xl transition-all duration-300 cursor-pointer transform hover:-translate-y-1"
           @click="$emit('click', post)">
    <div class="md:flex">
      <!-- Imagen del artículo -->
      <div class="md:w-1/3">
        <img :src="post.featuredImage || '/images/blog/default-blog.jpg'" 
             :alt="post.title"
             class="w-full h-48 md:h-full object-cover">
      </div>
      
      <!-- Contenido del artículo -->
      <div class="md:w-2/3 p-6 md:p-8">
        <div class="flex items-center gap-2 text-sm text-gray-500 mb-3">
          <span class="px-3 py-1 rounded-full text-xs font-medium" 
                :style="{ backgroundColor: 'var(--color-amarillo)', color: 'var(--color-negro)' }">
            {{ post.category || 'General' }}
          </span>
          <span>•</span>
          <time :datetime="post.date">{{ formatDate(post.date) }}</time>
        </div>
        
        <h2 class="text-xl md:text-2xl font-bold text-gray-900 mb-3 hover:text-yellow-600 transition-colors"
            style="font-family: var(--fuente-titulos)">
          {{ post.title }}
        </h2>
        
        <p class="text-gray-600 mb-4 line-clamp-3">
          {{ post.excerpt }}
        </p>
        
        <div class="flex items-center justify-between">
          <span class="text-sm text-gray-500">
            Publicado por <strong>{{ post.author || 'Automac' }}</strong>
          </span>
          
          <span class="inline-flex items-center text-sm font-medium hover:underline"
                :style="{ color: 'var(--color-amarillo)' }">
            Leer má
            <i class="las la-arrow-right ml-1"></i>
          </span>
        </div>
      </div>
    </div>
  </article>
</template>

<script>
export default {
  props: ['post'],
  emits: ['click'],
  methods: {
    formatDate(dateString) {
      if (!dateString) return ''
      const options = { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric' 
      }
      return new Date(dateString).toLocaleDateString('es-ES', options)
    }
  }
}
</script>

<style scoped>
.line-clamp-3 {
  display: -webkit-box;
  -webkit-line-clamp: 3;
  line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
}
</style>
  