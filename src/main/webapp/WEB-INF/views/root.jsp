<!DOCTYPE html>
<html>
<head>
	<title>Login/Sign Up Page</title>
	<link rel="stylesheet" href="css\normalize.css">
	<link rel="stylesheet" href="css\style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

<h4 align="center">
<a href="root.html" class="button-link">Home</a>
<a href="signup.html" class="button-link">Register 1</a>
<a href="signup2.html" class="button-link">Register 2</a>
<a href="profileUser.html" class="button-link">User Profile</a>
<a href="profileComp.html" class="button-link">Company Profile</a>
<a href="culturequiz.html" class="button-link">Culture Quiz</a>
<a href="techquiz.html" class="button-link">Tech Quiz</a>
<a href="postJobs.html" class="button-link">Post a Job</a>
<a href="viewResult.html" class="button-link">View Matched Employees</a>
</h4>


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