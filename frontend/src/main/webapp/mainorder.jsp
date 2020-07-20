<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ page  import = "de.uniba.dsg.dsam.model.dtos.customerOrderDTO" %>
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
		
		<p><a href="/frontend/orderservlet/neworder" class="btn btn-primary">Create Order</a></p>
	 
		<div class="row">
			<div class="col-md-3"><h3>Total Beverages Sold</h3></div>
			<div class="col-md-3"><h3>ID for Beverage</h3></div>
				
		</div>
		 
		
      	<%  
		List<customerOrderDTO> orders = (List<customerOrderDTO>)request.getAttribute("OrdersList");
		
		for(customerOrderDTO div: orders) { 
			
		%>
		<div class="row">
			<div class="col-md-3"><h4><%= div.getTotalbeverages() %></h4></div>
			<div class="col-md-3"><h4><%= div.getBvgfk() %></h4></div>
			
			</div>			
		
		<% } %>
		

      	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>
