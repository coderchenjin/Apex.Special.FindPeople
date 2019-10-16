<script>
	export default {
		onLaunch: function() {
			console.log('App Launch');
			uni.getStorage({
							key:'findapp_openid',
							success: function (res) {
							        console.log("老用户"+res.data);
									uni.navigateTo({
										url: 'pages/backend/searchmain'
									});
							    }
						});
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	/*每个页面公共css */
</style>
