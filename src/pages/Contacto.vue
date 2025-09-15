<template>
    <section class="section">
      <div class="container">
        <div class="section-header">
          <div class="section-icon">📞</div>
          <h2>Contáctanos</h2>
        </div>
        
        <div class="contact-content">
          <div>
            <div class="contact-item">
              <div class="contact-icon">📍</div>
              <div class="contact-details">
                <h3>Dirección</h3>
                <p>Calle Principal 123, Ciudad</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">📧</div>
              <div class="contact-details">
                <h3>Email</h3>
                <p>info@automac.com</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">📱</div>
              <div class="contact-details">
                <h3>Teléfono</h3>
                <p>+123 456 7890</p>
              </div>
            </div>
          </div>
          
          <ContactForm />
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
  