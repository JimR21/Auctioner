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

<body>

	<%@ include file="/resources/template/menu-top.jsp" %>
	
	<!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Upgrade Account! /></h1>
                <p class="lead">Upgrade Form Implementation</p>
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    
    <%@ include file="/resources/template/footer.jsp" %>

    <!-- /.container -->
    
    <script src=<c:url value="/resources/js/jquery.min.js" />></script>
   	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>

</html>