<template>
  <v-main>
    <v-container
      v-for="product in productsList"
      :key="product.id"
    >
      <v-card class="mx-auto" max-width="344">
        <v-img
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          height="200px"
          cover
        ></v-img>

        <v-card-title class="bg-red-darken-1">{{ product.label }}</v-card-title>

        <v-card-subtitle>{{ product.description }}</v-card-subtitle>

        <v-card-actions>
          <v-btn
            color="orange-lighten-2"
            variant="text"
            class="bg-red-darken-1"
            :href="'/product/' + product.id"
          >
            Change
          </v-btn>

          <v-spacer></v-spacer>

          <v-btn
            :icon="this.show ? 'mdi-chevron-up' : 'mdi-chevron-down'"
            @click="this.show = !this.show"
          ></v-btn>
        </v-card-actions>

        <v-expand-transition>
          <div v-show="this.show">
            <v-divider :thickness="4"></v-divider>
            <v-card-text> id: {{ product.id }}</v-card-text>
            <v-card-text> Creation time: {{ product.creationTime }}</v-card-text>
            <v-card-text> Discount information: {{ product.discount_information }}</v-card-text>
            <v-card-text> Organization: {{ product.id }}</v-card-text>
            <v-card-text> Price: {{ product.price }}</v-card-text>
            <v-card-text> Quantity: {{ product.quantity }}</v-card-text>
          </div>
        </v-expand-transition>
      </v-card>
    </v-container>
  </v-main>


</template>

<script>

//import NavbarSide from "@/App.vue";

const url = "http://localhost:8080/product"

export default {
  //components: {NavbarSide},
  data() {
    return {
      productsList: [],
      show: false
    }
  },
  async mounted() {
    const dataPromise = await fetch(url, {
      headers: {
        'Access-Control-Allow-Origin': '*',
        "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
        "Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With"
      },
      method: "GET",
      withCredentials: false
    }).then(response => response.json());
    this.productsList = await dataPromise;
    console.log("data: " + this.productsList)
  }
}
</script>

