$(function() {
	$("#title").focus();
	
	/**$("#form").validate({
		rules: {
	  		catalogID: {
	      		required: true,
	      		remote: {
	      			url: 'uniqueCatalog',
	      			type: 'POST',
	      			dataType: 'json',
	      			data:  {
	      				id : '1'
	      			}
	      		}
	    	}
	  }
	});**/
});

$(function(){
	selectDefaultCatalog();
	
	/*var ccc = $("#insertOrUpdateMsg").html();
    console && console.log("insertOrUpdateMsg="+insertOrUpdateMsg);
	if(ccc!='' && ccc.trim().length>0){
		$("#insertOrUpdateMsg").slideDown(1000).delay(1500).slideUp(1000);
	};*/
});

function addAttribute(){
	var lastIndex = $("#form tr[class=pclass]:last input").attr("name").match(/\d+/)[0];
	if(!lastIndex) return;
	lastIndex /= 1;
	var cc = $("#cloneTR").clone().attr('id','');
	cc.find("input[name='attrName']").attr("name","attrList[" + (lastIndex+1) + "].name");
	cc.find("input[name='attrId']").attr("name","attrList[" + (lastIndex+1) + "].id");
	cc.find("input[name='attrOrder']").attr("name","attrList[" + (lastIndex+1) + "].order1");
	$("#form tr[class=pclass]:last").after(cc.show());
}

function removeThis(t){
	$(t).parent().parent().remove();
	return false;
}

function catalogChange(obj){
	var _pid = $(obj).find("option:selected").attr("pid");
	console.log("_pid="+_pid);
	if(_pid==0){
		alert("不能选择大类!");
		selectDefaultCatalog();
		return false;
	}
}

function selectDefaultCatalog(){
	var _catalogID = $("#catalogID").val();
	console.log("_catalogID = " + _catalogID);
	if(_catalogID==0){
		$("#catalogSelect").prop("value","");
	}else{
		$("#catalogSelect").prop("value",_catalogID);
	}
}

//键盘按下的时候对字符进行检查，只能是数字
$("input[number=y]").keydown(function(event) {
	var key = event.keyCode ? event.keyCode : event.which;
	//console.log("key="+key+",value="+_obj.val()+"isNaN="+isNaN(_obj.val())+",IsNum="+IsNum(_obj.val()));
	if ((key >= 48 && key <= 57) || key==8) {
	//if (IsNum(_obj.val())) {
		var _obj = $(this);
		console.log(">>>_obj.val()="+_obj.val());
		//库存字符检查
		if($.trim(_obj.val())=='' || parseInt(_obj.val())<=0){
			_obj.val("1");
		}
		//checkStockFunc();
		return true;
	} else {
		return false;
	}
});