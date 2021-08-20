
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationManager from "./components/ReservationManager"

import PayManager from "./components/PayManager"

import TicketManager from "./components/TicketManager"


import MyReservation from "./components/MyReservation"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations',
                name: 'ReservationManager',
                component: ReservationManager
            },

            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },

            {
                path: '/tickets',
                name: 'TicketManager',
                component: TicketManager
            },


            {
                path: '/myReservations',
                name: 'MyReservation',
                component: MyReservation
            },


    ]
})
