import {createRouter, createWebHistory} from "vue-router";

import ProductList from "@/components/ProductList.vue";
import App from "@/App.vue";

const routes = [
  {
    path: '/',
    name: 'App',
    component: App
  },
  {
    path: '/product',
    name: 'product',
    component: ProductList
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router