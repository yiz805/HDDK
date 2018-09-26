import Vue from 'vue'
import Router from 'vue-router'
import ActivityList from './views/ActivityListPage'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: ActivityList
        }
        // {
        //     path: '/activity',
        //     name: 'activity',
        //     component:
        // }
    ]
})
