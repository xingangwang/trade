<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
<style type="text/css">
.centerImageCss{
	width: 560px;
	height: 180px;
}
</style>
<div id="wrap">
	<@menu.menu selectMenu=""/>
	<div class="container" style="width:1210px;">
		<div class="row">
			<div class="col-xs-3" style="padding:0; width:210px;">
				<#include "/helpCatalog.ftl"/>
			</div>
			<#if helpCode?? && helpCode=="index">
				<div class="col-xs-9">
					<div class="row">
						<strong>帮助中心首页</strong>
					</div>
					<div class="row"><hr></div>
					<div class="row">
						帮助中心首页内容
					</div>
				</div>
			<#else>
				<div class="col-xs-9" style="padding:0; padding-left:40px; width:1000px;">
					<!-- 导航写 -->
					<div class="row">
						<div class="col-xs-12" style="padding:0;">
							<ol class="breadcrumb">
							  <li><a href="${basepath}">首页</a></li>
							  <#if helpCode??&&helpCode=="index">
							      <li class="active">帮助中心</li>
							  <#else>
							  	  <li><!--<a href="${basepath}/help/index.html">-->帮助中心<!--</a>--></li>
								  <li class="active">${news.title!""}</li>
							  </#if>
							</ol>
						</div>
					</div>
		
					<div class="row">
						<div class="col-xs-12">
							<strong>${news.title!""}</strong>
							<hr>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							${news.content}
							<#--<@include_page path=newsInfoUrl/>-->
						</div>
					</div>
				</div>
			</#if>
		</div>
	</div>
</div>	
</@html.htmlBase>