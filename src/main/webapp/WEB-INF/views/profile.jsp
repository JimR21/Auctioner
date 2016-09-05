<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

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
            <div class="col-sm-12 text-center">
                <div class="container">
                    <h1 class="page-header"><strong>${usr.username}</strong></h1>
                    <div class="row">
                        <!-- left column -->
                        <div class="col-md-4 col-sm-6 col-xs-12">
                          <div class="text-center">
                            <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="avatar">
                            <h3>Bidder Rating</h3>
                            <ul class="list-inline ratings text-center" title="Ratings">
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                </ul>
                            <h3>Auctioneer Rating</h3>
                            <ul class="list-inline ratings text-center" title="Ratings">
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                  <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                                </ul>
                          </div>
                        </div>
                        <!-- edit form column -->
                        <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
                          <h3>Personal info</h3>
                          <div class="col-md-offset-4 col-md-3">
                            <h4 class="text-left">Name</h4>
                          </div>
                          <div class="col-md-4">
                              <h4 class="text-left"><strong>${usr.firstName}</strong></h4>
                          </div>
                          <div class="col-md-offset-4 col-md-3">
                            <h4 class="text-left">Lastname</h4>
                          </div>
                          <div class="col-md-4">
                              <h4 class="text-left"><strong>${usr.lastName}</strong></h4>
                          </div>
                          <div class="col-md-offset-4 col-md-3">
                            <h4 class="text-left">Country</h4>
                          </div>
                          <div class="col-md-4">
                              <h4 class="text-left"><strong>${usr.country}</strong></h4>
                          </div>
                          <div class="col-md-offset-4 col-md-3">
                            <h4 class="text-left">City</h4>
                          </div>
                          <div class="col-md-4">
                              <h4 class="text-left"><strong>${usr.city}</strong></h4>
                          </div>
                          <div class="col-md-offset-4 col-md-3">
                            <h4 class="text-left">Email</h4>
                          </div>
                          <div class="col-md-4">
                              <h4 class="text-left"><strong>${usr.email}</strong></h4>
                          </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-11">
                            <a href="/Auctioner/auctions/bySeller/${usr.userid}" class="btn btn-default pull-right">View User's Auctions</a>
                            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                                <a href="/Auctioner/admin-new-message/${usr.username}" class="btn btn-default pull-right">Send Message</a>
                            </sec:authorize>
                            <sec:authorize ifNotGranted="ROLE_ADMIN">
                                <a href="/Auctioner/myprofile-new-message/${usr.username}" class="btn btn-default pull-right">Send Message</a>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <%@ include file="/resources/template/footer.jsp" %>

</body>

</html>
