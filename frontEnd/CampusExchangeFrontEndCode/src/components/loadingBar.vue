<template>
    <div class="out">
        <div class="loadingBar">
            <div class="loadingGif">
                <img src="../assets/img/gif/loading_gif_01.gif"/>
            </div>
            <div class="text">
                正在加载
            </div>
        </div>
    </div>
</template>

<script setup>
import throttle from '@/utils/throttle';
import { defineEmits } from 'vue';
const emits = defineEmits(['touchBottom'])

const pageScroll = () => {
    // 获取文档的总高度
    const scrollHeight = document.documentElement.scrollHeight

    // 获取窗口的视口高度
    const clientHeight = document.documentElement.clientHeight

    // 获取当前滚动条的位置
    const scrollTop = document.documentElement.scrollTop

    //提前量
    const delta = 35

    if (clientHeight + scrollTop >= scrollHeight - delta){
        console.log('!!')
        emits('touchBottom')
    }
}

window.addEventListener('scroll', throttle(pageScroll, 1000))

</script>

<style lang="scss" scoped>
.out{
    .loadingBar{
        width: 100%;
        height: 70px;

        background-color: white;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;

        .loadingGif{
            width: 25px;
            height: 25px;
            img{
                width: 100%;
                height: 100%;
            }
        }
        .text{
            padding-left: 10px;
            color: rgb(174, 175, 175);
        }
    }
}
</style>