<template>
    <div class="out">
        <pageHeader />
        <div class="body">
            <div class="bodyBox">
                <div class="titleBox">
                    <input 
                        class="titleInput" 
                        placeholder="请输入帖子标题..."
                        maxlength="30"
                        v-model="titleInput"/>
                </div>

                <div class="contentBox">
                    <textarea 
                        class="contentInput" 
                        placeholder="请输入帖子内容..."
                        v-model="contentInput"
                        maxlength="2000">
                    </textarea>
                </div>

                <div class="uploadBox">
                    <div class="el-upload">
                        <input type="file" @change="handleFileChange">
                    </div>
                </div>
                
                <div class="submitBox">
                    <div class="releaseButton" @click="uploadImg()">
                        发布
                    </div>
                    <div class="cancelButton" @click="router.go(-1)">
                        取消
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import pageHeader from '@/components/page_header.vue';
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus'
import { ref , watch, onMounted} from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios';

const titleInput = ref('')
const contentInput = ref('')


const formData = new FormData()
const handleFileChange = (optios) => {
    formData.append('fileList', optios.target.files[0])
}

const router = useRouter()

const uploadImg = () => {
    formData.append('postTextContent', contentInput.value)
    formData.append('postTitle', titleInput.value)
    formData.append('postVisitorUserId', Number(localStorage.getItem('userId')))

    axios({
        url: 'http://localhost:8080/post',
        data: formData,
        method: 'put',
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    })

}

onMounted(() => {

})

watch(titleInput, newValue => {
    console.log(newValue)
    if (newValue.length >= 30){
        ElMessage({
            message: '帖子标题不能超过30个字哦',
            type: 'warning',
        })
    }
})

watch(contentInput, newValue => {
    console.log(newValue)
    if (newValue.length >= 2000){
        ElMessage({
            message: '帖子内容不能超过2000个字哦',
            type: 'warning',
        })
    }
})
</script>

<style lang="scss" scoped>
.out{
    background-color: $backgroundColorPage;
    .body{
        width: 1300px;
        height: 900px;
        margin: auto;
        padding: $gap_padding;

        .bodyBox{
            background-color: white;
            width: 100%;
            height: 100%;
            border-radius: 5px;

            .titleBox{
                height: 90px;
                width: 100%;

                padding-left: 50px;

                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: start;

                .titleInput{
                    width: 530px;
                    height: 42px;

                    border-radius: 10px;
                    padding-left: 10px;
                    background-color: $backgroundColorPage;
                }
            }

            .contentBox{
                height: 400px;
                width: 100%;
                padding: 0 50px;

                .contentInput{
                    width: 100%;
                    height: 100%;

                    border-radius: 10px;

                    padding: 10px;
                    background-color: $backgroundColorPage;

                    resize: none;
                }
            }

            .uploadBox{
                width: 100%;
                height: 170px;

                padding-left: 50px;

                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: start;
                .el-upload{
                    width: 140px;
                    height: 140px;
                    background-color: $backgroundColorPage;
                    border-radius: 10px;
                    .uploadImg{
                        // width: 140px;
                        // height: 140px;
                        width: 100%;
                        height: 100%;
                        
                        background-color: $backgroundColorPage;

                        @include aboutColumnCenter;
                        @include clickButtonShrink;

                        .addIcon{
                            width: 45px;
                            height: 45px;

                            img{
                                width: 100%;
                                height: 100%;
                            }
                        }

                        .text{
                            padding-top: 10px;
                            color: #7F7B7B;
                        }
                    }
                }
            }

            .submitBox{
                width: 100%;
                height: 90px;

                padding-right: 50px;

                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: end;

                .releaseButton,.cancelButton{
                    width: 120px;
                    height: 50px;

                    border-radius: 8px;

                    @include aboutColumnCenter;
                    @include clickButtonShrink;

                    font-size: 18px;
                }
                
                .releaseButton{
                    background-color: $Color1570EF;
                    color: white;
                }

                .cancelButton{
                    margin-left: 20px;
                    background-color: $backgroundColorPage;
                }
            }
        }
    }
}
</style>