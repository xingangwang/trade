<#import "/resource/common_html_front.ftl" as html/>
<#import "/indexMenu.ftl" as menu/>
<@html.htmlBase>

<!--  头部  start  LLY  20150706-->
<style>
.payment_success{
	width:960px;
	margin:0 auto;
	margin-top:5%;
	margin-bottom:5%;
}
.login_img{
	height:80px;
}
.container{
	width:950px;
	height:460px;
	margin:0;
	border:5px solid #bdbdbd;
}
.zf_ok{
	width:600px;
	margin:0 auto;
	padding-top:130px;
}
.zf_ok i{float:left;width:49px;height:49px;}
.zf_ok .right_box{
	width:520px;
	margin-left:20px;
	padding-bottom:10px;
	padding-left:10px;
	float:left;
}
.zf_ok .font1{
	color:#ff0000;
	font-family:"微软雅黑";
	font-size:24px;
	padding-top:6px;
	padding-bottom:20px;
}
.zf_ok .font2{
	color:#666;
	font-family:"微软雅黑";
	font-size:14px;
	line-height:28px;
}
</style>
<div class="payment_success">
	<div class="login_img"><img src="${basepath}/resource/zhaowoba/images/shop_logo.jpg" height="79" width="160"></div>
	
	<div class="container">
		<div class="row">
			<div class="zf_ok">
				<#if success>
					<i><img src="${basepath}/resource/zhaowoba/images/zf_ok.png" height="49" width="49"></i>
					<div class="right_box clearfix">
						<div class="font1">您已成功付款 ${order.amount} 元 </div>
						<div class="font2">订单号：${order.id}</div>
						<#if order.ordership??>
						<div class="font2">收货人：${order.ordership.shipname}</div>
						<div class="font2">电&nbsp;&nbsp;&nbsp;话：${order.ordership.tel!"无"}</div>
						<div class="font2">地&nbsp;&nbsp;&nbsp;址：${order.ordership.shipaddress!"无"}</div>
						</#if>
					</div>
				<#else>
				   <div class="font1">订单支付异常，请联系客服！ </div>
				</#if>
			</div>
		</div>
	</div>
</div>

</@html.htmlBase>
