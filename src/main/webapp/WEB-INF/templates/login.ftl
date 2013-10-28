<script src="js/login.js" type="text/javascript"></script>
<style type="text/css">
.form-signin {
	max-width: 300px;
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

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 5px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 5px;
	padding: 7px 9px;
}
</style>
	<div class="container">
		<form class="form-signin" name="loginForm" method="POST" action="login">
			<input type="hidden" name="act" value="signin"/>
			<table>
	        <tr><td><h2 class="form-signin-heading">Please sign in</h2></td></tr>
	        <tr><td><input name="name"  type="text" class="input-block-level" placeholder="User Name" required></td></tr>
	        <tr><td><span class="text-error hideItem" id="username_msg">Please input the user name.</span></td></tr>
	        <tr><td><input name="password" type="password" class="input-block-level" placeholder="Password" required></td></tr>
	        <tr><td><span class="text-error hideItem" id="pwd_msg">Please input the password.</span></td></tr>
	        <tr><td><span class="text-error" id="auth_err">[#if error??]${error}[/#if]</span></td></tr>
	        <tr><td><input type="button" class="btn btn-primary" value="Sign In" name="signin_bt"/></td></tr>
	        <tr><td><span class="text-info">Want an account? <a href="register">Join for free!</a></span></td></tr>
	        </table>
	      </form>
	</div>