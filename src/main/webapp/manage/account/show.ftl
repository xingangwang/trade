<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="会员管理">
<form action="${basepath}/manage/account" theme="simple" id="form">

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">基本信息</a></li>
	</ul>
	<div id="tabs-1">
		<div class="alert alert-info" style="margin-bottom: 2px;text-align: left;">
			<strong>会员信息：</strong>
		</div>
		<table class="table table-bordered">
					<tr style="display: none;">
						<td>id</td>
						<td><input type="hidden" value="${e.id!""}" name="id" label="id" id="id"/></td>
					</tr>
					<tr>
						<td style="text-align: right;">会员类型</td>
						<td style="text-align: left;">
							<#if e.accountType?? && e.accountType=="qq">
								<span class="label label-info">${e.accountTypeName!""}</span>
								<img alt="" src="${basepath}/resource/images/mini_qqLogin.png">
							<#elseif  e.accountType?? && e.accountType=="sinawb">
								<span class="label label-info">${e.accountTypeName!""}</span>
								<img alt="" src="${basepath}/resource/images/mini_sinaWeibo.png">
							<#elseif  e.accountType?? && e.accountType=="alipay">
								<span class="label label-info">alipay</span>
								<img alt="" src="${basepath}/resource/images/alipay_fastlogin.jpg">
							<#else>
								<span class="label label-info">jeeshop</span>
							</#if>
						
						</td>
					</tr>
					<tr>
						<td style="text-align: right;width: 200px;">昵称</td>
						<td style="text-align: left;">${e.nickname!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">账号</td>   
						<td style="text-align: left;">${e.account!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">城市</td>
						<td style="text-align: left;">${e.city!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">联系地址</td>
						<td style="text-align: left;">${e.address!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">消费额</td>
						<td style="text-align: left;">${e.amount!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">电话</td>
						<td style="text-align: left;">${e.tel!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">Email地址</td>
						<td style="text-align: left;">${e.email!""}
							<#if e.emailIsActive??&&e.emailIsActive=="y">
								<span class="label label-success">已激活</span>
							<#else><span class="label label-success">未激活</span></#if>
						</td>
					</tr>
					<tr>
						<td style="text-align: right;">是否冻结</td>
						<td style="text-align: left;">

							<#if e.freeze?? && e.freeze != "n">
								<span class="label label-warning">${e.freeze}（${e.freezeStartdate!""} ~ ${e.freezeEnddate!""}）</span>
							<#elseif e.freeze?? && e.freeze=="n">
								<span class="label label-success">未冻结</span>
							<#else>
								异常
							</#if>
						</td>
					</tr>
					
					<tr>
						<td style="text-align: right;">最后登录时间</td>
						<td style="text-align: left;">${e.lastLoginTime!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">最后登录IP</td>
						<td style="text-align: left;">${e.lastLoginIp!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">最后登录位置</td>
						<td style="text-align: left;">${e.lastLoginIp!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">注册日期</td>
						<td style="text-align: left;">${e.regeistDate!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">积分</td>
						<td style="text-align: left;">${e.score!""}</td>
					</tr>
					<tr>
						<td style="text-align: right;">等级</td>
						<td style="text-align: left;">

						${e.rankName!""}(${e.rank!""})
<!-- 							<div class="rateit"></div> -->
							
<!-- 							<div id="rateit13" class="rateit bigstars" data-rateit-value="4.2" data-rateit-ispreset="true" data-rateit-readonly="false"  -->
<!-- data-rateit-resetable="false" data-rateit-min="1" data-rateit-max="5" -->
<!-- data-rateit-starwidth="32" data-rateit-starheight="32"></div> -->

						</td>
					</tr>
				</table>
	</div>
</div>
</form>

<script type="text/javascript">
$(function() {
	$( "#tabs" ).tabs({
		//event: "mouseover"
	});
	
});

</script>

</@page.pageBase>