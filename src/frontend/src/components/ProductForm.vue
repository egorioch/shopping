<template>
  <v-card>

  </v-card>
</template>

<script>
const url = "http://localhost:8080/product/"

export default {
  data() {
    return {
      id: this.$route.params.id,
      product: null,
    }
  },
  async mounted() {
    const dataPromise = await fetch(url + this.id, {
      method: "post",
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      withCredentials: false
    }).then(res => res.json).then(result => console.log("dataPromise: " + result));
    this.product = dataPromise;
  },
}
</script>