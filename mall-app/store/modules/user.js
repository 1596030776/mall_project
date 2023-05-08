import {
	login,
	getUserInfo,
	logout,
	addVisitNum
} from '@/api/user'

const state = {
	hasLogin: false,
	nickname: 'www',
	avatar: '',
	balance: 10000,
	memberId: ''
}

const mutations = {
	SET_HAS_LOGIN: (state, hasLogin) => {
		state.hasLogin = hasLogin
	},
	SET_NICKNAME: (state, nickname) => {
		state.nickname = nickname
	},
	SET_AVATAR: (state, avatar) => {
		state.avatar = avatar
	},
	SET_BALANCE: (state, balance) => {
		state.balance = balance
	},
	SET_MEMBERID: (state, memberId) => {
		state.memberId = memberId
	}
}

const actions = {	
	// login({
	// 	commit
	// }, data) {
	// 	const {
	// 		mobile,
	// 		code
	// 	} = data
	// 	return new Promise((resolve, reject) => {
	// 		login(mobile,code).then(response => {
	// 			const {
	// 				access_token,
	// 				token_type
	// 			} = response.data
	// 			const token = token_type + " " + access_token
	// 			uni.setStorageSync('token', token)
	// 			commit('SET_HAS_LOGIN', true)
	// 			resolve()
	// 		}).catch(error => {
	// 			reject(error)
	// 		})
	// 	})
	// },
	

	// // get user info
	// getUserInfo({
	// 	commit,
	// 	state
	// }) {
	// 	return new Promise((resolve, reject) => {
	// 		getUserInfo().then(response => {
	// 			const {
	// 				data
	// 			} = response
	// 			if (!data) {
	// 				reject('Verification failed, please Login again.')
	// 			}
	// 			const {
	// 				id,
	// 				nickName,
	// 				avatarUrl,
	// 				balance
	// 			} = data
	// 			commit('SET_NICKNAME', nickName)
	// 			commit('SET_AVATAR', avatarUrl)
	// 			commit('SET_BALANCE', balance)
	// 			commit('SET_MEMBERID', id)
	// 			resolve(data)
	// 		}).catch(error => {
	// 			reject(error)
	// 		})
	// 	})
	// },
	
	login({
		commit
	}, data) {
		const {
			username,
			password,
			phoneNumber
		} = data
		return new Promise((resolve, reject) => {
			login(username,password,phoneNumber).then(response => {
				commit('SET_HAS_LOGIN', true)
				resolve()
			}).catch(error => {
				reject(error)
			})
			addVisitNum()
		})
	},
	
	
	// get user info
	getUserInfo({
		commit,
	}, username) {
		return new Promise((resolve, reject) => {
			getUserInfo(username).then(response => {
				commit('SET_NICKNAME', response.data.username)
				commit('SET_AVATAR', response.data.imageUrl)
				commit('SET_BALANCE', response.data.account)
				commit('SET_MEMBERID', response.data.id)
				resolve()
			}).catch(error => {
				reject(error)
			})
		})
	},

	// user logout
	logout({
		commit,
		state,
	}) {
		
		return new Promise((resolve, reject) => {
			logout().then(() => {
				console.log('logout')
				uni.removeStorageSync("userInfo")
				uni.removeStorageSync("token")
				commit('SET_HAS_LOGIN', false)
				commit('SET_NICKNAME', '')
				commit('SET_AVATAR', '')
				commit('SET_BALANCE', '')
				commit('SET_MEMBERID', '')
				resolve()
			}).catch(error => {
				reject(error)
			})
		})
	}
}

export default {
	namespaced: true,
	state,
	mutations,
	actions
}
