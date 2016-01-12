<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
		<@menu.menu selectMenu=""/>
	<div class="container" style="width:1210px;">
		<div class="row">
			<div class="col-xs-9" style="padding-right:40px;width:962px;">
				<div class="row">
					<div class="col-xs-12" style="padding:0;">
						<ol class="breadcrumb">
						  <li><a href="${basepath}">首页</a></li>
						  <li><a href="${basepath}/news/list">公告新闻</a></li>
						  <li class="active">${news.title!""}</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
<!-- 						<blockquote> -->
						  	<h3><strong style="color:#dd4814;">${news.title!""}</strong></h3>
						  	<div style="text-align: right;"><small>发布于:${news.createtime!""}</small></div>
<!-- 						</blockquote> -->
						<hr style="margin-top: 5px;">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						${news.content!""}
					</div>
				</div>
			</div>
			
			<!-- 右边公共部分 -->
			<div class="col-xs-3" style="width:248px;">
				<div class="row">
				<#include "/index_notice_slide.ftl"/>
				</br>
				<#include "/productlist_left_picScroll.ftl"/>
				</div>
			</div>
		</div>
	</div>
</@html.htmlBase>
