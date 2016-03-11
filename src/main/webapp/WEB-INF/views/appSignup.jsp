<!DOCTYPE html>
<html>
<head>
	<title>Registration2</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

<%@ include file="webParts/appBar.jsp" %>

	<section class="loginform cf">
		<form class="form-horizontal" name="login" action="registerFinalize" method="POST" accept-charset="utf-8">
            <div class="form-group">
					<label for="name">Name</label>
					<input id="name" class="form-control" type="string" name="name" placeholder="Company/Person" required>
				</div>
                <div class="form-group">
					<label for="password">SSN</label>
					<input id="password" class="form-control" type="password" name="ssn" placeholder="SSN" required></div>
                <div class="form-group">
					<label for="address">Address</label>
					<input id="address" class="form-control" type="address" name="address" placeholder="Address" required></div>
                <div class="form-group">
					<label for="number">Phone Number</label>
					<input id="number" class="form-control" type="number" name="number" placeholder="xxx-xxx-xxxx" required></div>
                <div class="form-group">
					<label for="password" name="edLevel">Education Level</label>
					 <select class="form-control">
						  <option value="undergrad" >Undergrad</option>
						  <option value="graduate">Graduate</option>
						  <option value="nodiploma">No Diploma</option>
					</select>
				</div>
                <div class="form-group">
					<label for="password" name="exLevel">Experience Level</label>
					 <select class="form-control">
						  <option value="no experience">No Experience</option>
						  <option value="novice">Novice</option>
						  <option value="Experienced">Experienced</option>
					</select>
				</div>
                <div class="form-group">
					<input class="btn btn-primary" type="submit" value="Submit">
				</div>
		</form>
	</section>
</body>
</html>
