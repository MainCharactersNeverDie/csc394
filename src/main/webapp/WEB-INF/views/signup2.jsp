<html>
<head>
	<title>Registration2</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>
	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="usermail">Name</label>
					<input type="email" name="usermail" placeholder="Company/Person" required>
				</li>
				<li>
					<label for="password">SSN/EID</label>
					<input type="password" name="password" placeholder="SSN/EID" required></li>
				<li>
					<label for="password">Address</label>
					<input type="password" name="password" placeholder="Address" required></li>
				<li>
					<label for="password">Phone Number</label>
					<input type="password" name="password" placeholder="xxx-xxx-xxxx" required></li>
				<li>
					<label for="password">Education Level</label>
					 <select>
						  <option value="undergrad">Undergrad</option>
						  <option value="graduate">Graduate</option>
						  <option value="no diploma">No Diploma</option>
					</select>
				</li>
				<li>
					<label for="password">Experience Level</label>
					 <select>
						  <option value="no experience">No Experience</option>
						  <option value="novice">Novice</option>
						  <option value="Experienced">Experienced</option>
					</select>
				</li>
				<li>
					<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>