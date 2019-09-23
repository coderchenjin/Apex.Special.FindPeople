<template>
	<view>
		<view style="margin-left: 5%; ">请输入邀请码:</view>
		<input class="zai-input" placeholder-class placeholder="请输入邀请码" v-model="Invite_Code" />
		<button class="zai-btn button-style" @tap="Submit">提交</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				Invite_Code: '',
				Is_Checkt: false,
				User_Error: ''
			}
		},
		methods: {
			check_code(e) {
				var code = e.detail.value;
				if (code != "1234") {
					this.User_Error = '请输入邀请码';
				} else {
					this.User_Error = '';
					Is_Checkt = true;
				}
			},
			Submit(e) {
				
				if (this.Invite_Code != "1234") {
					this.User_Error = '请输入邀请码';
				} else {
					var Url = '/pages/backend/searchhome';
					uni.navigateTo({
						url: Url
					});
				}
			}
		},
		onLoad() {
			var Url = '/pages/backend/searchhome';
			uni.navigateTo({
				url: Url
			});
		},
	}
</script>

<style>
.zai-input{
		background: #e2f5fc;
		margin-top: 30upx;
		border-radius: 100upx;
		padding: 20upx 40upx;
		font-size: 36upx;
		margin-top: 50upx;
	}
	.input-placeholder, .zai-input{
		color: #94afce;
	}
	
	.zai-btn{
		background: #ff65a3;
		color: #fff;
		border: 0;
		border-radius: 100upx;
		font-size: 36upx;
		margin-top: 50upx;
	}
	.zai-btn:after{
		border: 0;
	}
	/*按钮点击效果*/
	.zai-btn.button-hover{
		transform: translate(1upx, 1upx);
	}
</style>
