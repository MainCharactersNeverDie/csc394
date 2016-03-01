<!DOCTYPE html>
<html>
<head>
	<title>Tech Quiz</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

<%@ include file="webParts/appBar.jsp" %>

<h3 align="center"> Tech Quiz </h3>
	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
 Question 1
    <div>
        <input type="radio" name="question-1-answers" id="question-1-answers-A" value="A" /> Option 1
    </div>

    <div>
        <input type="radio" name="question-1-answers" id="question-1-answers-B" value="B" /> Option 2
    </div>

    <div>
        <input type="radio" name="question-1-answers" id="question-1-answers-C" value="C" /> Option 3
    </div>
    <div>
        <input type="radio" name="question-1-answers" id="question-1-answers-D" value="D" /> Option 4
    </div>
 <br>

 Question 2
     <div>
         <input type="radio" name="question-2-answers" id="question-2-answers-A" value="A" /> Option 1
     </div>

     <div>
         <input type="radio" name="question-2-answers" id="question-2-answers-B" value="B" /> Option 2
     </div>

     <div>
         <input type="radio" name="question-2-answers" id="question-2-answers-C" value="C" /> Option 3
     </div>
     <div>
         <input type="radio" name="question-2-answers" id="question-2-answers-D" value="D" /> Option 4
    </div>
<br>

 Question 3
     <div>
         <input type="radio" name="question-3-answers" id="question-3-answers-A" value="A" /> Option 1
     </div>

     <div>
         <input type="radio" name="question-3-answers" id="question-3-answers-B" value="B" /> Option 2
     </div>

     <div>
         <input type="radio" name="question-3-answers" id="question-3-answers-C" value="C" /> Option 3
     </div>
     <div>
         <input type="radio" name="question-3-answers" id="question-3-answers-D" value="D" /> Option 4
    </div>


				<li> <br><br><br><br><br>
					<input type="submit" value="Submit">
				</li>

		</form>
	</section>
</body>
</html>