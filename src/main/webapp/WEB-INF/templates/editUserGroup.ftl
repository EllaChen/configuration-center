
		<form name="editUserGroupForm" class="form-horizontal form-editUsrGrp" method="POST" action="editUserGroup">
		<input type="hidden" name="act" value="${act}"/>
			[#if error??]
			    <div class="alert">
				    <button type="button" class="close" data-dismiss="alert">&times;</button>
				    <strong>Error:</strong>${error}
			    </div>
    		[/#if]
			<div class="control-group">
				<span class="control-label">User Group: </span>
				<div class="controls">
					[#if userGroup ??]
						<input type="hidden" name="id" value="${userGroup.id}"/>
						<input type="text" name="name" value="${userGroup.name}" readonly/>
					[#else]
						<input type="text" name="name" placeholder="Group Name" maxlength="20"/>
					[/#if]
				</div>
			</div>
			<hr>
			<table name="users" class="table table-striped table-bordered">
			<tr>
				<td>Name</td>
				<td>Full Name</td>
				<td><a id="addRow"><i class="icon-plus"></i></a></td>
				
			</tr>
			[#if (userGroup.items) ??]
				[#list userGroup.items as item]
					<tr>
						<td><input type="text" name="userName" value="${item.user.name}" readonly/></td>
						<td>${item.user.fullName}</td>
						<td><a name="deleteRow"><i class="icon-remove"></i></a></td>
					</tr>
				[/#list]
			[/#if]
			</table>
			<input type="button" class="btn btn-primary" value="Submit" name="submit_bt"/>
		</form>
<script src="js/editUserGroup.js" type="text/javascript"></script>