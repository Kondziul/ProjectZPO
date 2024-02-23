
<template>
  <div>
    <h1 class="outlined">Strona Główna</h1>
    <p class="outlined">To jest strona główna aplikacji.</p>
  </div>

  <header>
    <img alt="Franio i Benio" class="logo" src="../assets/franiobenio.jpg" width="512" height="288" />

    <div class="wrapper">
      <HelloWorld msg="Hangar samolotów u Frania i Benia" />
    </div>
  </header>
</template>

<script setup>
// Tutaj możesz dodać logikę związaną z Composition API
import HelloWorld from "../components/HelloWorld.vue";
</script>

<style scoped>
header {
  line-height: 1.5;
}


@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>