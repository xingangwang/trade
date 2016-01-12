$(document).ready(function(){
    $('.sidelist').mousemove(function(){
    	//console.log("wwww = " + $("#sidebar").width());
    	var ww = $("#sidebar").width();
    	//var cc = $("#sidebar").width()+"px";
    	$(this).find('.i-list')
    	//.css("width",ww+"px")
    	.show();
		$(this).addClass('hover');//.css("width",ww+1+"px");
	});
	$('.sidelist').mouseleave(function(){
	$(this).find('.i-list').hide();
	$(this).removeClass('hover');
	});
});

//slideUp