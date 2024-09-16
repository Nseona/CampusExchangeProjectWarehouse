<template>
    <div class="out">
        <div class="uploadBox" ref="uploadBox">
            <div class="uploadImg" @click="uploadImg()">
                <div class="addIcon">
                    <img src="../assets/img/png/add.png"/>
                </div>
                <div class="text">
                    添加图片
                </div>                        
            </div>
        </div>
    </div>
</template>

<script setup>
import throttle from '@/utils/throttle'
import { ElMessage } from 'element-plus'
import { defineEmits} from 'vue'
const emits = defineEmits(['uploadImg'])

const fileList = []

const handleFileChange = (optios) => {
    const files = optios.target.files
    const len = files.length

    // 临时的文件列表，用于存储本次用户的有效图片提交
    const tmpFiles = []

    for (let i = 0; i < len; i++){
        if (limitImageFund()){
            break
        }

        fileList.push(files[i])

        tmpFiles.push(files[i])

        imgEcho(files[i])
    }

    emits('uploadImg', tmpFiles)
}

let uploadImg = () => {
    if (limitImageFund()){
        return
    }

    const inputDom = document.createElement('input')

    inputDom.type = "file"
    inputDom.style.visibility = "hidden"
    inputDom.accept = "image/*"
    inputDom.multiple = 'multiple'
    inputDom.addEventListener('change', handleFileChange)

    const out = document.getElementsByClassName('out')[0]

    out.appendChild(inputDom);

    inputDom.click()
}

const imgEcho = (file) => {
    const reader = new FileReader();
    reader.onload = function(e) {
        const uploadBox = document.getElementsByClassName('uploadBox')[0]
        
        const echoImg = document.createElement('div')
        echoImg.className = 'echoImg'

        const img = document.createElement('img')
        img.src = e.target.result  // 设置图片源为读取到的数据
        img.style.width = '100%'
        img.style.height = '100%'

        echoImg.appendChild(img) //正常添加子元素
        uploadBox.prepend(echoImg)  //添加到第一个子元素

    };
    reader.readAsDataURL(file); // 读取文件内容并转换为DataURL
}

const limitImageFund = () => {
    if (fileList.length > 4){
        ElMessage({
            message: '最多上传5张图片',
            type: 'warning',
        })
        // 图片超上限后 对按钮点击进行节流处理
        uploadImg = throttle(uploadImg, 2000)

    } 
    return fileList.length > 4
}
</script>

<style lang="scss" scoped>
.out{
    width: 100%;
    height: 170px;
    border-radius: 5px;
    .uploadBox{
        width: 100%;
        height: 170px;

        padding-left: 50px;

        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: start;

        background-color: white;
        &>div{
            background-color: $backgroundColorPage;
            border-radius: 10px;
            width: 140px;
            height: 140px;
            
            @include aboutColumnCenter;
            @include clickButtonShrink;

            margin-right: 10px;
        }
        
        :deep(.echoImg) {
            background-color: $backgroundColorPage;
            border-radius: 10px;
            width: 140px;
            height: 140px;
            
            @include aboutColumnCenter;
            @include clickButtonShrink;

            margin-right: 10px;

            overflow: hidden;
            img {
                width: 100%;
                height: 100%;

                object-fit: cover;
            }
        }

        .uploadImg{
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
</style>