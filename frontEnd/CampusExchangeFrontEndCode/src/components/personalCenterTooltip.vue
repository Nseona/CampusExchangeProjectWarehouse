<template>
    <div class="out">
        <div class="tooltip">
            <div class="tooltipItem" v-for="(item, index) in options" @click="clickOption(index)">
                <div class="tooltipItemBox" :class="{select: index === selectIndex}">
                    {{ item }}
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref , defineEmits} from 'vue'
const emits = defineEmits(['clickOption'])
const options = ref(['收藏', '点赞'])
const selectIndex = ref(0)
const clickOption = (index) => {
    selectIndex.value = index
    emits('clickOption', index)
}
</script>

<style lang="scss" scoped>
.out{
    .tooltip{
        width: 100%;
        height: 65px;
        border-bottom: 1px solid $fontColoreee;
        display: flex;
        flex-direction: row;
        align-items: center;
        border-radius: 5px 5px 0 0;
        background-color: white;
        .tooltipItem{
            height: 100%;
            width: 120px;
            padding: 20px 37px 15px 37px;
            @include clickButtonShrink;
            .tooltipItemBox{
                width: 100%;
                height: 100%;
                font-size: 18px;
                font-family: 'AlibabaPuHuiTi-3-85-Bold';
                text-align: center;
                border-radius: 0;
            }
            .select{
                border-bottom: 3px solid $Color1570EF;
            }
        }
    }
}
</style>