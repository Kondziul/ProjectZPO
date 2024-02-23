<template>
  <div>
    <h1 class="outlined">O Aplikacji</h1>
    <p class="outlined">To jest strona informacyjna o Twojej aplikacji.</p>
  </div>
  <div class="custom-div">
    <h1>Specyfikacja Projektu: Hangar Samolotów</h1>
    <h2>Opis Projektu:</h2>
    <p>Celem projektu jest stworzenie kompleksowej aplikacji webowej do zarządzania hangarem samolotów. Aplikacja umożliwi użytkownikom rezerwację miejsc hangarowych dla swoich samolotów na określony czas. Baza danych MySQL będzie przechowywać informacje o samolotach, właścicielach, miejscach w hangarze oraz rezerwacjach.</p>

    <h2>Funkcje Aplikacji:</h2>
    <h3>Rejestracja i Logowanie:</h3>
    <ul>
      <li>Użytkownicy mogą się zarejestrować, tworząc konto z podstawowymi danymi (imię, nazwisko, adres e-mail).</li>
      <li>Zalogowani użytkownicy mają dostęp do funkcji rezerwacji i zarządzania swoimi samolotami.</li>
    </ul>

    <h3>Zarządzanie Samolotami:</h3>
    <ul>
      <li>Użytkownicy mogą dodawać, edytować i usuwać informacje o swoich samolotach (numer rejestracyjny, model, rozpiętość skrzydeł, długość).</li>
      <li>Każdy samolot jest przypisany do właściciela.</li>
    </ul>

    <h3>Zarządzanie Hangarem:</h3>
    <ul>
      <li>Administrator może dodawać, edytować i usuwać informacje o hangarach (nazwa, maksymalna pojemność, powierzchnia).</li>
      <li>Każdy hangar ma przypisane miejsca hangarowe.</li>
    </ul>

    <h3>Zarządzanie Miejscami Hangarowymi:</h3>
    <ul>
      <li>Administrator może przypisywać samoloty do konkretnych miejsc hangarowych.</li>
      <li>Użytkownicy widzą dostępność miejsc hangarowych w zależności od rozmiaru swojego samolotu i dostępności w danym hangarze.</li>
    </ul>

    <h3>Rezerwacja Miejsca Hangarowego:</h3>
    <ul>
      <li>Użytkownicy mogą rezerwować miejsca hangarowe dla swoich samolotów na określony czas.</li>
      <li>Rezerwacja obejmuje datę rozpoczęcia i zakończenia.</li>
    </ul>

    <h3>Cennik Hangarowania:</h3>
    <p>System generuje cennik opłat za miesiąc hangarowania, uwzględniający różnice w powierzchniach miejsc hangarowych i rozmiarach samolotów.</p>

    <h3>Widok Dostępności Miejsc Hangarowych:</h3>
    <p>Użytkownicy mogą zobaczyć dostępność miejsc hangarowych w danym hangarze w danym okresie czasowym.</p>

    <h3>Historia Rezerwacji:</h3>
    <p>Użytkownicy mogą przeglądać historię swoich rezerwacji oraz zaplanowanych rezerwacji na przyszłość.</p>

    <h2>Architektura Aplikacji:</h2>
    <h3>Backend (Spring Boot):</h3>
    <ul>
      <li>Zastosowanie wzorca MVC z kontrolerami REST, warstwą serwisów i warstwą dostępu do danych (Spring Data JPA).</li>
      <li>Połączenie z bazą danych MySQL do przechowywania danych.</li>
    </ul>

    <h3>Frontend (Vue.js):</h3>
    <ul>
      <li>Stworzenie komponentów Vue.js reprezentujących różne widoki (rezerwacja, zarządzanie samolotami, zarządzanie miejscami hangarowymi itp.).</li>
      <li>Wykorzystanie routera do nawigacji między widokami.</li>
      <li>Komunikacja z backendem za pomocą żądań HTTP.</li>
    </ul>

  </div>
</template>

<script setup>
// Tutaj możesz dodać logikę związaną z Composition API
</script>

<style scoped>
.custom-div {
  width: 800px; /* Szerokość 500 pikseli */
  background-color: black; /* Czarne tło */
  color: white; /* Opcjonalnie, biały kolor tekstu dla lepszej widoczności */
  font-size: 7px;
  border: 3px solid #FFFFFF; /* biała obramówka */
  padding: 20px; /* opcjonalnie, dodaje przestrzeń wewnątrz diva */
  margin: 20px; /* opcjonalnie, dodaje przestrzeń na zewnątrz diva */

}
</style>
