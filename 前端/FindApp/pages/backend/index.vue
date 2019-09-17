<template>
	<view class="btn-page">
		<view class="btn-box" @tap="_tap">
			<luButtonRipple>默认</luButtonRipple>
		</view>
		<view class="btn-box" v-for="(btn,index) in btnList" :key="index">
			<luButtonRipple :rippleBackgroundColor="btn.backgroundColor" :rippleOpacity="btn.opacity" :buttonRippleId="index" @rippleTap="_tap">
				{{btn.text}}
			</luButtonRipple>
		</view>
	</view>
</template>
<script>
import luButtonRipple from '@/components/lu-button-ripple/lu-button-ripple.vue';
export default {
    components: { luButtonRipple },
    data() {
        return {
            btnList:[
                {   text:"透明度：1",
                    backgroundColor:"#999",
                    opacity:1
                },
                {
                    text:"透明度：0.6",
                    backgroundColor:"#999",
                    opacity:0.6
                },
                {
                    text:"透明度：0.3",
                    backgroundColor:"#999",
                    opacity:1
                },
                {
                    text:"透明度：0.1",
                    backgroundColor:"#999",
                    opacity:1
                },
                {
                    text:"颜色：红",
                    backgroundColor:"red",
                    opacity:1
                },
                {
                    text:"颜色：黄",
                    backgroundColor:"yellow",
                    opacity:1
                },
                {
                    text:"颜色：绿",
                    backgroundColor:"green",
                    opacity:1
                },
                {
                    text:"颜色：蓝",
                    backgroundColor:"blue",
                    opacity:1
                }
            ]
        };
    },
    methods: {
        _tap(i) {
            if (i>=0) {
                console.log('通过第'+(i+1)+'个buttonRipple触发');
            }else{
                console.log('通过btn-box触发');
            }
        }
    }
};
</script>

<style>
	    .btn-page{
	        position: relative;
	        width: 100%;
	        display: flex;
	        flex-flow: row wrap;
	        justify-content: center;
	        align-items: center;
	    }
	    .btn-box{
	        position: relative;
	        width: 80%;
	        height: 40px;
	        font-size: 12px;
	        background-color: #f9f9f9;
	        border-radius: 5px;
	        margin: 10px;
	        overflow: hidden;
	        box-shadow: 1px 2px 3px rgba(100,100,100,0.5);
	
	    }
</style>
