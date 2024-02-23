import { createRouter, createWebHistory } from 'vue-router';

// Importuj widoki
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import AirplanesView from '../views/AirplanesView.vue';
import LoginView from "@/views/LoginView.vue";
import ReservationView from "@/views/ReservationView.vue";
import MyReservationsVue from "@/views/MyReservationsVue.vue";

const routes = [
    {
        path: '/',
        name: 'Strona Główna',
        component: HomeView
    },
    {
        path: '/about',
        name: 'O aplikacji',
        component: AboutView
    },
    {
        path: '/airplanes',
        name: 'Samoloty',
        component: AirplanesView
    },
    {
        path: '/login',
        name: 'Zaloguj się',
        component: LoginView
    },
    {
        path: '/reservation',
        name: 'Zarezerwuj miejsce',
        component: ReservationView
    },
    {
        path: '/myreservations',
        name: 'Moje rezerwacje',
        component: MyReservationsVue
    }

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
