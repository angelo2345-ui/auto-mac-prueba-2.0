<template>
    <section class="hero" :style="{ backgroundImage: `url(${backgroundImages[currentImageIndex]})` }">
      <div class="carousel-overlay"></div>
      <div class="carousel-arrows">
        <button class="arrow prev" @click="prevImage">&lt;</button>
        <button class="arrow next" @click="nextImage">&gt;</button>
      </div>
      <div class="container">
        <div class="hero-content">
          <h1>Bienvenido a Automac</h1>
          <p>Soluciones innovadoras para tu negocio. Descubre nuestros productos y servicios de alta calidad.</p>
          <div class="hero-buttons">
            <a href="/productos" class="btn btn-primary">Ver Productos</a>
            <a href="/contacto" class="btn btn-secondary">Contáctanos</a>
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="section-header">
          <div class="section-icon">🔧</div>
          <h2>Nuestros Servicios</h2>
        </div>
        <div class="values-grid">
          <div class="value-card">
            <div class="value-icon">🛠️</div>
            <h3>Calidad Garantizada</h3>
            <p>Todos nuestros productos están fabricados con los más altos estándares de calidad.</p>
          </div>
          <div class="value-card">
            <div class="value-icon">⚡</div>
            <h3>Servicio Rápido</h3>
            <p>Entrega rápida y eficiente para todos nuestros clientes.</p>
          </div>
          <div class="value-card">
            <div class="value-icon">💼</div>
            <h3>Soporte Profesional</h3>
            <p>Nuestro equipo de expertos está siempre disponible para ayudarte.</p>
          </div>
        </div>
      </div>
    </section>

    <section class="section section-alt">
      <div class="container">
        <div class="section-header">
          <div class="section-icon">🏆</div>
          <h2>¿Por qué elegirnos?</h2>
        </div>
        <div class="content-card">
          <p>En Automac, nos dedicamos a proporcionar soluciones de alta calidad para nuestros clientes. Con años de experiencia en la industria, hemos desarrollado un profundo conocimiento y experiencia que nos permite ofrecer productos y servicios excepcionales.</p>
          <p>Nuestro compromiso con la excelencia y la satisfacción del cliente nos ha convertido en líderes en nuestro campo. Trabajamos incansablemente para asegurar que cada cliente reciba el mejor servicio posible.</p>
        </div>
      </div>
    </section>
  </template>
  
  <script>
  export default {
    data() {
      return {
        backgroundImages: [
          '/images/tractor.jpg',
          '/images/mechanic.jpg',
          '/images/truck.jpg'
        ],
        currentImageIndex: 0,
        intervalId: null
      }
    },
    mounted() {
      this.startSlideshow();
    },
    beforeUnmount() {
      this.stopSlideshow();
    },
    methods: {
      startSlideshow() {
        this.intervalId = setInterval(() => {
          this.nextImage();
        }, 3000);
      },
      stopSlideshow() {
        if (this.intervalId) {
          clearInterval(this.intervalId);
        }
      },
      nextImage() {
        this.currentImageIndex = (this.currentImageIndex + 1) % this.backgroundImages.length;
      },
      prevImage() {
        this.currentImageIndex = (this.currentImageIndex - 1 + this.backgroundImages.length) % this.backgroundImages.length;
      }
    }
  }
  </script>
  
  <style scoped>
  .hero {
    position: relative;
    height: 100vh;
    min-height: 500px;
    display: flex;
    align-items: center;
    overflow: hidden;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    transition: background-image 1s ease-in-out;
  }
  
  .carousel-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.4);
    z-index: 0;
  }
  
  .carousel-arrows {
    position: absolute;
    width: 100%;
    top: 50%;
    display: flex;
    justify-content: space-between;
    padding: 0 20px;
    z-index: 10;
    transform: translateY(-50%);
  }
  
  .arrow {
    background-color: rgba(255, 255, 255, 0.7);
    border: none;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    font-size: 20px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: background-color 0.3s;
  }
  
  .arrow:hover {
    background-color: rgba(255, 255, 255, 0.9);
  }
  
  .hero-content {
    position: relative;
    z-index: 2;
    text-align: center;
    color: white;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
    padding: 20px;
    background-color: rgba(0, 0, 0, 0.5);
    border-radius: 10px;
  }
  
  .container {
    position: relative;
    z-index: 2;
  }
  </style>
  