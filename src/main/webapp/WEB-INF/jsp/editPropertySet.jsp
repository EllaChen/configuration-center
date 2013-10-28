<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="span12">
	<div class="row-fluid">
		<div class="row-fluid">
			<div id="propertySetProfile" class="span12">
				<tiles:insertAttribute name="propertySetProfile" />
			</div>
		</div>
		<div class="row-fluid">
			<div id="propertyList" class="span12">
				<tiles:insertAttribute name="PropertyList" />
			</div>
		</div>
	</div>
</div>
<script src="js/editPropertySet.js" type="text/javascript"></script>