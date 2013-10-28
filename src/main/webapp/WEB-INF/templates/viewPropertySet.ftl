<style>
td{
	width: 50%;
}
.table-profile{
	max-width: 600px;
}
</style>
<div class="span12">
	<table class="table table-bordered table-profile">
	<caption>Property Set Profile</caption>
		<tr>
			<td>Name:</td>
			<td>${propertySet.name}</td>
		</tr>
		<tr>
			<td>Owner:</td>
			<td>${propertySet.owner}</td>
		</tr>
		<tr>
			<td>User Group:</td>
			<td>${propertySet.userGroup!''}</td>
		</tr>
		
		<tr>
			<td>Owner Permission:</td>
			<td>
			[#if propertySet.ownerWritable]
				Writable
			[/#if]
			[#if propertySet.ownerReadable]
					Readable
			[/#if]
			</td>
		</tr>
		<tr>
			<td>Group Permission:</td>
			<td>
			[#if propertySet.groupUserWritable]
			Writable
			[/#if]
			[#if propertySet.groupUserReadable]
			Readable
			[/#if]
			</td>
		</tr>
		<tr>
			<td>Others Permission:</td>
			<td>
			[#if propertySet.othersWritable]
			Writable
			[/#if]
			[#if propertySet.othersReadable]
			Readable
			[/#if]
			</td>
		</tr>
	</table>
	<hr/>
	<table name="props" class="table table-striped table-bordered">
		<caption>Properties</caption>
		<tr><th>Name</th><th>Value</th></tr>
		[#list propertySet.properties as property]
			<tr>
				<td>
					<span>${property.name}</span>
				</td>
				<td>
					<span>${property.value}</span>
				</td>
			</tr>
		[/#list]
	</table>
</div>

