<!DOCTYPE html>
<html>
<head>
	<title>Registration2</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

<%@ include file="webParts/appBar.jsp" %>

	<section class="loginform cf">
		<form name="login" action="registerFinalize" method="POST" accept-charset="utf-8">
			<ul>
				<li>
					<label for="name">Name</label>
					<input type="string" name="name" placeholder="Company/Person" required>
				</li>
				<li>
					<label for="password">EID</label>
					<input type="password" name="ssn" placeholder="EID" required></li>
				<li>
					<label for="address">Address</label>
					<input type="address" name="address" placeholder="Address" required></li>
				<li>
					<label for="number">Phone Number</label>
					<input type="number" name="number" placeholder="xxx-xxx-xxxx" required></li>
				<li>
					<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>