$(document).ready(function() {
	$("input[name='submit_bt']").click(function(){
		$("#mainBody").load($("form").attr("action"),$("form").serializeArray());
	});
	
	$("input[name^='add_ps_bt']").click(function(){
		$("#mainBody").load("createPropertySet?id=" + $(this).attr("name").replace("add_ps_bt_",""));
	});
});