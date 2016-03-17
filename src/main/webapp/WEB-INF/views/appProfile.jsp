<!DOCTYPE html>
<%@ page import="main.java.testName.userService.UserDetails" %>

<html>
    <%@ include file="webParts/appBar.jsp" %>
	<head>
		<title>User Profile</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src='js/profile.js'></script>
	</head>
	<body>

		<div id="badges" class="badge-row row" style="float:left">
		</div>

	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
		          <!-- Image 
		          <center><img class="portrait" src="image.jpg" alt="John Smith"/></center>
         End Image -->
          <!-- Contact-->
		  <% UserDetails ud= (UserDetails)request.getAttribute("userDetails");%>
          <div class="self" align="center">
            <h3 class="name"><%=ud.getName()%> <br />
            <ul>
              <li class="ad">Address - <%= ud.getAddress() %></li><br />
              <li class="mail">Email - <%=request.getAttribute("email") %></li><br />
              <li class="tel">Phone Number- <%=ud.getNumber()%></li><br />
            </ul>
          </div><br />
          
    </form>

</body>
</html>
