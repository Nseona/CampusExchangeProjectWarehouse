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
                        />

                        <loadingBar @touchBottom="touchBottom"/>
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
    </div>
</template>

<script setup>
import { ref , onMounted} from 'vue'
import { request } from '@/utils/request'
import { useRouter } from 'vue-router'
import { StatusCode } from '@/utils/statusCode';
import { ElMessage } from 'element-plus'
import home_navigation from '@/components/home_navigation.vue';
import postPreview from '@/components/postPreview.vue';
import loadingBar from '@/components/loadingBar.vue';
import goto_top_Icon from '@/components/goto_top_Icon.vue';
import pageHeader from '@/components/page_header.vue';

const router = useRouter()

const postPreviews = ref([])

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
    request({
        url_: '/post/posts',
        data_: {
            pageNow: 1,
            pageSize: 10
        }
    }).then(res => {
        const {statusCode} = res.data
        if (statusCode === StatusCode.refuse){
            router.push('/logOn')

            ElMessage({
                message: '请登录',
                type: 'warning',
            })

        }
        
        if (res.data.data){
           postPreviews.value.push(...res.data.data) 
        }
        
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