<!DOCTYPE html>
<html>
	<head>
		<title>Login/Sign Up Page</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src='https://code.jquery.com/jquery-2.2.1.min.js'></script>
        <script src="js/jquery.growl.js" type="text/javascript"></script>
        <link href="css/jquery.growl.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/signIn.js"></script>
	</head>
	<body>

		
		<%@ include file="webParts/anonBar.jsp" %>



		<section class="loginform cf">
			<form name="login" id="form" action="j_spring_security_check" method="POST" accept-charset="utf-8">
				<ul>
					<li>
						<label for="usermail">Email</label>
						<input type="email" name="j_username" placeholder="yourname@email.com" required>
					</li>
					<li>
						<label for="password">Password</label>
						<input type="password" name="j_password" placeholder="password" required></li>
					<li>
						<input id='submit' type="submit" value="submit">
					</li><br></br>
				</ul>
			</form>
		</section>
	</body>
</html>
