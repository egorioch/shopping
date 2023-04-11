<template>
  <v-container class="m-3">
    <v-sheet width="300" class="mx-auto">
      <v-form ref="form">
        <v-text-field
          v-model="name" :counter="15" :rules="nameRules"
          label="Name" required
        ></v-text-field>

        <v-text-field
          v-model="email" :counter="25"
          label="Email" required
        ></v-text-field>

        <v-text-field
          v-model="password" :counter="20"
          label="Password" required type="password"
        ></v-text-field>

        <v-text-field
          v-model="passwordConfirm" :counter="20"
          label="passwordConfirm" required type="password"
        ></v-text-field>

        <div class="d-flex flex-column">
          <v-btn color="success" class="mt-4"
                 block @click="registration"
          > Validate
          </v-btn>
        </div>

      </v-form>
    </v-sheet>
  </v-container>
</template>

<script>
const url = "http://localhost:8080/registration"

export default {
  data() {
    return {
      name: "",
      email: "",
      password: "",
      passwordConfirm: ""
    }
  },
  methods: {
    async registration() {
      let user = [];
      user.push({"name": this.name});
      user.push({"email": this.email});
      user.push({"password": this.password});

      await fetch(url, {
        method: "POST",
        body: JSON.stringify(user),
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      })
    }
  }
}
</script>
