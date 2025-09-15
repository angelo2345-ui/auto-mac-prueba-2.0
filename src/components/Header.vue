<template>
    <header class="navbar" :class="{'header-hidden': !isHeaderVisible}">
        <div class="nav-container">
            <a href="/" class="nav-logo">
                <img src="/public/images/logos/Automac Imagen.png" alt="Automac Logo">
                Automac
            </a>

            <div class="nav-toggle" @click="toggleMenu">
                <div class="bar"></div>
                <div class="bar"></div>
                <div class="bar"></div>
            </div>

            <nav class="nav-menu" :class="{active: menuActive}">
              <router-link to="/" class="nav-link" exact>Inicio</router-link>
              <router-link to="/productos" class="nav-link">Productos</router-link>
              <router-link to="/blog" class="nav-link">Blog</router-link>
              <router-link to="/contacto" class="nav-link">Contacto</router-link>
            </nav>
        </div>
    </header>
  </template>
  
  <script>
export default {
  data() {
    return {
      menuActive: false,
      lastScrollPosition: 0,
      isHeaderVisible: true
    }
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll);
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll);
  },
  methods: {
    toggleMenu() {
      this.menuActive = !this.menuActive
    },
    handleScroll() {
      const currentScrollPosition = window.pageYOffset || document.documentElement.scrollTop;
      
      // Determinar si el scroll es hacia arriba o hacia abajo
      if (currentScrollPosition < 0) {
        return;
      }
      
      // Si hacemos scroll hacia abajo y estamos más allá de 100px, ocultamos el header
      if (currentScrollPosition > 100 && currentScrollPosition > this.lastScrollPosition) {
        this.isHeaderVisible = false;
      } else {
        // Si hacemos scroll hacia arriba, mostramos el header
        this.isHeaderVisible = true;
      }
      
      this.lastScrollPosition = currentScrollPosition;
    }
    }
  }
</script>
  
  <style scoped>
/* Los estilos principales están en el CSS global */
.nav-logo img {
  height: 70px;
  margin-right: 12px;
  
}

.nav-logo {
  font-size: 2.8rem;
  margin-top: 10px;
  text-decoration: none; /* quita la raya debajo */


}


.header-hidden {
  transform: translateY(-100%);
}

@media (max-width: 768px) {
  .nav-menu {
    position: fixed;
    top: 90px;
    left: -100%;
    flex-direction: column;
    background: rgba(26, 26, 26, 0.9);
    width: 100%;
    text-align: center;
    transition: 0.3s;
    box-shadow: 0 10px 20px rgba(0,0,0,0.1);
    padding: 20px 0;
    gap: 15px;
  }
  
  .nav-menu.active {
    left: 0;
  }
  
  .nav-toggle {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 30px;
    height: 21px;
    cursor: pointer;
  }
  
  .bar {
    height: 3px;
    width: 100%;
    background-color: #fff;
    border-radius: 10px;
  }
}
</style>
  