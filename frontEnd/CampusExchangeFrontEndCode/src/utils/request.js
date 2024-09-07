import axios from 'axios';

export const request = async (obj) => {
    let { url_, data_, method_ = 'get' } = obj;

    // 转换小写字符
    method_ = method_.toLowerCase()

    const config = {
        url: 'http://localhost:8080' + url_,
        method: method_,
        timeout: 10 * 1000,
    }

    if (method_ === 'get') {
        config.params = data_
    } else if (method_ === 'post') {
        config.data = data_
    }

    return await axios(config)
};
