<template>
    <div class="out">
        <div class="header">
            <div class="text">
                CampusExchange!
            </div>
        </div>
        <div class="body">
            <home_navigation @clickOption="clickOption"/>
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
                            :author="String(item.postId)"
                        />

                    </div>
                </div>
                <div class="functionBox"></div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref , onMounted} from 'vue'
import { request } from '@/utils/request'
import home_navigation from '@/components/home_navigation.vue';
import postPreview from '@/components/postPreview.vue';

const postPreviews = ref([])

const clickOption = (index) => {
    console.log(index)
}

onMounted(() => {
    request({
        url_: '/post/posts',
        data_: {
            pageNow: 1,
            pageSize: 10
        }
    }).then(res => {
        postPreviews.value.push(...res.data.data)
    })
})
</script>

<style lang="scss" scoped>
.out{
    background-color: $backgroundColorPage;
    .header{
        height: 115px;
        width: 100vw;
        background-color: white;
        .text{
            width: 370px;
            height: 100%;
            @include aboutColumnCenter;
            font-size: 40px;
            font-family: 'AlibabaPuHuiTi-3-85-Bold';
            font-style: italic;
        }
        padding-left: 25%;
    }

    .body{
        width: 1300px;
        min-height: 1000px;
        margin: auto;

        .content{
            display: grid;
            grid-template-columns: 2fr 1fr;
            min-height: 600px;
            .postPreviews{
                padding: 10px;
                .box{
                    width: 100%;
                    height: 100%;
                    background-color: white;

                    .tooltip{
                        width: 100%;
                        height: 65px;
                        padding: 10px;
                        .box{
                            padding-left: 10px;

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
    }
}
</style>