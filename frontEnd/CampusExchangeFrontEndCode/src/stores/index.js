import { ref } from 'vue'
import { defineStore } from 'pinia'
import { request } from '@/utils/request'

export const useStore = defineStore('user', () => {
  const token = ref('')

  async function storeRequest(obj) {
    // 若 headers_ 不存在  则无法向其中的token赋值
    // if (!obj.headers_) {
    //   obj.headers_ = {}
    // }

    // obj.headers_.token = token.value

    return await request(obj)
  }

  function getToken() {
    return token.value
  }

  return { token, storeRequest, getToken }
}, {
  persist: true
})
