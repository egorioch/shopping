<template>
  <v-container>
    <v-card>
      <v-card-item>
        <div>
          <div>Label: <input v-model="this.product.label"/></div>
          <div>id: {{ this.product.id }}</div>
          <div>Creation time: {{ this.product.creation_time }}</div>
          <div>Description: {{ this.product.description }}</div>
          <div>Discount information: {{ this.product.discount_information }}</div>
          <div>Label: {{ this.product.label }}</div>
          <div>Organization: {{ this.product.organization }}</div>
          <div>Price: {{ this.product.price }}</div>
          <div>Quantity: {{ this.product.quantity }}</div>
        </div>
      </v-card-item>

      <v-card-actions>
        <v-btn variant="outlined" @click="">Save</v-btn>
      </v-card-actions>

    </v-card>
  </v-container>
</template>

<script>
const url = "http://localhost:8080/product/"

export default {
  data() {
    return {
      id: this.$route.params.id,
      product: {},
    }
  },
  async created() {
    const dataPromise = await fetch(url + this.id, {
      method: "GET",
    }).then(response => response.json());
    this.product = await dataPromise;
    console.log("productAwait: " + JSON.stringify(this.product));
  },
  methods: {
    async save(product) {

    }
  }
}
</script>