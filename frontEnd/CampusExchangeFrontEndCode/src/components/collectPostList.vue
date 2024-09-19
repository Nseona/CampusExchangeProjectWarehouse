<template>
    <div class="out">
        <postPreview 
            v-for="(item, index) in collectPostList" :key="item.postId"
            :title="item.postTitle"
            :text="item.postTextContent"
            :author="item.userName"
            :postId="item.postId"
            :base64="item.base64"
            @click="clickPreview(item.postId)"
        />

        <loadingBar @touchBottom="touchBottom" v-if="isLoadingBarShow"/>
    </div>
</template>

<script setup>
import { onMounted , ref} from 'vue';
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus';
import loadingBar from './loadingBar.vue';
import postPreview from './postPreview.vue';
import router from '@/router';

const collectPostList = ref([])

let pageNow = 1

const isLoadingBarShow = ref(true)

onMounted(() => {
    loadingPost()
})

const clickPreview = (postId) => {
    router.push({
        path: '/postDetails',
        query: {
            postId
        }
    })
}

const loadingPost = () => {
    if (!isLoadingBarShow.value){
        return
    }

    request({
        url_: '/user/userCollect',
        data_: {
            userId: localStorage.getItem('userId'),
            pageNow: pageNow++,
            pageSize: 4
        }
    }).then(res => {
        const {collectList, isHasNextPage} = res.data.data
        isLoadingBarShow.value = isHasNextPage
        collectPostList.value.push(...collectList)     
    })
}

const touchBottom = () => {
    loadingPost()
}
</script>

<style lang="scss" scoped>

</style>