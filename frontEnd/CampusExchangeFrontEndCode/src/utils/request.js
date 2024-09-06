import axios from 'axios';

export const request = async (obj) => {
    const { url_, data_, method_ = 'get', timeout_ = 10000 } = obj;
    return await axios({
        url: 'http://localhost:8080' + url_,
        data: {
            ...data_,
        },
        method: method_,
        timeout: timeout_,
    })
};
