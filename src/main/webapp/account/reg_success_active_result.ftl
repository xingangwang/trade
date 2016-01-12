<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
	<@menu.menu brandOnly=true brandText="注册" />
    <div class="loginBody">
    	<div class="bdInner clearfix">
            <div class="bdInnerWrapper">
                <!--注册-->
                <div class="loginBoxBd">
						<div class="container">
							<div class="row">
								<div class="col-xs-8" style="padding:20px 40px;">
									<div class="row">
										<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
											<span class="label label-default" style="font-size:100%;">
												1.填写注册信息 
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-default" style="font-size:100%;">
												2.邮箱验证 
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-success" style="font-size:100%;">
												3.注册成功 
											</span>
										</div>
									</div>
									<hr>
					            	<div>
						              	 <#if LinkInvalid??>
							              	<span class="glyphicon glyphicon-warning-sign"></span>
						              	 	<span class="text-default" style="font-size: 22px;" >链接已失效！</span>
						              	 <#else>
							              	 <span class="glyphicon glyphicon-ok text-success"></span>
											 <span class="text-success"  style="font-size: 22px;">恭喜：账号已成功激活，赶紧进行购物体验吧！</span>
											 <div style="margin-top:10px"><a href="${basepath}/account/login" class="btn btn-success">点此跳转登录页</a></div>
						              	 </#if>
					              </div>
							</div>
            			</div>
	           		 </div>
	        	</div>
			</div>
		</div>
	</div> 
</@html.htmlBase>