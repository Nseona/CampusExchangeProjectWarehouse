<template>
    <div class="out">
        <div class="box" @click="svgColor = switchSvgColor()">
            <div class="icon">
                <svg v-if="svgName === 'like'" t="1726562276428" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4287" width="200" height="200"><path d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z" p-id="4288" :fill="svgColor"></path></svg>
                <svg v-else-if="svgName === 'collect'" t="1726563428329" class="icon" viewBox="0 0 1025 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6612" width="200" height="200"><path d="M1020.85564 385.279248c-8.427984-26.487948-30.099941-45.751911-57.189888-49.965902l-83.075838-12.641975-171.569665-29.497942c-10.23398-1.805996-19.263962-8.427984-24.079953-18.059965l0-0.601999c-0.601999-2.407995-0.601999-4.213992-1.805996-6.621987L575.978509 41.537919c-3.009994-6.621987-7.223986-12.641975-11.437978-17.457966l0 0 0 0C550.694558 9.029982 532.634593 0 512.768632 0c-27.089947 0-51.1699 15.651969-63.209877 40.93592L329.158991 294.979424 60.667515 335.915344c-27.089947 4.213992-48.761905 22.875955-57.189888 49.965902-8.427984 27.089947-1.203998 55.985891 18.059965 75.249853l194.44562 197.455614-45.751911 278.725456c-4.815991 27.691946 6.019988 55.383892 28.293945 71.63786 21.671958 16.855967 50.567901 18.661964 74.045855 5.417989l240.197531-131.837743 240.197531 131.837743c10.23398 6.019988 21.671958 8.427984 32.507937 8.427984 14.447972 0 28.895944-4.815991 41.537919-14.447972 21.671958-16.855967 32.507937-43.945914 28.293945-71.63786l-45.751911-278.725456 194.44562-197.455614C1022.661636 441.265138 1029.283623 412.369195 1020.85564 385.279248z" p-id="6613" :fill="svgColor"></path></svg>
                <svg v-else-if="svgName === 'comment'" t="1726563479720" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8600" width="200" height="200"><path d="M847.36 107.52h-665.6c-69.12 0-125.44 56.32-125.44 125.44v401.92c0 69.12 56.32 125.44 125.44 125.44h38.4l15.36 181.76 158.72-181.76h453.12c69.12 0 125.44-56.32 125.44-125.44V232.96c0-69.12-56.32-125.44-125.44-125.44z m-563.2 376.32c-33.28 0-61.44-28.16-61.44-61.44 0-33.28 28.16-61.44 61.44-61.44 33.28 0 61.44 28.16 61.44 61.44 2.56 33.28-25.6 61.44-61.44 61.44z m230.4 0c-33.28 0-61.44-28.16-61.44-61.44 0-33.28 28.16-61.44 61.44-61.44 33.28 0 61.44 28.16 61.44 61.44 0 33.28-28.16 61.44-61.44 61.44z m227.84 0c-33.28 0-61.44-28.16-61.44-61.44 0-33.28 28.16-61.44 61.44-61.44 33.28 0 61.44 28.16 61.44 61.44 2.56 33.28-25.6 61.44-61.44 61.44z" :fill="svgColor" p-id="8601"></path></svg>
                <svg v-else="svgName === 'relay'" t="1726563509297" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9598" width="200" height="200"><path d="M919.272727 416.581818L607.418182 79.127273c-11.636364-11.636364-32.581818-11.636364-44.218182 0-6.981818 6.981818-9.309091 16.290909-9.309091 25.6v181.527272c-258.327273 0-465.454545 207.127273-465.454545 463.127273 0 62.836364 13.963636 125.672727 39.563636 183.854546 37.236364-193.163636 221.090909-339.781818 425.890909-339.781819v181.527273c-2.327273 9.309091 2.327273 18.618182 9.309091 25.6 4.654545 6.981818 13.963636 9.309091 23.272727 9.309091s18.618182-4.654545 23.272728-11.636364L919.272727 465.454545c6.981818-6.981818 9.309091-13.963636 9.309091-23.272727s-4.654545-18.618182-9.309091-25.6z" p-id="9599" :fill="svgColor"></path></svg>
            </div>
            <div class="number">{{ number }}</div>
        </div>
    </div>
</template>

<script setup>
import { request } from '@/utils/request';
import { StatusCode } from '@/utils/statusCode';
import { ElMessage } from 'element-plus';
import { defineProps, ref, onMounted, onBeforeUnmount} from 'vue'

let state = false
let isModified = false // 记录该组件是否被用户点击过
const svgColor = ref('')

onBeforeUnmount(() => {
    if (isModified){
        switch(props.svgName){
            case 'like':
            case 'collect':
                toolbarRequest(props.svgName, state)
                break
        }        
    }

})

onMounted(() => {
    state = props.isSelect
    svgColor.value = props.isSelect ? props.selectColor : props.defaultColor
})

const toolbarRequest = (target, operate) => {
    if (operate){
        operate = 'put'
    } else {
        operate = 'delete'
    }
    request({
        url_:`/post/${target}`,
        method_: operate,
        data_:{
            userId: props.userId,
            postId: props.postId
        }
    }).then(res => {
        const {statusCode, massage} = res.data
        if (statusCode !== StatusCode.OK){
            ElMessage.error(massage)
        }
    })
}

const switchSvgColor = () => {
    isModified = true
    if (state){
        state = !state
        return props.defaultColor
    } else {
        state = !state
        return props.selectColor
    }
}

const props = defineProps({
    number:Intl,
    index:Intl,
    svgName: String,
    userId:Intl,
    postId:Intl,
    isSelect:Boolean, // 初始状态是否选中
    defaultColor: {
        type:String,
        default: '#AFB1B5'
    },
    selectColor: {
        type: String, 
        default:'#AFB1B5'
    }
})

</script>

<style lang="scss" scoped>
.out{
    .box{
        @include aboutRowCenter;
        @include clickButtonShrink;
        width: 100px;
        height: 40%;
        padding-right: 20px;

        .icon{
            width: 25px;
            height: 25px;
            svg{
                width: 100%;
                height: 100%;
            }
        }
        .number{
            padding-left: 10px;
            font-size: 12px;
            color: $fontColor999;
        }
    }
}
</style>