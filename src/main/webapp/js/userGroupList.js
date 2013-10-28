$(document).ready(function() {
	$("a").click(function(){
		$(this).addClass("active");
		$("#mainBody").load("updateUserGroup?id=" + $(this).attr("name"));
	});
	
	$("a[name='creatUserGroup']").click(function(){
		$("#mainBody").load("newUserGroup");
	});
});