import { createRouter, createWebHistory } from 'vue-router'
import LogOn from '@/views/logon.vue'
import SignUp from '@/views/signUp.vue'
import Home from '@/views/home.vue'
import ReleasePost from '@/views/releasePost.vue'
import PostDetails from '@/views/postDetails.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: LogOn
    },
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
      name: 'home',
      component: Home,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/releasePost',
      name: 'releasePost',
      component: ReleasePost
    },
    {
      path: '/postDetails',
      name: 'postDetails',
      component: PostDetails
    }
  ]
})

export default router
