<template>
  <div ref="root">
  <!-- Hero corporativo -->
  <section class="relative pt-24 lg:pt-28 pb-16">
    <div
      class="absolute inset-0 -z-10"
      :style="{
        backgroundImage: `linear-gradient(rgba(11,18,32,.65), rgba(11,18,32,.65)), url('/images/truck_1.webp')`,
        backgroundSize: 'cover',
        backgroundPosition: 'center'
      }"
    ></div>
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <div class="text-center text-white reveal">
        <h1 class="text-3xl sm:text-4xl font-extrabold tracking-tight" style="font-family: var(--fuente-principal);">
          <span class="text-black">Automac</span>
        </h1>
        <p class="mt-3 text-black"><b>Compromiso, respaldo y calidad para tu operación</b></p>
        <div class="mt-6 flex items-center justify-center gap-4">
          <router-link to="/productos" class="px-5 py-2 rounded-lg bg-[var(--color-amarillo)] text-black font-semibold hover:brightness-110 transition">Ver productos</router-link>
          <router-link to="/contacto" class="px-5 py-2 rounded-lg text-white transition hover:brightness-110" style="background-color: #2c2b25;">Contáctanos</router-link>
        </div>
      </div>
    </div>
  </section>

  <!-- Acerca de la empresa -->
  <section class="bg-gray-50 py-12">
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8 items-stretch">
        <div class="lg:col-span-2 bg-white rounded-2xl shadow-sm border border-gray-200 p-6 reveal h-full">
          <div class="flex items-center gap-4 mb-4">
            <div class="h-12 w-12 flex items-center justify-center rounded-full" style="background-color: var(--color-amarillo);">
              <i class="las la-users text-2xl text-black"></i>
            </div>
            <h2 class="text-2xl font-bold">Misión</h2>
          </div>
          <div class="space-y-4 text-gray-700 leading-relaxed">
            <p>
              Somos especialistas en la <strong>importación, exportación y comercialización</strong> de repuestos para camiones, tractores y equipos industriales.
            </p>
            <p>
              Con <strong>más de 15 años de experiencia</strong>, ofrecemos soluciones integrales para el mantenimiento preventivo y correctivo.
            </p>
            <p>
              Atendemos a los sectores de <strong>transporte, industrial, minería, agrícola y construcción</strong>, con cobertura nacional y soporte en toda la cadena de suministro.
            </p>
            <ul class="list-disc pl-6 space-y-2">
              <li>Importaciones bajo pedido y logística nacional.</li>
              <li>Stock disponible y tiempos de entrega optimizados.</li>
              <li>Garantía de calidad en repuestos originales y compatibles.</li>
              <li>Asesoría técnica para selección, instalación y mantenimiento.</li>
            </ul>

            <!-- Visión -->
            <div class="mt-6 p-6 rounded-2xl bg-gray-900 text-white border border-gray-700 reveal">
              <div class="flex items-center gap-3 mb-2">
                <i class="las la-eye text-2xl" style="color: var(--color-amarillo);"></i>
                <h3 class="text-xl font-bold">Visión</h3>
              </div>
              <p class="text-gray-100">
                Mantener la excelencia en la distribución de repuestos para el sector de
                <strong>transporte, industrial, minería, agrícola y construcción</strong>,
                brindando el mejor servicio y garantizando la continuidad operativa de nuestros clientes.
              </p>
            </div>
          </div>
        </div>
        <div class="bg-white rounded-2xl shadow-sm border border-gray-200 overflow-hidden reveal h-full">
          <!-- Imagen corporativa real -->
          <img 
            src="/images/quienes%20somos/automac%20frente.jpg" 
            alt="Foto de la empresa Automac" 
            class="w-full h-full object-cover"
          />
        </div>
      </div>

      <!-- Valores -->
      <div class="mt-10">
        <h3 class="text-2xl font-bold mb-4" style="font-family: var(--fuente-titulos);">Valores</h3>
      </div>
      <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div class="rounded-xl border p-6 reveal" style="background-color: rgb(222 173 35 / 0.1); border-color: var(--color-amarillo);">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-shield-alt text-xl" style="color: var(--color-amarillo);"></i>
            <h3 class="font-semibold">Integridad</h3>
          </div>
          <p class="text-gray-600">Actuamos con ética, transparencia y responsabilidad en cada decisión.</p>
        </div>
        <div class="rounded-xl border p-6 reveal" style="background-color:#F0FDF4; border-color:#86EFAC;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-award text-xl" style="color: #16a34a;"></i>
            <h3 class="font-semibold">Calidad</h3>
          </div>
          <p class="text-gray-600">Garantizamos repuestos originales y compatibles certificados.</p>
        </div>
        <div class="rounded-xl border p-6 reveal" style="background-color:#EFF6FF; border-color:#93C5FD;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-handshake text-xl" style="color: #2563EB;"></i>
            <h3 class="font-semibold">Compromiso</h3>
          </div>
          <p class="text-gray-600">Acompañamos a nuestros clientes para asegurar la continuidad operativa.</p>
        </div>
        <div class="rounded-xl border p-6 reveal" style="background-color:#FAF5FF; border-color:#D8B4FE;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-lightbulb text-xl" style="color: #7C3AED;"></i>
            <h3 class="font-semibold">Innovación</h3>
          </div>
          <p class="text-gray-600">Mejoramos procesos y soluciones para superar expectativas.</p>
        </div>
      </div>

      <!-- Métricas con contadores -->
      <div id="metrics" class="mt-12 grid grid-cols-2 md:grid-cols-4 gap-6">
        <div class="stat-card rounded-2xl bg-white border border-gray-200 p-6 text-center reveal">
          <div class="text-3xl font-extrabold counter" data-target="15">0</div>
          <div class="mt-1 text-gray-600">Años de experiencia</div>
        </div>
        <div class="stat-card rounded-2xl bg-white border border-gray-200 p-6 text-center reveal">
          <div class="text-3xl font-extrabold counter" data-target="1200">0</div>
          <div class="mt-1 text-gray-600">Clientes satisfechos</div>
        </div>
        <div class="stat-card rounded-2xl bg-white border border-gray-200 p-6 text-center reveal">
          <div class="text-3xl font-extrabold counter" data-target="10000" data-plus="true">+0</div>
          <div class="mt-1 text-gray-600">Referencias de repuestos</div>
        </div>
        <div class="stat-card rounded-2xl bg-white border border-gray-200 p-6 text-center reveal">
          <div class="text-3xl font-extrabold counter" data-target="500" data-plus="true">+0</div>
          <div class="mt-1 text-gray-600">Proyectos completados</div>
        </div>
      </div>

      <!-- Historia / Timeline -->
      <div class="mt-12 bg-[#0B1220] text-gray-200 rounded-2xl p-6 shadow-lg border border-gray-700/40 reveal">
        <div class="flex items-center gap-3 mb-3">
          <i class="las la-stream text-2xl" style="color: var(--color-amarillo);"></i>
          <h3 class="text-xl font-bold">Nuestra Historia</h3>
        </div>
        <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
          <div>
            <h4 class="font-semibold">2009</h4>
            <p class="text-gray-300">Nacimiento de Automac con foco en repuestos de camiones.</p>
          </div>
          <div>
            <h4 class="font-semibold">2015</h4>
            <p class="text-gray-300">Expansión a sectores agrícola e industrial a nivel nacional.</p>
          </div>
          <div>
            <h4 class="font-semibold">2023</h4>
            <p class="text-gray-300">Optimización de cadena de suministro y asesoría técnica especializada.</p>
          </div>
        </div>
      </div>

      <!-- Equipo -->
      <div class="mt-12">
        <div class="flex items-center gap-3 mb-4 reveal">
          <i class="las la-id-card text-2xl" style="color: var(--color-amarillo);"></i>
          <h3 class="text-xl font-bold">Nuestro Equipo</h3>
        </div>
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-5 gap-6">
          <!-- Yosias Gonzalez -->
          <div class="bg-white rounded-xl border border-gray-200 p-4 text-center reveal hover:shadow-lg transition-shadow">
            <div class="mb-3">
              <img src="/images/EQUIPO/YOSIASGONZALEZDIRECTORACOMERCIAL.jpeg" alt="Yosias Gonzalez" class="w-full" />
            </div>
            <div class="font-semibold">Yosias Gonzalez</div>
            <div class="text-gray-600 text-sm">Directora Comercial</div>
          </div>
          
          <!-- Betty Segura -->
          <div class="bg-white rounded-xl border border-gray-200 p-4 text-center reveal hover:shadow-lg transition-shadow">
            <div class="mb-3">
              <img src="/images/EQUIPO/BETTY%20SEGURA_ENCARGADA%20DE%20FINANZAS.jpeg" alt="Betty Segura" class="w-full" />
            </div>
            <div class="font-semibold">Betty Segura</div>
            <div class="text-gray-600 text-sm">Encargada de Finanzas</div>
          </div>
          
          <!-- Orietta Guzman -->
          <div class="bg-white rounded-xl border border-gray-200 p-4 text-center reveal hover:shadow-lg transition-shadow">
            <div class="mb-3">
              <img src="/images/EQUIPO/ORIETTA%20GUZMAN_ENCARGADA%20DE%20TIENDA.jpeg" alt="Orietta Guzman" class="w-full" />
            </div>
            <div class="font-semibold">Orietta Guzman</div>
            <div class="text-gray-600 text-sm">Encargada de Tienda</div>
          </div>
          
          <!-- Stephanie Amador -->
          <div class="bg-white rounded-xl border border-gray-200 p-4 text-center reveal hover:shadow-lg transition-shadow">
            <div class="mb-3">
              <img src="/images/EQUIPO/STEPHANIE%20AMADOR_AUXILIAR%20DE%20PLATAFORMAS%20DIGITALES.jpeg" alt="Stephanie Amador" class="w-full" />
            </div>
            <div class="font-semibold">Stephanie Amador</div>
            <div class="text-gray-600 text-sm">Auxiliar de Plataformas Digitales</div>
          </div>
          
          <!-- Neftaly de Jesus -->
          <div class="bg-white rounded-xl border border-gray-200 p-4 text-center reveal hover:shadow-lg transition-shadow">
            <div class="mb-3">
              <img src="/images/EQUIPO/NEFTALY%20DE%20JESUS_AUXILIAR%20DE%20CAJA.jpeg" alt="Neftaly de Jesus" class="w-full" />
            </div>
            <div class="font-semibold">Neftaly de Jesus</div>
            <div class="text-gray-600 text-sm">Auxiliar de Caja</div>
          </div>
        </div>

        <!-- Botón Únete a nuestro equipo -->
        <div class="mt-12 text-center reveal">
          <router-link 
            :to="{ path: '/contacto', query: { subject: 'Unete a nuestro equipo' } }" 
            class="group inline-flex items-center px-8 py-4 rounded-full bg-black text-white font-bold text-lg hover:bg-[var(--color-amarillo)] hover:text-black transition-all duration-300 shadow-lg hover:shadow-xl hover:-translate-y-1"
          >
            <i class="las la-user-plus text-2xl mr-3 group-hover:scale-110 transition-transform"></i>
            Únete a nuestro equipo
          </router-link>
        </div>
      </div>

      <!-- CTA -->
      <div class="mt-12 flex flex-col md:flex-row items-center justify-between gap-4 bg-white border border-gray-200 rounded-2xl p-6 reveal">
        <div>
          <h4 class="text-lg font-semibold">¿Buscas repuestos específicos?</h4>
          <p class="text-gray-600">Te ayudamos a encontrarlos y coordinamos la entrega.</p>
        </div>
        <router-link to="/contacto" class="px-5 py-2 rounded-lg bg-[var(--color-amarillo)] text-black font-semibold hover:brightness-110 transition">Contactar ahora</router-link>
      </div>
    </div>
  </section>
  </div>
</template>

<script>
export default {
  name: 'QuienesSomos',
  mounted() {
    // Animaciones de revelado al hacer scroll
    const root = this.$refs.root;
    const reveals = root ? root.querySelectorAll('.reveal') : [];
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            entry.target.classList.add('visible');
          }
        });
      },
      { threshold: 0.15 }
    );
    reveals.forEach((el) => observer.observe(el));

    // Contadores animados
    const metrics = root ? root.querySelector('#metrics') : null;
    if (metrics) {
      const counters = metrics.querySelectorAll('.counter');
      const startCounters = () => {
        counters.forEach((el) => {
          const target = parseInt(el.getAttribute('data-target') || '0', 10);
          const duration = 1200; // ms
          const start = performance.now();
          const tick = (now) => {
            const progress = Math.min((now - start) / duration, 1);
            const value = Math.floor(progress * target);
            el.textContent = (el.dataset.plus ? '+' : '') + value.toLocaleString(); // Añadir signo + si el atributo data-plus es true
            if (progress < 1) requestAnimationFrame(tick);
          };
          requestAnimationFrame(tick);
        });
      };
      const metricsObserver = new IntersectionObserver(
        (entries) => {
          entries.forEach((entry) => {
            if (entry.isIntersecting) {
              startCounters();
              metricsObserver.disconnect();
            }
          });
        },
        { threshold: 0.3 }
      );
      metricsObserver.observe(metrics);
    }
  }
}
</script>

<style scoped>
.reveal {
  opacity: 0;
  transform: translateY(16px);
  transition: opacity 0.6s ease, transform 0.6s ease;
}
.reveal.visible {
  opacity: 1;
  transform: translateY(0);
}
.stat-card {
  transition: transform .25s ease, box-shadow .25s ease;
}
.stat-card:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 15px -3px rgb(0 0 0 / 0.1), 0 4px 6px -4px rgb(0 0 0 / 0.1);
}
</style>
