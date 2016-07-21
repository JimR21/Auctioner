<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<title>Login Page</title>


</head>
<body onload='document.loginForm.username.focus();'>

	<div class="container"  style="max-width:400px" >
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">${msg}</div>
		</c:if>
		<br/>
		<br/>
		<form name="loginForm" role="form" action="<c:url value='j_spring_security_check' />" method="POST">
			 <div class="form-group">
				 <label for="email">Email address:</label>
				 <input type="text" name='username' class="form-control" id="username">
			 </div>
			 <div class="form-group">
				  <label for="pwd">Password:</label>
				  <input type="password" name='password' class="form-control" id="pwd">
			 </div>
			 <div class="checkbox">
 			      <label><input type="checkbox"> Remember me</label>
			 </div>
	  		 <button name="submit" type="submit"
					value="submit" class="btn btn-default">Submit</button>
		</form>
		<p>Not a member? Sign up <a href="registration">here</a><p>
	</div>
	
	<script src=<c:url value="/resources/js/jquery.min.js" />></script>
   	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>
</html>