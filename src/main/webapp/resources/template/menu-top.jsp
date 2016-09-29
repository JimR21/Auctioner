<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/iconmoon.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/jquery.mCustomScrollbar.min.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/topnav.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">


<%--Top Navbar --%>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
    	<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/Auctioner/"><span class="icon-hammer2"></span> Auctioner</a>
	</div>

	<div class="collapse navbar-collapse js-navbar-collapse">

        <div class="col-md-offset-3 col-md-4">
            <form class="navbar-center" role="search" action="/Auctioner/auctions">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" name="searchString" class="form-control" placeholder="Search">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                        <input type="hidden" name="categoryId" value="all">
                        <input type="hidden" name="page" value="1">
                    </div>
                </div>
            </form>
        </div>

        <div class="nav navbar-nav navbar-right">
            <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
                <li>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <p class="navbar-btn">
                            <a href="/Auctioner/admin-inbox" class="btn btn-default btn-link">
                        </p>
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
                <sec:authorize ifNotGranted="ROLE_SELLER">
                    <li><a href="upgrade" style="color:orange">Become An Auctioner</a></li>
                </sec:authorize>
                </sec:authorize>
                <sec:authorize ifAnyGranted="ROLE_SELLER">
                   <li><a href="new-auction" style="color:orange">New Auction</a></li>
               </sec:authorize>
                <sec:authorize ifNotGranted="ROLE_ADMIN">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                            id="account">My Account (<sec:authentication property="name" />) <span class=
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
            </sec:authorize>
            <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
                <a class="btn btn-primary" href="/Auctioner/login">Login</a>
                or
                <a class="btn btn-warning" href="/Auctioner/registration">Sign up</a>
            </sec:authorize>
        </div>
	</div><!-- /.nav-collapse -->
  </div>
</nav>

<nav id="nav" class="navbar navbar-inverse navbar-lower" role="navigation">
  <div class="container">
    <div class="collapse navbar-collapse collapse-buttons">
        <ul class="nav navbar-nav">
            <li><a href="/Auctioner/auctions?categoryId=all">View All</a></li>

            <%-- Categories --%>
            <%@ include file="/resources/template/categories.jsp" %>

		</ul>
    </div>
  </div>
</nav>

<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
<script src=<c:url value="/resources/js/msg-notify.js" />></script>
</sec:authorize>
