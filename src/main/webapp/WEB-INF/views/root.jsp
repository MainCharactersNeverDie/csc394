<!DOCTYPE html>
<html>
<head>
	<title>Login/Sign Up Page</title>
	<link rel="stylesheet" href="css\normalize.css">
	<link rel="stylesheet" href="css\style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>
	<section class="loginform cf">
		<form name="login" action="j_spring_security_check" method="POST" accept-charset="utf-8">
			<ul>
				<li>
					<label for="usermail">Email</label>
					<input type="email" name="j_username" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="j_password" placeholder="password" required></li>
				<li>
					<input name="submit" type="submit" value="submit">
				</li><br></br>
				<li>
					Don't have an account? Register today!
					<input type="submit" value="Register">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>