<#macro menu selectMenu="0" brandOnly=false brandText="" >

<style type="text/css">
.centerImageCss{
	width: 289px;
	height: 190px;
}
.title {
	display: block;
	width: 280px;
	overflow: hidden; /*注意不要写在最后了*/
	white-space: nowrap;
	-o-text-overflow: ellipsis;
	text-overflow: ellipsis;
}
body{
	padding-top: 0px;
  	padding-bottom: 0px;
	font-size: 12px;
/*    	font-family: 微软雅黑, Verdana, sans-serif, 宋体; */
}
</style>

<style>
.hotSearch{
	cursor: pointer;
}
</style>

<#if brandOnly!false>
	<div class="loginHead">
    	<div class="hdInner">
        	<a href="${basepath}/" class="logoLink"><img src="${basepath}/resource/zhaowoba/images/shop_logo.jpg" alt="" /></a>  <h1 class="loginTitle">${brandText!""}</h1>
        </div>
    </div>
<#else>
	<a name="toTop" id="toTop"></a>
	<!-- 顶部导航条 -->
	<!-- new head start-->
	<div id="head">
		<div class="head_top">
	    	<div class="top_box clearfix">
	        	<div class="location">
	                <#if currentAccount()??>
	                	<div class="user"><a href="${basepath}/account/account">${currentAccount().nickname}</a><a class="sign_out" href="${systemSetting().casServerUrl}/logout?service=${systemSetting().www}/">退出</a></div>
	            	<#else >
	            		<div class="login"><a href="${systemSetting().casServerUrl}/login?service=${systemSetting().www}/">亲，请登录</a><a class="registered" href="${systemSetting().casServerUrl}/register?service=${systemSetting().www}/">免费注册</a></div>
	                </#if>
	                <div class="my_order"><a href="${basepath}/account/orders" target="_blank">我的订单</a></div>
	                <div class="delivery_address"><a href="${basepath}/account/address" target="_blank">配送地址</a></div>
	                <div class="favorites"><a href="${basepath}/account/favorite" target="_blank">收藏夹</a></div>
	                <div class="hotline"><i>咨询热线：</i>${systemSetting().tel}</div>
	            </div>
	        </div>
		</div>
	    <!-- 置顶广告 <div class="head_ad">
		    <div style="margin:0 auto;width:1210px; ">
				<script type="text/javascript">BAIDU_CLB_fillSlot("1111879");</script>
		    	<a href="#" target="_blank"><img src="${basepath}/resource/zhaowoba/images/pic/head_ad.jpg"></a>
		    </div>
	    </div>-->
		<div class="head_box clearfix" style="position:relative;">
	    	<div class="logo_box">
	        	<a href="${basepath}/"><img src="${basepath}/resource/zhaowoba/images/shop_logo.jpg" width="210" height="104"></a>
	            <div class="Classification deep_red">全部商品分类</div>
	        </div>
	        
	        <div class="search">
	        	<form class="form-inline" role="form" name="searchForm" id="searchForm" method="post"
					action="${basepath}/search.html">
					<input type="text" name="key" id="key" style="border-right: 0px;"
			      		placeholder="请输入商品关键字" size="40" value="${key!""}" maxlength="20"/>
					<button value="搜索" onclick="search();">	&nbsp;搜索</button>
				</form>
	            <a href="${basepath}/cart/cart.html" target="_blank" class="shopping_car">我的购物车
	            	<#if shoppingCart()?? && (shoppingCart().items?size gt 0)>
	                    <i class="deep_red">${shoppingCart().items?size}</i>
					</#if>
	            </a>
	            <div class="recommend">
	           		<#list systemManager().hotqueryList as item>
	            			<span><a href="${item.url}" target="_blank">${item.key1!""}</a></span>&nbsp;&nbsp;
					</#list>
	            </div> 
	        </div>
	        
	        <div class="navigation">
	        	<#if selectMenu=="0">
	        		<a href="${basepath}/" class="nav"><i>看</i><span>首页</span></a>
				<#else>
	               <a href="${basepath}/" class="nav hover"><i>看</i><span>首页</span></a>
				</#if>
				<!-- 类别作为菜单显示 -->
				<#--
				<#local itemCount=1/>
				<#list systemManager().catalogs as item>
				    <#if item.showInNav == "y">
				    	 <a href="${basepath}/catalog/${item.code}.html" target="_blank" class="nav">
				    	 <#if item.name == "图书"><i>买</i>
			    	  	 <#elseif item.name == "课程"><i>学</i>
			    	  	 <#elseif item.name == "服务"><i>选</i>
			    	  	 <#else><i>找</i>
			    	  	 </#if>
				    	 <span>${item.name}</span></a>
					</#if>
					<#local itemCount=itemCount+1/>
					<#if (itemCount > 3)>
						<#break>
					</#if>
				</#list>
				-->
				<a href="${basepath}/catalog/tushu.html" target="_self" class="nav"><i>买</i><span>图书</span></a>
				<a href="http://www.taxhoo.com/course/index" target="_blank" class="nav" id="menu_course"><i>学</i><span>课程</span></a>
				<a href="${basepath}/catalog/fuwu.html" target="_self" class="nav"><i>选</i><span>服务</span></a>
	            <a href="#" target="_self" class="nav" id="menu_traning"><i>优</i><span>培训</span></a>
	            <!--<span class="nav_age">|</span>-->
	            <a href="${basepath}/activity.html" target="_blank" class="promotion"><i>促</i>销活动</a>
	            <a href="${basepath}/activity/score.html" target="_blank" class="integral_mall"><i>积</i>分商城</a>
	        </div>
	    </div>
	</div>
</#if>
<!-- new head end-->
<!-- <div class="navbar navbar-default navbar-fixed-top" -->
<#--<div class="navbar navbar-default"
	style="background-color: white;border-color: #ccc;min-height: 10px;margin-top: 0px;margin-bottom: 0px;border: 0px; height: 100px;">
<!-- 			style="position: fixed;top: 0px;text-align: right;border: 2px solid red;z-index: 10000;"> --\>
	<div class="container" style="min-height: 10px;margin-top:5px;margin-bottom:5px;border: 0px solid red;">
		<div class="row">
			<div class="col-xs-3">
				<a href="${basepath}"><img style="max-height:90px; margin-left:30px;" src="${systemSetting().log}"/></a>
			</div>
			<div class="col-xs-6" style="border: 0px solid blue;padding-left:5px;">
				<!-- search查询输入框 --\>
<!-- 				style="padding: 0px;margin-left: 0px;" --\>
				<form class="form-inline" role="form" name="searchForm" id="searchForm" method="post"
					action="${basepath}/search.html">
					<div class="form-group btn-group">
						<div class="input-group" style="padding-top: 26px; margin-left:10px;">
							<input type="text" name="key" id="key" class="form-control input-sm" style="border: 2px solid red;border-right: 0px;" 
			      		placeholder="请输入商品关键字" size="40" value="${key!""}" maxlength="20"/>
							<span class="input-group-btn">
								<button value="搜索" class="btn btn-primary btn-sm" onclick="search();">
									<span class="glyphicon glyphicon-search"></span>&nbsp;搜索
								</button>
								<a class="btn btn-success btn-sm" href="${basepath}/cart/cart.html">
									<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;购物车
									<#if shoppingCart()?? && shoppingCart().productList?? && shoppingCart().productList?size gt 0>
                                        <span class="badge badge-success">${shoppingCart().productList?size}</span>
									</#if>
								</a>
							</span>
						</div>
					</div>
				</form>
				<div style="text-align: left;margin-top: 5px;">热门搜索：
					<#list systemManager().hotqueryList as item>
                        <a class="hotSearch" href="${item.url}" target="_blank">
							${item.key1!""}
                        </a>
					</#list>
				</div>
			</div>
			<div class="col-xs-3" style="height: 100%;">
		    	<div class="row" style="height: 100%; padding-top: 20px; float: right;">
					<#if currentAccount()??>
                        <span id="myshopMenuPPP" style="display: inline-block;z-index: 9999;position: relative;;">
		          			<!-- 会员中心的菜单 --\>
		          			<span style="margin-top: 0px;">
							  <a data-toggle="dropdown" style="display: block;margin-top: 0px;">
                                  <span class="glyphicon glyphicon-user"></span>&nbsp;用户中心
                                  (${currentAccount().nickname})
                                  <span class="caret" style="display: inline-block;"></span>
                              </a>
							  <ul class="dropdown-menu" id="myshopMenu" role="menu" style="display: none;margin-top: 0px;">
                                  <li><a href="${basepath}/account/account"><span class="glyphicon glyphicon-user"></span>&nbsp;个人资料</a></li>
                                  <li><a href="${basepath}/account/topwd"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;修改密码</a></li>
                                  <li class="divider"></li>
                                  <li><a href="${basepath}/account/orders"><span class="glyphicon glyphicon-th"></span>&nbsp;我的订单</a></li>
                                  <li><a href="${basepath}/account/address"><span class="glyphicon glyphicon-send"></span>&nbsp;配送地址</a></li>
                                  <li><a href="${basepath}/account/favorite"><span class="glyphicon glyphicon-tags"></span>&nbsp;收藏夹</a></li>
                                  <li class="divider"></li>
                                  <li><a href="${basepath}/account/exit"><span class="glyphicon glyphicon-pause"></span>&nbsp;退出系统</a></li>
                              </ul>
							</span>
		          		</span>
		          		<span style="display: none;">
							${currentAccount().nickname!""}
		          			(${currentAccount().loginType!""})
		          		</span>
					<#else >
                        <span class="col-xs-12" id="loginOrRegSpan" style="font-size: 14px;">
		          			<a href="${basepath}/account/login">登录</a>|<a href="${basepath}/account/register">注册</a>
		          		</span>
					</#if>

		          	<div style="vertical-align: middle;margin-top: 10px;font-size: 18px;z-index: 0;">
		          		<span class="glyphicon glyphicon-earphone"></span>&nbsp;<#--客服热线:--\>${systemSetting().tel}
		          	</div>
		    	</div>
			</div>
		</div>
		
	</div>
</div>
		
<!-- <div class="navbar navbar-default navbar-fixed-top" style="top: 50px;"> --\>
<div class="navbar navbar-default" style="margin-bottom: 15px;z-index: 111">
      <div class="container">
        <div class="navbar-header col-xs-3" style="text-align: center;" id="navbar-header">
			  <a class="navbar-brand" href="${basepath}" style="font-weight: bold;margin-left: 5px;">全部商品分类</a>
	          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
	          <ul class="nav navbar-nav" >
	          		<#--<%-->
	          			<#--//out.println("request.getServletPath()="+request.getServletPath());-->
	          				          		<#--if(request.getServletPath().endsWith("/index.jsp")){-->
	          				          			<#--request.getSession().setAttribute(FrontContainer.selectMenu,"0");-->
	          				          		<#--}else if(request.getServletPath().endsWith("/specialProductList.jsp")){-->
	          				          			<#--request.getSession().setAttribute(FrontContainer.selectMenu,"special");-->
	          				          		<#--}-->
	          				          		<#--if(request.getSession().getAttribute(FrontContainer.selectMenu)==null){-->
	          			          				<#--request.getSession().setAttribute(FrontContainer.selectMenu,"0");-->
	          				          		<#--}-->
	          				          		<#---->
	          				          		<#--List<Catalog> catalogs = SystemManager.catalogs;-->
	          			          			<#--application.setAttribute("catalogs", catalogs);-->
	          		<#--%>--\>
	          		<!-- 首页 --\>
						<#if selectMenu=="0">
                            <li class="active"><a href="${basepath}/"><b>首页</b></a></li>
						<#else>
                            <li><a href="${basepath}/"><b>首页</b></a></li>
						</#if>
					<!-- 类别作为菜单显示 --\>
						<#list systemManager().catalogs as item>
						    <#if item.showInNav == "y">
								<li class="${(item.code == selectMenu)?string("active","")}"><a href="${basepath}/catalog/${item.code}.html"><b>${item.name}</b></a></li>
							</#if>
						</#list>
				</ul>

		          <ul class="nav navbar-nav navbar-right" style="display: block;">
		          	<!-- 促销活动 --\>
					<li class="${(selectMenu=="activity")?string("active","")}">
						<a href="${basepath}/activity.html" >
						<span class="glyphicon glyphicon-time"></span>
						<b>促销活动</b></a>
					</li>

					<!-- 积分商城 --\>
						<li class="${(selectMenu=="score")?string("active","")}"><a href="${basepath}/activity/score.html" >
							<b>积分商城</b></a>
						</li>

					<!-- 团购活动 --\>
					<#if false>
						<li class="${(selectMenu=="tuan")?string("active","")}"><a href="${basepath}/activity/tuan.html" >
							<b>团购活动</b></a>
						</li>
					</#if>
		          </ul>
        </div>
      </div>
    </div>-->
<script type="javascript">
//搜索商品
function search(){
	var _key = $.trim($("#key").val());
	if(_key==''){
		return false;
	}
	$("#searchForm").submit();
}
</script>
</#macro>