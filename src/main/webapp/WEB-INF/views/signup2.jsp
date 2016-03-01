<!DOCTYPE html>
<html>
<head>
	<title>Register2</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
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
						  <option value="nodiploma">No Diploma</option>
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