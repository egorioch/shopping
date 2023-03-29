import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router/router";

import 'vuetify/styles'
import {createVuetify} from "vuetify";
import * as components from "vuetify/components";
import * as directives from 'vuetify/directives'
import * as cors from 'cors'

const vuetify = createVuetify({
  components,
  directives,
})

createApp(App)
  .use(router)
  .use(vuetify)
  .use(cors)
  .mount('#app')


