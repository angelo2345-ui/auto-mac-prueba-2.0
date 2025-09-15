<template>
    <div class="product-card">
      <img :src="product.img" :alt="product.name" />
      <div class="product-info">
        <h3>{{ product.name }}</h3>
        <p>{{ product.description }}</p>
        <a href="#" class="btn btn-primary btn-small">Ver Detalles</a>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: ['product']
  }
  </script>
  
  <style scoped>
/* Los estilos principales están en el CSS global */
</style>
  