<div class="row-fluid">
	<form class="form-horizontal" method="POST" action="editNameSpace">
	<input type="hidden" name="act" value="${act}"/>
		[#if error??]
		    <div class="alert">
			    <button type="button" class="close" data-dismiss="alert">&times;</button>
			    <strong>Error:</strong>${error}
		    </div>
		[/#if]
		<div class="control-group">
			<span class="control-label">Name: </span>
			<div class="controls">
				[#if act == "create"]
					<input type="text" name="name" placeHolder="Space Name" maxlength="20"/>
				[#else]
					<input type="hidden" name="id" value="${nameSpace.id}"/>
					<input type="text" name="name" value="${nameSpace.name}" readonly/>
				[/#if]
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">Owner: </span>
			<div class="controls">
				<input type="text" name="owner" value="${nameSpace.owner}" readonly/>
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">User Group: </span>
			<div class="controls">
				<input type="text" name="userGroup" value="${nameSpace.userGroup!''}"/>
			</div>
		</div>
		<div class="control-group">
			<span class="control-label">Owner Permission: </span>
			<div class="controls">
				<label class="checkbox inline">
					[#if nameSpace.ownerWritable ]
						<input type="checkbox" name="ownerWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="ownerWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
					[#if nameSpace.ownerReadable ]
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
					[#if nameSpace.groupUserWritable ]
						<input type="checkbox" name="groupUserWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="groupUserWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
					[#if nameSpace.groupUserReadable ]
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
					[#if nameSpace.othersWritable ]
						<input type="checkbox" name="othersWritable" value="true" checked>Writable
					[#else]
						<input type="checkbox" name="othersWritable" value="true">Writable
					[/#if]
				</label>
				<label class="checkbox inline">
					[#if nameSpace.othersReadable ]
						<input type="checkbox" name="othersReadable" value="true" checked>Readable
					[#else]
						<input type="checkbox" name="othersReadable" value="true">Readable
					[/#if]
				</label>
			</div>
		</div>

		<input type="button" class="btn btn-primary" value="Submit" name="submit_bt"/>
		[#if act == "update"]
		<input type="button" class="btn btn-primary" value="Add Property Set" name="add_ps_bt_${nameSpace.id}"/>
		[/#if]
	</form>
</div>
<script src="js/editNameSpace.js" type="text/javascript"></script>