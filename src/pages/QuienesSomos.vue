<template>
  <section class="bg-gray-50 pt-24 lg:pt-28 pb-12">
    <div class="max-w-7xl mx-auto px-6 sm:px-8 lg:px-10">
      <!-- Encabezado -->
      <div class="text-center mb-10">
        <h1 class="text-3xl sm:text-4xl font-extrabold tracking-tight" style="font-family: var(--fuente-principal);">
          <span class="bg-gradient-to-r from-yellow-400 to-amber-500 bg-clip-text text-transparent">Compromiso</span>, Respaldo y <span class="bg-gradient-to-r from-yellow-400 to-amber-500 bg-clip-text text-transparent">Calidad</span>
        </h1>
        <p class="mt-3 text-gray-600">15 años siendo el socio confiable para el mantenimiento de tu flota</p>
      </div>

      <!-- Contenido principal -->
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8">
        <!-- Quiénes somos -->
        <div class="lg:col-span-2 bg-white rounded-2xl shadow-sm border border-gray-200 p-6">
          <div class="flex items-center gap-4 mb-4">
            <div class="h-12 w-12 flex items-center justify-center rounded-full" style="background-color: var(--color-amarillo);">
              <i class="las la-users text-2xl text-black"></i>
            </div>
            <h2 class="text-2xl font-bold">Quiénes Somos</h2>
          </div>
          <div class="space-y-4 text-gray-700 leading-relaxed">
            <p>
              Somos especialistas en la <strong style="color: var(--color-amarillo)">importación, exportación y comercialización</strong> de repuestos para camiones, tractores y equipos industriales.
            </p>
            <p>
              Con <strong style="color: var(--color-amarillo)">más de 15 años de experiencia</strong>, nos hemos consolidado como líderes en el sector, ofreciendo soluciones integrales para el mantenimiento preventivo y correctivo.
            </p>
            <p>
              Atendemos a los sectores de <strong style="color: var(--color-amarillo)">transporte, industrial, minería, agrícola y construcción</strong>, con cobertura nacional y soporte en toda la cadena de suministro: desde la búsqueda del repuesto hasta su entrega y puesta en operación.
            </p>
            <p>
              Trabajamos con <strong style="color: var(--color-amarillo)">marcas certificadas</strong> y productos originales y compatibles, asegurando disponibilidad, trazabilidad y garantía en cada pieza. Nuestro equipo técnico brinda asesoría personalizada y seguimiento post‑venta.
            </p>
            <ul class="list-disc pl-6 space-y-2">
              <li>Gestión de <strong>importaciones bajo pedido</strong> y logística nacional.</li>
              <li><strong>Stock disponible</strong> y tiempos de entrega optimizados.</li>
              <li><strong>Garantía de calidad</strong> en repuestos originales y compatibles.</li>
              <li><strong>Asesoría técnica</strong> para selección, instalación y mantenimiento.</li>
              <li>Relaciones de <strong>largo plazo</strong> basadas en compromiso, respaldo y confianza.</li>
            </ul>
          </div>
        </div>

        <!-- Imagen empresa -->
        <div class="bg-white rounded-2xl shadow-sm border border-gray-200 p-4 flex items-center justify-center">
          <img src="/public/images/logos/Automac Imagen (1).png" alt="Automac Empresa" class="rounded-xl w-full h-64" />
        </div>
      </div>

      <!-- Tarjetas de valores/servicios -->
      <div class="grid grid-cols-1 md:grid-cols-2 gap-6 mt-10">
        <div class="rounded-xl border p-6" style="background-color:#FFF9E6; border-color:#FDE68A;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-truck text-xl" style="color: var(--color-amarillo);"></i>
            <h3 class="font-semibold">Envíos Nacionales</h3>
          </div>
          <p class="text-gray-600">Cobertura completa en todo el territorio nacional</p>
        </div>

        <div class="rounded-xl border p-6" style="background-color:#F0FDF4; border-color:#86EFAC;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-award text-xl" style="color: #16a34a;"></i>
            <h3 class="font-semibold">Garantía de Calidad</h3>
          </div>
          <p class="text-gray-600">100% repuestos originales y compatibles certificados</p>
        </div>

        <div class="rounded-xl border p-6" style="background-color:#EFF6FF; border-color:#93C5FD;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-shipping-fast text-xl" style="color: #2563EB;"></i>
            <h3 class="font-semibold">Entrega Rápida</h3>
          </div>
          <p class="text-gray-600">Stock disponible y tiempos de entrega optimizados</p>
        </div>

        <div class="rounded-xl border p-6" style="background-color:#FAF5FF; border-color:#D8B4FE;">
          <div class="flex items-center gap-3 mb-2">
            <i class="las la-headset text-xl" style="color: #7C3AED;"></i>
            <h3 class="font-semibold">Asesoría Técnica</h3>
          </div>
          <p class="text-gray-600">Equipo especializado para resolver tus consultas</p>
        </div>
      </div>

      <!-- Nuestra misión -->
      <div class="mt-10 bg-[#0B1220] text-gray-200 rounded-2xl p-6 shadow-lg border border-gray-700/40">
        <div class="flex items-center gap-3 mb-3">
          <i class="las la-bullseye text-2xl" style="color: var(--color-amarillo);"></i>
          <h3 class="text-xl font-bold">Nuestra Misión</h3>
        </div>
        <p>
          Mantener la excelencia en la distribución de repuestos para los sectores de 
          <strong>transporte, industrial, minería, agrícola y construcción</strong>, brindando el mejor servicio y garantizando la continuidad operativa de nuestros clientes.
        </p>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'QuienesSomos'
}
</script>

<style scoped>
</style>