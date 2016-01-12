<#import "/resource/common_html_front.ftl" as html/>
<#import "/indexMenu.ftl" as menu/>
<@html.htmlBase>
<#if e.title??>
<title>${e.title!""}</title>
<#else>
<title>${e.name!""}</title>
</#if>

<#if e.description??>
<meta name="description" content="${e.description!""}" />
<#else>
<meta name="description" content="${e.name!""}" />
</#if>

<#if e.keywords??>
<meta name="keywords"  content="${e.keywords!""}" />
<#else>
<meta name="keywords"  content="${e.name!""}" />
</#if>

<link rel="shortcut icon" href="${systemSetting().shortcuticon}">
<style type="text/css">
.topCss {
	height: 28px;
	line-height: 28px;
	background-color: #f8f8f8;
	border-bottom: 1px solid #E6E6E6;
	padding-left: 9px;
	font-size: 14px;
	font-weight: bold;
	position: relative;
	margin-top: 0px;
}
.left_product{
	font-size: 12px;display: inline-block;overflow: hidden;text-overflow: ellipsis;-o-text-overflow: ellipsis;white-space: nowrap;max-width: 130px;
}
img.err-product {
background: url(${systemSetting().defaultProductImg}) no-repeat 50% 50%;
}

.nowPrice{
	color: #F00;
	font-family: "微软雅黑";
	font-size: 20px;
}

.spec li{
	float: left;
	position: relative;
	margin: 0 4px 4px 0;
	vertical-align: middle;
	padding: 2px 8px;
	border: 1px solid #ccc;
	cursor: pointer;
}

.specSelectCss{
	border: 2px solid #ff0000;
	color:red;
}

.specNotAllowed{
	color: #CDCDCD;
	cursor: not-allowed;
}

.lazy {
  display: none;
}
.popover{
  height:40px;
}
.popover-title{
	background:#FFF;
	border:0;
	overflow:hidden;
	line-height:50px;
	float:left;
}
.tb-s310, .tb-s310 a{border:10px solid #f40;}
</style>
<script>
function defaultProductImg(){
	if(1==1){
		return;
	}
	var img=event.srcElement; 
	img.src="${systemSetting().defaultProductImg}";
	img.onerror=null; //控制不要一直跳动 
}
</script>
	<div id="wrap">
		<@menu.menu selectMenu=topMenu/>
		<div class="container" style="width:1210px;">
			<!-- 产品详细信息-->
			<div class="row" style="padding:0;">
				<!-- 热门商品列表 -->
				<div class="col-xs-3" style="width:210px; border: 1px solid #c0c0c0; text-align: left;">
					<div class="row" style="width:208px;">
						<h4 class="topCss">畅销商品</h4>
					</div>
					<#if hotProductList??>
					<#list hotProductList as item>
						<div class="row" style="width:210px;">
							<div class="col-xs-3">
								<a style="width: 50px;height: 50px;" href="${basepath}/product/${item.id!""}.html" target="_blank" title="${item.name!""}">
									<img class="lazy" style="border: 0px;display: block;margin: auto;width: 50px;height: 50px;" 
									src="${systemSetting().defaultProductImg}"
									data-original="${systemSetting().imageRootPath}${item.picture!""}" />
								</a>
							</div>
							<div class="col-xs-9">
								<h4 style="margin-top:0;">
									<div class="left_product" >
										<a title="${item.name!""}" href="${basepath}/product/${item.id!""}.html" target="_blank">
											${item.name!""}
										</a>
									</div>
								</h4>
								<div class="row">
									<div class="col-xs-6" style="width:100%">
										<b style="font-weight: bold;color: #cc0000;">
											￥${item.nowPrice!""}
										</b>
									</div>
									<!--<div class="col-xs-6">
										<b style="text-decoration: line-through;font-weight: normal;font-size: 11px;color: #a5a5a5;">
											￥${item.price!""}
										</b>
									</div>-->
								</div>
							</div>
						</div>
						<br>
					</#list>
					</#if>
					<!-- 特价商品 -->
					<div class="row">
						<h4 class="topCss">特价商品</h4>
					</div>
					<#list saleProducts as item>
						<div class="row">
							<div class="col-xs-3">
								<a href="${basepath}/product/${item.id!""}.html" target="_blank" title="${item.name!""}">
									
									<img class="lazy" style="border: 0px;display: block;margin: auto;width: 50px;height: 50px;"
                                         src="${systemSetting().defaultProductImg}"
                                         data-original="${systemSetting().imageRootPath}${item.picture!""}" />
								</a>
							</div>
							<div class="col-xs-9">
								<h4 style="margin-top:0;">
									<div class="left_product">
										<a title="${item.name!""}" href="${basepath}/product/${item.id!""}.html" target="_blank">
											${item.name!""}
										</a>
									</div>
								</h4>
								<div class="row">
									<div class="col-xs-6" style="width:100%">
										<b style="font-weight: bold;color: #cc0000;">
											￥${item.nowPrice!""}
										</b>
									</div>
									<!--<div class="col-xs-6">
										<b style="text-decoration: line-through;font-weight: normal;font-size: 11px;color: #a5a5a5;">
											￥${item.price!""}
										</b>
									</div>-->
								</div>
							</div>
						</div>
						<br>
					</#list>
					<#include "/history_productList.ftl"/>
				</div>
				
				<!-- 商品图片列表和购买按钮 -->
				<div class="col-xs-9" style="border: 0px solid red; text-align: left; padding-right:0; width:1000px;">
					<!-- 导航 -->
					<div class="row" style="margin-top:0; ">
						<div class="col-xs-12">
							<ol class="breadcrumb" style="margin-bottom: 0px;">
							  <li>${e.mainCatalogName!""}</li>
							  <#if e.childrenCatalogName??>
								  <li class="active"><a href="${basepath}/catalog/${e.childrenCatalogCode!""}.html">${e.childrenCatalogName!""}</a></li>
							  </#if>
							</ol>
						</div>
					</div>
					
					<!-- 如果商品有赠品，则显示到此处 -->
					<div class="row" style="margin-top: 10px;">
						<div class="col-xs-12">
							<#if e.gift??>
								<ul class="list-group" >
									<li class="list-group-item">
										商品赠品：${e.gift.giftName!""}
										<button class="btn btn-link btn-xs" onclick="showGiftDetail()">【详情】</button>
										
										<div style="display: none;" id="giftDetailDiv">
											<div class="row" style="margin-top: 10px;">
												<div class="col-xs-6">
													<img class="lazy" style="border: 0px;display: block;margin: auto;max-width: 100%;" 
													src="${systemSetting().imageRootPath}${e.gift.picture!""}" />
												</div>
												<div class="col-xs-6">
													赠品名称：${e.gift.giftName!""}<br>
													市场价：${e.gift.giftPrice!""}<br>
													赠品数量有限，赠完即止！
												</div>
											</div>
										</div>
								</ul>
							</#if>
						</div>
					</div>
					
					<div class="row" style="margin-top: 10px;">
						<div class="col-xs-6" id="productMainDiv">
							<#include "product_center_piclist_slide2.ftl"/>
							<!--
							<#--<ul id="myGallery">-->
								<#--<li style="max-width: 408px; height: 200px;"><img src="${e.maxPicture!""}" />-->
								<#--<#list e.imageList as item>-->
									<#--<li style="max-width: 408px; height: 200px;"><img src="${item!""}" />-->
								<#--</#ilist>-->
							<#--</ul>-->
							 -->
						</div>
						
						<!-- 产品详细信息 -->
						<div class="col-xs-6">
							<div style="line-height: 20px;">
								<!-- 活动判断，显示HTML -->
								<#if e.activityID??>
									<#if !e.expire>
										<ul class="list-group">
											<li class="list-group-item">
												<#if e.activityType??&&e.activityType=="c">
													<#if e.discountType=="d">
														<span class="badge pull-right" style="background-color:red;">
															${e.discountFormat}折</span>
														<span class="badge pull-left">折扣价
															<b style="font-weight: bold;">
																￥${e.finalPrice!""}
															</b>
														</span>
													<#elseif e.discountType=="r">
														<span class="label label-danger">促销价
															<b style="font-weight: bold;">
																￥${e.finalPrice!""}
															</b>
														</span>
													<#elseif e.discountType=="s">
														<span class="label label-success">双倍积分</span>
													</#if>
												<#elseif e.activityType??&&e.activityType=="j">
													<span class="badge pull-left" style="background-color:red;">兑换积分:
														<b style="font-weight: bold;">
															${e.exchangeScore!""}
														</b>
													</span>
												<#elseif e.activityType??&&e.activityType=="t">
													<span class="badge pull-left" style="background-color:red;">团购价:
														<b style="font-weight: bold;">
															${e.tuanPrice!""}
														</b>
													</span>
												</#if>
												
							
												<br>
												<!-- 活动结束时间显示 -->
												距离活动结束还剩：<div style="display: inline;" timer="activityEndDateTime" activityEndDateTime="${e.activityEndDateTime!""}"></div>
												<#if e.maxSellCount!=0>
													<br>
													<div>最多购买：${e.maxSellCount!""}件</div>
												</#if>
												<div>会员范围：${e.accountRange!""}</div>
											</li>
										</ul>
									<#else>
										<ul class="list-group">
											<li class="list-group-item">
												活动已经结束！
											</li>
										</ul>
									</#if>
								</#if>
								<!-- 活动判断，显示HTML END-->
								
								<div class="row">
									<div class="col-xs-12">
										<div style="font-weight: bold;font-size: 18px;">${e.name!""}</div>
										市场价：<b style="text-decoration: line-through;font-weight: normal;font-size: 11px;color: #a5a5a5;">
											￥${e.price!""}
										</b><br>
										现价：
										<#if e.activityID?? && !e.expire && e.discountType!="s">
											<b class="nowPrice" style="text-decoration: line-through;font-weight: bold;">
										<#else>
											<b class="nowPrice" style="font-weight: bold;">
										</#if>
											￥<span id="nowPrice">${e.nowPrice!""}</span>
										</b><br>
										<#if e.score gt 0>
											所需积分：${e.score!""}个积分点<br>
											<input type="hidden" id="score" name="score" value="${e.score!""}"/>
										</#if>
										<#if e.presentScore gt 0>
											赠送：${e.presentScore!""}个积分点<br>
										</#if>
										销量：已售${e.sellcount!""}件
										
									</div>
								</div>
								
								
								
								<#if e.specJsonString??>
									<!-- 商品规格 -->
									<input type="hidden" name="specJsonString" id="specJsonString"/>
									<div style="border:0px solid red; padding-top:16px;" class="spec clearfix" id="specDiv">
										<dl>
											<dt style="float: left;">尺寸：</dt>
											<dd>
												<ul style="list-style: none;" id="specSize">
													<#list e.specSize as item>
														<li>${item!""}</li>
													</#list>
												</ul>
											</dd>
										</dl>
										<br>
										<dl>
											<dt style="float: left;">颜色：</dt>
											<dd>
												<ul style="list-style: none;" id="specColor">
													<#list e.specColor as item>
														<li>${item!""}</li>
													</#list>
												</ul>
											</dd>
										</dl>
									</div>
								</#if>
								
								<form id="buyForm" action="${basepath}/order/buyNow.html"  method="post">
									<div class="row" style="margin-bottom: 10px;">
										<div class="col-xs-12">
											<br>购买数量：
											<span onclick="updateFunc(this, -1)" style="cursor: pointer;">
												<img src="${basepath}/resource/images/minimize.png" style="vertical-align: middle;"/>
											</span>
											<input value="1" size="4" maxlength="4" name="quantity" id="quantity" style="text-align: center;"/>
											<!-- <a id="addProductToCartErrorTips" href="#" data-toggle="tooltip" data-placement="bottom" data-original-title="购买的商品超出库存数！"></a> -->
											<span onclick="updateFunc(this, 1)" style="cursor: pointer;">
												<img src="${basepath}/resource/images/maximize.png" style="vertical-align: middle;"/>
											</span>
											(库存：<span id="stock_span_id">${e.stock!""}</span>${e.unit!""})<br>
											<!-- 超出库存提示语--> 
											<div id="exceedDivError" class="alert alert-danger fade in" style="display: none;margin-bottom: 0px;">
		<!-- 										<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button> -->
												<h4 id="exceedSpanError"></h4>
											</div>
											<input type="hidden" name="productId" value="${e.id!""}"/>
											<input type="hidden" name="isVirtual" value="${e.isVirtual}"/>
										</div>
									</div>
									
									<div class="row">
										<div class="col-xs-12">
											<#if e.status==2 && e.stock gt 0>
												<a name="stockErrorTips" productid="${id!""}" href="#" data-toggle="tooltip" title="" data-placement="top" ></a>
												<#if e.score gt 0>	
													<button type="button" data-toggle="show" data-placement="top" id="buyBtn" onclick="checkBuyNow()" value="立刻购买"
														class="btn btn-primary btn-sm">
														<span class="glyphicon"></span>立刻购买
													</button>
												<#else>
													<button data-toggle="show" data-placement="top" id="buyBtn" value="立刻购买"
														class="btn btn-primary btn-sm">
														<span class="glyphicon"></span>立刻购买
													</button>
												</#if>
												<#if (e.isVirtual!"") != 'y'>
												<button type="button" data-toggle="show" data-placement="top" id="addToCartBtn" onclick="addToCart()" value="加入购物车"
													 class="btn btn-primary btn-sm">
													<span class="glyphicon glyphicon-shopping-cart"></span>加入购物车
												</button>
												</#if>
											<#else>
												<button type="submit" id="buyBtn" value="立刻购买" class="btn btn-primary btn-sm disabled">
													<span class="glyphicon"></span>立刻购买
												</button>
												<#if (e.isVirtual!"") != 'y'>
												<button data-toggle="show" data-placement="top" id="addToCartBtn" value="加入购物车"
													 class="btn btn-primary btn-sm disabled">
													<span class="glyphicon glyphicon-shopping-cart"></span>加入购物车
												</button>
												</#if>
											</#if>
										
												<button id="addToFavoriteBtn" type="button" onclick="addToFavorite()" class="btn btn-primary btn-sm" disabled="disabled" 
													data-container="body" data-toggle="popover" data-placement="right" data-content="">
													<span class="glyphicon glyphicon-flag"></span>收藏
												</button>
										</div>
									</div>
								</form>
								<br>
								${qqHelpHtml!""}
								<hr style="margin-top: 5px;margin-bottom: 5px;">
								
								
								<#if e.stock lte 0>
									<strong><font style="font-size: 14px;" class="text-danger">抱歉，该商品已售卖完了！</font></strong><br>
								<#elseif e.status==3>
									<strong><font style="font-size: 14px;" class="text-danger">抱歉，该商品已下架！</font></strong><br>
								</#if>
								<#if currentUser()?? && e.showEmailNotifyProductInput>
									<div class="row" style="margin-top: 10px;" id="emailNotifyProduct_input">
									  <div class="col-lg-12">
									    <div class="input-group">
									      <input type="text" class="form-control" placeholder="到货通知的邮箱地址" id="receiveEmail" maxlength="45" size="45">
									      <span class="input-group-btn">
									        <button class="btn btn-success" type="button" onclick="emailNotifyProduct(this)"><span class="glyphicon glyphicon-ok"></span>&nbsp;到货通知</button>
									      </span>
									    </div>
									  </div>
									</div>
									<div class="row" style="margin-top: 10px;">
										<div class="col-lg-12 text-success" id="emailNotifyProductDiv"></div>
									</div>
								</#if>
											
							</div>
						</div>
					</div>
					
					<br>
					
					<div class="row">
						<div class="col-xs-12">
							<#include "/product_tab_slide.ftl"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="overflow: hidden;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"><b>提示信息:</b></h4>
      </div>
      <div class="modal-body" style="color: #7ABD54;font:normal 24px">
        <h3><span class="glyphicon glyphicon-ok"></span>&nbsp;商品已成功加入购物车！</h3>
      </div>
      <div class="modal-footer">
	        <button type="button" class="btn btn-default" onclick="javascript:$('#myModal').modal('hide');">继续购物</button>
        	<button class="btn btn-primary" data-dismiss="modal" value="去购物车结算" onclick="toCart();">
        		<span class="glyphicon glyphicon-usd"></span>去购物车结算
        	</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



	<input type="hidden" value="${e.name!""}" id="productName">
	<input type="hidden" value="${e.id!""}" id="productID">
	<input type="hidden" value="${e.nowPrice!""}" id="nowPriceHidden">
	<input type="hidden" value="${e.stock!""}" id="stockHidden">
	<input type="hidden" id="specIdHidden">

<script src="${basepath}/resource/js/product.js"></script>
<script src="${basepath}/resource/js/front.js"></script>
<script src="${basepath}/resource/js/superSlide/jquery.SuperSlide.js"></script>
<script src="${basepath}/resource/js/jquery.imagezoom/js/jquery.imagezoom.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".jqzoom").imagezoom();
	
	$("#thumblist li a").click(function(){
		$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
		$(".jqzoom").attr('src',$(this).find("img").attr("mid"));
		$(".jqzoom").attr('rel',$(this).find("img").attr("big"));
	});
});
</script>
<script>
$(function() {
	$("#addToCartBtn").removeAttr("disabled");
	$("#addToFavoriteBtn").removeAttr("disabled");
	
	jQuery(".slideTxtBox").slide();
	var ww = $("#productMainDiv").width();
	console.log("aww="+ww);
	$("#mainBox00").css("width",ww+"px");
	$("#mainBox00").find("img[name=box_img]").css("max-width",ww+"px");
	
	var specJsonStringVal = $("#specJsonString").val();
	
	//如果规格存在
	if(specJsonStringVal && specJsonStringVal.length>0){
		console.log("specJsonStringVal = " + specJsonStringVal);
		var specJsonStringObject = eval('('+specJsonStringVal+')');
		
		for(var i=0;i<specJsonStringObject.length;i++){
			console.log("specJsonStringObject = " + specJsonStringObject[i].specColor);
		}

		//规格被点击，则标记选中和不选中
		$("#specDiv li").click(function(){
			console.log("规格被点击。" + $(this).hasClass("specSelectCss"));
			if($(this).hasClass("specNotAllowed")){
				console.log("由于规格被禁用了，直接返回。");
				return;
			}
			
			$(this).parent().find("li").not(this).each(function(){
				$(this).removeClass("specSelectCss");
				$(this).attr("disabled","disabled");
			});
			if($(this).is(".specSelectCss")){
				console.log("removeClass specSelectCss");
				$(this).removeClass("specSelectCss");
				
				//如果当前点击的是尺寸，则释放所有的颜色的禁用状态；如果点击的是颜色，则释放所有的尺寸禁用状态
				if($(this).parent().attr("id")=="specSize"){
					console.log("当前点击的是尺寸。");
					//释放所有颜色的鼠标禁用状态
					$("#specColor li").each(function(){
						$(this).removeClass("specNotAllowed");
					});
				}else if($(this).parent().attr("id")=="specColor"){
					console.log("当前点击的是颜色。");
					//释放所有颜色的鼠标禁用状态
					$("#specSize li").each(function(){
						$(this).removeClass("specNotAllowed");
					});
				}else{
					console.log("当前点击的东东不明确。");
				}
			}else{
				console.log("addClass specSelectCss");
				$(this).addClass("specSelectCss");
			}
			
			//$("#specSize")
			
			var parentID = $(this).parent().attr("id");
			console.log("parentID = " + parentID);
			
			if($("#specSize li").hasClass("specSelectCss") && $("#specColor li").hasClass("specSelectCss")){
				console.log("都选中了。");
				
				console.log("选中的文本："+$("#specSize .specSelectCss").html());
				//找出对应的规格
				for(var i=0;i<specJsonStringObject.length;i++){
					var specItem = specJsonStringObject[i];
					if(specItem.specSize==$("#specSize .specSelectCss").html() 
							&& specItem.specColor==$("#specColor .specSelectCss").html()){
						console.log("找到了规格对象。");
						//改变商品的价格和库存数
						$("#nowPrice").text(specItem.specPrice);
						$("#stock_span_id").text(specItem.specStock);
						$("#specIdHidden").val(specItem.id);
						console.log("选中的规格ID="+$("#specIdHidden").val());
						break;
					}
				}
				//specNotAllowed
			}else if($("#specSize li").hasClass("specSelectCss")){
				resetProductInfo();
				//尺寸被选中了一个，则将于该尺寸不匹配的颜色禁用掉。
				console.log("尺寸被选中了一个，则将于该尺寸不匹配的颜色禁用掉。");
				//找出对应的规格
				var colorArr = [];//与选中的规格相匹配的颜色集合
				for(var i=0;i<specJsonStringObject.length;i++){
					var specItem = specJsonStringObject[i];
					if(specItem.specSize==$("#specSize .specSelectCss").html()){
						colorArr.push(specItem.specColor);
					}
				}
				
				//释放所有颜色的鼠标禁用状态
				$("#specColor li").each(function(){
					$(this).removeClass("specNotAllowed");
				});
				
				//找出于选择的尺寸不匹配的颜色，将其禁用掉。
				for(var i=0;i<specJsonStringObject.length;i++){
					var specItem = specJsonStringObject[i];
					var hanFind = false;
					for(var j=0;j<colorArr.length;j++){
						if(specItem.specColor==colorArr[j]){
							hanFind = true;
							break;
						}
					}
					
					if(!hanFind){
						console.log("禁掉的颜色有："+specItem.specColor);
						
						$("#specColor li").each(function(){
							console.log("text="+$(this).text());
							if($(this).text()==specItem.specColor){
								console.log("找到了。");
								$(this).addClass("specNotAllowed");
								return false;
							}
						});
					}
				}
				
			}else if($("#specColor li").hasClass("specSelectCss")){
				resetProductInfo();
				//颜色被选中了一个，则将于该颜色不匹配的尺寸禁用掉。
				console.log("颜色被选中了一个，则将于该颜色不匹配的尺寸禁用掉。");
				
				//找出对应的规格
				var sizeArr = [];//与选中的规格相匹配的颜色集合
				for(var i=0;i<specJsonStringObject.length;i++){
					var specItem = specJsonStringObject[i];
					if(specItem.specColor==$("#specColor .specSelectCss").html()){
						sizeArr.push(specItem.specSize);
					}
				}
				
				//释放所有颜色的鼠标禁用状态
				$("#specSize li").each(function(){
					$(this).removeClass("specNotAllowed");
				});
				
				//找出于选择的尺寸不匹配的颜色，将其禁用掉。
				for(var i=0;i<specJsonStringObject.length;i++){
					var specItem = specJsonStringObject[i];
					var hanFind = false;
					for(var j=0;j<sizeArr.length;j++){
						if(specItem.specSize==sizeArr[j]){
							hanFind = true;
							break;
						}
					}
					
					if(!hanFind){
						console.log("禁掉的尺寸有："+specItem.specSize);
						
						$("#specSize li").each(function(){
							console.log("text="+$(this).text());
							if($(this).text()==specItem.specSize){
								console.log("找到了。");
								$(this).addClass("specNotAllowed");
								return false;
							}
						});
					}
				}
				
			}else{
				console.log("都没选中。");
				resetProductInfo();
			}
			
		});
	}
	
});

//重置商品信息
function resetProductInfo(){
	console.log("resetProductInfo..."+$("#nowPriceHidden").val());
	//设置值为商品原价格
	$("#nowPrice").text($("#nowPriceHidden").val());
	$("#stock_span_id").text($("#stockHidden").val());
	$("#specIdHidden").val("");
}

//去购物车结算
function toCart(){
	window.location.href = "${basepath}/cart/cart.html";
}
var options={
		animation:true,
		trigger:'hover', //触发tooltip的事件
		show: 500, hide: 100
	};
//添加商品收藏
function addToFavorite(){
	var _url = "${basepath}/product/addToFavorite.html?productID="+$("#productID").val()+"&radom="+Math.random();
	console.log("_url="+_url);
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(data){
		  console.log("addToFavorite.data="+data);
		  var _result = "商品已成功添加到收藏夹！";
		  if(data=="0"){
			  _result = "商品已成功添加到收藏夹！";
		  }else if(data=='1'){
			  _result = "已添加，无需重复添加！";
		  }else if(data=='-1'){//提示用户要先登录
			  _result = "使用此功能需要先登录！";
		  }
		  
		  $('#addToFavoriteBtn').attr("data-content",_result).popover("toggle");
	  },
	  dataType: "text",
	  error:function(er){
		  console.log("addToFavorite.er="+er);
	  }
	});
}
//到货通知
function emailNotifyProduct(obj){
	var _receiveEmail = $("#receiveEmail").val();
	if($.trim(_receiveEmail).length==0){
		$("#receiveEmail").focus();
		return;
	}
	
	var _url = "${basepath}/product/insertEmailNotifyProductService.html?receiveEmail="+_receiveEmail+"&productID="+$("#productID").val()+"&productName="+$("#productName").val();
	console.log("_url="+_url); 
	$(obj).attr({"disabled":"disabled"});
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(data){
		  console.log("emailNotifyProduct.data="+data);
		  var _result = "到货通知添加成功！";
		  if(data=="0"){
		  }else if(data=='-1'){//提示用户要先登录
			  _result = "使用此功能需要先登录！";
		  }
		  $("#emailNotifyProduct_input").hide();
		  $("#emailNotifyProductDiv").html(_result);
		  console.log(_result);
	  },
	  dataType: "text",
	  error:function(er){
		  console.log("emailNotifyProduct.er="+er);
		  $("#emailNotifyProductDiv").html("添加到货通知失败，请联系站点管理员！");
	  }
	});
}

//显示礼品详情
function showGiftDetail(){
	if($("#giftDetailDiv").is(':hidden')){
		$("#giftDetailDiv").slideDown(1000);		
	}else{
		$("#giftDetailDiv").slideUp(1000);
	}
}

</script>

<!-- baidu fenxiang -->
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"0","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<!-- Baidu Button END -->

</@html.htmlBase>