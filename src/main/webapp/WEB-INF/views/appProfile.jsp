<!DOCTYPE html>
<%@ page import="main.java.testName.userService.UserDetails" %>

<html>
<head>
	<title>User Profile</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<center><img src="images\jobscam.png" ></center>

<%@ include file="webParts/appBar.jsp" %>

<aside style="float:left">
<div style="text-align:center">
<img src="images/boulder.png" height="42" width="42">
<img src="images/cascade.png" height="42" width="42">
<img src="images/thunder.png" height="42" width="42">
<img src="images/rainbow.png" height="42" width="42">
<img src="images/soul.png" height="42" width="42">
<img src="images/marsh.png" height="42" width="42">
<img src="images/volcano.png" height="42" width="42">
<img src="images/earth.png" height="42" width="42">
<br />
<img src="images/zephyr.png" height="42" width="42">
<img src="images/hive.png" height="42" width="42">
<img src="images/plain.png" height="42" width="42">
<img src="images/fog.png" height="42" width="42">
<img src="images/storm.png" height="42" width="42">
<img src="images/mineral.png" height="42" width="42">
<img src="images/glacier.png" height="42" width="42">
<img src="images/rising.png" height="42" width="42">
<br />
<img src="images/coal.png" height="42" width="42">
<img src="images/forest.png" height="42" width="42">
<img src="images/cobble.png" height="42" width="42">
<img src="images/fen.png" height="42" width="42">
<img src="images/relic.png" height="42" width="42">
<img src="images/mine.png" height="42" width="42">
<img src="images/ice.png" height="42" width="42">
<img src="images/beacon.png" height="42" width="42">


<div>
</aside>




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
