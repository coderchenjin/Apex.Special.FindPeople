<template>
	<view>
		<input class="zai-input" placeholder-class placeholder="请输入邀请码"  v-model="Invite_Code" />
		<button class="zai-btn button-style" @tap="Submit">提交</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				Invite_Code: '',
				Is_Checkt:false,
				User_Error:''
			}
		},
		methods: {
			check_code(e) {
				var code = e.detail.value;
				if (code != "1234") {
					this.User_Error = '请输入邀请码';
				} else {
					this.User_Error = '';
					Is_Checkt=true;
				}
			},
			Submit(e)
			{
				//var code = e.detail.value;
				if (Invite_Code != "1234") {
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
			// var Url = '/pages/backend/searchhome';
			// uni.navigateTo({
			// 	url: Url
			// });
		},
	}
</script>

<style>

</style>
