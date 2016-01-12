$(function() {
	selectDefaultCatalog();
});

function selectDefaultCatalog(){
	var _catalogID = $("#catalogID").val();
	if(_catalogID!='' && _catalogID>0){
		$("#catalogSelect").attr("value",_catalogID);
	}
}