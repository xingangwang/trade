$(function() {
	$( "#tabs" ).tabs({
		//event: "mouseover"
	});
	if($("#insertOrUpdateMsg").html()!='' && $("#insertOrUpdateMsg").html().trim().length>0){
		$("#insertOrUpdateMsg").slideDown(1000).delay(1500).slideUp(1000);
	}
	selectDefaultCatalog();
	$("#removePife").click(function(){
		clearRootImagePath();
	});
	
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="productHTML"]', {
			allowFileManager : true
		});
	});
	
	function addTrFunc(){
		var cc = $("#firstTr").clone();
		$("#firstTr").after(cc);
		cc.find("a").show();
	}
	
	function removeThis(t){
		$(t).parent().parent().remove();
		return false;
	}
});

KindEditor.ready(function(K) {
	var editor = K.editor({																								 
		allowFileManager : true,
		allowImageManager : true,
	});
	
	K('#addPic').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				imageUrl : '',
				clickFn : function(url, title, width, height, border, align) {
					var temp = $('#imgTemp tr').clone().show();
					temp.find('input').val(url.substring(url.indexOf("/attached/")));
					temp.find('a').attr('href', url);
					temp.find('img').attr('src', url);
					$('#img_table').append(temp);
					editor.hideDialog();
				}
			});
		});
	});
	
	K('#setMainPic').click(function() {
		editor.loadPlugin('image', function() {
			var img = $('#main_picture');
			editor.plugin.imageDialog({
				imageUrl : img.val(),
				clickFn : function(url, title, width, height, border, align) {
					img.val(url.substring(url.indexOf("/attached/")));
					img.parent('td').children('a').attr('href',url);
					img.parent('td').find('a>img').attr('src',url);
					editor.hideDialog();
				}
			});
		});
	});
});

//删除图片主路径
function clearRootImagePath(picInput){
	var _pifeSpan = $("#pifeSpan").text();
	var _imgVal = picInput.val();
	console.log("1===>_imgVal = "+_imgVal);
	//if(_imgVal && _imgVal.length>0 && _imgVal.indexOf(_pifeSpan)==0){
		//picInput.val(_imgVal.substring(_pifeSpan.length));
		console.log("2===>"+_imgVal.indexOf("/attached/"));
		picInput.val(_imgVal.substring(_imgVal.indexOf("/attached/")));
		
	//}
}
function deleteImageByImgPaths(){
	if ($("input:checked").size() == 0) {
		alert("请选择要删除的图片！");
		return false;
	}
	return confirm("确定删除选择的图片吗?");
}

function selectDefaultCatalog(){
	var _catalogID = $("#catalogID").val();
	$("#catalogSelect").val(_catalogID);
}

function catalogChange(obj){
	var _pid = $(obj).find("option:selected").attr("pid");
	if(_pid==0){
		alert("不能选择大类!");
		selectDefaultCatalog();
	}
	var _productID = $("#productID").val();
	/*if(confirm("修改商品类别会清空该商品的属性和参数，确认要这样做吗？")){
		$.blockUI({ message: "正在切换商品目录，请稍候...",css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        }});
		
		document.form.action = "updateProductCatalog?id="+_productID+"&chanageCatalog=true&catalog="+$(obj).val();
		document.form.submit();
	}else{
		selectDefaultCatalog();
	}*/
}

	//ajax加载内容图片列表
	function ajaxLoadImgList(){
		if($("#id").val()==''){
			 $("#fileListDiv").html("");
			 return;
		}
		
		$("#fileListDiv").html("");
		var _url = "ajaxLoadImgList?id="+$("#id").val();
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: {},
		  success: function(data){
			  var _tableHtml = "<table class='table table-bordered' style='border:0px solid red;'>";
				  _tableHtml += "<tr style='background-color: #dff0'>";
				  _tableHtml += "<td>图片地址</td><td>设为默认图片</td><td>操作</td>";
				  _tableHtml += "</tr>";
			  $.each(data,function(i,row){
				  _tableHtml += "<tr>";
				  var str = "<a target='_blank' href='"+row+"'>"+row+"</a>";
				  _tableHtml += "<td>"+str+"</td><td><input type='radio' onclick='setProductImageToDefault(\""+row+"\")' name='abcdef123'/></td><td><input type='button' Class='btn btn-danger' value='删除' onclick='deleteImageByProductID(\""+row+"\")'/></td>";
				  _tableHtml += "</tr>";
				  //$("#fileListDiv").append("<a target='_blank' href='"+row+"'>"+row+"</a><br>");
			  });
			  _tableHtml += "</table>";
			  $("#fileListDiv").append(_tableHtml);
		  },
		  dataType: "json",
		  error:function(){
			alert("加载图片列表失败！");
		  }
		});
	}
	
	//产品图片设置为默认图片
	function setProductImageToDefault(imageUrl){
		var _url = "setProductImageToDefault?id="+$("#id").val()+"&imageUrl="+imageUrl;
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: {},
		  success: function(data){
			  //alert("设置成功!");
			  $("#showMessage").append("设置成功！").fadeTo(2000, 1, function(){
				   //alert("Animation Done.");
				   $("#showMessage").html("").hide();
			  });
		  },
		  dataType: "text",
		  error:function(){
			alert("设置失败！");
		  }
		});
	}
	
	//产品图片设置为默认图片
	function deleteImageByProductID(imageUrl){
		if ($("input:checked").size() == 0) {
			alert("请选择要删除的图片！");
			return ;
		}
		if(!confirm("确定删除选择的图片吗?")){
			return ;
		}
		var _url = "deleteImageByProductID?id="+$("#id").val()+"&imageUrl="+imageUrl;
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: {},
		  success: function(data){
				  	ajaxLoadImgList();
			  //$("#showMessage").append("删除成功！").fadeTo(2000, 1, function(){
				//   $("#showMessage").html("").hide();
			  //});
			  
		  },
		  dataType: "text",
		  error:function(){
			alert("删除失败！");
		  }
		});
	}
