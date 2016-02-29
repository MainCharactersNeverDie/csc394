<!DOCTYPE html>
<html>
<head>
	<title>Post Job</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

<h4 align="center">
<a href="index.html" class="button-link">Home</a>
<a href="register.html" class="button-link">Register 1</a>
<a href="register2.html" class="button-link">Register 2</a>
<a href="profileUser.html" class="button-link">User Profile</a>
<a href="profileComp.html" class="button-link">Company Profile</a>
<a href="culturequiz.html" class="button-link">Culture Quiz</a>
<a href="techquiz.html" class="button-link">Tech Quiz</a>
<a href="postJobs.html" class="button-link">Post a Job</a>
<a href="viewEmployee.html" class="button-link">View Matched Employees</a>
</h4>

<h3 align="center"> Post a Job</h3>

	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="title">Job Title</label>
					<input type="title" name="title" placeholder="Job Title" required>
				</li>
				<li>
					<label for="desc">Brief Description</label>
					<input type="desc" name="desc" placeholder="Brief Description" required></li>
				<li>
					<label for="address">Location</label>
					<input type="address" name="address" placeholder="Address of Job Location" required></li>
				<li>
					<label for="culscore">Culture Score Needed</label>
					<input type="culscore" name="culscore" placeholder="Optimal Culture Score" required></li>
				<li>
					<label for="education">Education Level Needed</label>
					 <select>
						  <option value="undergrad">Undergrad</option>
						  <option value="graduate">Graduate</option>
						  <option value="no diploma">No Diploma</option>
					</select>
				</li><br />
				<li>
					<label for="experience">Experience Level Needed</label>
					 <select>
						  <option value="no experience">No Experience</option>
						  <option value="novice">Novice</option>
						  <option value="Experienced">Experienced</option>
					</select>
				</li><br />
				<li>
					<input type="submit" value="Post Job">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>