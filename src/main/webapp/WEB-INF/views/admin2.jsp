<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href=<c:url value="/resources/css/bootstrap.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <title>Admin Console</title>
	
	<style>
	  /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
	  .row.content {height: 550px}
	  
	  /* Set gray background color and 100% height */
	  .sidenav {
	    background-color: #f1f1f1;
	    height: 100%;
	  }
	      
	  /* On small screens, set height to 'auto' for the grid */
	  @media screen and (max-width: 767px) {
	    .row.content {height: auto;}
	  }
	</style>
</head>
<body>

	<%@ include file="/resources/template/menu.jsp" %>

	<nav class="navbar navbar-inverse visible-xs">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Logo</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Dashboard</a></li>
	        <li><a href="#">Users</a></li>
	        <li><a href="#">Auctions</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="container">
	  <div class="row content">
	    <div class="col-sm-3 sidenav hidden-xs">
	      <h2>Logo</h2>
	      <ul class="nav nav-pills nav-stacked">
	        <li class="active"><a href="#section1">Dashboard</a></li>
	        <li><a href="#section2">Users</a></li>
	        <li><a href="#section3">Auctions</a></li>
	      </ul><br>
	    </div>
	    <br>
	    
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
	</div>
	
	<script src=<c:url value="/resources/js/jquery.min.js" />></script>
   	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>
</html>

