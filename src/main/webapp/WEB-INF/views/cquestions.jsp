<!DOCTYPE html>
<html>
<head>
	<title>Post Job</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>


<h3 align="center"> Submit a Question</h3>

	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul class="questions">
			<div style="text-align:center">

					<label for="question">Question</label>
					<input type="question" width="3000px" name="qHead" placeholder="Question" required>

			</div>
			<div style="text-align:center">
					<label for="q1a">Answer 1 (correct)</label>
					<input type="q1a" name="q1" id="q1a" placeholder="option 1 (correct)" required>
			</div>
			<div style="text-align:center">
					<label for="q1b">Answer 2</label>
					<input type="q1b" name="q1" id ="q1b" placeholder="option 2 (wrong)" required>
			</div>
			<div style="text-align:center">
					<label for="q1c">Answer 3</label>
					<input type="q1c" name="q1" id ="q1c" placeholder="option 3 (wrong)">
			</div>
			<div style="text-align:center">
					<label for="q1d">Answer 4</label>
					<input type="q1d" name="q1" id="q1d" placeholder="option 3 (wrong)">
			</div>
			<div style="text-align:center">
					<label for="type">Which type?</label>
					 <select>
						  <option value="culture">Culture</option>
						  <option value="tech">Technical</option>
					</select>

			</div>
			<div style="text-align:center">
					<input type="submit" value="Submit Question">
			</div>
			</ul>
		</form>
	</section>
</body>
</html>