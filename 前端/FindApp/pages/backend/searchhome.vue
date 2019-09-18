<template>
	<view style="height: 100%;">
		<view>
			<view style="height: 295px;width: 100%;background: url('/static/img/bg1.png') no-repeat;background-size:100% 100%;">
				<input class="uni-input input-class" placeholder-class :placeholder="icon" v-model="big" :focus="bigfocus"
				 confirm-type="search" @confirm="big_confirm" @focus="focus_big" style="float:left;" />
			</view>
			<view style="height: 10px;"></view>
			<view style="height: 50%;width: 100%;" class="uni-padding-wrap uni-common-mt">
				<view style="float:right;margin-right: 5%;">清空</view>
				<view style="margin-left: 5%;">搜索历史</view>

				<view><button type="default" size="mini">页面主操作 Disabled</button></view>
				<view><button type="default" size="mini">页面主操作 Disabled</button></view>
				<view><button type="default" size="mini">页面主操作 Disabled</button></view>

			</view>


			<view style="clear: both;"></view>


		</view>
	</view>
</template>
<script>
	export default {
		components: {},
		destroyed() {

		},
		data() {
			return {
				big: "",
				bigfocus: true,
				smallbigfocus: false,
				smallbig: "",

				ErrorRemind: "",
				InWareHouseNumber: 0,
				bigdisabled: "disabled",
				TotalInpectionBig: 0,
				InpectionSmallBigData: [],

				icon: '搜索人名、项目'
			}
		},
		onLoad() {
			this.bigfocus = true;
			this.big = '';
			this.smallbigfocus = false;
			this.smallbig = '';
			this.ErrorRemind = '';
			this.InWareHouseNumber = 0;
			this.bigdisabled = "disabled";
			this.TotalInpectionBig = 0;
			this.InpectionSmallBigData = [];
		},
		onShow() {
			this.bigfocus = true;
			this.big = '';
			this.smallbigfocus = false;
			this.smallbig = '';
			this.ErrorRemind = '';
			this.InWareHouseNumber = 0;
			this.bigdisabled = "disabled";
			this.TotalInpectionBig = 0;
			this.InpectionSmallBigData = [];
		},
		methods: {
			focus_big() {
				if (this.big.length > 0) {
					this.big = '';
					this.smallbig = '';
					this.TotalInpectionBig = 0;
					this.InWareHouseNumber = 0;
				}
				setTimeout(() => {
					uni.hideKeyboard();
				}, 500);
			},
			smallbig_focus() {
				if (this.smallbig.length > 0) {
					this.smallbig = '';
				}
				setTimeout(() => {
					uni.hideKeyboard();
				}, 500);
			},
			//大包
			big_confirm() {

				var big = this.big.trim();
				console.log('该大包：' + this.big);
				if (big.length < 1) {
					this.bigdisabled = "disabled";
					this.TotalInpectionBig = 0;
					return;
				}
				var user = uni.getStorageSync('userName');
				var token = uni.getStorageSync('token');
				var Url = this.$websiteUrl + '/api/mbag/getcheckcount?bagid=' + big + '&user=' + user + '&token=' + token;
				uni.request({
					url: Url,
					method: 'GET',
					header: {
						'content-type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					success: res => {
						console.log('请求回执:' + JSON.stringify(res.data));
						if (res.data.code == '999') {
							uni.navigateTo({
								url: '/pages/zaizai-login/index'
							});
						}
						if (res.data.code == '200') {
							this.ErrorRemind = '';
							this.InWareHouseNumber = res.data.result == null ? 0 : res.data.result;

							if (res.data.result == 0) {
								this.TotalInpectionBig = 0;
								this.ErrorRemind = '不存在查验小包';
								this.bigfocus = true;
								this.smallbigfocus = false;
								//this.TotalBigStatus =false;
							} else {
								this.bigfocus = false;
								this.smallbigfocus = true;
								this.TotalInpectionBig = res.data.result;
								this.bigdisabled = false;
								this.TotalBigStatus = true;
							}

							console.log(this.TotalInpectionBig);
						} else {
							this.TotalInpectionBig = 0;
							this.ErrorRemind = res.data.text;
							this.big = '';
						}
					},
					fail: failres => {
						this.ErrorRemind = "请求异常";
						return;
					},
					complete: () => {}
				});

			},
			//小包
			smallbig_confirm() {
				console.log('该小包：' + this.smallbig);

				var big = this.big.trim();
				if (big.length < 1) {
					this.bigdisabled = "disabled";
					this.TotalInpectionBig = 0;
					this.ErrorRemind = '请先填充大包号';
					return;
				}

				var smallbig = this.smallbig.trim();
				if (smallbig.length < 1) {
					return;
				}
				var user = uni.getStorageSync('userName');
				var token = uni.getStorageSync('token');
				var url = this.$websiteUrl + '/api/mpackage/get?assbillno=' + smallbig + '&bagid=' + big + '&user=' + user +
					'&token=' + token;
				uni.request({
					url: url,
					method: 'GET',
					header: {
						'content-type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					success: res => {
						console.log('请求回执:' + JSON.stringify(res.data));
						if (res.data.code == '999') {
							uni.navigateTo({
								url: '/pages/zaizai-login/index'
							});
						}
						//return;
						if (res.data.code == '200') {
							this.ErrorRemind = '';
							//console.log(typeof(this.InpectionSmallBigData));
							this.smallbig = '';
							this.smallbigfocus = true;
							if (this.InpectionSmallBigData[big] == undefined) {
								this.InpectionSmallBigData[big] = [];
							}
							//return;
							this.InpectionSmallBigData[big] = this.InpectionSmallBigData[big].concat([smallbig]);

							var NewArray = new Map();
							this.InpectionSmallBigData[big] = this.InpectionSmallBigData[big].filter(function(value) {
								console.log('xunhuan' + value);
								return !NewArray.has(value) && NewArray.set(value, 1)
							});

							var count = this.InpectionSmallBigData[big].length;
							this.InWareHouseNumber = this.TotalInpectionBig - count;
						} else {
							this.ErrorRemind = res.data.text;
							this.smallbig = '';
							this.smallbigfocus = true;
						}
					},
					fail: failres => {
						this.ErrorRemind = "请求异常";
						return;
					},
					complete: () => {}
				});
			},
		}
	}
</script>

<style>
	.input-class {
		width: 80%;
		height: 38px;
		margin-left: 10%;
		margin-right: 10%;
		margin-top: 235px;
		border: 0px;
		line-height: 50px;
		border-radius: 20px;
		background: #F8F8F8;
		font-size: 16px;
		text-align: center;

	}

	,

	.input-disabled {
		background-color: #C8C7CC;
	}

	/* 	.zai-input{
		background: #e2f5fc;
		margin-top: 30upx;
		border-radius: 100upx;
		padding: 20upx 40upx;
		font-size: 36upx;
	} */
</style>
