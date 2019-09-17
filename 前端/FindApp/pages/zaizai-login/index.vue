<template>
	<!-- 插件市场 https://ext.dcloud.net.cn/plugin?id=465 -->
	<view class="zai-box">
		<image src="../../static/zaizai-login/login.png" mode='aspectFit' class="zai-logo"></image>
		<view class="zai-title">LOGO区域</view>
		<view class="zai-form">
			<!-- @input="check_User_Name" -->
			<input class="zai-input" placeholder-class placeholder="请输入用户名"  @blur="check_User_length"  v-model="User_Value"  />
			
			<view ref="warn_remind"  :class="[User_Error.length == 0 ? 'remind_none' : 'remind_display']" style="font-family: '楷体';margin-left: 7%;margin-top: 10px">{{User_Error}}</view>
			
			<input class="zai-input" placeholder-class password placeholder="请输入密码"  @blur="check_Pass_length"  v-model="PassWord_Value" />
			<!--<view class="zai-label">忘记密码？</view>-->
			<view ref="warn_remind"  :class="[Pass_Error.length == 0 ? 'remind_none' : 'remind_display']" style="font-family: '楷体';margin-left: 7%;margin-top: 10px">{{Pass_Error}}</view>
			
			<button class="zai-btn button-style" @tap="Login">立即登录</button>
			<!-- <navigator url="../zaizai-register/index" hover-class="none" class="zai-label">还没有账号？点此注册.</navigator> -->
		</view>
	</view>
</template>

<script>
	export default {
		//components: {},
		destroyed() { 

			}, 
		data() {
			return {
				User_Value:"",
				PassWord_Value:"",
				error_User_remind:true,
				User_Error:"",
				error_Pass_remind:true,
				Pass_Error:"",
			}
		},
		onLoad() {
			uni.setStorage({
				key: 'userName',
				data: '',
			});
		},
		onShow(){		

		},
		methods: {			
			check_User_length(e){
				var UserName = e.detail.value;
				if(UserName.length < 1)
				{
					this.User_Error = '请输入姓名';
				}
				else
				{
					this.User_Error = '';
				}
			},
			
			check_Pass_length(e){
				var Pass = e.detail.value;
				if(Pass.length < 1)
				{
					this.Pass_Error = '请输入密码';
				}
				else
				{
					this.Pass_Error = '';
				}
			},
			
			//登录
			Login()
			{
				//var Getopenid= uni.getStorageSync('OpenId');
				var User_Value = this.User_Value.trim();
				var Pass_Value = this.PassWord_Value.trim();
				if(User_Value.length < 1)
				{
					this.User_Error = '请输入姓名';
				}
				else
				{
					this.User_Error = '';
				}
				
				if(Pass_Value.length < 1)
				{
					this.Pass_Error = '请输入密码';
				}
				else
				{
					this.Pass_Error = '';
				}
				
				if(this.error_Pass_remind == false  || this.error_User_remind  == false)
				{
					return;
				}
				
				var Url =  this.$websiteUrl+'/api/mlogin/post';
				uni.request({
				//	url: 'http://open.orders.hscode.net:8081/index.php?r=test/testsave',
					url:Url,
					method: 'POST',
					data: {username:User_Value,password:Pass_Value},
					header: {
						'content-type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					success: res => {
						console.log('请求回执:'+res);
						//uni.hideLoading(); 
						if(res.data.code == '200')
						{
							uni.setStorage({
								key: 'userName',
								data: User_Value,
							});
							
							uni.setStorage({
								key: 'token',
								data: res.data.result,
							});
							
							console.log(uni.getStorageSync('userName'));
							uni.showToast({
								title: '成功',
								icon:'none',
								mask: false,
								duration: 2800,
								success:function(){
									console.log(User_Value);
									uni.navigateTo({
									   url:'/pages/backend/index1'
									});
								}
							});
							

						}
						else
						{
							uni.showToast({
								title: res.data.text,
								icon:'none',
								mask: false,
								duration: 12800
							});
						}
					},
					fail: failres => {
						console.log(failres);
						uni.showToast({
							title: '提交异常',
							icon:'none',
							mask: false,
							duration: 2800
						});
						
					},
					complete: () => {}
				});
			}
		}
	}
</script>

<style>
	.remind_none{
		display: none;
		color: #999999;
	}
	
	.remind_display{
		display: block;
		color: #CE0505;
	}
	
	
	.button-style{
		margin-top: 20px;
	}
	
	.zai-box{
		padding: 0 100upx;
		position: relative;
	}
	.zai-logo{
		width: 100%;
		width: 100%;
		height: 310upx;
	}
	.zai-title{
		position: absolute;
		top: 0;
		line-height: 360upx;
		font-size: 68upx;
		color: #fff;
		text-align: center;
		width: 100%;
		margin-left: -100upx;
	}
	.zai-form{
		margin-top: 300upx;
	}
	.zai-input{
		background: #e2f5fc;
		margin-top: 30upx;
		border-radius: 100upx;
		padding: 20upx 40upx;
		font-size: 36upx;
	}
	.input-placeholder, .zai-input{
		color: #94afce;
	}
	.zai-label{
		padding: 60upx 0;
		text-align: center;
		font-size: 30upx;
		color: #a7b6d0;
	}
	.zai-btn{
		background: #ff65a3;
		color: #fff;
		border: 0;
		border-radius: 100upx;
		font-size: 36upx;
	}
	.zai-btn:after{
		border: 0;
	}
	/*按钮点击效果*/
	.zai-btn.button-hover{
		transform: translate(1upx, 1upx);
	}
</style>
