<template>
    <div class="out">
        <div class="header">
            <div class="text">
                CampusExchange!
            </div>
        </div>
        <div class="body">
            <home_navigation @clickOption="clickOption"/>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import home_navigation from '@/components/home_navigation.vue';
const clickOption = (index) => {
    console.log(index)
}
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
    }
}
</style>