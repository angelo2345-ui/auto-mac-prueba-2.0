<template>
  <footer class="bg-slate-900/95 text-gray-300 pt-12 pb-6 border-t border-gray-700/50 relative">
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <div class="grid grid-cols-1 md:grid-cols-3 gap-10 mb-8">
        <!-- Columna Automac -->
        <div>
          <div class="flex items-center space-x-3 mb-4">
            <div class="bg-gradient-to-br from-yellow-500 to-amber-600 p-2 rounded-xl shadow-lg ring-2 ring-yellow-400/20">
              <img src="/public/images/logos/Automac Imagen.png" alt="Automac Logo" class="h-8 w-8 sm:h-10 sm:w-10 object-contain" />
            </div>
            <span class="text-white text-2xl font-bold tracking-tight bg-gradient-to-r from-white to-gray-200 bg-clip-text text-transparent">Auto<span class="text-yellow-400">mac</span></span>
          </div>
          <p class="text-sm text-gray-400 mb-2">Soluciones automotrices</p>
          <nav class="flex flex-col space-y-1 mt-4">
            <router-link to="/" class="hover:text-yellow-400 transition">Inicio</router-link>
            <router-link to="/productos" class="hover:text-yellow-400 transition">Productos</router-link>
            <router-link to="/blog" class="hover:text-yellow-400 transition">Blog</router-link>
            <router-link to="/contacto" class="hover:text-yellow-400 transition">Contacto</router-link>
          </nav>
        </div>

        <!-- Columna Contacto -->
        <div>
          <h3 class="text-lg font-bold text-white mb-4">Contacto</h3>
          <ul class="space-y-2 text-sm">
            <li class="flex items-center">
              <svg class="w-5 h-5 text-yellow-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12v1a4 4 0 01-8 0v-1m8 0a4 4 0 01-8 0m8 0V8a4 4 0 00-8 0v4"></path></svg>
              <span>829-687-4000</span>
            </li>
            <li class="flex items-center">
              <svg class="w-5 h-5 text-yellow-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12v1a4 4 0 01-8 0v-1m8 0a4 4 0 01-8 0m8 0V8a4 4 0 00-8 0v4"></path></svg>
              <span>849-629-2974</span>
            </li>
            <li class="flex items-center">
              <svg class="w-5 h-5 text-yellow-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12v1a4 4 0 01-8 0v-1m8 0a4 4 0 01-8 0m8 0V8a4 4 0 00-8 0v4"></path></svg>
              <span><a href="https://wa.me/18296874000" target="_blank" class="hover:text-yellow-400 transition">WhatsApp</a></span>
            </li>
            <li class="flex items-center">
              <svg class="w-5 h-5 text-yellow-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12v1a4 4 0 01-8 0v-1m8 0a4 4 0 01-8 0m8 0V8a4 4 0 00-8 0v4"></path></svg>
              <span><a href="mailto:info@automacdom.com.do" class="hover:text-yellow-400 transition">info@automacdom.com.do</a></span>
            </li>
            <li class="flex items-center">
              <svg class="w-5 h-5 text-yellow-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17.657 16.657L13.414 12.414a2 2 0 00-2.828 0l-4.243 4.243M15 11V7a4 4 0 10-8 0v4"></path></svg>
              <span>Av. Máximo Gómez, No 103-A, Esq. Américo Lugo, Villa Juana</span>
            </li>
          </ul>
        </div>

        <!-- Columna Redes -->
        <div>
          <h3 class="text-lg font-bold text-white mb-4">Síguenos</h3>
          <div class="flex space-x-4 mb-4">
            <a href="https://instagram.com/automacdom" target="_blank" aria-label="Instagram" class="hover:scale-110 transition">
              <svg class="w-7 h-7" fill="currentColor" viewBox="0 0 24 24"><path d="M7.75 2h8.5A5.75 5.75 0 0122 7.75v8.5A5.75 5.75 0 0116.25 22h-8.5A5.75 5.75 0 012 16.25v-8.5A5.75 5.75 0 017.75 2zm0 1.5A4.25 4.25 0 003.5 7.75v8.5A4.25 4.25 0 007.75 20.5h8.5a4.25 4.25 0 004.25-4.25v-8.5A4.25 4.25 0 0016.25 3.5h-8.5zm4.25 3.25a5.25 5.25 0 110 10.5 5.25 5.25 0 010-10.5zm0 1.5a3.75 3.75 0 100 7.5 3.75 3.75 0 000-7.5zm5.25.75a1 1 0 110 2 1 1 0 010-2z"></path></svg>
            </a>
            <a href="https://facebook.com" target="_blank" aria-label="Facebook" class="hover:scale-110 transition">
              <svg class="w-7 h-7" fill="currentColor" viewBox="0 0 24 24"><path d="M22 12c0-5.522-4.478-10-10-10S2 6.478 2 12c0 5.019 3.676 9.163 8.438 9.877v-6.987h-2.54v-2.89h2.54V9.797c0-2.507 1.492-3.89 3.777-3.89 1.094 0 2.238.195 2.238.195v2.46h-1.261c-1.243 0-1.631.771-1.631 1.562v1.875h2.773l-.443 2.89h-2.33v6.987C18.324 21.163 22 17.019 22 12z"></path></svg>
            </a>
            <a href="https://wa.me/18296874000" target="_blank" aria-label="WhatsApp" class="hover:scale-110 transition">
              <svg class="w-7 h-7" fill="currentColor" viewBox="0 0 24 24"><path d="M17.472 14.382c-.297-.149-1.758-.867-2.028-.967-.271-.099-.469-.149-.667.15-.197.297-.767.967-.94 1.164-.173.198-.347.223-.644.075-.297-.149-1.255-.462-2.39-1.475-.883-.788-1.48-1.761-1.653-2.059-.173-.297-.018-.458.13-.606.134-.133.298-.347.447-.52.149-.174.198-.298.298-.497.099-.198.05-.373-.025-.522-.075-.149-.667-1.611-.916-2.207-.242-.579-.487-.5-.667-.51-.173-.008-.373-.01-.572-.01-.198 0-.52.075-.792.373-.271.298-1.04 1.016-1.04 2.479 0 1.462 1.065 2.875 1.213 3.075.149.198 2.099 3.205 5.077 4.377.711.306 1.263.489 1.695.625.712.227 1.36.195 1.872.118.571-.085 1.758-.719 2.007-1.413.248-.694.248-1.289.173-1.413-.075-.124-.271-.198-.568-.347z"></path></svg>
            </a>
            <a href="mailto:info@automacdom.com.do" aria-label="Email" class="hover:scale-110 transition">
              <svg class="w-7 h-7" fill="currentColor" viewBox="0 0 24 24"><path d="M21 8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2h14a2 2 0 002-2V8zm-2 0l-7 5-7-5"></path></svg>
            </a>
            <a href="https://maps.google.com/?q=Av.+Máximo+Gómez,+No+103-A,+Esq.+Américo+Lugo,+Villa+Juana" target="_blank" aria-label="Ubicación" class="hover:scale-110 transition">
              <svg class="w-7 h-7" fill="currentColor" viewBox="0 0 24 24"><path d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5A2.5 2.5 0 1 1 12 6a2.5 2.5 0 0 1 0 5.5z"></path></svg>
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
    <div class="absolute left-0 bottom-0 w-full h-2 bg-gradient-to-r from-yellow-500/40 via-amber-500/30 to-transparent"></div>
  </footer>
</template>
  
<script>
export default {}
</script>
  
<style scoped>
/* El diseño principal usa Tailwind, pero puedes agregar estilos extra aquí si lo necesitas */
</style>
  