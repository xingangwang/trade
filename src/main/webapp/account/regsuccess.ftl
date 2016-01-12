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
											<span class="label label-success" style="font-size:100%;">
												2.邮箱验证 
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-default" style="font-size:100%;">
												3.注册成功 
											</span>
										</div>
									</div>
									<hr>
					            	<div>
					              	 <span class="glyphicon glyphicon-ok text-success"></span>
									 <span class="text-success" style="font-size: 22px;">邮件已发送，请立刻去验证。</span>
									 <hr>
									 <div style="text-align: left;line-height: 20px;">
									 	<dl>
										  <dt>如果您长时间未收到邮件，您可以：</dt>
										  <dd>1、登录注册时填写的邮箱，检查是否被当成垃圾邮件处理了。</dd>
										  <dd>2、您可以点击<span class="glyphicon glyphicon-share-alt"></span><a href="${basepath}/account/sendEmailAgain.html?uid=${uid!""}">再次发送</a></dd>
											  <dd>如果已上都不能解决您的问题，请联系${systemSetting().systemCode!""}管理员寻求帮助：
											 	${systemSetting().email!""}</dd>
											</dl>
								 		</div>
					              </div>
							</div>
            			</div>
	           		 </div>
	        	</div>
			</div>
		</div>
	</div> 
</@html.htmlBase>