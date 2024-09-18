<template>
    <div class="out">
        <div class="header" :style="{height}">
            <div class="text">
                CampusExchange!
            </div>
        </div>
    </div>
</template>

<script setup>
import { defineProps } from 'vue';
const props = defineProps({
    height: {
        type: String,
        default: '115px'
    }
})
</script>

<style lang="scss" scoped>
.out{
    background-color: $backgroundColorPage;
    .header{
        width: 100vw;
        background-color: white;
        margin-bottom: $gap_padding;
        .text{
            width: 370px;
            height: 100%;
            @include aboutColumnCenter;
            font-size: 40px;
            font-family: 'AlibabaPuHuiTi-3-85-Bold';
            font-style: italic;
        }
        padding-left: 20%;
    }
}
</style>