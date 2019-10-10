<template>
	<view class="content">
		<div v-for="(item, index) in btnList" :key="index">
			<QSWavesButton btnStyle="margin: 10px;" :size="item.size" :btnType="item.type" :txt="item.txt" :wavesColor="item.wavesColor"
			 :disabled="item.disabled" :loading="item.loading" :plain="item.plain" :formType="item.formType" :openType="item.openType"
			 :hoverStartTime="item.hoverStartTime" :hoverStayTime="item.hoverStayTime" :hoverClass="item.hoverClass"
			 :preIconType="item.preIconType" @getuserinfo="getuserinfo($event)" @click="clickFc(btnList,index)" :class="[AddClass ? 'disabled_button' : '',QS_WavesButton]">slot传入内容</QSWavesButton>
		</div>
	</view>

</template>

<script>
	import QSWavesButton from '@/components/QS-WavesButton/QS-WavesButton.vue';
	export default {
		components: {
			QSWavesButton
		},
		onLoad() {
			this.clickUrl = false; //点击超时
		},
		data() {
			return {
				AddClass: false,
				clickUrl: false,
				btnList: [{
						type: 'default',
						txt: '搜索入口',
						disabled: false,
						plain: true,
					},
					{
						type: 'default',
						txt: '搜索主页',
						disabled: false,
						plain: true,
					},
					{
						type: 'default',
						txt: '退出',
						disabled: false,
						plain: true,
					},
				]
			}
		},
		methods: {
			clickFc(btnList, index) {
				//console.log(index);
				//console.log(btnList[index].txt);

				//预防重复点击 通过变量开关来控制  以防万一添加定时
				if (this.clickUrl == true) {
					console.log('已提交');
					return;
				}

				this.clickUrl = true;
				setTimeout(() => {
					this.clickUrl = false;
				}, 1500);

				var Url = '';
				var text = btnList[index].txt;
				this.AddClass = true;
				if (text == '入库收货') {
					Url = '/pages/backend/intowarehouse';
				} else if (text == '搜索入口') {
					Url = '/pages/backend/searchhome';
				} else if (text == '搜索主页') {
					Url = '/pages/backend/searchmain';
				} else if (text == '移库') {
					Url = '/pages/backend/movegoods';
				} else if (text == '发货出库') {
					Url = '/pages/backend/outofwarehouse';
				} else if (text == '退出') {
					Url = '/pages/zaizai-login/index';

					uni.setStorage({
						key: 'userName',
						data: '',
					});

					uni.setStorage({
						key: 'token',
						data: '',
					});

				}

				if (Url) {
					console.log(Url);
					uni.navigateTo({
						url: Url
					});

				}
				console.log(text);



				//uni.showToast({
				//	title: '点击了:' + text
				//})
			},
			getuserinfo(e) {
				console.log(JSON.stringify(e))
			}
		}
	}
</script>

<style scoped>
	.content {
		text-align: center;
	}

	.disabled_button {}
</style>
