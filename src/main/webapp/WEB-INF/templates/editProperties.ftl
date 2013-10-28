<style>
th{
	width: 33.3%;
}
</style>
	[#if act == "update"]
	<div>
		<table name="props" class="table table-striped table-bordered">
			<caption>Properties</caption>
			<tr><th>Name</th><th>Value</th><th colspan="2"><a id="addRow"><i class="icon-plus"></a></th></tr>
			[#list propertySet.properties as property]
				<tr>
					<td>
						<input type="text" name="propertyName" value="${property.name}" readonly/>
						<input type="hidden" name="propertyId" value="${property.id}"/>
						<input type="hidden" name="propertyAct" value="update"/>
					</td>
					<td><input type="text" name="propertyValue" value="${property.value}"/> </td>
					<td><a name='editCurrentRow'><i class='icon-ok'></i></a></td>
					<td><a name="deleteRow"><i class="icon-remove"></i></a></td>
				</tr>
			[/#list]
		</table>
	</div>
	[/#if]

