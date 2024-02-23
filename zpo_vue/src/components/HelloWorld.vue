<script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="greetings">
    <h1 class="green outlined">{{ msg }}</h1>
    <h3 class="outlined">
      Może nie za tanio, ale za to jako tako
    </h3>
  </div>
</template>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: left;
}

@media (min-width: 5048px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
