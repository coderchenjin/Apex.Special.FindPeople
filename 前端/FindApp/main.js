import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

App.mpType = 'app'
Vue.prototype.$websiteUrl = 'http://localhost:7011/handle'; 
//Vue.prototype.$websiteUrl = 'http://192.168.9.93:7011'; 
const app = new Vue({
    ...App
})
app.$mount()
