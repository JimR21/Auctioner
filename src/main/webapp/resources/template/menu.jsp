<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head> 

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home">Auctioner</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="showauctions">Auctions</a>
                    </li>
                    <li>
                        <a href="about">About</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                	<sec:authorize ifAnyGranted="ROLE_ADMIN">
	                	<li>
	                		<a href="admin" style="color:orange">Admin Console</a>
	                	</li>
                	</sec:authorize>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="account"> 
                        	My Acount
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" aria-laballedby="account">
                            <li>
                                <a href="account">Account Settings</a>
                            </li>
                            <li>
                                <a href="myauctions">My Auctions</a>
                            </li>
                            <li>
                                <a href="j_spring_security_logout">Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

</body>

</html>
