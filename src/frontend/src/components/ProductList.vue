<template>
  <div>
    <div
      v-for="product in productsList"
      :key="product.id"
    >
      {{product}}
    </div>
  </div>
</template>

<script>
console.log("нормик чё")
const url = "http://localhost:8080/product"

export default {
  data() {
    return {
      productsList: []
    }
  },
  async mounted() {
    const dataPromise = await fetch(url);
    this.productsList = await dataPromise.json;
    console.log("data: " + this.productsList)
  }
}
</script>

