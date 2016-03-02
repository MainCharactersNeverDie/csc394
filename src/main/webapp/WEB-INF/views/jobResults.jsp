<!DOCTYPE html>

<%@ page import="main.java.testName.alg.Result" %>
<%@ page import="main.java.testName.userService.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<title>Applicant matches</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1 align="center"> Welcome to Jobscam.ru! </h1>
<%@ include file="webParts/coBar.jsp" %>


<h3 align="center"> Applicants Matched</h3>
<table class="hamsterTable" align="center">
<tr>
<th>Applicant Name</th><th>Job Title</th><th>Tech Score</th><th>Culture Score</th> <th>Overall Score</th><th>Availability</th>
</tr>
<%
List<Result> results = (List<Result>)request.getAttribute("res");
for(Result result:results){
%>
<tr>
<td><%=result.getUser().getUsername()%></td><td><%=result.getJobTitle() %></td><td><%=result.getTechScore()%>%</td><td><%=result.getCultureScore() %>%</td><td><%=result.getOveralScore() %></td><td><input type="submit" value="Contact"></td>
</tr>
<%
}
%>
</table>

	</section>
</body>
</html>