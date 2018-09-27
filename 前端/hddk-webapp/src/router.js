import Vue from 'vue'
import Router from 'vue-router'
import ActivityList from './views/ActivityListPage'
import ActivityFull from './views/ActivityFullPage'

Vue.use(Router)

export default new Router({
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: ActivityList,
            children: [
                {
                    path: 'activity/:id',
                    name: 'activity',
                    component: ActivityFull,
                    props: true
                }
            ]
        }
        // {
        //     path: '/activity',
        //     name: 'activity',
        //     component:
        // }
    ]
})
