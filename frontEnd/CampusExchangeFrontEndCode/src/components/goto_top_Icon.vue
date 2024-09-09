<template>
    <div class="out">
        <div class="gototop_icon" @click="goTop">
            <img src="../assets/img/png/go_to_top.png"/>
        </div>
    </div>
</template>

<script setup>
const goTop = () => {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}
</script>

<style lang="scss" scoped>
.out{
    .gototop_icon{
        position: fixed;
        bottom: 50px;
        right: 120px;

        width: 50px;
        height: 50px;

        @include clickButtonShrink;

        img{
            width: 100%;
            height: 100%;
        }
    }
}
</style>