<!DOCTYPE html>
<%@ page import="java.util.List" %>
<html>
<head>
	<title>Tech Quiz</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 align="center"> Welcome to Jobscam.ru! </h1>

<%@ include file="webParts/appBar.jsp" %>

<h3 align="center"> Get To Know Me! </h3>
	<section class="loginform cf">
		<form name="question" action="question" method="get" accept-charset="utf-8">
			<%  int i=0;
				for(String s:(List<String>)request.getAttribute("answerList")) { i++; if(i==1){%>
					<%=s%>
				<%continue;}%>
					<div>
						<input type="radio" name="answer" id="answer" value="<%= i-2 %>" /> <%= s %>
					</div>
				<% } %>
			<br>

			<li> 
				<input type="submit" value="Submit">
			</li>

		</form>
	</section>
</body>
</html>