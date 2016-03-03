<!DOCTYPE html>
<html>
<head>
	<title>Post Job</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<center><img src="images\jobscam.png" ></center>

<%@ include file="webParts/coBar.jsp" %>

<h3 align="center"> Post a Job</h3>

	<section class="loginform cf">
		<form name="login" action="postJob" method="POST" accept-charset="utf-8">
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
					 <select name="ed">
						  <option value="undergrad">Undergrad</option>
						  <option value="graduate">Graduate</option>
						  <option value="no diploma">No Diploma</option>
					</select>
				</li><br />
				<li>
					<label for="experience">Experience Level Needed</label>
					 <select name="exp">
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
