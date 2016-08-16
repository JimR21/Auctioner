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
	<link href=<c:url value="/resources/css/sidenav.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/dataTables.bootstrap.min.css" /> rel="stylesheet" type="text/css">
    <link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <title>Auctioner</title>

    <style>

    .table tbody {
        cursor: pointer;
    }

    </style>

</head>

<body data-spy="scroll" data-target="#bs-sidebar-navbar-collapse-1" data-offset="50">

   	<%@ include file="/resources/template/menu-top.jsp" %>

    <div class="container">
	  <div class="row content">

          <!-- Mobile navbar -->
          <nav class="navbar navbar-default sidebar" role="navigation">
              <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
              </div>

              <!-- Desktop sidebar -->
              <div class="col-sm-3 collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                <h4 class="text-center"><sec:authentication property="name"</h4>
                <hr />
                <ul class="nav navbar-nav nav-pills">
                  <li class="active"><a href="#section1" data-toggle="pill">Overview<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Messages <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                      <li><a href="messaging/inbox" data-target="#section2" id="inbox_tab" data-toggle="pill" rel="tooltip">Inbox</a></li>
                      <li><a href="messaging/new-message" data-target="#section3" id="newMessage_tab" data-toggle="pill" rel="tooltip">New Message</a></li>
                      <li><a href="messaging/sent" data-target="#section4" id="sent_tab" data-toggle="pill" rel="tooltip">Sent</a></li>
                      <li class="divider" data-toggle="pill"></li>
                      <li><a href="messaging/anouncements" data-target="#section5" id="inbox_tab" data-toggle="pill" rel="tooltip">Anouncements</a></li>
                    </ul>
                  </li>
                  <li ><a href="admin/settings" data-target="#section6" id="settings_tab" data-toggle="pill" rel="tooltip">Other Settings<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tasks"></span></a></li>
                </ul>
              </div>
            </div>
         </nav>

	    <div  id="loading" class="tab-content">
	    	<div class="tab-pane fade in active" id="section1" name="overview">
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

		    <div class="tab-pane fade" id="section2" name="inbox">

			</div>

            <div class="tab-pane fade" id="section3" name="newMessage">

		    </div>

		    <div class="tab-pane fade" id="section4" name="sent">

		    </div>

            <div class="tab-pane fade" id="section5" name="anouncements">
			    <div class="col-sm-9">
			      <div class="well">
			        <h4>Settings</h4>
			        <p>Some text..</p>
			      </div>
			    </div>
		    </div>

            <div class="tab-pane fade" id="section6" name="settings">
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
    <script src=<c:url value="/resources/js/jquery.dataTables.min.js" />></script>
   	<script src=<c:url value="/resources/js/dataTables.bootstrap.min.js" />></script>
    <script src=<c:url value="/resources/js/spin.min.js" />></script>
    <script src=<c:url value="/resources/js/spinner.js" />></script>
    <script src=<c:url value="/resources/js/myprofile-page-load.js" />></script>

</body>

</html>
