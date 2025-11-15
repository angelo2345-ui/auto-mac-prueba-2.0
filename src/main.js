import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import './assets/css/main.css'
// Fuentes: Oswald (títulos) y Montserrat (textos)
import '@fontsource/oswald/400.css'
import '@fontsource/oswald/500.css'
import '@fontsource/oswald/700.css'
import '@fontsource/montserrat/400.css'
import '@fontsource/montserrat/500.css'
import '@fontsource/montserrat/700.css'

createApp(App).use(router).mount('#app')
