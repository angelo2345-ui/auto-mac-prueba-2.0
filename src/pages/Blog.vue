<template>
  <!-- Breadcrumb Navigation -->
<!-- Breadcrumb Navigation -->
<nav class="bg-gray-50 py-3 border-b border-gray-200 breadcrumb-nav" aria-label="Breadcrumb">
  <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
    <ol class="flex items-center justify-start space-x-3 text-sm min-h-[2rem]">
      <li class="flex items-center">
        <router-link to="/" class="text-gray-500 hover:text-gray-700 transition-colors flex items-center gap-2 px-2 py-2 rounded hover:bg-gray-100">
          <i class="las la-home text-base"></i>
          <span>Inicio</span>
        </router-link>
      </li>
      <li class="flex items-center text-gray-400 px-1">
        <i class="las la-angle-right text-sm"></i>
      </li>
      <li v-if="currentArticle" class="flex items-center">
        <button @click="goBackToBlog" class="text-gray-500 hover:text-gray-700 transition-colors flex items-center px-2 py-2 rounded hover:bg-gray-100">
          Blog
        </button>
      </li>
      <li v-if="currentArticle" class="flex items-center text-gray-400 px-1">
        <i class="las la-angle-right text-sm"></i>
      </li>
      <li v-if="currentArticle" class="flex items-center">
        <span class="text-gray-700 font-medium px-2 py-1 line-clamp-1 max-w-md flex items-center">{{ currentArticle.title }}</span>
      </li>
      <li v-else class="flex items-center">
        <span class="text-gray-700 font-semibold px-2 py-1 flex items-center">Blog</span>
      </li>
    </ol>
  </div>
</nav>

  <!-- Vista de artículo individual -->
  <article v-if="currentArticle" class="py-12 bg-white mb-16">
    <div class="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8">
      <!-- Header del artículo -->
      <header class="mb-8">
        <div class="flex items-center gap-2 text-sm text-gray-500 mb-4">
          <span class="px-3 py-1 rounded-full text-xs font-medium" 
                :style="{ backgroundColor: 'var(--color-amarillo)', color: 'var(--color-negro)' }">
            {{ currentArticle.category }}
          </span>
          <span>•</span>
          <time :datetime="currentArticle.date">{{ formatDate(currentArticle.date) }}</time>
          <span>•</span>
          <span>Publicado por {{ currentArticle.author }}</span>
        </div>
        
        <h1 class="text-3xl md:text-4xl font-bold text-gray-900 mb-6 leading-tight"
            style="font-family: var(--fuente-titulos)">
          {{ currentArticle.title }}
        </h1>
        
        <div class="w-20 h-1 rounded-full mb-8" :style="{ backgroundColor: 'var(--color-amarillo)' }"></div>
      </header>

      <!-- Imagen destacada -->
      <div v-if="currentArticle.featuredImage" class="mb-8">
        <img :src="currentArticle.featuredImage" 
             :alt="currentArticle.title"
             class="w-full h-64 md:h-96 object-cover rounded-lg shadow-lg">
      </div>

      <!-- Contenido del artículo -->
      <div class="prose prose-lg max-w-none">
        <div v-html="currentArticle.content" class="text-gray-700 leading-relaxed"></div>
      </div>

      <!-- Botón volver -->
      <div class="mt-12 pt-8 border-t border-gray-200">
        <button @click="goBackToBlog" 
                class="inline-flex items-center px-6 py-3 rounded-lg font-medium transition-all duration-300 hover:scale-105"
                :style="{ backgroundColor: 'var(--color-amarillo)', color: 'var(--color-negro)' }">
          <i class="las la-arrow-left mr-2"></i>
          Volver al Blog
        </button>
      </div>
    </div>
  </article>

  <!-- Vista de lista del blog -->
  <section v-else class="py-12 bg-gray-50 mb-16">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <!-- Header del blog -->
      <div class="text-center mb-12">
        <div class="inline-flex items-center justify-center w-16 h-16 rounded-full mb-6" 
             :style="{ backgroundColor: 'var(--color-amarillo)' }">
          <i class="las la-newspaper la-3x text-white"></i>
        </div>
        <h1 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4"
            style="font-family: var(--fuente-titulos)">
          Blog de <span class="text-gray-900">Automac</span> - Repuestos y Maquinaria Pesada
        </h1>
        <p class="text-lg text-gray-600 max-w-3xl mx-auto">
          Noticias, historias corporativas y evolución de Automac en República Dominicana. Líder en repuestos para maquinaria pesada, camiones y equipos industriales.
        </p>
        <div class="w-24 h-1 mx-auto mt-6 rounded-full" 
             :style="{ backgroundColor: 'var(--color-amarillo)' }"></div>
      </div>

      <!-- Lista de artículos -->
      <div class="grid gap-8 md:grid-cols-2 lg:grid-cols-1">
        <BlogCard 
          v-for="(post, index) in posts" 
          :key="index"
          :post="post"
          @click="viewArticle(post)"
          class="cursor-pointer hover-lift"
        />
      </div>
    </div>
  </section>
</template>

<script>
import BlogCard from '../components/BlogCard.vue'

export default {
  props: ['id', 'slug'],
  components: {
    BlogCard
  },
  data() {
    return {
      currentArticle: null,
      posts: []
    }
  },
  methods: {
    async fetchPosts() {
      try {
        const repoUser = 'angelo2345-ui'
        const repoName = 'automac'
        const branch = 'main'
        const folder = 'postblog'
        // Listar archivos del folder
        const listUrl = `https://api.github.com/repos/${repoUser}/${repoName}/contents/${folder}?ref=${branch}`
        const listRes = await fetch(listUrl)
        if (!listRes.ok) throw new Error('No se pudo listar posts del repositorio')
        const files = await listRes.json()
        const mdFiles = files.filter(f => f.name.endsWith('.md') && f.download_url)
        const posts = []
        for (const f of mdFiles) {
          const rawRes = await fetch(f.download_url)
          if (!rawRes.ok) continue
          const raw = await rawRes.text()
          const parsed = this.parseFrontMatter(raw)
          if (!parsed) continue
          posts.push({
            id: posts.length + 1,
            title: parsed.frontMatter.title || f.name,
            date: parsed.frontMatter.date || '',
            author: parsed.frontMatter.author || 'Automac',
            category: parsed.frontMatter.category || 'General',
            tags: parsed.frontMatter.tags || [],
            featuredImage: parsed.frontMatter.image || '',
            excerpt: parsed.frontMatter.excerpt || '',
            content: parsed.content || ''
          })
        }
        // Ordenar por fecha desc si disponible
        this.posts = posts.sort((a, b) => new Date(b.date) - new Date(a.date))
      } catch (err) {
        console.error('fetchPosts error:', err)
      }
    },
    parseFrontMatter(text) {
      // Espera formato: ---\nkey: value\n...\n---\n\ncontenido
      const start = text.indexOf('---')
      if (start !== 0) return { frontMatter: {}, content: text }
      const end = text.indexOf('\n---', start + 3)
      if (end === -1) return { frontMatter: {}, content: text }
      const fmBlock = text.slice(start + 3, end).trim()
      const content = text.slice(end + 4).trim()
      const frontMatter = {}
      fmBlock.split('\n').forEach(line => {
        const idx = line.indexOf(':')
        if (idx > -1) {
          const key = line.slice(0, idx).trim()
          let value = line.slice(idx + 1).trim()
          // Quitar comillas y manejar arrays simples
          if (value.startsWith('"') && value.endsWith('"')) value = value.slice(1, -1)
          if (value.startsWith('[') && value.endsWith(']')) {
            value = value
              .slice(1, -1)
              .split(',')
              .map(v => v.trim().replace(/^"|"$/g, ''))
          }
          frontMatter[key] = value
        }
      })
      return { frontMatter, content }
    },
    viewArticle(post) {
      this.currentArticle = post
      // Crear URL SEO-friendly
      const slug = post.title
        .toLowerCase()
        .replace(/[^a-z0-9\s-]/g, '') // Remover caracteres especiales
        .replace(/\s+/g, '-') // Reemplazar espacios con guiones
        .replace(/-+/g, '-') // Remover guiones múltiples
        .trim()
      
      // Cambiar la URL sin recargar la página
      window.history.pushState({}, '', `/blog/${post.id}/${slug}`)
      this.updatePageTitle()
      window.scrollTo({ top: 0, behavior: 'smooth' })
    },
    goBackToBlog() {
      this.currentArticle = null
      // Restaurar la URL del blog principal
      window.history.pushState({}, '', '/blog')
      this.updatePageTitle()
      window.scrollTo({ top: 0, behavior: 'smooth' })
    },
    formatDate(dateString) {
      const options = { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric' 
      }
      return new Date(dateString).toLocaleDateString('es-ES', options)
    },
    updatePageTitle() {
      if (this.currentArticle) {
        document.title = `${this.currentArticle.title} - Blog Automac | Repuestos y Maquinaria Pesada`
        // Actualizar meta descripción
        let metaDesc = document.querySelector('meta[name="description"]')
        if (metaDesc) {
          metaDesc.setAttribute('content', this.currentArticle.excerpt)
        } else {
          metaDesc = document.createElement('meta')
          metaDesc.name = 'description'
          metaDesc.content = this.currentArticle.excerpt
          document.getElementsByTagName('head')[0].appendChild(metaDesc)
        }
      } else {
        document.title = 'Blog Automac - Noticias y Historias de Repuestos para Maquinaria Pesada en República Dominicana'
        // Meta descripción para página principal del blog
        let metaDesc = document.querySelector('meta[name="description"]')
        if (metaDesc) {
          metaDesc.setAttribute('content', 'Descubre las historias, noticias y evolución de Automac, líder en repuestos para maquinaria pesada, camiones y equipos industriales en República Dominicana y el Caribe.')
        } else {
          metaDesc = document.createElement('meta')
          metaDesc.name = 'description'
          metaDesc.content = 'Descubre las historias, noticias y evolución de Automac, líder en repuestos para maquinaria pesada, camiones y equipos industriales en República Dominicana y el Caribe.'
          document.getElementsByTagName('head')[0].appendChild(metaDesc)
        }
      }
    }
  },
  mounted() {
    // Cargar posts desde GitHub y sincronizar estado
    this.fetchPosts().then(() => {
      if (this.id) {
        const articleId = parseInt(this.id)
        this.currentArticle = this.posts.find(post => post.id === articleId)
      }
      this.updatePageTitle()
    })
  },
  watch: {
    // Observar cambios en los parámetros de la ruta
    $route(to, from) {
      if (to.params.id) {
        const articleId = parseInt(to.params.id)
        this.currentArticle = this.posts.find(post => post.id === articleId)
        this.updatePageTitle()
      } else {
        this.currentArticle = null
        this.updatePageTitle()
      }
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


.line-clamp-1 {
  display: -webkit-box;
  -webkit-line-clamp: 1;
  line-clamp: 1;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.prose h2 {
  font-family: var(--fuente-titulos);
  color: var(--color-negro);
  margin-top: 2rem;
  margin-bottom: 1rem;
}

.prose h3 {
  font-family: var(--fuente-titulos);
  color: var(--color-amarillo);
  margin-top: 1.5rem;
  margin-bottom: 0.75rem;
}

.prose p {
  margin-bottom: 1.5rem;
  font-family: var(--fuente-principal);
  line-height: 1.8;
}

.prose strong {
  color: var(--color-amarillo);
  font-weight: 600;
}

.py-12 {
  padding: 80px 0 0 0; /* 80px = 5rem */
}

.breadcrumb-nav{
  margin-top: 98px !important;
}
/* Responsive padding para el breadcrumb */
@media (max-width: 1023px) {
  .breadcrumb-nav {
    margin-top: 83px !important;
  }
}
</style>
