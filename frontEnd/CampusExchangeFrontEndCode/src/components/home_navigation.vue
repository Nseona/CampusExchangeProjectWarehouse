<template>
    <div class="out">
        <div class="navigation">
            <div class="box">
                <div class="item" v-for="(item, index) in navItems" @click="clickOption(index)">
                    <div 
                        class="box" 
                        :class="{selected: activeIndex === index}">
                        {{item}}
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue'
const navItems  = ref(['首页', '选项1', '选项1'])
const activeIndex = ref(0);
const emits = defineEmits(['clickOption'])

const clickOption = (index) => {
    activeIndex.value = index
    emits('clickOption', index)
}

</script>

<style lang="scss" scoped>
.out{
    .navigation{
            width: 100%;
            height: 60px;
            padding: $gap_padding;
            .box{
                width: 100%;
                height: 100%;
                border-radius: 5px;
                background-color: white;

                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: start;

                .item{
                    width: 110px;
                    height: 100%;
                    padding: 10px;

                    .box{
                        width: 100%;
                        height: 100%;
                        border-radius: 5px;
                        @include aboutColumnCenter;
                        @include clickButtonShrink;

                        font-size: 16px;
                        font-family: 'AlibabaPuHuiTi-3-85-Bold';
                    }

                    .selected{
                        background-color: $Color1570EF;
                        color: white;
                    }

                    .notSelected{
                        color: black;
                    }
                }
            }
        }
}
</style>