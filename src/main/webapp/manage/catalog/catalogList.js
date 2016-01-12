/**
 * 
 */
$(function() {
		$("#treegrid").treegrid({"treeColumn":1});
	});
	function deleteSelect(id) {
		try{
			if(confirm("确定删除当前记录?")){
				$.blockUI({ message: "系统处理中，请等待...",css: { 
			        border: 'none', 
			        padding: '15px', 
			        backgroundColor: '#000', 
			        '-webkit-border-radius': '10px', 
			        '-moz-border-radius': '10px', 
			        opacity: .5, 
			        color: '#fff' 
			    }});
				var _url = "deleteByID?id="+id;
				$.ajax({
				  type: 'POST',
				  url: _url,
				  data: {},
				  async:false,
				  success: function(data){
					  console.log("ajax.data="+data);
					  if (data){
						  
						var _form = $("#form");
						_form.attr("action","selectList");
						_form.submit();
							
						  //alert("删除成功！");
						  //document.form.action = "catalog!selectList.action";   
					      //document.form.submit();   
					  }
					  jQuery.unblockUI();
				  },
				  dataType: "text",
				  error:function(){
					  	jQuery.unblockUI();
						alert("加载失败，请联系管理员。");
				  }
				});
			}
		}catch(e){
			console.log("eee="+e);
		}
		return false;
	}
	//编辑
	function editSelect(id){
		//document.form1.action = "catalog!toEdit.action?e.id="+node.id;
        //document.form1.submit();
        var _url = "toEdit?id="+id;
        var _form = $("#form");
		_form.attr("action",_url);
		_form.submit();
	}