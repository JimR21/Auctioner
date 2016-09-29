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


     <div class="container">
        <h1>Edit Profile</h1>
       	<hr>
     	<div class="row">
           <!-- left column -->
           <div class="col-md-3">
             <div class="text-center">
               <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
               <h6>Upload a different photo...</h6>

               <input type="file" class="form-control">
             </div>
           </div>

           <!-- edit form column -->
           <div class="col-md-9 personal-info">
               <c:if test="${not empty msg}">
                 <div class="alert alert-info alert-dismissable">
                   <a class="panel-close close" data-dismiss="alert">×</a>
                   <i class="glyphicon glyphicon-info-sign"></i>
                   ${msg}
                 </div>
             </c:if>
             <h3 class="text-center">Personal info</h3>

             <form:form id="form" name="regForm" class="form-horizontal" role="form" modelAttribute="user" method="POST">
               <div class="form-group">
                 <label for="firstName" class="col-lg-3 control-label">First name:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='firstName' path="firstName" class="form-control" value="${user.firstName}" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="lastName" class="col-lg-3 control-label">Last name:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='lastName' path="lastName" class="form-control" value="${user.lastName}" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="email" class="col-lg-3 control-label">Email:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='email' path="email" class="form-control" value="${user.email}" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="username" class="col-lg-3 control-label">Username:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='username' path="username" class="form-control" value="${user.username}" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="password" class="col-lg-3 control-label">Password:</label>
                 <div class="col-lg-8">
                  <form:input type="password" name='password' path="password" class="form-control" value="p4DS*4a$hLA*4#ataPv" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="country" class="col-lg-3 control-label">Country:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='country' path="country" class="form-control" value="${user.country}" />
                 </div>
               </div>
               <div class="form-group">
                 <label for="city" class="col-lg-3 control-label">City:</label>
                 <div class="col-lg-8">
                  <form:input type="text" name='city' path="city" class="form-control" value="${user.city}" />
                 </div>
               </div>
               <sec:authorize ifAnyGranted="ROLE_SELLER">
                   <div class="form-group">
                     <label for="address" class="col-lg-3 control-label">Address:</label>
                     <div class="col-lg-8">
                      <form:input type="text" name='address' path="address" class="form-control" value="${user.address}" />
                     </div>
                   </div>
                   <div class="form-group">
                     <label for="postalCode" class="col-lg-3 control-label">Postal Code:</label>
                     <div class="col-lg-8">
                      <form:input type="text" name='postalCode' path="postalCode" class="form-control" value="${user.postalCode}" />
                     </div>
                   </div>
                   <div class="form-group">
                     <label for="afm" class="col-lg-3 control-label">AFM:</label>
                     <div class="col-lg-8">
                      <form:input type="text" name='afm' path="afm" class="form-control" value="${user.afm}" />
                     </div>
                   </div>
                   <div class="form-group">
                     <label for="phone" class="col-lg-3 control-label">Phone:</label>
                     <div class="col-lg-8">
                      <form:input type="text" name='phone' path="phone" class="form-control" value="${user.phone}" />
                     </div>
                   </div>
               </sec:authorize>
               <form:input type="hidden" name='userid' path="userid" class="form-control" value="${user.userid}" />
               <div class="form-group">
                 <label class="col-md-3 control-label"></label>
                 <div class="col-md-8">
                     <a href="/Auctioner/myprofile" class="btn btn-default">Cancel</a>
                     <span></span>
                     <button name="submit" type="submit" value="submit" class="btn btn-success">Save Changes</button>
                 </div>
               </div>
           </form:form>
           </div>
       </div>
     </div>
 <hr>

    <%@ include file="/resources/template/footer.jsp" %>

    <script src=<c:url value="/resources/js/jquery.validate.min.js" />></script>

    <script>

    $('#form').validate({

        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required:true
            },
            username: {
                required:true
            },
            email: {
                required:true
            },
            password: {
                required:true
            },
            phone: {
                required:true
            },
            country: {
                required:true
            },
            city: {
                required:true
            },
            address: {
				required:true
			},
			postalCode: {
				required:true
			},
			afm: {
				required:true
			}
        },
        highlight: function(element, errorClass) {
            $(element).closest('.form-group').addClass('has-error');
        }
    });

    </script>

</body>

</html>
