<template>

<v-data-table
    :headers="headers"
    :items="myReservation"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyReservation',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "reservationId", value: "reservationId" },
            { text: "payId", value: "payId" },
            { text: "ticketId", value: "ticketId" },
            { text: "userid", value: "userid" },
            { text: "movie", value: "movie" },
            { text: "theater", value: "theater" },
            { text: "time", value: "time" },
            { text: "seatNo", value: "seatNo" },
            { text: "price", value: "price" },
            { text: "status", value: "status" },
        ],
        myReservation : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/myreservations')

      this.myReservation = temp.data._embedded.myreservations;

    },
    methods: {
    }
  }
</script>

