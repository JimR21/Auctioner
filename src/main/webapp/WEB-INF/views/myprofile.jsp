<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/sidenav.css" /> rel="stylesheet" type="text/css">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <title>Auctioner</title>

</head>

<body data-spy="scroll" data-target="#myFullNavbar" data-offset="50">

   	 <%@ include file="/resources/template/menu-top.jsp" %>

    <nav class="navbar navbar-default visible-xs">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#"><sec:authentication property="name" /></a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a data-toggle="pill" href="#section1">Overview</a></li>
	        <li><a data-toggle="pill" href="#section2">Messages</a></li>
	        <li><a data-toggle="pill" href="#section3">Other Settings</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="container">
	  <div class="row content">
	    <div class="col-sm-3 sidenav hidden-xs" id="myFullNavbar">
	      <h2><sec:authentication property="name" /></h2>
	      <ul class="nav nav-pills nav-stacked">
	        <li class="active"><a data-toggle="pill" href="#section1">Overview</a></li>
	        <li><a data-toggle="pill" href="#section2">Messages</a></li>
	        <li><a data-toggle="pill" href="#section3">Other Settings</a></li>
	      </ul><br>
	    </div>
	    <br>
	    
	    <div class="tab-content">
	    	<div class="tab-pane fade in active" id="section1">
			    <div class="col-sm-9">
			      <div class="well">
			        <h4>Dashboard</h4>
			        <p>Some text..</p>
			      </div>
			      <div class="row">
			        <div class="col-sm-3">
			          <div class="well">
			            <h4>Users</h4>
			            <p>1 Million</p>
			          </div>
			        </div>
			        <div class="col-sm-3">
			          <div class="well">
			            <h4>Pages</h4>
			            <p>100 Million</p>
			          </div>
			        </div>
			        <div class="col-sm-3">
			          <div class="well">
			            <h4>Sessions</h4>
			            <p>10 Million</p>
			          </div>
			        </div>
			        <div class="col-sm-3">
			          <div class="well">
			            <h4>Bounce</h4>
			            <p>30%</p>
			          </div>
			        </div>
			      </div>
			      <div class="row">
			        <div class="col-sm-4">
			          <div class="well">
			            <p>Text</p>
			            <p>Text</p>
			            <p>Text</p>
			          </div>
			        </div>
			        <div class="col-sm-4">
			          <div class="well">
			            <p>Text</p>
			            <p>Text</p>
			            <p>Text</p>
			          </div>
			        </div>
			        <div class="col-sm-4">
			          <div class="well">
			            <p>Text</p>
			            <p>Text</p>
			            <p>Text</p>
			          </div>
			        </div>
			      </div>
			      <div class="row">
			        <div class="col-sm-8">
			          <div class="well">
			            <p>Text</p>
			          </div>
			        </div>
			        <div class="col-sm-4">
			          <div class="well">
			            <p>Text</p>
			          </div>
			        </div>
			      </div>
			    </div>
			</div>
		    
		    <div class="tab-pane fade" id="section2">
			    <div class="col-sm-9">
			      <div class="well">
			        <h4>Messages</h4>
			        <p>Some text..</p>
			      </div>
			    </div>
			</div>
		    
		    <div class="tab-pane fade" id="section3">
			    <div class="col-sm-9">
			      <div class="well">
			        <h4>Settings</h4>
			        <p>Some text..</p>
			      </div>
			    </div>
		    </div>
		    
	  	</div>
	    
	  </div>
	</div>
    
    <%@ include file="/resources/template/footer.jsp" %>

    <!-- /.container -->
    
    <script src=<c:url value="/resources/js/jquery.min.js" />></script>
   	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>

</html>
