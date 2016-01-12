<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
	<@menu.menu selectMenu=""/>
	<form action="#" method="post" theme="simple">
		<style>.right{border:0;}</style>
		<div class="container" style="min-height: 200px;">
			<div class="row">
				<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
					<span class="label label-success" style="font-size:100%;">
						1.查看购物车
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						2.确认订单信息
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						3.确认收货
					</span>
					&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
					<span class="label label-default" style="font-size:100%;">
						4.评价
					</span>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-12" style="border: 0px solid;text-align: left;">
					<#if cart?? && cart.items?size gt 0>
						<#--<#if currentAccount()?? && (currentAccount().score < cart.totalExchangeScore)>
							<div class="alert alert-danger" role="alert">
								积分不足，无法提交订单。
								<br />当前积分：<span style="font-weight: bold;">${currentAccount().score!0}</span>
								<br />所需积分：<span style="font-weight: bold;" id="needExchangeScore">${cart.totalExchangeScore!""}</span>
							</div>
						</#if>-->
						<h3 style="font-weight: bold;">购物车中的商品</h3>
						<hr style="margin: 0px;margin-bottom: 10px;">
						<table id="result_table" class="table table-bordered">
							<tr style="background-color: #dff0d8">
								<th style="text-align:center;"><input id="bischecked" type="checkbox" checked="checked" /></th>
								<th width="400px">商品名称</th>
								<th >单价(元)</th>
								<th >数量</th>
	<!-- 							<th >优惠方式(元)</th> -->
								<th >小计(元)</th>
								<th >操作</th>
							</tr>
							<#list cart.items as item>
								<tr>
									<td align="center"><input id="all_${item.id!""}" name="checkbox" type="checkbox" checked="checked" onClick="onSelectOne();" value="${item.id!""}"/></td>
									<td style="display: none;">&nbsp;${item.id!""}</td>
									<td>&nbsp;<a target="_blank" href="${basepath}/product/${item.sku.id!""}.html">${item.sku.name!""}</a>
										<#if item.sku.exchangeScore!=0>
											<p>
												<span id="totalExchangeScoreSpan" class="label label-default">兑换积分:${item.sku.exchangeScore!""}
												</span>
											</p>
										</#if>
										<#if item.spec??>
											<br>商品规格：${item.spec.specColor!""},
											${item.spec.specSize!""}
										</#if>
									</td>
									<td>&nbsp;
										<#if item.sku.exchangeScore!=0>
											<span style="text-decoration: line-through;">
										<#else>
											<span>
										</#if>
											${item.sku.nowPrice!""}
											<#if item.sku.score!=0>
												(${item.sku.score}积分)
											</#if>
										</span>
									</td>
									<td>
										<span onclick="updateFunc(this, -1)" style="cursor: pointer;"><img src="${basepath}/resource/images/minimize.png" style="vertical-align: middle;"/></span>
										<input type="hidden" name="id" value="${item.id}"/>
										<input type="hidden" name="skuId" value="${item.skuId}"/>
										<input type="hidden" id="score_${item.id!""}" name="score" value="${item.score}"/>
										<input style="text-align: center;border-radius:4px;border:1px solid #ccc;" name="quantity" value="${item.quantity}" size="4" maxlength="4"/>
										<a name="stockErrorTips" data-toggle="show" data-placement="top">
										</a>
										<span onclick="updateFunc(this, 1)" style="cursor: pointer;">
											<img src="${basepath}/resource/images/maximize.png" style="vertical-align: middle;"/>
										</span>
									</td>
									<td id="amount_${item.id!""}" name="amount">&nbsp;
										#{item.amount;m2}
										<#if item.score!=0>
											(${item.score}积分)
										</#if>
									</td>
									<td><a href="javascript:deleteFromCart('${item.id}')">删除</a></td>
								</tr>
							</#list>
						</table>
					
						<div style="border: 0px solid;float: right;margin-right: 20px;">
							<div class="row">
<#--								<h4>合计：<span style="color: red;font-weight: bold;" id="totalPayMonery">#{cart.amount;m2}</span>-->
								<h4>合计：<span style="color: red;font-weight: bold;" id="totalPayMonery">${cart.amount}元
											<#if cart.score!=0>
												(${cart.score}积分)
											</#if>
										 </span>
								</h4>
							</div>
							
							<#--<div class="row">
								<#if cart.totalExchangeScore!=0>
									<h4>所需积分：<span style="color: red;font-weight: bold;" id="totalExchangeScore">${cart.totalExchangeScore!""}</span>
									</h4>
								</#if>
							</div>-->
							<div class="row">
								<input type="hidden" id="totalScore" name="totalScore" value="${cart.score}"/>
								<a href="javascript:;" data-toggle="show" data-placement="top" class="btn btn-success" id="confirmOrderBtn" onclick="confirmOrder()" disabled="disabled">
									<span class="glyphicon glyphicon-ok"></span>去结算
								</a>
							</div>
						</div>
					<#else>
						<div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 22px;margin: 2px 0px;">
							<span class="glyphicon glyphicon-info-sign"></span>&nbsp;您的购物车是空的，赶紧去看看有什么好宝贝吧...
						</div>
					</#if>
					
				</div>
			</div>
		</div>
	</form>
<form action="${basepath}/cart/delete" method="POST" id="formDelete">
	<input type="hidden" name="id">
</form>
<script src="${basepath}/resource/js/product.js"></script>
<script src="${basepath}/resource/js/math.js"></script>
<script type="text/javascript">
$(function() {
	$("div[address=address]").click(function(){
		$("div[address=address]").removeClass("alert-info");
		
		$(this).addClass("alert-info");
		$(this).find("input[type=radio]").attr("checked",true);
	});
	
	$("#confirmOrderBtn").removeAttr("disabled");
	
	//全选商品
	$('#bischecked').click(function(){
		$("#confirmOrderBtn").removeAttr("data-original-title");
         //判断是否被选中
        var flag = $("#bischecked").prop("checked");
        $("input[name='checkbox']").prop("checked",flag);
        totalPayMonery();
    });
});
function deleteFromCart(productId){
	if(productId){
		$("#formDelete :hidden[name=id]").val(productId);
		$("#formDelete").submit();
	}
}

//提交订单事件
function confirmOrder(){
	var submitFlg = false;
	//将选中的表单传递至下一环节
	var objs = $('input[name=checkbox]');
	var object = {};
	var j = 0;
	for(var i = 0; i < objs.length; i++){
		if(objs[i].checked){
			var tr = $(objs[i]).parents('tr:first');
			var cId = tr.find('input[name=id]').val();
			var pId = tr.find('input[name=skuId]').val();
			var nm = tr.find('input[name=quantity]').val();
			object["orderdetail["+j+"].cartItemId"]=cId;
			object["orderdetail["+j+"].productID"]=pId;
			object["orderdetail["+j+"].number"]=nm;
			submitFlg = true;
			j += 1;
		}
	}
	if(submitFlg){
		post(jns.basepath+'/order/confirmOrder.html', object);
	}else{
		$("#confirmOrderBtn").attr("data-original-title","请至少选中一件商品，才能去结算！").tooltip('show');
	}
}


//选中一个订单
function onSelectOne(){
	$("#confirmOrderBtn").removeAttr("data-original-title");
	var objs = document.getElementsByName('fruit');
	var i;
	var selected = 0;
	for(i = 0; i < objs.length; i++){
		if(!objs[i].checked){
			selected = selected + 1;
		}
	}
	if(selected > 0){
		document.getElementById('bischecked').checked = false;
	}else{
		document.getElementById('bischecked').checked = true;
	}
	totalPayMonery();
}
</script>
</@html.htmlBase>