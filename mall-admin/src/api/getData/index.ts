import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import axios from 'axios';
export function getVisitNum() {
    return axios.get('/myapi/mall/getVisitNum')
}
