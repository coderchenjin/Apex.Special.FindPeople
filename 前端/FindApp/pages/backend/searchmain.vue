<template>
	<view>
		<view style="top:10px">
			<input class="uni-input input-class" placeholder-class :placeholder="icon" v-model="big" :focus="bigfocus"
			 confirm-type="search" @input="big_input" @confirm="big_confirm" style="float:left;" />
			<view ref="warn_remind" :class="[ErrorRemind.length == 0 ? 'remind_none' : 'remind_display']" style="font-family: '楷体';margin-left: 7%;margin-top: 10px">{{ErrorRemind}}</view>

		</view>
		<view>
			<view class="listhot">
				<view v-for="(item,i) in hotdata" :id="item.id">

					<label style="margin-left: 30px;color: #A0A0A0;size: 14px;">{{item.name}}</label>

					<view style="height:1px;background:#E5E5E5;margin:10px 0"></view>
				</view>

			</view>
		</view>
		<view>
			<segmented-Control id="tabbar" :values="items" :stickyTop="108" :current="current" @clickItem="onClickItem"></segmented-Control>

			<view class="list" id="list">
				<view v-for="(item,i) in data">
					<view>
						<label style="margin:0 20px; margin-bottom: 10px;">{{item.name}}</label>
						<label>{{item.nameEn}}</label>
					</view>
					<view :style="telshow">
						<label style="margin:0 20px;font-size: 13px;">手机：</label>
						<label style="font-size:13px">{{item.mobile}}</label>
					</view>
					<view :style="emailshow">
						<label style="margin:0 20px;font-size: 13px;">邮箱：</label>
						<label style="font-size:13px">{{item.email}}</label>
					</view>
					<view :style="companyshow">
						<label style="margin:0 20px;font-size: 13px;">公司：</label>
						<label style="font-size:13px">{{item.company}}</label>
					</view>
					<view :style="titleshow">
						<label style="margin:0 20px;font-size: 13px;">部门职位：</label>
						<label style="font-size:13px">{{item.position}}</label>
					</view>
					<view :style="skillshow">
						<label style="margin:0 20px; font-size: 13px;">擅长：</label>
						<label style="font-size:13px">{{item.hobby}}</label>
					</view>
					<view style="height:1px;background:#E5E5E5;margin:0 10px"></view>
					<view :style="projectshow">
						<label style="margin:0 20px; font-size: 13px;">项目：</label>
						<label style="font-size:13px">{{item.project}}</label>
					</view>
					<view style="height:8px;background:grey;margin:10px 0"></view>
				</view>

			</view>
		</view>
	</view>
</template>

<script>
	import segmentedControl from '@/components/segmented-control';

	export default {
		components: {
			segmentedControl
		},
		onLoad() {
			this.bigfocus = true;
			//console.log('testOnload2'+this.bigfocus);
			this.big = '';

			this.ErrorRemind = '';

			// this.data = [];

		},
		data() {
			return {
				icon: '搜索人名、项目',
				items: ['全部', '联系人', '部门', '项目'],
				current: 0,
				hotdata: [{
					"id": "b5485dc5da9f11e990ae00155d05700a",
					"name": "任涛"
				}, {
					"id": "b5486415da9f11e990ae00155d05700a",
					"name": "陶方涛"
				}],
				data: [{
					'name': '张三峰',
					'nameEn': 'sanfeng.zhang',
					'tel': '12354215564',
					'email': 'email@email.com',
					'company': '上海顺普智能科技有限公司',
					'position': '设计师',
					'hobby': '画画、PPT',
					'project': 'specialteam第二期找人小程序项目、specialteam第一期监控系统项目、般出口监管场所系统',
					'mobileshow': 'display:block',
					'emailshow': 'display:block',
					'companyshow': 'display:block',
					'titleshow': 'display:block',
					'skillshow': 'display:block',
					'projectshow': 'display:block',
					'name': '张三峰'
				}, {
					'nameEn': 'sanfeng.zhang',
					'tel': '12354215564',
					'email': 'email@email.com',
					'company': '上海顺普智能科技有限公司',
					'position': '设计师',
					'hobby': '画画、PPT',
					'project': 'specialteam第二期找人小程序项目、specialteam第一期监控系统项目、般出口监管场所系统',
					'mobileshow': 'display:block',
					'emailshow': 'display:block',
					'companyshow': 'display:block',
					'titleshow': 'display:block',
					'skillshow': 'display:block',
					'projectshow': 'display:block'
				}],

				mobileshow: 'display:block',
				emailshow: 'display:block',
				companyshow: 'display:block',
				titleshow: 'display:block',
				skillshow: 'display:block',
				projectshow: 'display:block',
			};
		},
		methods: {
			/**
			 * 点击segmentedControl 事件回调
			 */
			onClickItem(index) {
				if (this.current !== index) {
					this.current = index;

					if (index == 0) //全部
					{
						this.mobileshow = 'display:block';
						this.emialshow = 'display:block';
						this.companyshow = 'display:block';
						this.titleshow = 'display:block';
						this.skillshow = 'display:block';
						this.projectshow = 'display:block';
					}
					if (index == 1) //联系人
					{
						this.mobileshow = 'display:block';
						this.emialshow = 'display:block';
						this.companyshow = 'display:block';
						this.titleshow = 'display:none';
						this.skillshow = 'display:block';
						this.projectshow = 'display:none';
					}
					if (index == 2) //部门
					{
						this.mobileshow = 'display:none';
						this.emialshow = 'display:none';
						this.companyshow = 'display:block';
						this.titleshow = 'display:block';
						this.skillshow = 'display:none';
						this.projectshow = 'display:none';
					}
					if (index == 3) //项目
					{
						this.mobileshow = 'display:none';
						this.emialshow = 'display:none';
						this.companyshow = 'display:block';
						this.titleshow = 'display:none';
						this.skillshow = 'display:none';
						this.projectshow = 'display:block';
					}
				}
			},

			onNavigationBarButtonTap() {
				console.log("你点击了按钮")
			},
			onNavigationBarSearchInputChanged() {
				console.log("你输入了信息")
			},
			big_input: function(event) {
				var big = this.big.trim();
				console.log('该大包：' + this.big);
				// console.log('该大包：' + event.target.value);
				if (big.length < 1) {
					this.ErrorRemind = "请输入人名或项目名";
					return;
				}
				var Url ='http://218.80.251.194:7788/index/hotSeach?name=' + big;
				this.bigfocus = false;
				uni.request({
					url: Url,
					method: 'GET',
					header: {
						'content-type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					success: res => {
						this.ErrorRemind = '';

						if (res.data.code == '200') {
							this.ErrorRemind = '';
							this.hotdata = res.data.data;

							// console.log(this.hotdata);
						} else {
							this.bigfocus = true;
							this.ErrorRemind = res.data.message;

						}
					},
					fail: failres => {
						this.ErrorRemind = "请求异常";
						return;
					},
					complete: () => {}
				});
			},
			big_confirm() {

				var big = this.big.trim();
				console.log('该大包：' + this.big);
				if (big.length < 1) {
					this.ErrorRemind = "请输入人名或项目名";
					return;
				}
				var Url = this.$websiteUrl + '/api/mbag/getcheckcount?bagid=' + big;
				this.bigfocus = false;
				uni.request({
					url: Url,
					method: 'GET',
					header: {
						'content-type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					success: res => {
						this.ErrorRemind = '';

						if (res.data.code == '200') {
							this.ErrorRemind = '';
							this.data = res.data.data;

							console.log(this.TotalInpectionBig);
						} else {
							this.bigfocus = true;
							this.ErrorRemind = res.data.message;

						}
					},
					fail: failres => {
						this.ErrorRemind = "请求异常";
						return;
					},
					complete: () => {}
				});

			}
		}
	};
</script>
<style>
	.listhot {
		position: absolute;
		top: 48px;
		z-index: 99999999;
		background-color: white;
		width: 100%;

	}

	.input-class {
		width: 90%;
		height: 30px;
		margin-left: 5%;
		margin-right: 5%;
		margin-bottom: 10px;
		border: 1px solid #0e141a;
		line-height: 50px;
		border-radius: 10px;
	}

	.Textclass {
		font-size: 80%;
		margin-left: 20px;
		margin-bottom: 5px;
		float: right;
	}
</style>
