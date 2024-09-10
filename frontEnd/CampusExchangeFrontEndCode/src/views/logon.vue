<template>
    <div class="out">
        <div class="box">
            <div class="title section">
                Welcome to CampusExchange!
            </div>
            <div class="section">
                <input type="text" placeholder="name" v-model="userName">
            </div>
            <div class="section">
                <input type="password" placeholder="password" v-model="userPassword">
            </div>
            <div class="section">
                <div class="logonButton" @click="clickLogonButton">
                    log on
                </div>
            </div>
            <div class="section divide">
                or
            </div>

            <div class="section">
                <div class="signUpButton" @click="clickSignUpButton">
                    sign up
                </div>
            </div>

        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { request } from '@/utils/request'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { StatusCode } from '@/utils/statusCode'

const router = useRouter()

const userName = ref("")
const userPassword = ref("")

const clickSignUpButton = () => {
    router.push('/signUp')
}

const clickLogonButton = () => {
    
    const obj = {
        data_: {
            userName: userName.value,
            userPassword: userPassword.value
        },
        method_: 'post',
        url_: '/user/logon'
    }

    request(obj).then(res => {
        const {statusCode, message} = res.data
        switch (statusCode){
            case StatusCode.OK:
                ElMessage({
                    message,
                    type: 'success',
                })
                break
            case StatusCode.unauthorized:
                ElMessage.error(message)
                break
        }
    })

}

</script>

<style lang="scss" scoped>
.out{
    margin: auto;
    position: relative;
    .box{
        width: 700px;
        height: 400px;
        margin: auto;
        margin-top: 150px;
        display: grid;
        grid-template-rows: 1fr repeat(3, 0.7fr) 0.2fr 0.7fr;
        .title{
            font-size: 36px;
            font-style: italic;
            font-family: 'AlibabaPuHuiTi-3-85-Bold';
        }
        &>.section{
            width: 100%;
            
            @include aboutColumnCenter;
            input{
                width: 240px;
                height: 34px;
                border-radius: 7px;
                padding-left: 10px;
                border: 1px solid rgba($color: #BBB7B7, $alpha: 0.6);
                @include borderGlowing;
            }
            .logonButton, .signUpButton{
                width: 250px;
                height: 34px;

                border-radius: 5px;
                @include aboutColumnCenter;
                @include clickButtonShrink;
            }
            .logonButton{
                color: white;
                background-color: $Color1570EF;
            }
            .signUpButton{
                color: $Color1570EF;
                background-color: white;
                border: 2px solid rgba($color: #BBB7B7, $alpha: 0.3);
            }
        }
        .divide{
            color: rgba($color: #BBB7B7, $alpha: 0.8);
        }

    }
}
</style>