<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet"  type="text/css">


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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>