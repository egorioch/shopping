<template>
  <v-container>
    <v-card>
      <v-card-item>
        <v-text-field v-model="this.product.label">
          <template v-slot:label> <span>Label</span> </template>
        </v-text-field>

        <v-text-field v-model="this.product.description">
          <template v-slot:label> <span>Description</span> </template>
        </v-text-field>

        <v-text-field v-model="this.product.discount_information">
          <template v-slot:label> <span>Discount</span> </template>
        </v-text-field>

        <v-text-field v-model="this.product.organization">
          <template v-slot:label> <span>Organization</span> </template>
        </v-text-field>

        <v-text-field v-model="this.product.price">
          <template v-slot:label> <span>Price</span> </template>
        </v-text-field>

        <v-text-field v-model="this.product.quantity">
          <template v-slot:label> <span>Quantity</span> </template>
        </v-text-field>
      </v-card-item>

      <v-card-actions>
        <v-btn variant="outlined" @click="save()">Add</v-btn>
      </v-card-actions>

    </v-card>
  </v-container>
</template>

<script>
const url = "http://localhost:8080/product"

export default {
  data() {
    return {
      product: {}
    }
  },
  methods: {
    async save() {
      console.log("new PRODUCT: " + JSON.stringify(this.product));
      const productJson = JSON.stringify(this.product);
      await fetch(url, {
        method: "POST",
        body: productJson,
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      }).then(response => console.log("RESPONSE: " + JSON.stringify(response)))
        .catch(error => console.log("ERROR RESPONSE: " + JSON.stringify(error)))
    }
  }
}
</script>