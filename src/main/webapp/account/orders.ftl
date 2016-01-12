<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
<style type="text/css">
.centerImageCss{
	width: 560px;
	height: 180px;
}
.simpleOrderReport{
font-weight: 700;font-size: 16px;color: #f50;
}
</style>
<@menu.menu selectMenu=""/>
	<script type="text/javascript">
		function confirmReceiveProduct(orderId, tag){
			$.post(jns.basepath + '/order/confirmReceiveProduct', {id: orderId},
				function(result){
					if (result.success) {
						$(tag).parents('tr').children('td[name="orderStatus"]').text(result.data);
						$(tag).remove();
					} else {
						
					}
					alert(result.message); 
				},
				'json');
		}
	</script>
	<div class="container" style="width:1210px;">
		<div class="row">
			<div class="col-xs-3" style="padding:0; width:210px;">
				<@accountMenu.accountMenu currentMenu="orders"/>
			</div>
			
			<div class="col-xs-9">
				<div class="row" style="width:1000px; padding-left:20px;">
					<#if pager.list?? && pager.pagerSize gt 0>
						<div class="panel panel-default">
							<div class="panel-heading"><span class="glyphicon glyphicon-th"></span>我的订单列表</div>
							<div class="panel-body">
								<#if orderSimpleReport??>
									<#if orderSimpleReport.orderCompleteCount!=0>
										<span class="glyphicon glyphicon-ok"></span>&nbsp;<span class="simpleOrderReport">${orderSimpleReport.orderCompleteCount!""}</span>个交易完成.
									</#if>
									<#if orderSimpleReport.orderCancelCount!=0>
										<span class="glyphicon glyphicon-remove"></span>&nbsp;<span class="simpleOrderReport">${orderSimpleReport.orderCancelCount!""}</span>个取消.
									</#if>
									<#if orderSimpleReport.orderWaitPayCount!=0>
										<span class="glyphicon glyphicon-time"></span>&nbsp;<span class="simpleOrderReport">${orderSimpleReport.orderWaitPayCount!""}</span>个等待付款.
									</#if>
								<#else>
									无任何订单数据！
								</#if>
							</div>
							<table class="table">
								<#--<tr>
									<td colspan="21"><span class="text-primary">选择担保交易的订单只能登录支付宝来进行【确认收货】操作。</span></td>
								</tr>-->
								<tr>
									<th style="text-align: left;">
	<!-- 									<input type="checkbox" id="firstCheckbox" />&nbsp;&nbsp; -->
										商品</th>
									<th style="text-align: center;" nowrap="nowrap">数量</th>
									<th style="text-align: center;" nowrap="nowrap">单价</th>
									<th style="text-align: center;" nowrap="nowrap">订单状态</th>
									<th style="text-align: center;width: 100px;">操作</th>
								</tr>
								<#list pager.list as itemOrder>
									<tr class="warning">
										<td colspan="11">
											<div class="row">
												<div class="col-xs-3">
	 												<input type="hidden" name="id" value="${itemOrder.id!""}" /> 
													订单号:${itemOrder.id!""}
												</div>
												<div class="col-xs-3">
													成交时间:${itemOrder.createdate!""}
												</div>
												<div class="col-xs-3">
													合计:<b class="simpleOrderReport">${itemOrder.amount!""}</b>
												</div>
												<div class="col-xs-3">
													<#if itemOrder.score!=0>
														<span class="label label-default">扣除：${itemOrder.score!""}个积分</span>
													</#if>
												</div>
											</div>
										</td>
									</tr>
									<#list itemOrder.orderdetail as detail>
										<tr>
											<td>&nbsp;
												<div style="width:50px;height: 50px;border: 0px solid;float: left;margin-left: 20px;">
													<a href="${basepath}/product/${detail.productID!""}.html" target="_blank" title="${detail.productName!""}">
														<img style="width: 100%;height: 100%;border: 0px;" alt="" src="${systemSetting().imageRootPath}${detail.picture!""}" onerror="nofind()"/>
													</a>
												</div>
												<div style="float: left;">&nbsp;${detail.productName!""}</div>
											</td>
											<td style="text-align: center;">&nbsp;${detail.number!""}</td>
											<td style="text-align: center;">&nbsp;${detail.price!""}</td>
											<#if detail_index == 0>
												<td name="orderStatus" style="text-align: center;border-left:1px solid #ddd;vertical-align: middle;" rowspan="${(itemOrder.orderdetail?size)!""}">
													<#if itemOrder.status??>
														<#if itemOrder.status =="INIT" || itemOrder.status =="PASSED">
															等待付款
														<#elseif itemOrder.status =="PAID">
															等待发货
														<#elseif itemOrder.status =="SENT">
															已发货
														<#elseif itemOrder.status =="SIGNED" || itemOrder.status=="FILED" >
															交易完成
															<#if itemOrder.closedComment == "y">
																<br/>已评价
															</#if>
														<#elseif itemOrder.status =="CANCELLED">
															已取消
														</#if>
													</#if>
												</td>
												<td style="text-align: center;border-left:1px solid #ddd;vertical-align: middle;" rowspan="${(itemOrder.orderdetail?size)!""}">

												<#if itemOrder.paystatus??>
													<#if itemOrder.status?? && (itemOrder.status =="INIT" || itemOrder.status =="PASSED")>
                                                        <a target="_blank" href="${basepath}/order/toPay?id=${itemOrder.id!""}">付款</a>
                                                    <#elseif itemOrder.status == "PAID">
                                                    
													<#elseif itemOrder.status =="SENT">
														<#if itemOrder.guaranteePay>
                                                        	<a target="_blank" href="http://www.alipay.com" class="btn btn-primary btn-sm">确认收货</a>
                                                        <#else>
                                                        	<a class="btn btn-primary btn-sm" onclick="confirmReceiveProduct(${itemOrder.id},this);">确认收货</a>
                                                        </#if>
													<#elseif itemOrder.status =="SIGNED">
                                                        <!-- 交易完成 -->
													</#if>
												</#if>
                                                	<br>
												<#if itemOrder.closedComment?? && itemOrder.closedComment !="y" && (itemOrder.status=="SIGNED" || itemOrder.status=="FILED")>
													<a target="_blank" href="${basepath}/order/rate?orderid=${itemOrder.id!""}" class="btn btn-danger btn-sm">我来评价</a><br>
												</#if>
                                                	<a target="_blank" href="${basepath}/order/${itemOrder.id!""}">订单详情</a>
                                                	<br>
                                                <#if itemOrder.status?? && (itemOrder.status =="SENT" || itemOrder.status=="SIGNED" || itemOrder.status=="FILED")>
                                                	<a target="_blank" href="http://www.kuaidi100.com/chaxun?com=${itemOrder.expressCompanyName!""}&nu=${itemOrder.expressNo!""}">快递物流</a>
                                                </#if>
												</td>
											</#if>
										</tr>
									</#list>
								</#list><#--pager.list-->
							</table>
						</div>
						
						<div style="text-align: right;">
							<#include "/pager.ftl"/>
						</div>
					<#else>
						<!-- 订单列表为空 -->
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<ol class="breadcrumb">
									  <li class="active">我的订单</li>
									</ol>
								</div>
							</div>
							
							<hr>
							
							<div class="row">
								<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
									<div class="panel panel-default">
							              <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
								              <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
								              		<span class="glyphicon glyphicon-user"></span>亲，你还没有任何订单信息！赶紧去下个单吧。
								              </div>
							              </div>
									</div>
									<hr>
								</div>
							</div>
							
						</div>
			
						<!--  
							<div class="bs-callout bs-callout-danger author" 
							style="text-align: left;font-size: 34px;margin: 2px 0px;vertical-align: middle;
							margin: auto;margin-top:50px;">
								<span class="glyphicon glyphicon-exclamation-sign" style="font-size: 34px;"></span>
								<span style="font-size: 16px;">还没有任何订单信息！赶紧去下个单吧。</span>
							</div>-->
					</#if>
				</div>
			</div>
		</div>
	</div>
	
</@html.htmlBase>