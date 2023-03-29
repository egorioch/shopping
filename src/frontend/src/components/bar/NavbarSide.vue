<template>
  <div>
    <v-toolbar color="orange">
      <template v-slot:prepend>
        <v-app-bar-nav-icon>
          <sidebar-side></sidebar-side>
        </v-app-bar-nav-icon>
      </template>

      <v-toolbar-title>
        <v-toolbar-items>
          <v-btn href="/" flat>Home</v-btn>
          <v-btn href="/product">Product</v-btn>
          <v-btn href="/profile">Profile</v-btn>
        </v-toolbar-items>
      </v-toolbar-title>
      <v-spacer></v-spacer>

    </v-toolbar>
  </div>

  <router-view></router-view>
</template>

<script>
import SidebarSide from "@/components/bar/SidebarSide.vue";

export default {
  name: "NavbarSide",
  components: {SidebarSide},
}
</script>