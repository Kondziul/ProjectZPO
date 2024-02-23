<script setup>
</script>

<template>
  <div>


<!--    <main>-->
<!--      <TheWelcome />-->
<!--    </main>-->

    <nav>
      <router-link to="/">Strona Główna</router-link>
      <router-link to="/about">O aplikacji</router-link>
      <router-link to="/airplanes">Samoloty</router-link>
      <router-link to="/reservation">Zarezerwuj</router-link>
      <router-link to="/myreservations">Moje rezerwacje</router-link>
      <router-link to="/login">Zaloguj się</router-link>
    </nav>

    <router-view />
  </div>
</template>


<style scoped>
header {
  line-height: 1.5;
}


nav {
  position: absolute;
  top: 0;
  left: 0;
  background-color: #2a2a2a;
  padding: 10px 20px;
  text-align: center;
  width: 100%;
}
nav a {
  color: white;
  text-decoration: none;
  font-size: 1.2em;
  margin: 0 10px;
  position: relative;
}

nav a::after {
  content: '|';
  color: white; /* Ten sam kolor co linki */
  font-size: 1.2em; /* Ta sama wielkość czcionki co linki */
  position: absolute;
  right: -10px; /* Dostosuj, aby kontrolować pozycję kreski */
  top: -4px;
}

nav a:last-child::after {
  content: none; /* Usuwa kreskę za ostatnim linkiem */
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
