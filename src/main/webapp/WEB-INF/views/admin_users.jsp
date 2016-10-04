<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9">
   	<form id="authorize-form" method="GET">
      <div class="panel panel-primary">
      	<div class="panel-heading">
      		<h4 class="panel-title">All Users</h4>
      	</div>
      	<div class="panel-body">
		        <table id="allUsers" class="table table-striped table-hover table-condensed">
		        	<thead>
						<tr>
							<th>Username</th><th>Firstname</th><th>Lastname</th><th>Email</th><th>Approved</th><th></th>
						</tr>
					<thead>
					<tbody>
					<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.username}"></c:out></td><td><c:out value="${user.firstName}"></c:out></td><td><c:out value="${user.lastName}"></c:out></td><td><c:out value="${user.email}"></c:out></td>
						<td style="text-align: right">
							<input type="checkbox" id="approved" name="approved" value="${user.userid }"
								<c:if test="${user.approved==1}">
									checked disabled="disabled"
								</c:if>
							/>
						</td>
						<td style="text-align: right">
							<div class="dropdown">
							<button class="btn btn-xs btn-primary" data-toggle="dropdown">More</button>
							<ul class="dropdown-menu">
								<li><a href="/Auctioner/profile/${user.userid}">Profile</a>
								<%-- <li class="divider"></li>
								<li id="deleteU"><a href="#">Delete</a> --%>
							</ul>
						</div>
						</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
		</div>
		<div class="panel-footer">
			<input class="btn btn-success col-md-offset-10" type="submit" value="Approve" id="appr-btn" disabled="disabled"></input>
		</div>
      </div>
    </form>
</div>

<script src=<c:url value="/resources/js/approve.js" />></script>

<script>

	/* All Users Table */
	$(document).ready(function() {
		$('#allUsers').DataTable({

			lengthChange: false,

			columnDefs: [
			{ "orderable": false, "targets": 5 }
			 ]
		});
	});

</script>
