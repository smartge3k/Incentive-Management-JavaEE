<%@ page  import = "de.uniba.dsg.dsam.model.dtos.incentiveDTO" %>
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
		<h1>Edit Division</h1>
		
		<p>&nbsp;</p>

		<%  incentiveDTO div = (incentiveDTO) request.getAttribute("div"); %>
		<form role="form" action="/frontend/incentiveservlet/editincentiveservlet" method="post">
			<input type="hidden" name="div_id" value="<%= div.getId() %>">
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Incentive Name</span>
					<input name="div_name" type="text" class="form-control" value="<%= div.getName() %>" required/>
				</div>
			</div>

			<a href="/frontend/incentiveservlet" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-success">Save</button>
		</form>					
		
	</div>
</body>
</html>