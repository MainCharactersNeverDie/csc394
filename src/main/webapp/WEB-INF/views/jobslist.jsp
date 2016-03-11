<!DOCTYPE html>

<%@ page import="main.java.testName.jobs.Job" %>
<%@ page import="java.util.List" %>

<html>
<head>
	<title>List of Jobs</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

<%@ include file="webParts/coBar.jsp" %>

<h3 align="center"> List of Jobs You've Made</h3>

<table class="hamsterTable" id="hamsterTable" align="center">
<tr>
<th data-tsorter="input-text">Job Title</th>
<th data-tsorter="input-text">Brief Description</th>
</tr>

<%
int i=0;
List<Job> results = (List<Job>)request.getAttribute("jobs");
for(Job j:results){
%>
<tr>
<td><a href="createQuestions?jobNum=<%= i++%>"><%= j.getTitle() %></a></td>
<td><%= j.getDiscription() %></td>
</tr>

<%
}
%>

</table>
</section>
</body>
</html>