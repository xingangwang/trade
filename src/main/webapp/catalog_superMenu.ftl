<#--左侧导航栏、热卖商品、文章、事项-->
<link rel="stylesheet"
	href="${basepath}/resource/js/superMenu/css/css.css"
	type="text/css">

<div id="sidebar" style="height:310px;overflow: hidden;">
	<#list systemManager().catalogs as item>
	    <#if item.showInNav == "y">
			<div class="sidelist clearfix">
				<span>
					<h3>
						<a href="${basepath}/catalog/${item.code}.html">${item.name}</a>
					</h3>
					
					<#if item.children??>
						<#list item.children as sItem>
    					<#if sItem.showInNav == "y">
							<li>
			          			<a class="small" href="${basepath}/catalog/${sItem.code}.html">${sItem.name}</a>
							</li>
						</#if>
						</#list>
					</#if>
					
				</span>
				<#-- <div class="i-list">
					
					<ul>
						<#if item.children??>
							<#list item.children as sItem>
	    					<#if sItem.showInNav == "y">
								<li>
				          			<a href="${basepath}/catalog/${sItem.code}.html">${sItem.name}</a>
								</li>
							</#if>
							</#list>
						</#if>
					</ul>
					<div style="clear: both;"></div>
					
					<#if item.superMenuProducts??>
						<div style="border-top: 1px solid #f40;clear: both;" class="hotText">
							<div style="font-weight: bold;padding-top: 5px;padding-bottom: 5px;">推荐热卖：</div>
							<#list item.superMenuProducts as pItem>
								<div style="margin-top: 5px;">
									&gt;<a title="${pItem.name}" target="_blank" href="${basepath}/product/${pItem.id}.html">
										${pItem.name}
									</a>
								</div>
							</#list>
						</div>
					</#if>
				</div> -->
			</div>
		</#if>
	</#list>
</div>