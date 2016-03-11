<!DOCTYPE html>
<%@ page import="main.java.testName.userService.UserDetails" %>

<html>
	<head>
		<title>User Profile</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script type="text/javascript" src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
	</head>
	<body>
<%@ include file="webParts/appBar.jsp" %>

		<div class="row" style="float:left">
			<div class="row"style="text-align:center">
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/boulder.png" height="42" width="42">
					<img src="images/cascade.png" height="42" width="42">
					<img src="images/thunder.png" height="42" width="42">
					<img src="images/rainbow.png" height="42" width="42">
				</diV>
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/soul.png" height="42" width="42">
					<img src="images/marsh.png" height="42" width="42">
					<img src="images/volcano.png" height="42" width="42">
					<img src="images/earth.png" height="42" width="42">
				</div>
			</div>
			<div class="row"style="text-align:center">
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/zephyr.png" height="42" width="42">
					<img src="images/hive.png" height="42" width="42">
					<img src="images/plain.png" height="42" width="42">
					<img src="images/fog.png" height="42" width="42">
				</div>
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/storm.png" height="42" width="42">
					<img src="images/mineral.png" height="42" width="42">
					<img src="images/glacier.png" height="42" width="42">
					<img src="images/rising.png" height="42" width="42">
				</div>
			</div>
			<div class="row"style="text-align:center">
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/coal.png" height="42" width="42">
					<img src="images/forest.png" height="42" width="42">
					<img src="images/cobble.png" height="42" width="42">
					<img src="images/fen.png" height="42" width="42">
				</div>
				<div class="col-xs-12 col-md-6 badge-div">
					<img src="images/relic.png" height="42" width="42">
					<img src="images/mine.png" height="42" width="42">
					<img src="images/ice.png" height="42" width="42">
					<img src="images/beacon.png" height="42" width="42">
				</div>
			</div>
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
