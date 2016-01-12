/**
 * 
 */

//删除图片主路径
function clearRootImagePath(picInput){
	var _pifeSpan = $("#pifeSpan").text();
	var _imgVal = picInput.val();
	picInput.val(_imgVal.substring(_imgVal.indexOf("/attached/")));
	//if(_imgVal && _imgVal.length>0 && _imgVal.indexOf(_pifeSpan)==0){
		//picInput.val(_imgVal.substring(_pifeSpan.length));
	//}
}

KindEditor.ready(function(K) {
	var editor = K.editor({
		allowFileManager : true,
	});
	K('input[name=filemanager]').click(function() {
		var imagesInputObj = $(this).parent().children("input[ccc=imagesInput]");
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				imageUrl : imagesInputObj.val(),
				clickFn : function(url, title) {
					imagesInputObj.val(url);
					$('#img_preview img').attr('src',url);
					$('#img_preview').attr('href',url);
					editor.hideDialog();
					clearRootImagePath(imagesInputObj);
				}
			});
		});
	});
	
});