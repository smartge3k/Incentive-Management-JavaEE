<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ page  import = "de.uniba.dsg.dsam.model.dtos.beverageDTO" %>
<title>Beverage Store Demo</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
		<h1>Beverage Store</h1>
		
		<p><a href="/frontend/beverages/new" class="btn btn-primary">Create Beverage</a></p>
		
		<div class="row">
			<div class="col-md-1"><h3>Name</h3></div>
			<div class="col-md-1"><h3>Mnfctur.</h3></div>
			<div class="col-md-1"><h3>Quantity</h3></div>
			<div class="col-md-1"><h3>Price ($)</h3></div>
			<div class="col-md-2"><h3>Incentive ID</h3></div>
			
		</div>
      	<%  
		List<beverageDTO> beverages = (List<beverageDTO>) request.getAttribute("BevereagesList");
		
		for(beverageDTO div: beverages) { 
		%>
		<div class="row">
			<div class="col-md-1"><h4><%= div.getName() %></h4></div>
			<div class="col-md-1"><h4><%= div.getType() %></h4></div>
			<div class="col-md-1"><h4><%= div.getQuantity() %></h4></div>
			<div class="col-md-1"><h4><%= div.getPrice() %></h4></div>
			<div class="col-md-1"><h4><%= div.getIncentive() %></h4></div>
			<div class="col-md-4">
				<div class="btn-group" role="group">
					<a href="/frontend/beverages/editbeverage?div_id=<%= div.getId() %>" class="btn btn-primary">Edit Beverage</a>
					<a id="<%= div.getId() %>"  href="" class="delete btn btn-danger">Delete Beverage</a>
				
				</div>
			</div>			
		</div>
		<% } %>
      	
	
	</div>

	
	
	<script>
		$(document).ready(function() {
			$(".delete").click(function() {
				
				event.preventDefault();
				
				$.ajax({
					url: '/frontend/beverages?div_id=' + event.target.id,
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
