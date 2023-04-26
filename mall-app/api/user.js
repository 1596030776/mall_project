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
	return request({
		url: '/user/userSignIn',
		method: 'post',
		data: {
			username: username,
			password: password,
			phoneNumber: phoneNumber
		},
	})
}

export function register(username, password, phoneNumber) {
	return request({
		url: '/user/register',
		method: 'post',
		data: {
			username: username,
			password: password,
			phoneNumber: phoneNumber
		}
	})
}
// #endif



export function logout() {
	return request({
		url: '/youlai-auth/oauth/logout',
		method: 'delete',
		headers: {
			'auth': true // 需要认证，通过
		}
	})
}

// export function getUserInfo() {
// 	return request({
// 		url: '/mall-ums/app-api/v1/members/me',
// 		method: 'get',
// 		headers: {
// 			'auth': true
// 		}
// 	})
// }
export function getUserInfo(username) {
	return request({
		url: '/user/getUserInfo',
		method: 'post',
		data: {
			username: username
		}
	})
}
// export function getUserInfo(name) {
// 	uni.request({
// 		url: `http://121.199.1.81:8080/user/getUserInfo`,
// 		method:'POST',
// 		data: {
// 			username: name
// 		},
// 		success(res) {
// 			console.log(res)
// 		},
// 		fail(err) {
// 			console.log(err)
// 		}
// 	})
// }