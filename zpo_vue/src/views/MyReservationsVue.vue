<script>
export default {
  data() {
    return {
      reservations: [],
    };
  },
  mounted() {
    this.fetchReservations();
  },
  methods: {
    async fetchReservations() {
      try {
        const response = await this.$http.get('/api/reservations');
        this.reservations = response.data;
      } catch (error) {
        console.error("There was an error fetching the reservations: ", error);
      }
    },
  },
};
</script>

<template>
  <div class="reservations">
    <h1>Rezerwacje</h1>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Data</th>
        <th>Godzina</th>
        <th>Miejsce</th>
        <th>Użytkownik</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="reservation in reservations" :key="reservation.id">
        <td>{{ reservation.id }}</td>
        <td>{{ reservation.date }}</td>
        <td>{{ reservation.time }}</td>
        <td>{{ reservation.place.name }}</td>
        <td>{{ reservation.user.name }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>


<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}
</style>