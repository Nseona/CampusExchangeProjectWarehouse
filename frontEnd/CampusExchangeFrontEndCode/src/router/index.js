import { createRouter, createWebHistory } from 'vue-router'
import LogOn from '@/views/logon.vue'
import SignUp from '@/views/signUp.vue'
import Home from '@/views/home.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'SignUp',
    //   component: SignUp
    // },
    // {
    //   path: '/LogOn',
    //   name: 'LogOn',
    //   component: LogOn
    // }


    {
      path: '/logOn',
      name: 'LogOn',
      component: LogOn
    },
    {
      path: '/signUp',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})

export default router
