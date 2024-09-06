<template>
    <div class="out">
        <div class="box">
            <div class="title section">
                Sign up
            </div>

            <div class="section">
                <input type="text" placeholder="name" v-model="userName">
            </div>

            <div class="section">
                <input type="password" placeholder="password" v-model="userPassword">
            </div>

            <div class="section">
                <div class="signUpButton" @click="clickSignUpButton">
                    sign up
                </div>
            </div>

            <div class="section prompt">
                <p>
                    Do you already have an account? <span @click="clickLogonButton">Go login</span>
                </p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { request } from '@/utils/request'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import  { StatusCode }  from '@/utils/statusCode'

const router = useRouter()

const userName = ref("")
const userPassword = ref("")

const clickLogonButton = () => {
    router.push('/logon')

}

const clickSignUpButton = () => {
    // 只包含数字字母下划线
    let userNameRegex = /^[A-Za-z0-9_]+$/

    // 密码至少 8 位
    let userPasswordRegex = /^[A-Za-z0-9_]{8,}$/

    if (!userNameRegex.test(userName.value)) {
        ElMessage.error('Username format error, Contains only numbers, letters, underscores')
        return
    }

    if (!userPasswordRegex.test(userPassword.value)) {
        ElMessage.error('userPassword format error, Contains only numbers, letters, underscores')
        return
    }

    const obj = {
        url_: '/user/signup',
        data_: {
            userName: userName.value,
            userPassword: userPassword.value
        },
        method_: 'post'
    }

    request(obj).then(res => {
        const {statusCode, message} = res.data
        switch (statusCode){
            case StatusCode.OK:
                ElMessage({
                    message,
                    type: 'success',
                })
                router.push('/logOn')
                break
            case StatusCode.unknownServerError:
                ElMessage({
                    message,
                    type: 'warning',
                })
                break
            case StatusCode.nonStandard:
                ElMessage.error(message)
                break
        }
    })
}
</script>

<style lang="scss" scoped>
.out {
    // width: 1440px;
    // min-height: 810px;
    margin: auto;
    position: relative;

    .box {
        width: 700px;
        height: 400px;
        margin: auto;
        margin-top: 150px;
        display: grid;
        grid-template-rows: 1fr repeat(3, 0.7fr) 0.1fr;

        .title {
            font-size: 36px;
            font-style: italic;
            font-family: 'AlibabaPuHuiTi-3-85-Bold';
        }

        &>.section {
            width: 100%;
            position: relative;
            @include aboutColumnCenter;

            input {
                width: 240px;
                height: 34px;
                border-radius: 7px;
                padding-left: 10px;
                border: 1px solid rgba($color: #BBB7B7, $alpha: 0.6);
                @include borderGlowing;
            }

            .signUpButton {
                width: 250px;
                height: 34px;

                border-radius: 5px;
                @include aboutColumnCenter;
                @include clickButtonShrink;
                color: white;
                background-color: $Color1570EF;
            }
        }

        .prompt {
            color: rgba($color: #BBB7B7, $alpha: 0.8);

            span,
            p {
                font-size: 12px;
            }

            span {
                color: $Color1570EF;
            }

            span:hover {
                text-decoration: underline;
            }
        }

    }
}
</style>