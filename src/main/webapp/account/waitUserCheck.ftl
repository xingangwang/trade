<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
	<@menu.menu brandOnly=true brandText="找回密码" />
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
												1.填写账户信息
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-success" style="font-size:100%;">
												2.身份验证
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-default" style="font-size:100%;">
												3.设置新密码
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-default" style="font-size:100%;">
												4.完成
											</span>
										</div>
									</div>
									<hr>
					            	<div>
						              <div class="panel-body" style="font-size: 16px;font-weight: normal;">
						              	 <span class="glyphicon glyphicon-ok"></span>
						              	 <span class="text-success">验证邮件已发送，请您登录邮箱完成身份验证！</span>
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