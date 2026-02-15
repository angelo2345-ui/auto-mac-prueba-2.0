<template>
  <div class="pt-32 lg:pt-48 pb-12">
    <!-- Hero Section -->
    <div class="bg-gray-50 py-24 mb-20">
      <div class="w-full px-4 sm:px-8 lg:px-16 text-center">
        <h1 class="text-5xl lg:text-7xl font-bold text-gray-900 mb-8" style="font-family: var(--fuente-titulos);">
          Únete a la familia <span style="color: var(--color-amarillo);">AUTOMAC</span>
        </h1>
        <p class="text-2xl lg:text-3xl text-gray-600 max-w-6xl mx-auto leading-relaxed">
          En AUTOMAC estamos comprometidos con nuestra gente, su desarrollo y bienestar. 
          Buscamos talento apasionado por el sector automotriz y maquinaria pesada.
        </p>
      </div>
    </div>

    <div class="w-full px-4 sm:px-8 lg:px-16">
      
      <!-- View: List of Vacancies -->
      <div v-if="!selectedVacancy">
        <!-- Culture Section (Only visible in list view) -->
        <div class="grid grid-cols-1 lg:grid-cols-2 gap-16 items-center mb-24">
          <div>
            <h2 class="text-4xl font-bold text-gray-900 mb-8">Nuestra Cultura</h2>
            <p class="text-gray-600 mb-6 text-xl">
              Operamos bajo principios de ética, respeto y excelencia. Queremos que cada colaborador 
              sepa que es parte esencial de este equipo, fomentando una cultura basada en nuestros valores.
            </p>
            <ul class="space-y-6 mt-8">
              <li class="flex items-center text-gray-700 text-lg">
                <span class="w-3 h-3 bg-[var(--color-amarillo)] rounded-full mr-4"></span>
                Desarrollo profesional continuo
              </li>
              <li class="flex items-center text-gray-700 text-lg">
                <span class="w-3 h-3 bg-[var(--color-amarillo)] rounded-full mr-4"></span>
                Ambiente de trabajo colaborativo
              </li>
              <li class="flex items-center text-gray-700 text-lg">
                <span class="w-3 h-3 bg-[var(--color-amarillo)] rounded-full mr-4"></span>
                Beneficios competitivos
              </li>
            </ul>
          </div>
          <div class="rounded-2xl overflow-hidden shadow-2xl h-[500px]">
            <img src="/images/mechanic_1.webp" alt="Equipo Automac" class="w-full h-full object-cover">
          </div>
        </div>

        <div class="mb-20">
          <h2 class="text-4xl font-bold text-gray-900 mb-12 text-center">Vacantes Disponibles</h2>
          
          <!-- Layout with Sidebar -->
          <div class="grid grid-cols-1 lg:grid-cols-4 gap-10">
            <!-- Sidebar Filters -->
            <div class="lg:col-span-1">
              <div class="bg-white p-8 rounded-2xl shadow-lg border border-gray-100 sticky top-32">
                <h3 class="font-bold text-gray-900 mb-6 text-xl border-b border-gray-100 pb-4">
                  <i class="las la-filter text-[var(--color-amarillo)] mr-2"></i>
                  Filtrar por Área
                </h3>
                <div class="flex flex-col gap-3">
                  <button 
                    @click="selectedCategory = 'todas'"
                    :class="['w-full text-left px-5 py-4 rounded-xl text-base font-medium transition-all flex justify-between items-center group', 
                      selectedCategory === 'todas' 
                        ? 'bg-[var(--color-amarillo)] text-white shadow-md' 
                        : 'text-gray-600 hover:bg-gray-50 hover:text-gray-900']"
                  >
                    Todas
                    <i v-if="selectedCategory === 'todas'" class="las la-check"></i>
                    <i v-else class="las la-angle-right opacity-0 group-hover:opacity-100 transition-opacity"></i>
                  </button>
                  <button 
                    v-for="category in categories" 
                    :key="category"
                    @click="selectedCategory = category"
                    :class="['w-full text-left px-5 py-4 rounded-xl text-base font-medium transition-all flex justify-between items-center group', 
                      selectedCategory === category 
                        ? 'bg-[var(--color-amarillo)] text-white shadow-md' 
                        : 'text-gray-600 hover:bg-gray-50 hover:text-gray-900']"
                  >
                    {{ category }}
                    <i v-if="selectedCategory === category" class="las la-check"></i>
                    <i v-else class="las la-angle-right opacity-0 group-hover:opacity-100 transition-opacity"></i>
                  </button>
                </div>
              </div>
            </div>

            <!-- Vacancy List -->
            <div class="lg:col-span-3">
              <div v-if="filteredVacancies.length > 0" class="grid gap-8">
                <div 
                  v-for="vacancy in filteredVacancies" 
                  :key="vacancy.id"
                  class="bg-white rounded-xl shadow-lg p-8 border border-gray-100 hover:shadow-2xl transition-all duration-300 transform hover:-translate-y-1"
                >
                  <div class="flex flex-col md:flex-row justify-between items-start md:items-center">
                    <div class="flex-1 pr-4">
                      <h3 class="text-2xl font-bold text-gray-900">{{ vacancy.title }}</h3>
                      <div class="flex flex-wrap gap-4 mt-4">
                        <span :class="['px-4 py-1.5 rounded-full text-sm font-bold', getCategoryColor(vacancy.category)]">
                          {{ vacancy.category }}
                        </span>
                        <span class="px-4 py-1.5 bg-gray-50 text-gray-700 rounded-full text-sm font-medium flex items-center gap-2 border border-gray-200">
                          <i class="las la-map-marker text-red-500"></i> {{ vacancy.location }}
                        </span>
                        <span class="px-4 py-1.5 bg-gray-50 text-gray-700 rounded-full text-sm font-medium flex items-center gap-2 border border-gray-200">
                          <i class="las la-clock text-blue-500"></i> {{ vacancy.type }}
                        </span>
                      </div>
                    </div>
                    <button 
                      @click="selectVacancy(vacancy)"
                      class="mt-6 md:mt-0 px-8 py-3 bg-[var(--color-amarillo)] text-white font-bold rounded-xl hover:bg-yellow-600 transition-colors shadow-md hover:shadow-lg flex items-center gap-2 whitespace-nowrap"
                    >
                      Ver Detalle
                      <i class="las la-arrow-right text-xl"></i>
                    </button>
                  </div>
                </div>
              </div>
              <div v-else class="text-center py-12 bg-gray-50 rounded-xl border border-dashed border-gray-300">
                <i class="las la-search text-4xl text-gray-400 mb-3"></i>
                <p class="text-gray-500 text-lg">No hay vacantes disponibles en esta categoría por el momento.</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- View: Vacancy Details -->
      <div v-else class="w-full">
        <div class="bg-white rounded-2xl shadow-xl overflow-hidden border border-gray-100">
          <!-- Header -->
          <div class="bg-gray-50 px-12 py-10 border-b border-gray-200">
            <button 
              @click="clearSelection"
              class="mb-8 text-gray-500 hover:text-[var(--color-amarillo)] font-medium flex items-center gap-2 transition-colors text-lg"
            >
              <i class="las la-arrow-left text-xl"></i> Regresar a la lista
            </button>
            
            <div class="flex flex-col md:flex-row justify-between items-start gap-6">
              <div>
                <h2 class="text-4xl font-bold text-gray-900 mb-4">{{ selectedVacancy.title }}</h2>
                <div class="flex flex-wrap gap-4 mt-2">
                  <span :class="['px-4 py-2 rounded-full text-base font-bold', getCategoryColor(selectedVacancy.category)]">
                    {{ selectedVacancy.category }}
                  </span>
                  <span class="px-4 py-2 bg-white border border-gray-200 text-gray-700 rounded-full text-base font-medium flex items-center gap-2">
                    <i class="las la-map-marker text-red-500 text-lg"></i> {{ selectedVacancy.location }}
                  </span>
                  <span class="px-4 py-2 bg-white border border-gray-200 text-gray-700 rounded-full text-base font-medium flex items-center gap-2">
                    <i class="las la-clock text-blue-500 text-lg"></i> {{ selectedVacancy.type }}
                  </span>
                </div>
              </div>
              <!-- ID display removed -->
            </div>
          </div>

          <!-- Content -->
          <div class="px-12 py-12">
            <div class="mb-12">
              <h3 class="text-2xl font-bold text-gray-900 mb-6 flex items-center gap-3">
                <i class="las la-bullseye text-[var(--color-amarillo)] text-3xl"></i>
                Objetivo de la posición
              </h3>
              <p class="text-gray-600 leading-relaxed text-xl">
                {{ selectedVacancy.description }}
              </p>
            </div>

            <div class="grid md:grid-cols-2 gap-16 mb-12">
              <div>
                <h3 class="text-2xl font-bold text-gray-900 mb-6 flex items-center gap-3">
                  <i class="las la-list-ul text-[var(--color-amarillo)] text-3xl"></i>
                  Responsabilidades
                </h3>
                <ul class="space-y-4">
                  <li v-for="(resp, index) in selectedVacancy.responsibilities" :key="index" class="flex items-start gap-4 text-gray-600 text-lg">
                    <span class="mt-2 w-2 h-2 bg-gray-400 rounded-full flex-shrink-0"></span>
                    {{ resp }}
                  </li>
                </ul>
              </div>

              <div>
                <h3 class="text-2xl font-bold text-gray-900 mb-6 flex items-center gap-3">
                  <i class="las la-check-circle text-[var(--color-amarillo)] text-3xl"></i>
                  Requisitos
                </h3>
                <ul class="space-y-4">
                  <li v-for="(req, index) in selectedVacancy.requirements" :key="index" class="flex items-start gap-4 text-gray-600 text-lg">
                    <span class="mt-2 w-2 h-2 bg-gray-400 rounded-full flex-shrink-0"></span>
                    {{ req }}
                  </li>
                </ul>
              </div>
            </div>

            <div class="bg-blue-50 rounded-xl p-8 mb-12 border border-blue-100">
              <h4 class="font-bold text-blue-900 mb-4 text-xl">Competencias requeridas</h4>
              <div class="flex flex-wrap gap-3">
                <span v-for="(comp, index) in selectedVacancy.competencies" :key="index" class="bg-white text-blue-800 px-5 py-2 rounded-lg text-base font-medium shadow-sm">
                  {{ comp }}
                </span>
              </div>
            </div>

            <!-- Action Buttons -->
            <div class="flex flex-col sm:flex-row gap-6 pt-8 border-t border-gray-100">
              <a 
                :href="`mailto:recursoshumanos@automac.com?subject=Aplicación para ${selectedVacancy.title}`"
                class="flex-1 bg-[var(--color-amarillo)] text-white text-center font-bold py-4 px-8 rounded-xl hover:bg-yellow-600 transition-colors shadow-md hover:shadow-lg flex items-center justify-center gap-3 text-lg"
              >
                <i class="las la-paper-plane text-2xl"></i>
                Aplicar ahora
              </a>
              
              <a 
                :href="`mailto:?subject=Mira esta vacante en AUTOMAC: ${selectedVacancy.title}&body=Te comparto esta oportunidad laboral que vi en AUTOMAC:%0D%0A%0D%0APosición: ${selectedVacancy.title}%0D%0AUbicación: ${selectedVacancy.location}%0D%0A%0D%0AMás información contactando a recursoshumanos@automac.com`"
                class="flex-1 bg-white text-gray-700 border border-gray-300 text-center font-bold py-4 px-8 rounded-xl hover:bg-gray-50 transition-colors flex items-center justify-center gap-3 text-lg"
              >
                <i class="las la-envelope text-2xl"></i>
                Enviar por correo
              </a>

              <button 
                @click="clearSelection"
                class="flex-1 bg-gray-800 text-white text-center font-bold py-4 px-8 rounded-xl hover:bg-gray-900 transition-colors flex items-center justify-center gap-3 text-lg"
              >
                <i class="las la-undo-alt text-2xl"></i>
                Regresar a la lista
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- General Call to Action (Only visible in list view) -->
      <div v-if="!selectedVacancy" class="bg-gray-900 text-white rounded-3xl p-16 text-center mt-20 shadow-2xl">
        <h3 class="text-4xl font-bold mb-6">¿No encontraste la posición ideal?</h3>
        <p class="mb-10 text-gray-300 text-xl max-w-4xl mx-auto">
          Siempre estamos buscando talento. Envíanos tu CV y te contactaremos cuando se abra una vacante acorde a tu perfil.
        </p>
        <a href="mailto:recursoshumanos@automac.com" class="inline-block px-10 py-4 bg-[var(--color-amarillo)] text-white font-bold text-lg rounded-xl hover:bg-yellow-600 transition-colors shadow-lg hover:shadow-xl transform hover:-translate-y-1">
          Enviar Currículum Espontáneo
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import { db } from '../firebase';
import { collection, getDocs, query, orderBy } from "firebase/firestore";

export default {
  name: 'Unete',
  data() {
    return {
      selectedCategory: 'todas',
      selectedVacancy: null,
      categories: ['Ventas', 'Servicio Técnico', 'Logística', 'Tecnología', 'Recursos Humanos', 'Administración'],
      vacancies: []
    };
  },
  async created() {
    await this.fetchVacancies();
  },
  methods: {
    async fetchVacancies() {
      try {
        const q = query(collection(db, "vacancies"), orderBy("createdAt", "desc"));
        const querySnapshot = await getDocs(q);
        this.vacancies = querySnapshot.docs.map(doc => ({
          id: doc.id,
          ...doc.data()
        }));

        // Dynamically add categories found in the database
        const uniqueCategories = new Set(this.vacancies.map(v => v.category).filter(c => c));
        uniqueCategories.forEach(c => {
          if (!this.categories.includes(c)) {
            this.categories.push(c);
          }
        });
      } catch (error) {
        console.error("Error fetching vacancies:", error);
      }
    },
    selectVacancy(vacancy) {
      this.selectedVacancy = vacancy;
      window.scrollTo({ top: 0, behavior: 'smooth' });
    },
    clearSelection() {
      this.selectedVacancy = null;
      window.scrollTo({ top: 0, behavior: 'smooth' });
    },
    getCategoryColor(category) {
      const colors = {
        'Ventas': 'bg-blue-100 text-blue-800',
        'Servicio Técnico': 'bg-orange-100 text-orange-800',
        'Logística': 'bg-green-100 text-green-800',
        'Tecnología': 'bg-purple-100 text-purple-800',
        'Recursos Humanos': 'bg-pink-100 text-pink-800',
        'Administración': 'bg-gray-100 text-gray-800'
      };
      return colors[category] || 'bg-gray-100 text-gray-800';
    }
  },
  computed: {
    filteredVacancies() {
      if (this.selectedCategory === 'todas') {
        return this.vacancies;
      }
      return this.vacancies.filter(vacancy => vacancy.category === this.selectedCategory);
    }
  }
}
</script>