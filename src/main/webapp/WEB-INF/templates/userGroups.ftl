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
        <div class="span3">
          <ul class="nav nav-list bs-docs-sidenav">
              <li><a name="creatUserGroup"><strong>User Groups</strong><i class="icon-plus"></i></a></li>
              [#list userGroups as userGroup]
    			<li><a name="${userGroup.id}" data-toggle="tab">${userGroup.name}</a></li>
    		  [/#list]
          </ul>
      	 </div><!--/span-->
      	 <div class="span9">
        	<div id="mainBody" class="row-fluid">
        	</div>
        </div>
      </div>
 </div>
 <script src="js/userGroupList.js" type="text/javascript"></script>