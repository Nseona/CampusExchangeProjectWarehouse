<template>
    <div class="out">
        <pageHeader />
        <div class="body">
            <div class="bodyBox">
                <div class="title">
                    {{ postTitle }}
                </div>

                <div class="content">
                    <div class="contentBox">
                        <div class="postUser">
                            <div class="userPicture"></div>
                            <div class="postInfo">
                                <div class="">
                                    <span class="userName">{{ userName }}</span>
                                    <span class="releaseTime">{{ postPostingTime }} 发布</span>
                                </div>
                                <div class="">{{ postTitle }}</div>
                            </div>
                        </div>
                        <div class="postContent">
                            {{ postTextContent }}
                        </div>

                        <div class="imgList">
                            <div class="item" v-for="(item, index) in imgList">
                                <div class="imgBox">
                                    <el-image 
                                        :src = "item" 
                                        fit="cover"
                                        style="width: 100%; height: 100%;"
                                        :preview-src-list="imgList">
                                    </el-image>
                                </div>
                            </div>
                        </div>

                        <div class="toolbar">
                            <toolbarItem 
                                v-for="(item, index) in toolbarIconList"
                                number="123"
                                :svgName="item.svgName"
                                :defaultColor="item.defaultColor"
                                :selectColor="item.selectColor"
                                :userId="userId"
                                :postId="postId"
                                :isSelect="item.isSelect"
                                />
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
import { ref , onMounted} from 'vue'
import { request } from '@/utils/request'
import { useRoute } from 'vue-router'
import { StatusCode } from '@/utils/statusCode';
import { ElMessage , ElImage} from 'element-plus'
import moment from 'moment';
import goto_top_Icon from '@/components/goto_top_Icon.vue';
import pageHeader from '@/components/page_header.vue';
import pageFooter from '@/components/pageFooter.vue';
import toolbarItem from '@/components/toolbarItem.vue';

const route = useRoute() 
const postTextContent = ref('')
const postTitle = ref('')
const userName = ref('')
const postPostingTime = ref('')
const postId = ref(route.query.postId);
const userId = ref(localStorage.getItem('userId'))
const imgList = ref([])
let toolbarIconList = null

onMounted(() => {
    request({
        url_: '/post',
        data_: {
            postId: postId.value,
            currentUserId: userId.value
        }
    }).then(res => {
        const {statusCode, message} = res.data
        if (statusCode !== StatusCode.OK){
            ElMessage.error(message)
            return
        }

        const pd = res.data.data.postDetails

        postTextContent.value = pd.postTextContent
        postTitle.value = pd.postTitle
        userName.value = pd.userName
        postPostingTime.value = moment(pd.postPostingTime).format('YYYY-MM-DD HH:mm:ss')

        toolbarIconList = ref([
            {svgName:'like', selectColor:'#00AEEC', isSelect: pd.likeState},
            {svgName:'collect', selectColor: '#DF8130', isSelect: pd.collectState},
            {svgName:'comment'},
            {svgName:'relay'}
        ])

        pd.base64List.forEach(item => {
            imgList.value.push('data:image/png;base64,' + item)
        });
    })
})
</script>

<style lang="scss" scoped>
.out{
    background-color: $backgroundColorPage;
    .body{
        width: 1300px;
        min-height: 1000px;
        margin: auto;
        padding: 5px;

        .bodyBox{
            width: 100%;
            min-height: 1000px;
            background-color: white;
            border-radius: 5px;

            .title{
                width: 100%;
                height: 80px;
                font-size: 20px;
                font-family: 'AlibabaPuHuiTi-3-85-Bold';
                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: start;
                padding-left: 20px;
            }

            .content{
                width: 100%;
                min-height: 600px;
                padding: 0 20px 10px 20px;

                .contentBox{
                    width: 100%;
                    min-height: 600px;
                    background-color: $backgroundColorContent;
                    border-radius: 5px;

                    .postUser{
                        width: 100%;
                        height: 140px;
                        padding-left: 40px;

                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        justify-content: start;

                        .userPicture{
                            width: 70px;
                            height: 70px;
                            border-radius: 5px;
                            background-color: antiquewhite;
                            overflow: hidden;
                            img{
                                width: 100%;
                                height: 100%;

                                object-fit: cover;
                            }
                        }

                        .postInfo{
                            width: 300px;
                            height: 70px;

                            padding-left: 10px;

                            display: grid;
                            grid-template-rows: 1fr 1fr;

                            &>div{
                                width: 100%;
                                display: flex;
                                align-items: flex-end;
                                font-size: 14px;

                                .userName{
                                    font-size: 16px;
                                    color: #4B8DC3;
                                }
                                .releaseTime{
                                    font-size: 14px;
                                    color: $fontColor999;
                                    padding-left: 15px;
                                }
                            }

                        }
                    }

                    .postContent{
                        font-size: 14px;
                        line-height: 30px;

                        padding: 0 40px;
                    }

                    .imgList{
                        margin-left: 40px;
                        width: 600px;
                        height: auto;

                        .item{
                            width: 100%;
                            height: 350px;
                            padding-top: 20px;
                            .imgBox{
                                width: 100%;
                                height: 100%;
                            }
                        }
                    }

                    .toolbar{
                        margin: auto;
                        width: 700px;
                        height: 95px;

                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        justify-content: start;
                    }
                }
            }
        }
    }
}
</style>