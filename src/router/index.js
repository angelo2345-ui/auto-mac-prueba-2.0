import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import Productos from '../pages/Productos.vue'
import Blog from '../pages/Blog.vue'
import Contacto from '../pages/Contacto.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/productos', component: Productos },
  { path: '/contacto', component: Contacto },
]

export default createRouter({
  history: createWebHistory(),
  routes
})
