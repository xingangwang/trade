/**
 * 商品javascript，对购买商品的一些控制和提示
 * 
 */

//商品数
function updateFunc(obj, num){
	var _obj = $(obj).parent().find("input[name=quantity]");
	var quantity = parseInt(_obj.val()) + num;
	if (/^[1-9]\d*$/.test(quantity)) {
		_obj.val(quantity);
	} else {
		_obj.val(1);
	}
	notifyCart(_obj);
}

//判断是否是正整数
function IsNum(s)
{
    if(s!=null){
        var r,re;
        re = /\d*/i; //\d表示数字,*表示匹配多个数字
        r = s.match(re);
        return (r==s)?true:false;
    }
    return false;
}

/**
 * 购物车数量输入框keydown事件处理：
 * 		1.输入字符合法性检查及异常处理  
 * 		2.库存检查及更新购物车
 */
$("input[name=quantity]").keydown(function(event) {
	var field = $(this);
	var preValue = field.val(); 
	var key = event.keyCode ? event.keyCode : event.which;
	
	setTimeout(function(){
		var value = field.val();
		/**
		 * 1.新字符合法性校验及异常输入处理
		 */
		//1.判断输入的数字是否包含非数字类型
		if (isNaN(value)) { 
			if(value.length==1){
				value = 1;
			}else{
				for(var i=0;i<value.length;i++){ 
					if(isNaN(value.charAt(i))){
						value = value.substring(0,i);
						break;
					}
				}
			}
	    } 
		//数量为空则为1
		if($.trim(value)=='' || parseInt(value)<=0){
			value=1;
		}
		//转为数字放入数量
		field.val(parseInt(value));
		//2.判断如果新值不等于旧值则进行库存检查及购物车更新
		if (preValue != value) {
			notifyCart(field, value);
		}
	},1);
});

//通知购物车
function notifyCart(_obj, value){
	var _url = jns.basepath +"/cart/notifyCart.html";
	var td = _obj.parent();
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {
		  id: td.children('input[name="id"]').val(),
		  quantity: _obj.val(),
		  skuId: td.children('input[name="skuId"]').val()
	  },
	  cache:false,
	  success: function (result){
		  var tips = _obj.parent().find("a[name=stockErrorTips]");
		  if (result.success) {
			  tips.tooltip('hide');
		  } else {
			  if (result.data.max) {
				  _obj.val(result.data.max);
			  }
			  tips.attr("data-original-title",result.message).tooltip('show');
		  }
		  if(result.data.amount==0){
			  _obj.parent().parent().find("td[name=amount]").text(result.data.amount);
		  }else{
			  _obj.parent().parent().find("td[name=amount]").text(result.data.amount+" ("+parseInt(result.data.score)+"积分)");
		  }
		  td.children('input[name="score"]').val(result.data.score);
		  totalPayMonery();//计算合计
		  setTimeout(function(){
			  tips.tooltip('hide');
			  _obj.blur();
		  },1500);
	  },
	  dataType: "json",
	  error:function(er){
		  console.log("notifyCart.er="+er);
	  }
	});
}

//加入购物车
function addToCart(){
	var _specIdHidden = $("#specIdHidden").val();
	var specJsonStringVal = $("#specJsonString").val();
	//如果规格存在
	console.log("specIdHidden = " + _specIdHidden);
	if(specJsonStringVal && specJsonStringVal.length>0){
		if(!_specIdHidden || _specIdHidden==''){
			$("#addToCartBtn").attr("data-original-title","请选择商品规格！").tooltip('show');
			return;
		}
	}
	
	
	var _url = jns.basepath+"/cart/addToCart?productID="+$("#productID").val()+"&buyCount="+$("#quantity").val()+"&buySpecID="+$("#specIdHidden").val();
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(result){
		if(result.success){
			$('#myModal').modal('toggle');
		}else{
			$("#addToCartBtn").attr("data-original-title",result.message).tooltip('show');
		}
	  },
	  dataType: "json",
	  error:function(e){
		  $("#addToCartBtn").attr("data-original-title","加入购物车失败！请联系客服寻求解决办法。").tooltip('show');
	  }
	});
}

//校验个人积分是否足够商品所需要的积分
function checkBuyNow(){
	var quantity = $("#quantity").val();
	var score = $("#score").val();
	var _url = jns.basepath+"/order/checkScore?score="+quantity*score;
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(result){
		if(result.success){
			$("#buyForm").submit();
		}else{
			$("#buyBtn").attr("data-original-title",result.message).tooltip('show');
			$("#buyBtn").removeAttr("data-original-title");
		}
	  },
	  dataType: "json",
	  error:function(e){
		  $("#buyBtn").attr("data-original-title","积分校验失败！请联系客服寻求解决办法。").tooltip('show');
	  }
	});
}




//模拟表单发送post提交
function post(URL, PARAMS) {  
	var _url = jns.basepath+"/order/checkScore?score="+$("#totalScore").val();
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  success: function(result){
		if(result.success){
			var inputs = [];
		    for (var x in PARAMS) {        
		        var opt = document.createElement("textarea");        
		        opt.name = x;        
		        opt.value = PARAMS[x];        
		        inputs.push(opt);        
		    }
		    postWithInput(URL, inputs);
		}else{
			$("#confirmOrderBtn").attr("data-original-title",result.message).tooltip('show');
			$("#confirmOrderBtn").removeAttr("data-original-title");
		}
	  },
	  dataType: "json",
	  error:function(e){
		  $("#confirmOrderBtn").attr("data-original-title","积分校验失败！请联系客服寻求解决办法。").tooltip('show');
	  }
	});
}

function postWithInput(url, inputs) {
	var temp = document.createElement("form"); 
    temp.action = url;        
    temp.method = "post";        
    temp.style.display = "none";        
    $.each(inputs, function(i, e){
    	$(temp).append(e);        
    });        
            
    document.body.appendChild(temp);  
    temp.submit(); 
}
//计算合计
function totalPayMonery(){
	//判断是否为选中的商品
	 var str="";
	 var totalprice = 0.00;
	 var objs = document.getElementsByName('checkbox');
	 var i;
	 var totalscore = 0;
	 for(i = 0; i < objs.length; i++){
		if(objs[i].checked){
			str = objs[i].value;
       	 	var value = $("#amount_"+str).text();
       	 	var score = $("#score_"+str).val();
       	 	if(value.indexOf("(")>0){
       	 		value = value.substring(0,value.indexOf("("));
       	 	}
       	 	totalprice = accAdd(totalprice,value); 
       	 	totalscore = accAdd(score,totalscore);
		}
	 }
	 if(totalscore == 0){
		 $("#totalPayMonery").text(toDecimal2(totalprice)+"元");
	 }else{
		 $("#totalPayMonery").text(toDecimal2(totalprice)+"元  ("+parseInt(totalscore)+"积分)");
	 }
     $("#totalScore").val(parseInt(totalscore));
}


 
 


