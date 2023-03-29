import {createRouter, createWebHistory} from "vue-router";

import ProductList from "@/components/ProductList.vue";
import App from "@/App.vue";
import UserProfile from "@/components/UserProfile.vue"
import ProductForm from "@/components/ProductForm.vue";

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'App',
      component: App
    },
    {
      path: '/product',
      name: 'product',
      component: ProductList
    },
    {
      path: '/profile',
      name: 'profile',
      component: UserProfile
    },
    {
      path: '/product/:id',
      name: 'productForm',
      component: ProductForm
    }
  ]
})


