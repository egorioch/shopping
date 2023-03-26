<template>
  <div>
    <div
      v-for="product in products"
      :key="product.id"> {{product}}</div>
  </div>
</template>

<script>
console.log("нормик чё")

export default {
  data() {
    return {
      products: frontendData.products
    }
  }
}
</script>