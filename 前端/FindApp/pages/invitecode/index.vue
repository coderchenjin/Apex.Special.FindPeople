<template>
	<view>
	<view style="height:400upx;width: 100%;background-color:#1377E3; text-align: center;">
		<image src='../../static/img/LOGO.png' style="height:70%;width: 50%;" ></image>
	
	</view>
	<view style="margin: 40upx;margin-top: -200upx;">
	
		<view class="invitecodebox">
			<view style="margin: 100upx 10upx;">
				<span class="iline" style="text-align: center;">用户名：</span><Input class="zai-input iline" placeholder="请输入用户名"
				 v-model="UserName" />
			</view>
			<button class="zai-btn button-style" @tap="Submit">登录</button>
		</view>
		<view style="clear: both;"></view>
		<view>

			<view style="height:400upx;width: 100%;margin-top: -150upx">
				<image src='../../static/img/i-rooter.png' style="size:100% 100%;">
				</image>
			</view>
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
							url: 'https://zhaoren.wellwinyun.com/index/weChatAuthorization?code=' + res.code + '&name=' + cuser,
							method: 'GET',
							success: result => {
								console.log('登录成功' + result);
								var sucdata = result.data;
								if (sucdata.code == '200') {
									let openid = sucdata.data;
									uni.setStorageSync("findapp_openid", openid);
									uni.redirectTo({
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
		onLoad() {
			uni.getStorage({
				key: 'findapp_openid',
				success: function(res) {
					console.log("老用户222222222" + res.data);
					uni.redirectTo({
						url: '../backend/searchmain'
					});
				}
			});
		}
	}
</script>

<style>
	.invitecodebox {
		border: 1upx solid #006699;
		padding: 20upx;
		height: 400upx;
		/* background-image: url('../../static/img/wb.png'); */
		z-index: 999999;
		position:relative;
		margin-top: 10%;
		background-color:#FFFFFF;
		border-color: #C0C0C0;
		border-radius: 10upx;
	}

	.iline {
		display: inline-block;
	}

	.label {
		margin-top: 10upx;
		padding: 10upx 10upx;
	}

	.input-placeholder,
	.zai-input {
		background: #C0C0C0;
		border-radius: 1upx;
		padding: 5upx 0upx 5upx 0upx;
		font-size: 36upx;
		overflow: visible;
	}

	.zai-btn {
		background: #1377E3;
		color: #fff;
		border: 0;
		border-radius: 20upx;
		font-size: 36upx;
		/* margin-top: 20upx; */

	}

	.zai-btn:after {
		border: 0;
	}

	/*按钮点击效果*/
	.zai-btn.button-hover {
		transform: translate(1upx, 1upx);
	}
</style>
