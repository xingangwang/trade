<#import "/resource/common_html_front.ftl" as html/>
<#import "/indexMenu.ftl" as menu/>
<@html.htmlBase>
<style>
	#advert img{
		max-width: 364px;
		max-height: 290px;
		border:0px;
	}
	#otherLogin a:hover{
		text-decoration: none;
	}
	.n-right{
		width:100%;
	}
</style>
<input value="${basepath}" type="hidden" id="wwwInput"/>
	<@menu.menu brandOnly=true brandText="登录" />
	<div class="container">
		<div class="row">
		    <div class="loginBody">
		    	<div class="bdInner clearfix">
		        	<div class="loginBdLeft">
						<!-- 广告位：登陆框左侧 -->
						<script type="text/javascript">BAIDU_CLB_fillSlot("1109438");</script>
		            </div>
		            <div class="loginBdRight">
		            	<div class="loginBoxTit">
		                	<a href="${basepath}/account/login" class="cur" style="margin-right:8px;" id="dengluBtn">登录</a> | <a href="${basepath}/account/register" style="margin-left:8px;" id="zhuceBtn">注册</a>
		                </div>
		                <div class="loginBoxBd">
		                	<div class="generalLogin">
	              				<form role="form" id="form" class="form-horizontal" action="${basepath}/account/doLogin" method="post" theme="simple">
							    	<input name="account" type="text" class="form-control tyInput" id="account" data-rule="账号:required;account;" placeholder="请输入账号" />
							    	<input name="password" type="password" class="form-control tyInput" id="password" data-rule="密码:required;password;" placeholder="请输入密码" />
									<#if errorMsg??>
									<div class="" style="text-align: left;font-size: 12px;margin: 5px 0px;">
										<strong>登录失败!</strong> ${errorMsg}
									</div>
									</#if>
		                            <div class="loginSub">
								      <button type="submit" class="btn btn-success btn-sm" value="登录">
								      	<span class="glyphicon glyphicon-ok"></span>&nbsp;登录
								      </button>
		                            </div>
		                            <div class="pwdHandle clearfix">
						      			<a href="${basepath}/account/forget">忘记密码？</a>
		                            </div>
		                        </form>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>

<script type="text/javascript">
	(function(){
		//if(QC.Login.check()){//如果已登录
			//console.log('QC.Login.check()=true');
			//QC.Login.signOut();
			//showQQLogin();	
		//}else{
			//console.log('QC.Login.check()=false');
			//showQQLogin();
		//}
	})();
	
	function showQQLogin(){
		//调用QC.Login方法，指定btnId参数将按钮绑定在容器节点中
		   QC.Login({
		       //btnId：插入按钮的节点id，必选
		       btnId:"qqLoginBtn",	
		       //用户需要确认的scope授权项，可选，默认all
		       scope:"all",
		       //按钮尺寸，可用值[A_XL| A_L| A_M| A_S|  B_M| B_S| C_S]，可选，默认B_S
		       size: "A_M"
			   }, function(reqData, opts){//登录成功
				   
				   console.log('QQ登录 登录成功reqData='+reqData);
				   $.each(reqData,function(index,value){
					   console.log("index="+index+"value="+value);
				   });
				   console.log('获取openId...');
				   try{
				    	QC.Login.getMe(function(openId, accessToken){
							//alert(["当前登录用户的", "openId为："+openId, "accessToken为："+accessToken].join("\n"));
							console.log(["当前登录用户的", "openId为："+openId, "accessToken为："+accessToken].join("\n"));
							//$("#qqLoginBtn").html("qq登录了");
							notifySession("login",openId,accessToken,reqData.nickname);
						});
				    }catch(e){
				    	console.log("QC.Login.getMe异常="+e);
				    }
			   }, function(opts){//注销成功
					console.log('QQ登录 注销成功');
				}
			);
	}
	function notifySession(status,openId,accessToken,nickname){
		var _url = "${basepath}/account/qqCallbackNotifySession?status="+status+"&openId="+openId+"&accessToken="+accessToken+"&nickname="+nickname;
		console.log("_url="+_url);
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: {},
		  success: function(data){
			  console.log("notifySession.data="+data);
			  window.location.href = "${basepath}";
		  },
		  dataType: "text",
		  error:function(er){
			  console.log("notifySession.er="+er);
		  }
		});
	}
</script>

<script type="text/javascript">
(function(){
	//if(WB2.checkLogin()){
		//console.log("已经登录新浪微博");
		//WB2.logout(function(){
			//console.log("已经退出新浪微博");
			//showSinaWeiboButton();
		//});
	//}else{
		//console.log("未登录新浪微博");
		//showSinaWeiboButton();
	//}
})();
function _login3213123(){
	WB2.login(function(){
		console.log("登录成功");
	});
}
function _logout321312323(){
	WB2.logout(function(){
		console.log("退出成功");
	});
}

function showSinaWeiboButton(){
	WB2.anyWhere(function(W){
	    W.widget.connectButton({
	        id: "wb_connect_btn",
	        type: '3,2',
	        callback : {
	            login:function(o){
	                console.log("logout,screen_name"+o.screen_name+"id="+o.id);
	                //sinaWeiboLoginNotifySession("login",o.id,o.screen_name);
	                
	                var _url = "/account/sinaWeiboLoginNotifySession?status=login"+"&id="+o.id+"&nickname="+o.screen_name;
					console.log("_url="+_url);
					$.ajax({
					  type: 'POST',
					  url: _url,
					  data: {},
					  success: function(data){
						  console.log("success.sinaWeiboLoginNotifySession.data="+data);
						  window.location.href = "${basepath}";
					  },
					  dataType: "text",
					  error:function(er){
						  console.log("sinaWeiboLoginNotifySession.er="+er);
					  }
					});
					
	            },
	            logout:function(){
	            	console.log("logout");
	            }
	        }
	    });
	});
}

function sinaWeiboLoginNotifySession(status,id,nickname){
	var _url = "user/sinaWeiboLoginNotifySession?status="+status+"&id="+id+"&nickname="+nickname;
	console.log("_url="+_url);
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(data){
		  console.log("sinaWeiboLoginNotifySession.data="+data);
		  window.location.href = "${basepath}";
	  },
	  dataType: "text",
	  error:function(er){
		  console.log("sinaWeiboLoginNotifySession.er="+er);
	  }
	});
}
</script>

<!-- baidu登录 
</@html.htmlBase>