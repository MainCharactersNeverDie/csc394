<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>
	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul>
				<li> I am a...
				<input type="radio">Person
				<input type="radio">Company
				</li>
				<br></br>
				<li>
					<label for="usermail">Email</label>
					<input type="email" name="usermail" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
				<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>