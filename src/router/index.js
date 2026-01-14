import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import Productos from '../pages/Productos.vue'
import Blog from '../pages/Blog.vue'
import Contacto from '../pages/Contacto.vue'
import QuienesSomos from '../pages/QuienesSomos.vue'

const AdminRedirect = { template: '<div></div>' }

const routes = [
  { path: '/', component: Home },
  { path: '/quienes-somos', component: QuienesSomos },
  { path: '/productos', component: Productos },
  { path: '/contacto', component: Contacto },
  { path: '/blog', component: Blog},
  { path: '/blog/:id/:slug', component: Blog, props: true },
  {
    path: '/admin',
    component: AdminRedirect,
    beforeEnter() {
      window.location.href = '/admin.html'
    }
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
