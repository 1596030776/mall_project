import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import axios from 'axios';
export function getVisitNum() {
    return axios.get('/myapi/mall/getVisitNum')
}

export function getOrderNum(){
    return axios.get('/myapi/mall/getOrderNum')
}

export function getOnlineNum(){
    return axios.get('/myapi/mall/getOnlineUserNum')
}

export function getAllGoodsInfo(){
    return axios.get('/myapi/mall/getAllGoods')
}