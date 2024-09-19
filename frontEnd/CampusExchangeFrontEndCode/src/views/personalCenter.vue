<template>
    <div class="out">
        <pageHeader height="65px"/>
        <div class="body">
            <div class="header">
                <div class="boxHeader">
                    <div class="userBackground">
                        <img src="../assets/img/png/leisureBackground.png"/>
                    </div>
                    <div class="userInfo">
                        <div class="userInfoLeftBox">
                            <div class="topBox userName">
                                {{ userName }}
                            </div>
                            <div class="belowBox briefIntroduction">
                                这个人很懒，没有留下简介 
                            </div>
                        </div>
                        <div class="userInfoRightBox">
                            <div class="modifyDataButton">
                                编辑个人资料
                            </div>
                        </div>
                        <div class="userProfilePicture">
                            <div class="userProfilePictureBox">
                                <img src="../assets/img/jpg/t1.jpg"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="content">
                <div class="postPreviews">
                    <div class="postPreviewsBox">
                        <personalCenterTooltip @clickOption="clickOption"/>
                        <collectPostList v-if="selectIndex === 0"/>
                        <likePostList v-else-if="selectIndex === 1"/>
                    </div>
                </div>

                <div class="rightContent">
                    <div class="boxRightContent"></div>
                </div>
            </div>

            <goto_top_Icon />
        </div>
        <pageFooter />
    </div>
</template>

<script setup>
import { ref , onMounted } from 'vue'
import { request } from '@/utils/request'
import { useRouter } from 'vue-router'
import { StatusCode } from '@/utils/statusCode';
import { ElMessage } from 'element-plus'
import postPreview from '@/components/postPreview.vue';
import loadingBar from '@/components/loadingBar.vue';
import goto_top_Icon from '@/components/goto_top_Icon.vue';
import pageHeader from '@/components/page_header.vue';
import pageFooter from '@/components/pageFooter.vue';
import personalCenterTooltip from '@/components/personalCenterTooltip.vue';
import collectPostList from '@/components/collectPostList.vue';
import likePostList from '@/components/LikePostList.vue';

const router = useRouter()

const userName = ref('')

const selectIndex = ref(0)

const clickOption = (index) => {
    selectIndex.value = index
}

onMounted(() => {
    request({
        url_: '/user/userInfo',
        data_: {
            userId: localStorage.getItem('userId')
        }
    }).then(res => {
        const info = res.data.data.userInfo
        userName.value = info.userName
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
        .header{
            padding: 5px;
            height: 550px;
            .boxHeader{
                width: 100%;
                height: 100%;
                background-color: white;

                display: grid;
                grid-template-rows: 75fr 25fr;

                border-radius: 5px;

                .userInfo{
                    display: grid;
                    grid-template-columns: 5fr 1fr;
                    position: relative;
                    .userProfilePicture{
                        position: absolute;
                        left: 90px;
                        top: -47px;
                        width: 160px;
                        height: 160px;
                        border-radius: 5px;
                        border: 5px solid white;
                        .userProfilePictureBox{
                            width: 100%;
                            height: 100%;
                            border-radius: 0;
                            background-color: $backgroundColorPage;
                            img{
                                width: 100%;
                                height: 100%;
                                object-fit: cover;
                            }
                        }
                    }

                    .userInfoLeftBox{
                        display: grid;
                        grid-template-rows: 1fr 1fr;

                        &>div{
                            padding-left: 280px;
                            display: flex;
                            flex-direction: row;
                            align-items: center;
                            justify-content: start;
                        }

                        .userName{
                            font-size: 26px;
                            font-family: 'AlibabaPuHuiTi-3-85-Bold';
                            padding-top: 15px;
                        }

                        .briefIntroduction{
                            font-size: 20px;
                            padding-bottom: 10px;
                            color: $fontColor999;
                        }
                    }
                    .userInfoRightBox{
                        @include aboutColumnCenter;
                        padding-top: 40px;
                        padding-right: 20px;
                        .modifyDataButton{
                            width: 170px;
                            height: 40px;
                            border-radius: 5px;
                            border: 1px solid $Color1570EF;
                            font-size: 16px;
                            color: $Color1570EF;
                            @include aboutColumnCenter;
                            @include clickButtonShrink;
                        }
                    }
                }
                .userBackground{
                    img{
                        width: 100%;
                        height: 100%;
                        object-fit: cover;
                        border-radius: 5px 5px 0 0;
                    }
                }
            }
        }

        .content{
            display: grid;
            grid-template-columns: 2fr 1fr;
            min-height: 600px;
            .postPreviews{
                padding: $gap_padding;
                .postPreviewsBox{
                    width: 100%;
                    height: 100%;
                    background-color: white;
                    border-radius: 5px;
                }
            }
        }

        .rightContent{
            width: 100%;
            height: 600px;
            padding: $gap_padding;
            .boxRightContent{
                width: 100%;
                height: 100%;
                background-color: white;
            }
        }
    }
}
</style>