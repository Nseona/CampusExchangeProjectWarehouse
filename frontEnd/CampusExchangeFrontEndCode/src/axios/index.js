import { StatusCode } from '@/utils/statusCode';
import { ElMessage } from 'element-plus';
import router from '@/router';
import axios from 'axios';

axios.interceptors.request.use(
    config => {
        const token = localStorage.getItem('token');
        if (token) {
            config.headers['token'] = token;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

axios.interceptors.response.use(
    response => {
        const { statusCode, message } = response.data

        if (statusCode === StatusCode.refuse) {
            ElMessage.error(`${message} 请登录`)
            router.push('/logOn')
        } else if (statusCode !== StatusCode.OK) {
            ElMessage.error(message)
        }

        return response;
    },
    error => {
        return Promise.reject(error);
    }
);

export default axios;