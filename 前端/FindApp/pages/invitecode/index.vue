<template>
	<view style="margin: 40upx;">
		<view class="invitecodebox">
			<view style="margin: 100upx 10upx;">
				<span class="iline ">用户名：</span><input class="zai-input iline" placeholder="请输入用户名" v-model="UserName" />
			</view>
		</view>
		<view>
			<button class="zai-btn button-style" @tap="Submit">登录</button>
			<view style="height:400upx;width: 100%;background: url('/static/img/u2.png') no-repeat;background-size:100% 100%;">
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				Invite_Code: '',
				Is_Check: false,
				error_User_remind: true,
				User_Error: '',
				WXCode: '',
				UserName: '',
			}

		},
		methods: {

			Submit(e) {

				if (this.UserName.length < 1) {
					uni.showToast({
						title: '请输入用户名',
						icon: 'none',
						mask: false,
						duration: 3000
					});
					return;
				}
				let cuser = this.UserName;
				uni.login({
					provider: 'weixin',
					success: function(res) {
						let currentwxcode = res.code;
						uni.setStorageSync("findapp_wxcode", currentwxcode);
						console.log('微信CODE' + currentwxcode)
						uni.request({
							url: 'http://218.80.251.194:7788/index/weChatAuthorization?code=' + res.code + '&name=' + cuser,
							method: 'GET',
							success: result => {
								console.log('登录成功' + result);
								var sucdata = result.data;
								if (sucdata.code == '200') {
									let openid = sucdata.data;
									uni.setStorageSync("findapp_openid", openid);
									uni.navigateTo({
										url: '../backend/searchmain'
									});
								} else if (sucdata.code == '400') {
									uni.showToast({
										title: '用户不存在',
										icon: 'none',
										mask: false,
										duration: 3000
									});
								} else {
									uni.showToast({
										title: '登录失败',
										icon: 'none',
										mask: false,
										duration: 3000
									});
								}
							},
							fail: failres => {
								console.log('登录失败' + failres);
								uni.showToast({
									title: '登录失败',
									icon: 'none',
									mask: false,
									duration: 3000
								});
							},
						});
						// uni.navigateTo({
						// 	url: '../backend/searchmain'
						// });
					},
					fail(fdata) {
						console.log('获取code失败');
						uni.showToast({
							title: '获取code失败',
							icon: 'none',
							mask: false,
							duration: 3000
						});
					}
				})
			}
		},
		onShow() {



		},
	}
</script>

<style>
	.invitecodebox {
		border: 1upx solid #006699;
		padding: 20upx;
		height: 400upx;
	}

	.iline {
		display: inline-block;
	}

	.label {
		margin-top: 10upx;
		padding: 10upx 10upx;

	}

	.zai-input {
		background: #C8C7CC;


	}

	.input-placeholder,
	.zai-input {
		background: #C8C7CC;
		border-radius: 1upx;
		padding: 5upx 10px;
		font-size: 36upx;
	}

	.zai-btn {
		background: #1377E3;
		color: #fff;
		border: 0;
		border-radius: 20upx;
		font-size: 36upx;
		margin-top: 20upx;

	}

	.zai-btn:after {
		border: 0;
	}

	/*按钮点击效果*/
	.zai-btn.button-hover {
		transform: translate(1upx, 1upx);
	}
</style>
