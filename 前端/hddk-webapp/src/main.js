import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Axios from 'axios'

import Scroll from './components/Scroll'
import element from 'element-ui';
require('./mock');

Vue.config.productionTip = false
Vue.use(element)
Vue.prototype.$http = Axios

Vue.component('Scroll', Scroll);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
