<template>
  <footer class="text-gray-300 pt-12 pb-6 border-t border-gray-700/50 relative" style="background-color: var(--color-negro);">
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <div class="grid grid-cols-1 md:grid-cols-3 gap-10 mb-8">
        <!-- Columna Automac -->
        <div>
          <div class="flex items-center space-x-3 mb-4">
            <div class="p-2">
              <img src="/images/logos/Automac Imagen.png" alt="Logo Automac" class="h-8 w-8 sm:h-10 sm:w-10 object-contain" />
            </div>
            <span class="text-white text-2xl font-bold tracking-tight bg-gradient-to-r from-white to-gray-200 bg-clip-text text-transparent">Auto<span style="color: var(--color-amarillo);">mac</span></span>
          </div>
          <p class="text-sm text-gray-400 mb-2">Soluciones automotrices</p>
          <nav class="flex flex-col space-y-3 mt-4">
            <router-link to="/quienes-somos" class="transition hover:[color:var(--color-amarillo)] flex items-center gap-2">
              <i class="las la-users la-lg"></i>
              <span>Quiénes Somos</span>
            </router-link>
            <router-link to="/" class="transition hover:[color:var(--color-amarillo)] flex items-center gap-2">
              <i class="las la-home la-lg"></i>
              <span>Inicio</span>
            </router-link>
            <router-link to="/productos" class="transition hover:[color:var(--color-amarillo)] flex items-center gap-2">
              <i class="las la-tools la-lg"></i>
              <span>Productos</span>
            </router-link>
            <router-link to="/blog" class="transition hover:[color:var(--color-amarillo)] flex items-center gap-2">
             <i class="las la-rss"></i>
             <span>Blog</span>
           </router-link>
            <router-link to="/contacto" class="transition hover:[color:var(--color-amarillo)] flex items-center gap-2">
              <i class="las la-envelope la-lg"></i>
              <span>Contacto</span>
            </router-link>
          </nav>
        </div>

        <!-- Columna Contacto -->
        <div>
          <h3 class="text-lg font-bold text-white mb-4">Contacto</h3>
          <ul class="space-y-3 text-sm">
            <li class="flex items-center gap-3">
              <i class="las la-phone la-lg" style="color: var(--color-amarillo)"></i>
              <span>829-687-4000</span>
            </li>
            <li class="flex items-center gap-3">
              <i class="las la-mobile la-lg" style="color: var(--color-amarillo)"></i>
              <span>849-629-2974</span>
            </li>
            <li class="flex items-center gap-3">
              <i class="lab la-whatsapp la-lg" style="color: var(--color-amarillo)"></i>
              <span><a href="https://wa.me/18296874000" target="_blank" class="hover:[color:var(--color-amarillo)] transition">WhatsApp</a></span>
            </li>
            <li class="flex items-center gap-3">
              <i class="las la-envelope la-lg" style="color: var(--color-amarillo)"></i>
              <span><a href="mailto:info@automacdom.com.do" class="hover:[color:var(--color-amarillo)] transition">info@automacdom.com.do</a></span>
            </li>
            <li class="flex items-center gap-3">
              <i class="las la-map-marker la-lg" style="color: var(--color-amarillo)"></i>
              <span>Av. Máximo Gómez, No 103-A, Esq. Américo Lugo, Villa Juana</span>
            </li>
          </ul>
        </div>

        <!-- Columna Redes -->
        <div>
          <h3 class="text-lg font-bold text-white mb-4">Síguenos</h3>
          <div class="flex space-x-4 mb-4">
            <a href="https://instagram.com/automacdom" target="_blank" aria-label="Instagram" class="hover:scale-110 transition">
              <i class="lab la-instagram la-2x"></i>
            </a>
            <a href="https://www.facebook.com/AUTOMACDOM" target="_blank" aria-label="Facebook" class="hover:scale-110 transition">
              <i class="lab la-facebook la-2x"></i>
            </a>
            <a href="https://wa.me/18296874000" target="_blank" aria-label="WhatsApp" class="hover:scale-110 transition">
              <i class="lab la-whatsapp la-2x"></i>
            </a>
            <a href="mailto:info@automacdom.com.do" target="_blank" aria-label="Email" class="hover:scale-110 transition">
              <i class="las la-envelope la-2x"></i>
            </a>
            <a href="https://www.google.com/maps/place/Automac+Dominicana,+S.R.L/@18.4901516,-69.9182441,17z/data=!4m10!1m2!2m1!1sautomacdom!3m6!1s0x8eaf89bd3f041d7b:0x2adaafbed2d2f4a7!8m2!3d18.4901516!4d-69.9145709!15sCgphdXRvbWFjZG9tWgwiCmF1dG9tYWNkb22SARd0cnVja19hY2Nlc3Nvcmllc19zdG9yZZoBI0NoWkRTVWhOTUc5blMwVkpRMEZuU1VSUGIyOWxja2hSRUFF4AEA-gEECAAQJA!16s%2Fg%2F11t5r90sk3?entry=ttu&g_ep=EgoyMDI1MDkxNy4wIKXMDSoASAFQAw%3D%3D" target="_blank" aria-label="Ubicación" class="hover:scale-110 transition">
              <i class="las la-map-marker la-2x"></i>
            </a>
          </div>
          <p class="text-xs text-gray-400">Síguenos en redes para novedades, tips y ofertas exclusivas.</p>
        </div>
      </div>
      <div class="border-t border-gray-700/50 pt-6 text-center">
        <p class="text-sm text-gray-400">© 2025 Automac - Todos los derechos reservados</p>
      </div>
    </div>
    <!-- Gradiente decorativo -->
    <div class="absolute left-0 bottom-0 w-full h-2" style="background: linear-gradient(to right, rgba(var(--color-amarillo), 0.4), rgba(var(--color-amarillo), 0.3), transparent);"></div>
  </footer>
</template>
  
<script>
export default {}
</script>
  
<style scoped>
/* El diseño principal usa Tailwind, pero puedes agregar estilos extra aquí si lo necesitas */
</style>