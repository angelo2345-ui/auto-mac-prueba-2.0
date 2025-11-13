<template>
  <div v-if="show" class="fixed inset-0 z-50 overflow-y-auto" aria-labelledby="modal-title" role="dialog" aria-modal="true">
    <div class="flex items-center justify-center min-h-screen pt-4 px-4 pb-20 text-center sm:block sm:p-0">
      <!-- Overlay de fondo con efecto de gradiente y desenfoque -->
      <div class="fixed inset-0 bg-gradient-to-br from-blue-900/40 to-gray-900/60 backdrop-blur-sm transition-opacity" @click="closeModal"></div>

      <!-- Contenido del modal -->
      <div class="inline-block align-bottom bg-white rounded-xl text-left overflow-hidden shadow-2xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full relative border border-blue-100">
        <div class="bg-white px-4 pt-5 pb-4 sm:p-6 sm:pb-4">
          <div class="sm:flex sm:items-start">
            <!-- Imagen del producto -->
            <div class="mt-3 text-center sm:mt-0 sm:ml-4 sm:text-left w-full">
              <div class="flex justify-between items-start">
                <h3 class="text-2xl leading-6 font-bold text-blue-800 mb-4" id="modal-title">
                  {{ product.name }}
                </h3>
                <button @click="closeModal" class="text-gray-400 hover:text-red-500 transition-colors">
                  <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                  </svg>
                </button>
              </div>
              
              <div class="flex flex-col md:flex-row gap-6">
                <div class="md:w-1/2">
                  <img :src="product.image" :alt="product.name" class="w-full h-auto rounded-lg object-cover mb-4 shadow-md">
                </div>
                
                <div class="md:w-1/2">
                  <h4 class="text-lg font-semibold text-blue-800 mb-2">Descripción</h4>
                  <p class="text-gray-600 mb-4">{{ product.description }}</p>
                  
                  <h4 class="text-lg font-semibold text-blue-800 mb-2">Especificaciones</h4>
                  <ul class="list-disc pl-5 text-gray-600 mb-4">
                    <li>Compatible con múltiples marcas</li>
                    <li>Alta durabilidad y resistencia</li>
                    <li>Certificado de calidad</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="bg-gray-50 px-4 py-3 sm:px-6 sm:flex sm:flex-row-reverse border-t border-blue-100">
          <button 
            type="button" 
            class="w-full inline-flex justify-center rounded-md border border-transparent shadow-md px-5 py-2.5 bg-yellow-600 text-base font-medium text-white hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 sm:ml-3 sm:w-auto sm:text-sm transition-all duration-300 hover:scale-105"
            @click="requestQuote"
          >
            Cotizar precio y disponibilidad
          </button>
          <button 
            type="button" 
            class="mt-3 w-full inline-flex justify-center rounded-md border border-gray-300 shadow-sm px-5 py-2.5 bg-white text-base font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 sm:mt-0 sm:ml-3 sm:w-auto sm:text-sm transition-all duration-300"
            @click="closeModal"
          >
            Cerrar
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProductModal',
  props: {
    show: {
      type: Boolean,
      default: false
    },
    product: {
      type: Object,
      required: true,
      default: () => ({
        name: '',
        description: '',
        image: '',
        marca: '',
        modelo: '',
        stock: ''
      })
    }
    ,
    // Número de WhatsApp en formato internacional (ej: "51912345678") sin el signo +.
    whatsappNumber: {
      type: String,
      default: ''
    }
  },
  methods: {
    closeModal() {
      this.$emit('close');
    },
    requestQuote() {
      // Construir mensaje con los datos del producto
      const p = this.product || {};
      const name = p.name || '';
      const marca = p.marca || '';
      const modelo = p.modelo || '';
      const desc = p.description || '';
      const stock = p.stock || '';

      const message = `Hola, estoy interesado en este producto:\n\n*${name}*\nMarca: ${marca || '-'}\nModelo: ${modelo || '-'}\nDescripción: ${desc || '-'}\nStock: ${stock || 'Consultar'}\n\n¿Me pueden indicar precio y disponibilidad?`;

      const encoded = encodeURIComponent(message);
      const recipient = (this.whatsappNumber || '').trim();

      // Si se proporciona número, usar la ruta con phone; si no, abrir WhatsApp sin número para que el usuario elija contacto.
      let url = '';
      if (recipient) {
        // Normalizar: eliminar todo lo que no sea dígito
        const phoneDigits = recipient.replace(/\D/g, '');
        url = `https://api.whatsapp.com/send?phone=${phoneDigits}&text=${encoded}`;
      } else {
        url = `https://api.whatsapp.com/send?text=${encoded}`;
      }

      // Abrir en nueva pestaña/ventana
      window.open(url, '_blank', 'noopener,noreferrer');
      this.closeModal();
    }
  }
}
</script>

<style scoped>
/* Animaciones para el modal */
.modal-enter-active, .modal-leave-active {
  transition: opacity 0.3s ease;
}
.modal-enter-from, .modal-leave-to {
  opacity: 0;
}
</style>