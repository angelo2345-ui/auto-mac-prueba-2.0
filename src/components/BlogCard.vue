<template>
    <div class="value-card blog-card">
      <div class="blog-date">{{ post.date || '01 Ene 2025' }}</div>
      <h3>{{ post.title }}</h3>
      <p>{{ post.excerpt }}</p>
      <a href="#" class="btn btn-primary btn-small">Leer más </a>
    </div>
  </template>
  
  <script>
  export default {
    props: ['post']
  }
  </script>
  
  <style scoped>
.blog-card {
  text-align: left;
  margin-bottom: 30px;
}

.blog-date {
  color: #e74c3c;
  font-weight: 500;
  margin-bottom: 10px;
}
</style>
  