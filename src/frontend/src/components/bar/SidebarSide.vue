<template>
    <v-layout>
      <v-navigation-drawer
        v-model="this.toggle_sidebar"
        temporary
      >
        <v-list-item
          prepend-avatar="https://randomuser.me/api/portraits/men/78.jpg"
          title="John Leider"
        ></v-list-item>

        <v-divider></v-divider>

        <v-list density="compact" nav>
          <v-list-item prepend-icon="mdi-view-dashboard" title="Home" value="home"></v-list-item>
          <v-list-item prepend-icon="mdi-forum" title="About" value="about"></v-list-item>
        </v-list>
      </v-navigation-drawer>
      <v-main style="height: 250px">
        <div class="justify-center align-center h-100">
          <v-btn
            color="primary"
            @click.stop="this.toggle_sidebar = !this.toggle_sidebar"
          >
            Toggle
          </v-btn>
        </div>
      </v-main>
    </v-layout>
</template>

<script>
  export default {
    data() {
      return {
        toggle_sidebar: false
      }
    }
  }
</script>