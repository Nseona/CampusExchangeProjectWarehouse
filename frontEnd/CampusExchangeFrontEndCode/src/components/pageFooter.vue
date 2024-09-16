<template>
    <div class="out">
        <div class="pageFooter">
            <div class="pageFooterBox">
                <div class="text">
                    来自庄庄子的demo
                </div>
                <div class="text">
                    <span>网站首页</span>|<span>意见反馈</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.out{
    .pageFooter{
        padding-top: 5px;
        .pageFooterBox{
            width: 100%;
            height: 80px;
            background-color: white;
            @include aboutRowCenter;
            .text{
                width: 200px;
                font-size: 16px;
                color: #888787;
                @include aboutRowCenter;
            }           
        }
    }
}
</style>