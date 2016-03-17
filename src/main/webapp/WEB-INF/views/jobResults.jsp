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

<%@ include file="webParts/coBar.jsp" %>


<h3 align="center"> Applicants Matched</h3>

<% if (((List<Result>)request.getAttribute("res")).size()!=0){ %>
<table class="hamsterTable" align="center">
<tr>
<th>Applicant Name</th><th>Job Title</th><th>Tech Score</th><th>Culture Score</th> <th>Overall Score</th><th>Availability</th>
</tr>
<%
List<Result> results = (List<Result>)request.getAttribute("res");
for(Result result:results){
%>
<tr>
<td><%= result.getName() %></td><td><%=result.getJobTitle() %></td><td><%=result.getTechScore()%>%</td><td><%=result.getCultureScore() %>%</td><td><%=result.getOveralScore() %></td><td><%=result.getUser().getUsername()%></td>
</tr>
<%
}
%>
</table>
<% } else{ %>
<section class="loginform cf">
<p align="center"> Post Jobs and create questions to see any Matches</p>
</section>

<% }%>


</body>
</html>
