$(document).ready(function() {
	
	(function( $ ) {
		$.editCurrentRow = function(aElem) {
			var tr = aElem.parent().parent();
			var nameEle = tr.find("input[name='propertyName']");
			var valueEle = tr.find("input[name='propertyValue']");
			var idEle = tr.find("input[name='propertyId']");
			var optEle = tr.find("input[name='propertyAct']");
			var propertySetId = $("input[name='id']").val();
			
			var param = {act: optEle.val(),
						propertySetId: propertySetId,
						id: idEle.val(),
						name: nameEle.val(),
						value: valueEle.val()
			};
			
			$.ajax({url:"editProperty", 
				data:param,
				type:"POST",
				dataType:"json",
				success:function(result){
					nameEle.attr("readonly","true");
					optEle.val("update")
					idEle.val(result.id);
					alert("Operation succeed!");
				},
				error:function(xhr,msg){
					alert("Failed to create/update property.");
				}
			});//end of ajax
		};
		
		$.deleteCurrentRow = function(aElem) {
			var tr = aElem.parent().parent();
			var optEle = tr.find("input[name='propertyAct']");
			var idEle = tr.find("input[name='propertyId']");
			if(optEle.val() == "create"){
				tr.remove();
			}else{
			
				var param = {id: idEle.val()};
				
				$.ajax({url:"deleteProperty", 
					data:param,
					type:"POST",
					dataType:"text",
					success:function(result){
						tr.remove();
						alert(result);
					},
					error:function(xhr,msg){
						alert("Failed to delete property: " + msg);
					}
				});//end of ajax
			}
		};
		
		}( jQuery ));
	
	$("#addRow").click(function(){
		var $table = $("table[name='props']");  
        var row = $("<tr></tr>");
        var td = $("<td></td>");
        td.append($("<input type='text' name='propertyName' value=''>"));
        td.append($("<input type='hidden' name='propertyId' value=''>"));
        td.append($("<input type='hidden' name='propertyAct' value='create'>"));
        row.append(td);
        
        td = $("<td></td>");
        td.append($("<input type='text' name='propertyValue' value=''>"));
        row.append(td);
        
        td = $("<td></td>");
        var editCurrentRowLink = $("<a name='editCurrentRow'><i class='icon-ok'></i></a>");
        td.append(editCurrentRowLink);
        row.append(td);
        
        td = $("<td></td>");
        var deleteCurrentRowLink = $("<a name='deleteRow'><i class='icon-remove'></i></a>");
        td.append(deleteCurrentRowLink);
        row.append(td);
        
        $table.append(row); 
        
        deleteCurrentRowLink.click(function(){
        	$.deleteCurrentRow($(this));
    	});
    	
        editCurrentRowLink.click(function(){
    		$.editCurrentRow($(this));
    	});//end of addCurrentRow click
    	
    }); //end of addRow click
	
	$("a[name='editCurrentRow']").click(function(){
		$.editCurrentRow($(this));
	});
	
	$("a[name^='deleteRow']").click(function(){
		$.deleteCurrentRow($(this));
    }); 
	
	$("input[name='submit_bt']").click(function(){
		if( $("input[name='act']").val() == 'create'){
			$("#mainBody").load($("form").attr("action"),$("form").serializeArray());
		}else{
			$("#propertySetProfile").load($("form").attr("action"),$("form").serializeArray());
		}
		
	});
});