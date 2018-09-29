import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Axios from 'axios'

import { library } from '@fortawesome/fontawesome-svg-core'
import * as i from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

import Scroll from './components/Scroll'
require('./mock');

Vue.config.productionTip = false
Vue.prototype.$http = Axios

library.add(i.faTimesCircle, i.faUser, i.faUsers, i.faPercentage, i.faTimes, i.faAngleDoubleDown,
    i.faStar, i.faCalendarAlt, i.faStopwatch)

Vue.component('font-icon', FontAwesomeIcon)
Vue.component('Scroll', Scroll);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
