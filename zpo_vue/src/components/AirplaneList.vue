<template>
  <div>
    <h1>Lista Samolotów</h1>
    <ul v-if="airplanes.length">
      <li v-for="airplane in airplanes" :key="airplane.id">
        {{ airplane.registration }} - {{ airplane.model }}
      </li>
    </ul>
    <p v-else>Ładowanie danych samolotów...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const airplanes = ref([]);

const fetchAirplanes = async () => {
  try {
    const response = await axios.get('http://localhost:8081/airplanes');
    airplanes.value = response.data;
  } catch (error) {
    console.error("Błąd podczas ładowania samolotów:", error);
  }
};

onMounted(fetchAirplanes);
</script>

<style scoped>
h1 {
  color: white;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 5px 0;
  color: #555;
}
</style>