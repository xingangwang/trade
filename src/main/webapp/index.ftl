<#import "/resource/common_html_front.ftl" as html/>
<#import "/indexMenu.ftl" as menu/>
<#import "/index_productList.ftl" as indexProduct/>
<@html.htmlBase>
<style type="text/css">
.alert123{
/* 	padding: 10px; */
	margin-bottom: 5px;margin-top: 10px;margin-right: -15px;
}
.product_css{
	height: 200px;border: 0px solid #ccc;
}
.left_product{
	font-size: 12px;max-height: 35px;overflow: hidden;text-overflow: ellipsis;-o-text-overflow: ellipsis;
}
img{border: 0px;}

.thumbnail_css{
	border-color: red;
}
img.err-product {
<#if systemSetting().defaultProductImg??>
background: url("${systemSetting().defaultProductImg}"") no-repeat 50% 50%;
</#if>
.lazy {
  display: none;
}
</style>
<script>
function defaultProductImg(){ 
	var img=event.srcElement; 
	img.src="${systemSetting().defaultProductImg}";
	img.onerror=null; //控制不要一直跳动 
}
</script>
	<@menu.menu/>
	<div class="container clearfix" style="width:1210px;">
		<div class="row">
			<!-- 左侧导航栏、热卖商品、文章、事项 -->
			<div class="col-xs-3" style="padding:0; width:210px;">
				<#include "/catalog_superMenu.ftl">
				<#--<#include "/productlist_left_picScroll.ftl">-->
			</div>
			<!-- 右侧。滚动图片、新闻活动、首页商品展示 -->
			<div class="col-xs-9" style="margin-left:11px;">
				<div class="row" style="width:1000px;">
					<div class="col-xs-9" style="width:730px;">
							<div class="row" style="border:0px solid red;">
								<#include "/index_center_slide.ftl"/>
							</div>
					</div>
					<div class="col-xs-3" style="width:248px;margin-left:11px;">
<!-- 							<div style="border:1px solid red;"></div> -->
							<div class="row" style="border:0px solid red;">
								<#include "/index_notice_slide.ftl"/>
							</div>
					</div>
				</div>
				<#--
				<@indexProduct.indexProduct queryType="hot" productList=systemManager().hotProducts title="热门商品" />
				<@indexProduct.indexProduct queryType="sale" productList=systemManager().saleProducts title="特价商品" />
				<@indexProduct.indexProduct queryType="newest" productList=systemManager().newProducts title="最新商品" />
				-->
			</div>
			<!--  商品推荐 start LLy 20150706  -->
		    <div class="service_recom">
		    	<div class="recom_left">
		        	<div class="top_box"><span>找我吧推荐</span></div>
		            <!-- 广告位：底部1 -->
					<script type="text/javascript">BAIDU_CLB_fillSlot("1107932");</script>
		        </div>
		        <div class="recom_right">
		            <span class="ad_box">
		            <!-- 广告位：底部右侧1 -->
					<script type="text/javascript">BAIDU_CLB_fillSlot("1107933");</script>
		            </span>
		            <span class="ad_box">
		            <!-- 广告位：底部右侧2 -->
					<script type="text/javascript">BAIDU_CLB_fillSlot("1107934");</script>
		            </span>
		            <span class="ad_box">
		            <!-- 广告位：底部右侧3 -->
					<script type="text/javascript">BAIDU_CLB_fillSlot("1107935");</script>
		            </span>
		            <span class="ad_box">
		            <!-- 广告位：底部右侧4 -->
					<script type="text/javascript">BAIDU_CLB_fillSlot("1107936");</script>
		        	</span>
		        </div>
		    </div>
		    <!--  商品推荐 start LLy 20150706  -->
		    
		    
		</div>
	</div>
<#-- 
<script>
$(function() {
	//商品鼠标移动效果
	$("div[class=thumbnail]").hover(function() {
		$(this).addClass("thumbnail_css");
	}, function() {
		$(this).removeClass("thumbnail_css");
	});
	
});
</script>
-->
</@html.htmlBase>