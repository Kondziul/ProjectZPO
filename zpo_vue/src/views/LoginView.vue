<template>
  <div class="login-container">
    <h1>Logowanie</h1>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="credentials.email" required>
      </div>
      <div class="form-group">
        <label for="password">Hasło:</label>
        <input type="password" id="password" v-model="credentials.password" required>
      </div>
      <button type="submit">Zaloguj się</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const credentials = ref({
  email: '',
  password: ''
});

const login = () => {
  // Tu dodaj logikę logowania
  console.log('Dane logowania:', credentials.value);
  // Zazwyczaj tutaj wywoływałbyś metodę wysyłającą dane do backendu
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="email"], input[type="password"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 10px 15px;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  color: white;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
