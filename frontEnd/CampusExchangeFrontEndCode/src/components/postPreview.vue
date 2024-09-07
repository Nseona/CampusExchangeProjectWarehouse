<template>
    <div class="out">
        <div class="item">
            <div class="box">
                <div class="left">
                    <div class="box"></div>
                </div>

                <div class="right">
                    <div class="title">
                        {{ title }}
                    </div>
                    <div class="text">
                        {{ text }}
                    </div>
                </div>

                <div class="author">
                    {{ author }}
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { defineProps } from 'vue'
const props = defineProps({
    title: String,
    text: String,
    author: String,
    imgUrl: String
})
</script>

<style lang="scss" scoped>
.out{
    .item{
        background-color: white;
        width: 100%;
        height: 135px;
        padding: 10px;
        .box{
            @include clickButtonShrink;
            position: relative;
            border-bottom: 1px solid #EEEEEE;
            display: grid;
            grid-template-columns: 1fr 4fr;

            &>div{
                height: 115px;
            }

            .left{
                padding: 0 10px 10px 0;
                .box{
                    width: 100%;
                    height: 100%;
                    background-color: rgb(172, 167, 197);
                }
            }

            .right{
                display: grid;
                grid-template-rows: 1fr 4fr;
                &>div{
                    width: 100%;
                }
                .title{
                    font-size: 16px;
                    font-family: 'AlibabaPuHuiTi-3-85-Bold';

                    display: flex;
                    flex-direction: row;
                    align-items: center;
                    justify-content: start;
                    
                    padding: 0 0 10px 10px;
                }

                .text{
                    padding: 0 0 10px 10px;
                    font-size: 14px;
                }
            }

            .author{
                font-size: 14px;
                min-width: 60px;
                max-width: 120px;
                height: fit-content;
                text-align: right;
                color: #D6D6D6;

                position: absolute;
                bottom: 0;
                right: 0;

                padding: 10px 0 10px 0
            }
        }
    }
}

</style>