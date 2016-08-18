<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/iconmoon.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">


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
                <a class="navbar-brand" href="/Auctioner"><span class="icon-hammer2"></span> Auctioner</a>
            </div>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="showauctions">Auctions</a></li>
                <li><a href="/Auctioner/about">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li style="width: 3em">
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <a href="/Auctioner/admin-inbox" class="btn btn-default btn-sm btn-link">
                    </sec:authorize>
                    <sec:authorize ifNotGranted="ROLE_ADMIN">
                        <a href="/Auctioner/myprofile-inbox" class="btn btn-default btn-sm btn-link">
                    </sec:authorize>
                        <div class="notification-icon">
                            <span class="glyphicon glyphicon-envelope"></span>
                            <span id="msg-badge" class="badge" style="display: none"></span>
                        </div>
                    </a>
                </li>
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
	             	<li><a href="/Auctioner/admin" style="color:orange">Admin Console</a></li>
	             	<li><a href="/Auctioner/j_spring_security_logout">Logout</a></li>
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
	                        <li><a href="/Auctioner/myprofile">Account Settings</a></li>
	                        <sec:authorize ifAnyGranted="ROLE_SELLER">
	                        	<li><a href="myauctions">My Auctions</a></li>
	                        </sec:authorize>
	                        <li class="divider"></li>
	                        <li><a href="/Auctioner/j_spring_security_logout">Logout</a></li>
	                    </ul>
	                </li>
	           	</sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<script src=<c:url value="/resources/js/msg-notify.js" />></script>
