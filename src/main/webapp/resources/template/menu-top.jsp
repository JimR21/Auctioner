
<!-- Navigation -->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- Button when screen gets smaller -->
            <button class="btn navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div id="logo" >
                <a class="navbar-brand" href="home">Auctioner</a>
            </div>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="showauctions">Auctions</a></li>
                <li><a href="about">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
	             	<li><a href="admin" style="color:orange">Admin Console</a></li>
	             	<li><a href="j_spring_security_logout">Logout</a></li>
            	</sec:authorize>
            	 <sec:authorize ifAnyGranted="ROLE_BIDDER">
	             	<li><a href="upgrade" style="color:orange">Become An Auctioner</a></li>
            	</sec:authorize>
            	<sec:authorize ifNotGranted="ROLE_ADMIN">
	                <li class="dropdown">
	                    <a class="dropdown-toggle" data-toggle="dropdown" href=
	                    "#" id="account">My Account (<sec:authentication property="name" />) <span class=
	                    "caret"></span></a>
	                    <ul class="dropdown-menu">
	                        <li><a href="myprofile">Account Settings</a></li>
	                        <sec:authorize ifAnyGranted="ROLE_SELLER">
	                        	<li><a href="myauctions">My Auctions</a></li>
	                        </sec:authorize>
	                        <li class="divider"></li>
	                        <li><a href="j_spring_security_logout">Logout</a></li>
	                    </ul>
	                </li>
	           	</sec:authorize>
            </ul>
        </div>
    </div>
</nav>
