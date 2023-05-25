import request from '@/utils/request'

export function getAllGoodsInfo(callback) {
	// return request({
	// 	url: '/mall/getAllGoods',
	// 	method: 'get',
	// })
	  return new Promise((resolve, reject) => {
	    uni.request({
	      url: 'http://121.199.1.81:8080/mall/getAllGoods',
	      method: 'GET',
	      success: res => {
	        console.log(res.data.data)
	        resolve(res.data.data)
	      },
	      fail: err => {
	        console.log(err)
	        reject(err)
	      }
	    })
	  })
}

export function addOrderNum() {
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/mall/orderNumIncrease',
	    method: 'POST',
	    success: res => {
	      console.log(res)
	      resolve(res)
	    },
	    fail: err => {
	      console.log(err)
	      reject(err)
	    }
	  })
	})
}