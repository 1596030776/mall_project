import request from '@/utils/request'

export function getAllGoodsInfo() {
	return request({
		url: '/mall/getAllGoods',
		method: 'get',
	})
}