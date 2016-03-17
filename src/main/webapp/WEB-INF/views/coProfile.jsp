<!DOCTYPE html>
<%@ page import="main.java.testName.userService.UserDetails" %>

<html>
<head>
	<title>Company Profile Manager</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
    <%@ include file="webParts/coBar.jsp" %>
</head>
<body>



	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">

          <!-- Contact-->
          	  <% UserDetails ud= (UserDetails)request.getAttribute("userDetails");%>
          <div class="self" align="center">
            <h3 class="name"><%=ud.getName()%> <br />
            <ul>
              <li class="ad">Address- <%= ud.getAddress() %></li><br />
              <li class="mail">Email- <%=request.getAttribute("email") %></li><br />
              <li class="tel">Phone Number- <%=ud.getNumber()%></li><br />
            </ul>
          </div><br />
    </form>

</body>
</html>
