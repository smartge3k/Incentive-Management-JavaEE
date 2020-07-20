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
		<h1>New Beverage</h1>

		<p>&nbsp;</p>
		
		<form role="form"  action="/frontend/beverages" method="post"> <!--  it Will first call beverage dopost method which is resp. for adding new beverage -->
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Name</span>
					<input name="div_name" type="text" class="form-control" required/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Manufacturer</span>
					<input name="div_type" type="text" class="form-control" required/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Quantity</span>
					<input name="div_quantity" type="number" class="form-control" required/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Price</span>
					<input name="div_price" type="number" class="form-control" required/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Incentive</span>
					<input name="div_incentive" type="number" class="form-control"  />
				</div>
			</div>
			<a href="/frontend/beverages" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-success">Save</button>
		</form>					
		
	</div>
	

</body>
</html>
