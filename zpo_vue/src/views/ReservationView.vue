<script>
import axios from 'axios';

export default {
  data() {
    return {
      airplanes: [],
      places: [],
      reservation: {
        airplaneId: null,
        placeId: null,
        startDate: '',
        endDate: '',
        monthlyFee: 0,
      },
    }
  },
  async created() {
    await this.fetchAirplanes();
    await this.fetchPlaces();
  },
  methods: {
    async fetchAirplanes() {
      try {
        const response = await axios.get('http://localhost:8081/airplanes');
        this.airplanes = response.data;
      } catch (error) {
        console.error('Error fetching airplanes:', error);
      }
    },
    async fetchPlaces() {
      try {
        const response = await axios.get('http://localhost:8081/places');
        this.places = response.data;
      } catch (error) {
        console.error('Error fetching places:', error);
      }
    },
    updateMonthlyFee() {
      const selectedPlace = this.places.find(place => place.id === this.reservation.placeId);
      this.reservation.monthlyFee = selectedPlace ? selectedPlace.monthlyFee : 0;
    },
    async submitForm() {
      try {
        // Przygotowanie danych do wysłania
        const payload = {
          airplaneId: this.reservation.airplaneId,
          placeId: this.reservation.placeId,
          startDate: this.reservation.startDate,
          endDate: this.reservation.endDate,
          monthlyFee: this.reservation.monthlyFee,
        };
        // Wysyłanie żądania POST do API
        const response = await axios.post('http://localhost:8081/reservations', payload);
        // Opcjonalnie: obsługa odpowiedzi, np. wyświetlenie komunikatu o sukcesie
        console.log('Reservation created successfully', response.data);
        // Możesz tutaj dodać logikę czyszczenia formularza lub przekierowania użytkownika
        this.resetForm();
      } catch (error) {
        console.error('Error creating reservation:', error);
        // Opcjonalnie: obsługa błędów, np. wyświetlenie komunikatu o błędzie
      }
    },
  },
}
</script>

<template>
  <div>
    <h1>Create Reservation</h1>
    <form @submit.prevent="submitForm">
      <div>
        <label for="airplane">Airplane:</label>
        <select v-model="reservation.airplaneId">
          <option v-for="airplane in airplanes" :value="airplane.id">{{ airplane.model }}</option>
        </select>
      </div>
      <div>
        <label for="place">Place:</label>
        <select v-model="reservation.placeId" @change="updateMonthlyFee">
          <option v-for="place in places" :value="place.id">{{ place.hangar.name }} - Miejsce: {{ place.area }}</option>
        </select>
      </div>
      <div>
        <label for="startDate">Start Date:</label>
        <input id="startDate" type="date" v-model="reservation.startDate">
      </div>
      <div>
        <label for="endDate">End Date:</label>
        <input id="endDate" type="date" v-model="reservation.endDate">
      </div>
      <div>
        <label for="monthlyFee">Monthly Fee:</label>
        <input id="monthlyFee" type="number" v-model="reservation.monthlyFee" readonly>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>


<style scoped>
select {
  width: 100%; /* Może być konieczne dostosowanie szerokości do układu */
  padding: 8px; /* Dostosuj wypełnienie dla lepszego wyglądu */
  border: 1px solid #ccc; /* Dostosuj kolor ramki do swojego designu */
  border-radius: 4px; /* Dla zaokrąglonych rogów */
  height: auto; /* Pozwól wysokości dostosować się do zawartości */
  min-height: 38px; /* Minimalna wysokość dla lepszego wyglądu */
}

/* Style dla opcji, aby były lepiej widoczne */
option {
  padding: 8px; /* Dostosuj wypełnienie dla lepszego wyglądu */
  color: black; /* Upewnij się, że kolor tekstu jest kontrastujący */
  background-color: white; /* Tło opcji powinno być wyraźne */
}

input[type="date"], input[type="number"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  min-height: 38px;
}

/* Styl dla przycisku */
button {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}

button:hover {
  background-color: #0056b3;
}
</style>
