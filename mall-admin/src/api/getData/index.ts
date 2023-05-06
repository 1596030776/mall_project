import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import axios from 'axios';

export function getVisitNum() {
    // return request({
    //     url:"mall/getVisitNum",
    //     method:"get"
    // })

    axios.get('http://121.199.1.81:8080/mall/getVisitNum')
        .then(response => {
            // 处理响应数据
            console.log(response);
            console.log("yes")
        })
        .catch(error => {
            // 处理错误
            console.log(error);
        });
}