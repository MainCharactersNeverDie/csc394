<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

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