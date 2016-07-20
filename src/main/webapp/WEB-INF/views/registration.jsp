<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

	<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
	<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">

	<title>Registration</title>
</head>
<body>

	<div class="container"  style="max-width:400px" >
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">${msg}</div>
		</c:if>
		<form:form name="regForm" role="form" modelAttribute="user" method="POST">
			<div class="form-group">
				 <label for="firstname">First Name:</label>
				 <form:input type="text" name='firstname' path="name" class="form-control" id="firstname" />
				 <form:errors path="name" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="lastname">Last Name:</label>
				 <form:input type="text" name='lastname' path="surname" class="form-control" id="lastname" />
				 <form:errors path="surname" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="email">Email address:</label>
				 <form:input type="text" name='email' path="email" class="form-control" id="email" />
				 <form:errors path="email" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="phone">Phone:</label>
				 <form:input type="text" name='phone' path="phone" class="form-control" id="phone" />
				 <form:errors path="phone" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="state">State:</label>
				 <form:input type="text" name='state' path="state" class="form-control" id="state" />
				 <form:errors path="state" style="color:red" />
			 </div>
			  <div class="form-group">
				 <label for="city">City:</label>
				 <form:input type="text" name='city' path="city" class="form-control" id="city" />
				 <form:errors path="city" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="address">Address:</label>
				 <form:input type="text" name='address' path="address" class="form-control" id="address" />
				 <form:errors path="address" style="color:red" />
			 </div>
			 <div class="form-group">
				 <label for="postalCode">Postal Code:</label>
				 <form:input type="text" name='postalCode' path="postalCode" class="form-control" id="postalCode" />
				 <form:errors path="postalCode" style="color:red" />
			 </div>
			 <div class="form-group">
				  <label for="pwd">Password:</label>
				  <form:input type="password" name='password' path="password" class="form-control" id="pwd" />
				  <form:errors path="password" style="color:red" />
			 </div>
	  		 <button name="submit" type="submit"
					value="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>