<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9">
  <form:form id="new-message-form" name="newMessageForm" role="form" modelAttribute="new_message" method="POST">
      <div class="panel panel-primary">
          	<div class="panel-heading">
          		<h4 class="panel-title">New Message</h4>
          	</div>
          	<div class="panel-body">
                    <form:input class="form-control" name="receiver.username" path="receiver" placeholder="Receipient username"></form:input>
                    <br />
                    <form:textarea class="form-control" name="message" path="message" placeholder="Type in your message" rows="10"></form:textarea>
        	</div>
        	<div class="panel-footer">
        		<input class="btn btn-success col-md-offset-10" type="submit" value="Send Message" id="appr-btn"></input>
        	</div>
      </div>
  </form:form>
</div>
