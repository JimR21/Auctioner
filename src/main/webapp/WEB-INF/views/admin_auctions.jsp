<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9">
    <form id="auction-form" method="GET">
      <div class="panel panel-primary">
        <div class="panel-heading">
            <h4 class="panel-title">All Auctions</h4>
        </div>
        <div class="panel-body">
                <table id="allAuctions" class="table table-striped table-hover table-condensed">
                    <thead>
                        <tr>
                            <th>Name</th><th>Seller</th><th>Started</th><th>Ends</th><th>First Bid</th><th></th>
                        </tr>
                    <thead>
                    <tbody>
                    <c:forEach items="${auctions}" var="auction">
                    <tr>
                        <td><c:out value="${auction.name}"></c:out></td>
                        <td><c:out value="${auction.user.username}"></c:out></td>
                        <td><c:out value="${auction.started}"></c:out></td>
                        <td><c:out value="${auction.ends}"></c:out></td>
                        <td><c:out value="${auction.firstBid}"></c:out></td>
                        <td style="text-align: right">
                            <div class="dropdown">
                            <button class="btn btn-xs btn-primary" data-toggle="dropdown">More</button>
                            <ul class="dropdown-menu">
                                <li><a href="Profile">Details</a>
                                <li><a href="Profile">Seller</a>
                                <li><a href="api/auctions/${auction.auctionid}">Auction XML</a>
                                <li class="divider"></li>
                                <li id="deleteU"><a href="#">Delete</a>
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
    <div class="row">
        <div class="col-sm-6">
            <div class="well">
                <h4>New Users</h4>
                <p>Some text...</p>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="well">
                <h4>Highest Rating Users</h4>
                <p>Some text...</p>
            </div>
        </div>
    </div>
</div>

<script>

	/* All Auctions Table */
	$('#allAuctions').DataTable({

		lengthChange: false,

		"columnDefs": [
		{ "orderable": false, "targets": 5 }
		 ]
		});

</script>
