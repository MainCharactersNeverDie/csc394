<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src='https://code.jquery.com/jquery-2.2.1.min.js'></script>
    <script src="js/jquery.growl.js" type="text/javascript"></script>
    <link href="css/jquery.growl.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/signIn.js"></script>
</head>
<body>
<center><img src="images\jobscam.png" ></center>

<%@ include file="webParts/anonBar.jsp" %>

	<section class="loginform cf">
		<form name="login" action="register" method="POST" accept-charset="utf-8">
			<ul>
				<li> I am a...
				<input type="radio" name="test" value="person">Person
				<input type="radio" name="test" value="compony">Company
				</li>
				<br></br>
				<li>
					<label for="username">Email</label>
					<input type="email" name="username" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
				<input type="submit" value="submit">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>
