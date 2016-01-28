<!DOCTYPE html>
<head>
	<title>Login/Sign Up Page</title>
	<link rel="stylesheet" href="css\normalize.css">
	<link rel="stylesheet" href="css\style.css">
</head>
<body>
<html lang="en">
<h1 align="center"> Welcome to Jobscam.ru! </h1>
	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="usermail">Email</label>
					<input type="email" name="usermail" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login">
				</li>
				<li>
					Don't have an account? Register today!
					<input type="submit" value="Register">
				</li>
			</ul>
		</form>
	</section>

</body>
</html>
