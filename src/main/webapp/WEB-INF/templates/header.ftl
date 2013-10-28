<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span>
				 <span class="icon-bar"></span> 
				 <span class="icon-bar"></span>
			</button>
			<a class="brand" href="#">Configuration Center</a>
			<div class="nav-collapse collapse">
			[#if (SPRING_SECURITY_CONTEXT.authentication.principal)??]
				<ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                      <a href="" id="drop_usr" role="button" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user icon-white"></i>${SPRING_SECURITY_CONTEXT.authentication.principal.username}<b class="caret"></b></a>
                      <ul class="dropdown-menu" role="menu" aria-labelledby="drop_usr">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="editProfile">Edit Profile</a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="register">Register</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="logout">Sing Out</a></li>
                      </ul>
                    </li>
                  </ul>
              [#else]
              	<div class="navbar-text pull-right">
					<a href="login">Sign In</a>
				</div>
				[/#if]
				<ul class="nav">
					<li class="active"><a href="home"><i class="icon-home icon-white"></i>Home</a></li>
					<li class="active"><a href="userGroups">User Group</a></li>
					<li class="active"><a href="nameSpaces">Name Space</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>
<script src="js/home.js" type="text/javascript"></script>

