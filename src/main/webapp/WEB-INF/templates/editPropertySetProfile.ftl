<div class="span12">
	<form name="propertySet_info" class="form-horizontal" method="POST" action="editPropertySet">
	<input type="hidden" name="act" value="${act}"/>
	<input type="hidden" name="nameSpaceId" value="${propertySet.nameSpaceId}"/>
		[#if error??]
		    <div class="alert alert-error">
			    <button type="button" class="close" data-dismiss="alert">&times;</button>
			    <strong>Error:</strong>${error}
		    </div>
		[/#if]
		<div class="control-group">
			<span class="control-label">Name: </span>
			<div class="controls">
				[#if act == "create"]
					<input type="text" name="name" placeHolder="Property Set Name" maxlength="20"/>
				[#else]
					<input type="hidden" name="id" value="${propertySet.id}"/>
					<input type="text" name="name" value="${propertySet.name}" readonly/>
				[/#if]
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">Owner: </span>
			<div class="controls">
				<input type="text" name="owner" value="${propertySet.owner}" readonly/>
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">User Group: </span>
			<div class="controls">
				<input type="text" name="userGroup" value="${propertySet.userGroup!''}"/>
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">Owner Permission: </span>
			<div class="controls">
				<label class="checkbox inline">
					[#if propertySet.ownerWritable]
						<input type="checkbox" name="ownerWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="ownerWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
				[#if propertySet.ownerReadable]
					<input type="checkbox" name="ownerReadable" value="true" checked>Readable
				[#else]
					<input type="checkbox" name="ownerReadable" value="true">Readable
				[/#if]
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<span class="control-label">Group Permission: </span>
			<div class="controls">
				<label class="checkbox inline">
					[#if propertySet.groupUserWritable]
						<input type="checkbox" name="groupUserWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="groupUserWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
				[#if propertySet.groupUserReadable]
					<input type="checkbox" name="groupUserReadable" value="true" checked>Readable
				[#else]
					<input type="checkbox" name="groupUserReadable" value="true">Readable
				[/#if]
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<span class="control-label">Other Permission: </span>
			<div class="controls">
				<label class="checkbox inline">
					[#if propertySet.othersWritable]
						<input type="checkbox" name="othersWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="othersWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
				[#if propertySet.othersReadable]
					<input type="checkbox" name="othersReadable" value="true" checked>Readable
				[#else]
					<input type="checkbox" name="othersReadable" value="true">Readable
				[/#if]
				</label>
			</div>
		</div>

		<input type="button" class="btn btn-primary" value="Submit" name="submit_bt"/>
	</form>
</div>