<template>
    <div class="out">
        <div class="item">
            <div :class="{ box:true, haveImg:base64 }" ref="box" >
                <div class="left" v-show="base64">
                    <div class="imgBox">
                        <img :src = "'data:image/png;base64,' + base64"/>
                    </div>
                </div>

                <div class="right">
                    <div class="title">
                        {{ title }}
                    </div>
                    <div class="text">
                        <el-text line-clamp="2">
                            {{ text }}
                        </el-text>
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
import { defineProps , ref} from 'vue'
import { ElText } from 'element-plus'

const box = ref(null)

const props = defineProps({
    title: String,
    text: String,
    author: String,
    postId: Number,
    base64: String
})
</script>

<style lang="scss" scoped>
.out{
    .item{
        background-color: white;
        width: 100%;
        height: 135px;
        padding: $gap_padding;
        .box{
            position: relative;
            border-bottom: 1px solid #EEEEEE;

            &:hover {
                cursor: pointer;
            }

            &>div{
                height: 115px;
            }

            .left{
                padding: $gap_padding;
                .imgBox{
                    width: 100%;
                    height: 100%;
                    border-radius: 7px;
                    overflow: hidden;

                    img {
                        width: 100%;
                        height: 100%; 
                        object-fit: cover; 
                    }
                }
            }

            .right{
                display: grid;
                grid-template-rows: 1fr 4fr;
                width: 100%;
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
                    
                    padding: $gap_padding;
                }

                .text{
                    padding: $gap_padding;
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

                padding: $gap_padding;
            }
        }

        .haveImg{
            display: grid;
            grid-template-columns: 1fr 4fr;
        }

        .notHaveImg{
            display: block;
            grid-template-columns: none;
        }
    }
}

</style>