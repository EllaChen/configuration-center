<div class="span12">
	<div class="alert alert-info">
	    <button type="button" class="close" data-dismiss="alert">&times;</button>
	    <strong>Information:</strong> If you need to edit the user group, please login first.
    </div>
<table>
	<tr>
		<td>Name:</td>
		<td>${userGroup.name}</td>
	</tr>
	<tr>
		<td>Owner:</td>
		<td>${userGroup.owner.name}</td>
	</tr>
</table>
<hr>
<table name="users" class="table table-striped table-bordered">
<tr>
	<td>Name</td>
	<td>Full Name</td>
</tr>
[#if (userGroup.items) ??]
	[#list userGroup.items as item]
		<tr>
			<td>${item.user.name}</td>
			<td>${item.user.fullName}</td>
		</tr>
	[/#list]
[/#if]
</table>
</div>