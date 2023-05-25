/**
 * 用户相关api
 */
import request from '@/utils/request'
import user from '../store/modules/user'

// H5/Android/IOS 手机短信验证码登录
// #ifndef MP
// export function login(mobile, code) {
// 	return request({
// 		url: '/youlai-auth/oauth/token',
// 		method: 'post',
// 		params: {
// 			mobile: mobile,
// 			code: code,
// 			grant_type: 'sms_code'
// 		},
// 		headers: {
// 			'Authorization': 'Basic bWFsbC1hcHA6MTIzNDU2' // 客户端信息Base64加密，明文：mall-app:123456
// 		}
// 	})
// }

export function login(username, password, phoneNumber) {
	// return request({
	// 	url: '/user/userSignIn',
	// 	method: 'post',
	// 	data: {
	// 		username: username,
	// 		password: password,
	// 		phoneNumber: phoneNumber
	// 	},
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/user/userSignIn',
	    method: 'POST',
		data: {
			username: username,
			password: password,
			phoneNumber: phoneNumber
		},
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

export function addVisitNum() {
	// return request({
	// 	url: '/mall/orderVisitIncrease',
	// 	method: 'post',
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/mall/orderVisitIncrease',
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

export function addOnlineNum() {
	// return request({
	// 	url: '/mall/onlineUserNumIncrease',
	// 	method: 'post',
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/mall/onlineUserNumIncrease',
	    method: 'POST',
	    success: res => {
	      resolve(res)
	    },
	    fail: err => {
	      console.log(err)
	      reject(err)
	    }
	  })
	})
}

export function minusOnlineNum() {
	// return request({
	// 	url: '/mall/onlineUserNumSub',
	// 	method: 'post',
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/mall/onlineUserNumSub',
	    method: 'POST',
	    success: res => {
	      resolve(res)
	    },
	    fail: err => {
	      console.log(err)
	      reject(err)
	    }
	  })
	})
}

export function register(username, password, phoneNumber) {
	// return request({
	// 	url: '/user/register',
	// 	method: 'post',
	// 	data: {
	// 		username: username,
	// 		password: password,
	// 		phoneNumber: phoneNumber
	// 	}
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/user/register',
	    method: 'POST',
		data: {
			username: username,
			password: password,
			phoneNumber: phoneNumber
		},
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
// #endif



// export function logout() {
// 	return request({
// 		url: '/youlai-auth/oauth/logout',
// 		method: 'delete',
// 		headers: {
// 			'auth': true // 需要认证，通过
// 		}
// 	})
// }

export function logout(username) {
	// return request({
	// 	url: '/user/userLogout',
	// 	method: 'post',
	// 	data: {
	// 		username: username,
	// 	}
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/user/userLogout',
	    method: 'POST',
		data: {
			username: username
		},
	    success: res => {
	      resolve(res)
	    },
	    fail: err => {
	      console.log(err)
	      reject(err)
	    }
	  })
	})
}

export function getUserInfo(username) {
	// return request({
	// 	url: '/user/getUserInfo',
	// 	method: 'post',
	// 	data: {
	// 		username: username
	// 	}
	// })
	
	return new Promise((resolve, reject) => {
	  uni.request({
	    url: 'http://121.199.1.81:8080/user/getUserInfo',
	    method: 'POST',
		data: {
			username: username
		},
	    success: res => {
	      console.log(res.data.data)
	      resolve(res.data)
	    },
	    fail: err => {
	      console.log(err)
	      reject(err)
	    }
	  })
	})
}
