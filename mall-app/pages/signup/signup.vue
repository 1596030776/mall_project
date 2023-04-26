<template>
	<view class="container">
		<view class="left-bottom-sign"></view>
		<view class="right-top-sign"></view>

		<view class="register-form">
			<view class="register">注册</view>
			<view style="margin-bottom: 20rpx;"><uni-easyinput v-model="form.username" prefixIcon="person-filled"
					placeholder="请输入您的用户名"></uni-easyinput></view>
			<view style="margin-bottom: 20rpx;"><uni-easyinput v-model="form.phoneNumber" prefixIcon="phone-filled"
					placeholder="请输入您的用户名"></uni-easyinput></view>
			<view style="margin-bottom: 20rpx;"><uni-easyinput type="password" v-model="form.password"
					prefixIcon="locked-filled" placeholder="请输入您的密码"></uni-easyinput></view>
			<view style="margin-bottom: 20rpx;"><uni-easyinput type="password" v-model="form.password"
					prefixIcon="locked-filled" placeholder="请确定您的密码"></uni-easyinput></view>
			<button class="button" type="text" @click="toRegister">注册</button>
<!-- 			<button class="button2" type="text" @click="toLogin">返回登录</button> -->
		</view>
	</view>
</template>

<script>
	import {
		register
	} from '@/api/user.js';
	export default {
		data() {
			return {
				form: {
					username: 'admin',
					password: '123456',
					phoneNumber: '17621590365'
				},
				countdown: 0
			};
		},
		methods: {
			// toLogin() {
			// 	uni.navigateTo({
			// 		url: "/pages/login/login"
			// 	})
			// },

			//  #ifndef MP
			async toRegister() {
				console.log("点击注册")
				let result;
				try {
					result = await register(this.form.username, this.form.password, this.form.phoneNumber)
					// 处理注册结果
					console.log(result)
					if (result.success) {
						uni.showToast({
							title: '注册成功'
						})
					} else {
						uni.showToast({
							title: result.message,
							icon: 'none'
						})
					}
				} catch (err) {}
			},
			// #endif
		}
	}
</script>

<style lang="scss">
	page {
		background: #fff;
	}

	.container {
		padding-top: 115px;
		position: relative;
		width: 100vw;
		height: 100vh;
		overflow: hidden;
		background: #fff;
	}

	.register {
		font-size: 60rpx;
		color: #2a81f3;
		text-align: center;
		margin-bottom: 20rpx;

	}

	.register-form {
		width: 450rpx;
		height: 150rpx;
		margin: auto;
		margin-top: 100rpx;
	}

	.button {
		margin-top: 15rpx;
		background-color: #63d6ff;
		color: #fff;
	}

	.button2 {
		margin-top: 15rpx;
		background-color: #ff3a3d;
		color: #fff;
	}

	.return {
		color: blue;
	}

	.left-bottom-sign {
		position: absolute;
		left: -270upx;
		bottom: -320upx;
		border: 100upx solid #d0d1fd;
		border-radius: 50%;
		padding: 180upx;
	}

	.right-top-sign {
		position: absolute;
		top: 80upx;
		right: -30upx;
		z-index: 95;

		&:before,
		&:after {
			display: block;
			content: '';
			width: 400upx;
			height: 80upx;
			background: #b4f3e2;
		}

		&:before {
			transform: rotate(50deg);
			border-radius: 0 50px 0 0;
		}

		&:after {
			position: absolute;
			right: -198upx;
			top: 0;
			transform: rotate(-50deg);
			border-radius: 50px 0 0 0;
			/* background: pink; */
		}
	}
</style>