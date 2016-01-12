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
											<span class="label label-success" style="font-size:100%;">
												1.填写账户信息
											</span>
											&nbsp;<span class="glyphicon glyphicon-circle-arrow-right"></span>
											<span class="label label-default" style="font-size:100%;">
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
						              	 <form role="form" name="form" method="post" id="form" class="form-horizontal" action="${basepath}/account/doForget.html" theme="simple">
											  <div class="form-group">
											    <label for="account" class="col-lg-2 control-label">账号</label>
											    <div class="col-lg-6">
												    <input  name="account" type="text" class="form-control" id="account" placeholder="请输入会员账号"
												    data-rule="账号:required;account;length[3~10];remote[checkAccountExist.html]"/>
											    </div>
											  </div>
											  
											  <div class="form-group">
											    <label for="vcode" class="col-lg-2 control-label">验证码</label>
											    <div class="col-lg-2">
												    <input type="text" name="vcode" type="text" class="form-control" id="vcode" placeholder="验证码"
												    data-rule="验证码:required;vcode;remote[unique.html]" size="4" maxlength="4" />
											    </div>
											    <div class="col-lg-6" style="float: right;">
											    	<img src="${basepath}/ValidateImage.do" id="codes2"
															onclick="javaScript:reloadImg2();" class="vcodeCss"></img>
											    </div>
											  </div>
											  
											  <div class="form-group">
											    <div class="col-lg-offset-2 col-lg-6">
											      <button type="submit" class="btn btn-success btn-sm" value="提交信息"/>
											      	<span class="glyphicon glyphicon-ok"></span>&nbsp;提交信息
											      </button>
											    </div>
											  </div>
										</form>
					              </div>
							</div>
            			</div>
	           		 </div>
	        	</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
function reloadImg2() {
	document.getElementById("codes2").src = "${basepath}/ValidateImage.do?random="
			+ Math.random();
	$("#vcode2").focus();
}
</script>
</@html.htmlBase>