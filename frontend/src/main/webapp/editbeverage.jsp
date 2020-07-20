<%@ page  import = "de.uniba.dsg.dsam.model.dtos.beverageDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Beverage Store</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Beverage</h1>
		
		<p>&nbsp;</p>
		
		<%  beverageDTO div = (beverageDTO) request.getAttribute("div"); %>
		<form role="form" action="/frontend/beverages/editbeverage" method="post">
			<input type="hidden" name="div_id" value="<%= div.getId() %>">
			
			
			<input type="hidden" name="div_inc" value="<%= div.getIncentive()%>">
			
			
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Beverage Name</span>
					<input name="div_name" type="text" class="form-control" value="<%= div.getName() %>" required/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Beverage Price</span>
					<input name="div_price" type="number" class="form-control" value="<%= div.getPrice() %>" required/>
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Beverage Quantity</span>
					<input name="div_quantity" type="number" class="form-control" value="<%= div.getQuantity() %>" required/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Manufacturer</span>
					<input name="div_type" type="text" class="form-control" value="<%= div.getType() %>" required/>
				</div>
			</div>
						

			<a href="/frontend/beverages" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-success">Save</button>
		</form>					
		
	</div>
</body>
</html>