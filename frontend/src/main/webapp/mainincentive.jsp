<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<%@ page  import = "de.uniba.dsg.dsam.model.dtos.incentiveDTO" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>Incentives</title>
</head>
<body>

<h1> Incentives</h1>
<p><a href="/frontend/incentiveserlvet/newincentive" class="btn btn-primary">Create Incentive</a></p>


<%  
		List<incentiveDTO> incentives = (List<incentiveDTO>) request.getAttribute("incentivelist");
		
		for(incentiveDTO div: incentives) { 
		%>
		<div class="row">
			<div class="col-md-3"><h4><%= div.getName() %></h4></div>
			<div class="col-md-4">
				<div class="btn-group" role="group">
					<a href="/frontend/incentiveservlet/editincentiveservlet?div_id=<%= div.getId() %>" class="btn btn-primary">Edit Incentive</a>
						<a id=<%= div.getId() %> href="" class="delete btn btn-danger">Delete Incentive</a>
					</div>
				</div>			
			</div>
			<% } %>
			
	<script>
		$(document).ready(function() {
			$(".delete").click(function() {
				
				event.preventDefault();
				
				$.ajax({
					url: '/frontend/incentiveservlet?div_id=' + event.target.id,
					type: 'DELETE',
					success: function(response) {
						location.reload();
					}
				});
			});
		});
		</script>

</body>
</html>