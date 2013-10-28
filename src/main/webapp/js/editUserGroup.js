$(document).ready(function() {
	$("#addRow").click(function(){
		var $table = $("table[name='users']");  
        var len = $table.length;
        
        var row = $("<tr></tr>");
        var td = $("<td></td>");
        td.append($("<input type='text' name='userName' value=''>"));
        row.append(td);
        td = $("<td><span></span></td>");
        row.append(td);
        td = $("<td><a name='deleteRow'><i class='icon-remove'></i></a></td>");
        row.append(td);
        
        $table.append(row); 
        
    	$("a[name='deleteRow']").click(function(){
		$(this).parent().parent().remove();
    	});
    }); 
	
	$("a[name='deleteRow']").click(function(){
		$(this).parent().parent().remove();
    }); 
	
	$("input[name='submit_bt']").click(function(){
		$("#mainBody").load($("form").attr("action"),$("form").serializeArray());
	});
});