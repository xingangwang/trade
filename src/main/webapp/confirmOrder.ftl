<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
<style type="text/css">
.totalPayMonery{
	color: red;font-weight: bold;font-size:22px;
}
.expressSelected {
	background: #d9edf7;
}
</style>
<div id="wrap">
	<@menu.menu selectMenu=""/>
	<form action="${basepath}/order/createOrderAndPay.html" method="post" theme="simple" onsubmit="return submitOrder();">
		<div class="container">
			<div class="row">
				<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
				<input type="hidden" name="buyer_from" value="${buyer_from!""}"/>
				<#if "cart" == buyer_from!"">
					<span class="label label-default" style="font-size:100%;">
						1.查看购物车
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-success" style="font-size:100%;">
						2.确认订单信息
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						2.付款
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						3.确认收货
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						4.评价
					</span>
				<#else>
					<span class="label label-success" style="font-size:100%;">
						1.确认订单信息
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						2.付款
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						3.确认收货
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						3.评价
					</span>
				</#if>
				</div>
			</div>
			<hr style="margin-bottom: 5px;">
			
			<div class="panel panel-primary">
				<div class="panel-heading">订单确认</div>
				<ul class="list-group">
				<input type="hidden" name="isVirtual" value="${order.isVirtual!""}"/>
				<input type="hidden" name="score" value="${order.score!""}"/>
				<#if "y"!=order.isVirtual!"">
					<li class="list-group-item">
						<a id="addressTips" href="#" data-toggle="tooltip" title="请选择收货地址！">
							<span class="glyphicon glyphicon-user"></span>&nbsp;请选择收货地址
						</a>
					</li>
					<li class="list-group-item">
						<#if addresses?? && addresses?size gt 0>
							<div class="row">
								<div class="col-xs-12" style="line-height: 20px;" id="adressListDiv">
									<!--
									<div class="alert alert-danger fade in">
								        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								        <strong>提示：</strong>请选择收货地址!
								      </div>
									 -->
									<#list addresses as item>	
										<label for="c${item_index}">
										<#if defaultAddessID?? && item.id == defaultAddessID>
											<div address="address" class="col-xs-3 alert alert-info" style="border: 1px solid;text-align: left;margin-right: 10px;width: 200px;line-height: 20px;cursor: pointer;">
												${item.name!""},${item.phone!""}
												<input type="radio" name="selectAddressID" id="c${item_index}" checked="checked"  value="${item.id!""}" style="visibility: hidden;"/>
												<br>
												${item.address!""}<br>
											</div>
										<#else>
											<div address="address" class="col-xs-3 alert" style="border: 1px solid;text-align: left;margin-right: 10px;width: 200px;line-height: 20px;cursor: pointer;">
												${item.name!""},${item.phone!""}
												<input type="radio" name="selectAddressID" id="c${item_index}" value="${item.id!""}" style="visibility: hidden;" />
												<br>
												${item.address!""}<br>
											</div>
										</#if>
										</label>
									</#list>
								</div>
							</div>
						<#else>
							<#if currentAccount()??>
								<div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
									暂时还没有收获地址！<a style="text-decoration: underline;" href="${basepath}/account/address.html">点此设置</a>
								</div>
							</#if>
						</#if>
					</li>
					<li class="list-group-item">
						<a href="#" data-toggle="tooltip" title="请选择配送方式！" id="expressTips">
							<span class="glyphicon glyphicon-send"></span>&nbsp;请选择配送方式
						</a>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-12">
								<!-- 
								<div class="alert alert-danger fade in">
							        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							        <strong>提示：</strong>请选择配送方式!
							      </div>
								 -->
								<table class="table table-bordered" id="expressTable">
									<#list expressList as item>
										<tr style="cursor: pointer;">
											<td width="400px">
												<span value="${item.code!""}" fee="${item.fee!""}">
												${item.name!""}</span>
											</td>
											<td>${item.fee!""}</td>
										</tr>
									</#list>
								</table>
								<input type="hidden" name="expressCode" />
								
							</div>
						</div>
					</li>
				</#if>
					<li class="list-group-item"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;购买到的商品</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-12">
								<table class="table table-bordered table-hover">
									<tr>
										<th width="400px">商品名称</th>
										<th >单价(元)</th>
										<th >数量</th>
			<!-- 							<th >优惠方式(元)</th> -->
										<th >小计(元)</th>
									</tr>
									<#list order.orderdetail as item>
										<tr>
											<td>
												<input type="hidden" name="orderdetail[${item_index!""}].productName" value="${item.product.name}"/>
												<input type="hidden" name="orderdetail[${item_index!""}].productID" value="${item.productID}"/>
												<input type="hidden" name="orderdetail[${item_index!""}].price" value="${item.price}"/>
												<input type="hidden" name="orderdetail[${item_index!""}].number" value="${item.number}"/>
												<input type="hidden" name="orderdetail[${item_index!""}].total0" value="${item.total0}"/>								
												<input type="hidden" name="orderdetail[${item_index!""}].cartItemId" value="${item.cartItemId!""}"/>
												<input type="hidden" name="orderdetail[${item_index!""}].score" value="${item.score!""}"/>
												&nbsp;<a target="_blank" href="${basepath}/product/${item.product.id!""}.html">${item.product.name!""}</a>
												<a name="stockErrorTips" href="#" data-toggle="tooltip" title="" data-placement="right" data-original-title="商品库存不足20个，"></a>
												<#if item.product.exchangeScore?? && item.product.exchangeScore != 0>
													<p>
														<span id="totalExchangeScoreSpan" class="label label-default">兑换积分:${item.product.exchangeScore!""}
														</span>
													</p>
												</#if>
											</td>
											<td>
												<#if item.product.exchangeScore?? && item.product.exchangeScore != 0>
													<span style="text-decoration: line-through;">
												<#else>
													<span>
												</#if>
													${item.product.nowPrice!""}
													<#if item.product.score!=0>
														(${item.product.score}积分)
													</#if>
												</span>
											</td>
											<td>
												${item.number!""}
											</td>
											<td>&nbsp;${item.total0!""}
												<#if item.score!=0>
													(${item.score}积分)
												</#if>
											</td>
										</tr>
									</#list>
								</table>
							</div>
						</div>
					</li>
				</ul>
				
				<div class="panel-footer primary" align="right">
					<div class="row">
						<div class="col-xs-12">
							<input id="productTotalMonery" type="hidden" value="${order.ptotal!""}"/>
							合计：<span class="totalPayMonery" id="totalPayMonery">${order.ptotal!""}元
										<#if order.score!=0>
											(${order.score}积分)
										</#if>	
								 </span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<#--<#if myCart.totalExchangeScore!=0>
								<h4>所需积分：<span style="color: red;font-weight: bold;" id="totalExchangeScore">${myCart.totalExchangeScore!""}</span>
								</h4>
							</#if>-->
						</div>
					</div>
							
					<div class="row">
						<div class="col-xs-6">
							<input name="otherRequirement" class="form-control" placeholder="此处您可以输入您的附加要求，以便我们提供更好的服务。" size="50" maxlength="50"/>
						</div>
						<div class="col-xs-6">
							<button value="button" class="btn btn-success" value="提交订单" id="confirmOrderBtn">
								<span class="glyphicon glyphicon-ok"></span>提交订单
							</button>
						</div>
					</div>
				</div>
			</div>			
			
		</div>
	</form>
</div>

<script type="text/javascript">
$(function() {
	$("div[address=address]").click(function(){
		$("div[address=address]").removeClass("alert-info");
		
		$(this).addClass("alert-info");
		$(this).find("input[type=radio]").attr("checked",true);
	});
	
	$("#expressTable tr").each(function(){
		var _tr = $(this);
		_tr.click(function(){
		
			$("#expressTable tr").removeClass('expressSelected');
			_tr.addClass('expressSelected');
		
			var _radio = _tr.find("span");
			console.log("选中的快递费用为="+_radio.attr("fee"));
			var _totalPayMonery = parseFloat($("#productTotalMonery").val())+parseFloat(_radio.attr("fee"));
			$("#totalPayMonery").text(_totalPayMonery.toFixed(2));
			
			$('#expressTips').tooltip('hide');
			
			$("input[name='expressCode']").val(_radio.attr("value"));
		});
	});
	
	$("#confirmOrderBtn").removeAttr("disabled");
});

function submitOrder(){
	if($("input[name=isVirtual]").val() == 'y')
		return true;
	var submitFlg = true;
	if($("#adressListDiv").length > 0){
		if($("#adressListDiv").find(":checked").size()==0){
			$('#addressTips').tooltip('show');
			submitFlg = false;
		}else{
			$('#addressTips').tooltip('hide');
		}
		if($("#expressTable tr.expressSelected").size()==0){
			$('#expressTips').tooltip('show');
			submitFlg = false;
		}else{
			$('#expressTips').tooltip('hide');
		}
		console.log("提交订单...submitFlg= " + submitFlg);
	}else{
		$("#confirmOrderBtn").attr("data-original-title","请选择收货地址！").tooltip('show');
		submitFlg = false;
	}
	
	return submitFlg;
}

</script>
</@html.htmlBase>