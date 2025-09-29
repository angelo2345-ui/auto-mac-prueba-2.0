import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import Productos from '../pages/Productos.vue'
import Blog from '../pages/Blog.vue'
import Contacto from '../pages/Contacto.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/productos', component: Productos },
  { path: '/contacto', component: Contacto },
  { path: '/blog', component: Blog},
  { path: '/blog/:id/:slug', component: Blog, props: true }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
