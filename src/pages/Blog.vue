<template>
    <section class="section section-alt">
      <div class="container">
        <div class="section-header">
          <div class="section-icon">📝</div>
          <h2>Nuestro Blog</h2>
        </div>
        <div class="values-grid">
          <BlogCard
            v-for="(post, index) in posts"
            :key="index"
            :post="post"
          />
        </div>
      </div>
    </section>
</template>
  
  <script>
import BlogCard from '../components/BlogCard.vue'

export default {
  components: { BlogCard },
  data() {
    return {
      posts: [
        { 
          title: 'Novedades en la Industria', 
          excerpt: 'Descubre las últimas tendencias y avances tecnológicos en nuestra industria que están revolucionando el mercado.',
          date: '15 Mar 2025'
        },
        { 
          title: 'Consejos para el Mantenimiento', 
          excerpt: 'Aprende cómo mantener tus equipos en óptimas condiciones con estos consejos prácticos de nuestros expertos.',
          date: '10 Mar 2025'
        },
        { 
          title: 'Casos de Éxito', 
          excerpt: 'Conoce cómo nuestros productos han ayudado a diferentes empresas a mejorar su productividad y eficiencia.',
          date: '05 Mar 2025'
        }
      ]
    }
  }
}
</script>
  