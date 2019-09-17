<template>
	<view>
		<view style="text-align:center;font-size:120%">搜索</view>
		<view class="uni-flex uni-column">
			<view>
				<input class="zai-input input-class" placeholder-class placeholder="搜索人名,项目" v-model="big" :focus="bigfocus"
				 @confirm="big_confirm" @focus="focus_big" style="float:left;" />

				<view style="margin-right: 6%;color: #CE0505;" :style="{display:TotalInpectionBig.length > 0 ? 'bolck' : 'none',float:'right'}">{{TotalInpectionBig}}个查验小包</view>
			</view>
			<view style="clear: both;"></view>

、
				<view class="uni-flex flex-item uni-row">
					<view class="flex-item uni-bg-grey">
						<button type="default">搜索历史</button>
					</view>
					<view class="flex-item uni-bg-grey">
						<button type="default">清空</button>
					</view>
					<view class="flex-item uni-bg-grey">
						<button type="default">清空</button>
					</view>
					<view class="flex-item uni-bg-grey">
						<button type="default">清空</button>
					</view>
					<view class="flex-item uni-bg-grey">
						<button type="default">清空</button>
					</view>
				</view>
	、
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
				InpectionSmallBigData: []
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
		width: 90%;
		height: 50px;
		margin-left: 5%;
		margin-right: 5%;
		margin-bottom: 10px;
		border: 1px solid #0e141a;
		line-height: 50px;
		border-radius: 10px;

	}

	,
	.remind_display {
		display: block;
		color: #CE0505;
	}

	.clearclass {
		float: left;
		font-size: 1;

		line-height: 50px;
		margin-right: 5%;
		margin-left: 2px;
	}

	,
	.Textclass {
		font-size: 80%;
		margin-left: 20px;
		margin-bottom: 5px;
	}

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
