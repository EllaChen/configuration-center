
<style type="text/css">
.form-register {
	max-width: 700px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
</style>
	<div class="container">
		<form name="registerForm" class="form-horizontal form-register" method="POST" action="register">
		<input type="hidden" name="act" value="register"/>
			<div class="control-group">
				<span class="control-label">User Name: </span>
				<div class="controls">
					<input name="name" type="text" maxlength="20"
						placeholder="User Name" required>
				</div>
			</div>
			<div class="control-group">
				<span class="control-label">Password:</span>
				<div class="controls">
					<input type="password" name="password" placeholder="Password" required>
				</div>
			</div>

			<div class="control-group">
				<span class="control-label">Full Name: </span>
				<div class="controls">
					<input type="text" name="fullName" placeholder="Full Name">
				</div>
			</div>

			<div class="control-group">
				<span class="control-label">Email: </span>
				<div class="controls">
					<input type="text" name="email" placeholder="Email">
				</div>
			</div>

			<div class="control-group">
				<span class="control-label">Tel: </span>
				<div class="controls">
					<input type="text" name="tel" placeholder="Tel">
				</div>
			</div>
			<div class="control-group">
			<div class="controls">
				<input id="register_btn" type="button" value="Register" class="btn btn-primary" />
			</div>
			</div>
		</form>
	</div>
<script src="js/register.js" type="text/javascript"></script>