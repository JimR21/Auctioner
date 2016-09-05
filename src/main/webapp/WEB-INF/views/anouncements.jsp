<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- Anouncements and Message View swap through Javascript --%>

<%-- Anouncements --%>
<div id="messages" class="col-sm-9">
  <div class="panel panel-primary">
  	<div class="panel-heading">
  		<h4 class="panel-title">Anouncements</h4>
  	</div>
  	<div class="panel-body">
        <table id="anouncements" class="table table-hover table-condensed">
        	<thead>
        		<tr>
                    <td>Id</td>
        			<td class="text-right">Date</td>
                    <td>Message</td>
        		</tr>
        	</thead>
			<tbody>
			<c:forEach items="${anouncements}" var="anouncement">
			<tr>
                <td><c:out value="${anouncement.messageId}"></c:out></td>
				<td class="text-right"><fmt:formatDate pattern="hh:mm dd-MMM-yyyy" value="${anouncement.date}" /></td>
                <td><c:out value="${anouncement.message}"></c:out></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="panel-footer">
		<input class="btn btn-success col-md-offset-10" type="submit" value="New Message" id="appr-btn"></input>
	</div>
  </div>
</div>

<%-- Message View --%>
<div id="message" class="col-sm-9" style="display: none">
    <div class="panel panel-primary">
      	<div class="panel-heading">
      		<h4 id="header_an" class="panel-title"></h4>
      	</div>
      	<div class="panel-body">
      		<button id="back" class="btn btn-sm btn-active"><span class="glyphicon glyphicon-arrow-left"></span></button>
            <div class="well">
            	<p id="content_an"></p>
            </div>
    	</div>
    </div>
</div>


<script>

	/* Anouncements Table */
	var table = $('#anouncements').DataTable({

	    lengthChange: false,
	    ordering: false,
	    info: false,
	    autoWidth: false,

        /* Hide Columns */
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 1 ],
                "width": "50%"
            },
            {
                "targets": [ 2 ],
                "visible": false,
                "searchable": false
            }
        ]
	});

    /* Anouncements table onClick */
    $('#anouncements tbody').on('click', 'tr', function () {
		var data = table.row( this ).data(),
            row = $(this);

        /* Table data */
        var date = data[1],
            message = data[2];

        /* Populate Message View */
        $('#header_an').text(date);
        $('#content_an').text(message);

        $('#messages').hide();
        $('#message').show();
    });

    /* Back button. Swap to Anouncements View */
    $('#back').click(function() {

    	 $('#message').hide();
         $('#messages').show();
    });

</script>
