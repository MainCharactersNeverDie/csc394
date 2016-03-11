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

<%@ include file="webParts/anonBar.jsp" %>

	<section class="loginform cf">
		<form class="form-horizontal" name="login" action="register" method="POST" accept-charset="utf-8">
            <div class="form-group"> I am a...
                <input type="radio" name="test" value="person">Person
                <input type="radio" name="test" value="compony">Company
            </div>
            <div class="form-group">
                <label for="username">Email</label>
                <input class="form-control" type="email" name="username" placeholder="yourname@email.com" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" type="password" name="password" placeholder="password" required></div>
            <div class="form-group">
                <input class="btn btn-primary" type="submit" value="submit">
            </div>
        </form>
    </section>
</body>
</html>
