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
	<caption>Name Space Profile</caption>
		<tr>
			<td>Name:</td>
			<td>${nameSpace.name}</td>
		</tr>
		<tr>
			<td>Owner:</td>
			<td>${nameSpace.owner}</td>
		</tr>
		<tr>
			<td>User Group:</td>
			<td>${nameSpace.userGroup!''}</td>
		</tr>
		
		<tr>
			<td>Owner Permission:</td>
			<td>
			[#if nameSpace.ownerWritable]
				Writable
			[/#if]
			[#if nameSpace.ownerReadable]
					Readable
			[/#if]
			</td>
		</tr>
		<tr>
			<td>Group Permission:</td>
			<td>
			[#if nameSpace.groupUserWritable]
			Writable
			[/#if]
			[#if nameSpace.groupUserReadable]
			Readable
			[/#if]
			</td>
		</tr>
		<tr>
			<td>Others Permission:</td>
			<td>
			[#if nameSpace.othersWritable]
			Writable
			[/#if]
			[#if nameSpace.othersReadable]
			Readable
			[/#if]
			</td>
		</tr>
	</table>
</div>

