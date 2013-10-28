<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
      div{
      	border: 1px;
      }
</style>
<div class="container-fluid">
	<div class="row-fluid">
    	<div class="span3" >
            	<ul class="nav nav-list bs-docs-sidenav">
              		<li><a name="createNameSpace"><strong>Name Spaces</strong><i class="icon-plus"></i></a></li>
		              [#if nameSpaces??]
			              [#list nameSpaces as nameSpace]
			    			[#if nameSpace.currentReadable ]
			    				<li>
				    				<a name="nameSpaceDetail_${nameSpace.id}" data-toggle='tab'><i class="icon-folder-close"></i>${nameSpace.name}</a>
			    				</li>
			    			[#else]
			    				<li><span>${nameSpace.name}</span></li>
			    			[/#if]
			    		  [/#list]
		    		  [/#if]
             	</ul>
		</div><!--/span-->
		<div class="span9">
	        <div id="mainBody" class="row-fluid">
	        </div>
        </div>
	</div>
 </div>

 <script src="js/nameSpaces.js" type="text/javascript"></script>