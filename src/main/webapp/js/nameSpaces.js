$(document).ready(function() {
	
	(function( $ ) {
		$.expendList = function(aElem) {
			var div = aElem.parent();
			var currentDiv=$("<div name='propertyList'></div>");
			var ul = $("<ul class='nav nav-list nav-stacked'></ul>");
			div.find("div[name='propertyList']").remove();
			$.getJSON("listPropertySets?id=" + aElem.attr("name").replace("nameSpaceDetail_",""),
					function(data){
					  $.each(data, function(i,data){
					    var li = $("<li><a name='propertySet" + data.id + "' data-toggle='tab'><i class='icon-file'></i>" + data.name+ "</a></li>");
					    ul.append(li);
					    
					    $("a[name='propertySet" + data.id +"']").click(function(){
							$("#mainBody").load("viewPropertySet?id=" + data.id);
						});
					  });
					  
					  
					});
			currentDiv.append(ul);
			div.append(currentDiv);
			aElem.find("i").attr("class", "icon-folder-open");
		};
		
		$.collapseList = function(aElem) {
			var div = aElem.parent();
			div.find("div[name='propertyList']").hide();
			aElem.find("i").attr("class", "icon-folder-close");
		};
		
		}( jQuery ));
	
	$("a[name^='nameSpaceDetail_']").click(function(){
		//$(this).parent().addClass("active");
		//alert($(this).attr("name").replace("nameSpaceDetail_",""));
		$("#mainBody").load("viewNameSpace?id=" + $(this).attr("name").replace("nameSpaceDetail_",""));
		//load propertyset list
		var icon = $(this).find("i");
		if(icon.attr("class") == "icon-folder-close"){
			$.expendList($(this));
		}else{
			$.collapseList($(this));
		}
	});
	
	$("a[name='createNameSpace']").click(function(){
		$("#mainBody").load("createNameSpace");
	});
});