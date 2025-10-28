<template>
  <section class="section contact-section">
    <div class="container">
      <div class="section-header">
        <div class="section-icon">📞 Contáctanos </div>
        <p class="section-description">Estamos aquí para ayudarte con cualquier consulta sobre nuestros productos y servicios</p>
      </div>
      
      <div class="contact-grid">
        <!-- Columna de información de contacto y formulario -->
        <div class="contact-info-form">
          <!-- Información de contacto -->
          <div class="contact-info-card">
            <h3 class="contact-subtitle">Información de Contacto</h3>
            
            <div class="contact-item">
              <div class="contact-icon">📍</div>
              <div class="contact-details">
                <h4>Dirección</h4>
                <p>Av. 27 de Febrero, Santo Domingo, República Dominicana</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">📧</div>
              <div class="contact-details">
                <h4>Email</h4>
                <p>info@automac.com</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">📱</div>
              <div class="contact-details">
                <h4>Teléfono</h4>
                <p>+1 809-555-1234</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">🕒</div>
              <div class="contact-details">
                <h4>Horario</h4>
                <p>Lunes - Viernes: 8:00 AM - 6:00 PM</p>
                <p>Sábado: 8:00 AM - 1:00 PM</p>
              </div>
            </div>
          </div>
          
          <!-- Formulario de contacto -->
          <ContactForm />
        </div>
        
        <!-- Columna del mapa -->
        <div class="map-container">
          <h3 class="contact-subtitle">Nuestra Ubicación</h3>
          <div class="google-map">
            <iframe 
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3784.3825246652604!2d-69.91824408255616!3d18.490151600000003!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8eaf89bd3f041d7b%3A0x2adaafbed2d2f4a7!2sAutomac%20Dominicana%2C%20S.R.L!5e0!3m2!1ses!2sdo!4v1658352214584!5m2!1ses!2sdo" 
              width="100%" 
              height="100%" 
              style="border:0;" 
              allowfullscreen="" 
              loading="lazy" 
              referrerpolicy="no-referrer-when-downgrade">
            </iframe>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import ContactForm from '../components/ContactForm.vue'

export default {
  components: { ContactForm }
}
</script>

<style scoped>
.contact-section {
  padding: 80px 0 0 0; /* Añadido padding superior para evitar superposición con el header */
  background-color: #f8f9fa;
  min-height: 100vh;
  width: 100%;
}

.container {
  padding: 2rem;
  width: 100%;
  max-width: none;
}

.section-icon {
  font-size: 2rem;
  color: var(--color-negro);
  margin-bottom: 1rem;
  text-align: center;

}

.section-description {
  text-align: center;
  max-width: 800px;
  margin: 0 auto 2rem;
  color: #6c757d;
}

.contact-grid {
  display: grid;
  grid-template-columns: 1fr;
  gap: 2rem;
  width: 100%;
  padding: 1rem;
}

@media (min-width: 992px) {
  .contact-grid {
    grid-template-columns: 1fr 1fr;
  }
}

.contact-info-form {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.contact-info-card {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  padding: 2rem;
}

.contact-subtitle {
  font-size: 1.5rem;
  margin-bottom: 1.5rem;
  color: var(--color-azul);
  font-weight: 600;
}

.contact-item {
  display: flex;
  margin-bottom: 1.5rem;
}

.contact-icon {
  font-size: 1.5rem;
  margin-right: 1rem;
  color: var(--color-amarillo);
}

.contact-details h4 {
  font-size: 1.1rem;
  margin-bottom: 0.5rem;
  color: #333;
}

.contact-details p {
  color: #6c757d;
  margin: 0;
}

.map-container {
  display: flex;
  flex-direction: column;
}

.google-map {
  flex-grow: 1;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  background-color: white;
  height: 350px;
  position: relative;
}

.google-map iframe {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>
  