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
		<h1>New Incentive</h1>

		<p>&nbsp;</p>
		
		<form role="form" action="/frontend/incentiveservlet" method="post">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Name</span>
					<input name="div_name" type="text" class="form-control" required/>
				</div>
			</div>
			
			Type: <p>&nbsp;</p>
			
			 <input type="radio" value="PromotionalGiftEntity" name="div_type" checked>PromotionalGiftEntity
			 <input type="radio" value="TrialPackageEntity" name="div_type">TrialPackageEntity

			
          <br>

	
			<a href="/frontend/incentiveservlet" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-success">Save</button>
		</form>					
		
	</div>
</body>
</html>