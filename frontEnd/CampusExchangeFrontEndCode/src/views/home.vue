<template>
    <div class="out">
        <pageHeader />
        <div class="body">
            <home_navigation @clickOption="clickOption()"/>
            <div class="content">
                <div class="postPreviews">
                    <div class="box">
                        <div class="tooltip">
                            <div class="box">
                                最新内容
                            </div>
                        </div>

                        <postPreview 
                            v-for="(item, index) in postPreviews" :key="item.postId"
                            :title="item.postTitle"
                            :text="item.postTextContent"
                            :author="item.userName"
                            :postId="item.postId"
                            :base64="item.base64"
                            @click="clickPreview(item.postId)"
                        />

                        <loadingBar @touchBottom="touchBottom" v-if="isLoadingBarShow"/>
                    </div>
                </div>

                <div class="rightContent">
                    <div class="functionalModule">
                        <div class="box">

                            <div class="releasePost" @click="router.push('/releasePost')">
                                <img src="../assets/img/png/file_icon.png"/>
                                <div class="text">
                                    发帖子
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <goto_top_Icon />
        </div>
        <pageFooter />
    </div>
</template>

<script setup>
import { ref , onMounted, defineOptions} from 'vue'
import { request } from '@/utils/request'
import { useRouter } from 'vue-router'
import { StatusCode } from '@/utils/statusCode';
import { ElMessage } from 'element-plus'
import home_navigation from '@/components/home_navigation.vue';
import postPreview from '@/components/postPreview.vue';
import loadingBar from '@/components/loadingBar.vue';
import goto_top_Icon from '@/components/goto_top_Icon.vue';
import pageHeader from '@/components/page_header.vue';
import pageFooter from '@/components/pageFooter.vue';

const router = useRouter()

const postPreviews = ref([])

const isLoadingBarShow = ref(true)

let pageNow = 1

const clickPreview = (postId) => {
    router.push({
        path: '/postDetails',
        query: {
            postId
        }
    })
}

const clickOption = (index) => {
    console.log(index)
}

onMounted(() => {
    loadingPost()
})

const touchBottom = () => {
    loadingPost()
}

const loadingPost = () => {

    if (!isLoadingBarShow.value){
        return
    }

    request({
        url_: '/post/previewPosts',
        data_: {
            pageNow: pageNow++,
            pageSize: 4
        }
    }).then(res => { 
        const {postList, isHasNextPage} = res.data.data

        if (!isHasNextPage){
            ElMessage('没有更多了')
            isLoadingBarShow.value = isHasNextPage
        }
        
        postPreviews.value.push(...postList)        

    })
}

</script>

<style lang="scss" scoped>
.out{
    background-color: $backgroundColorPage;
    .body{
        width: 1300px;
        min-height: 1000px;
        margin: auto;

        .content{
            display: grid;
            grid-template-columns: 2fr 1fr;
            min-height: 600px;
            .postPreviews{
                padding: $gap_padding;
                .box{
                    width: 100%;
                    height: 100%;
                    background-color: white;
                    border-radius: 5px;

                    .tooltip{
                        width: 100%;
                        height: 65px;
                        padding: $gap_padding;
                        .box{
                            padding: $gap_padding;

                            display: flex;
                            flex-direction: row;
                            align-items: center;
                            justify-content: start;

                            font-size: 16px;
                            font-family: 'AlibabaPuHuiTi-3-85-Bold';

                            border-radius: 0;
                            border-bottom: 1px solid #EEEEEE;
                        }
                    }
                }
            }
        }

        .rightContent{
            width: 100%;
            .functionalModule{
                padding: $gap_padding;
                height: 135px;
                .box{
                    width: 100%;
                    height: 100%;
                    background-color: white;
                    border-radius: 5px;
                    @include aboutRowCenter;

                    .releasePost{
                        width: 70px;
                        height: 70px;

                        @include aboutColumnCenter;
                        @include clickButtonShrink;

                        img{
                            width: 45px;
                            height: 45px;
                        }

                        .text{
                            padding-top: 5px;
                            font-size: 14px;
                        }
                    }
                }
            }
        }
    }
}
</style>