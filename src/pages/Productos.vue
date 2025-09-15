<template>
    <section class="section">
      <div class="container">
        <div class="section-header">
          <div class="section-icon">🛒</div>
          <h2>Nuestros Productos</h2>
        </div>
        
        <div class="catalog-filters">
          <button class="btn btn-secondary">Todos</button>
          <button class="btn btn-secondary">Categoría 1</button>
          <button class="btn btn-secondary">Categoría 2</button>
          <button class="btn btn-secondary">Categoría 3</button>
        </div>
        
        <div class="product-grid">
          <ProductCard
            v-for="(item, index) in products"
            :key="index"
            :product="item"
          />
        </div>
      </div>
    </section>
  </template>
  
  <script>
import ProductCard from '../components/ProductCard.vue'

export default {
  components: { ProductCard },
  data() {
    return {
      products: [
        { name: 'Producto 1', description: 'Descripción detallada del producto 1. Características y beneficios.', img: '/images/product1.jpg' },
        { name: 'Producto 2', description: 'Descripción detallada del producto 2. Características y beneficios.', img: '/images/product2.jpg' },
        { name: 'Producto 3', description: 'Descripción detallada del producto 3. Características y beneficios.', img: '/images/product1.jpg' },
        { name: 'Producto 4', description: 'Descripción detallada del producto 4. Características y beneficios.', img: '/images/product2.jpg' }
      ]
    }
  }
}
</script>
  
  <style scoped>
/* Los estilos principales están en el CSS global */
</style>
  