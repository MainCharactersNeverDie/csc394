<!DOCTYPE html>
<html>
<head>
	<title>Registration2</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<center><img src="images\jobscam.png" ></center>

<%@ include file="webParts/appBar.jsp" %>

	<section class="loginform cf">
		<form name="login" action="registerFinalize" method="POST" accept-charset="utf-8">
			<ul>
				<li>
					<label for="name">Name</label>
					<input type="string" name="name" placeholder="Company/Person" required>
				</li>
				<li>
					<label for="password">SSN</label>
					<input type="password" name="ssn" placeholder="SSN" required></li>
				<li>
					<label for="address">Address</label>
					<input type="address" name="address" placeholder="Address" required></li>
				<li>
					<label for="number">Phone Number</label>
					<input type="number" name="number" placeholder="xxx-xxx-xxxx" required></li>
				<li>
					<label for="password" name="edLevel">Education Level</label>
					 <select>
						  <option value="undergrad" >Undergrad</option>
						  <option value="graduate">Graduate</option>
						  <option value="nodiploma">No Diploma</option>
					</select>
				</li>
				<li>
					<label for="password" name="exLevel">Experience Level</label>
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
