<!DOCTYPE html>
<%@ page import="main.java.testName.userService.UserDetails" %>

<html>
	<head>
		<title>User Profile</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="css/style.css">
        <%@ include file="webParts/appBar.jsp" %>
        <script type="text/javascript" >
		$(document).ready(function(){
    var first = true;
   
    <%= "var badges ="+request.getAttribute("badges")%>
   //var badges=['images/boulder.png', 'images/cascade.png', 'images/thunder.png', 'images/rainbow.png', 'images/soul.png', 'images/marsh.png', 'images/volcano.png', 'images/earth.png', "images/zephyr.png", "images/hive.png", "images/plain.png", "images/fog.png"];
    var el      = "";
    for(var i = 0;  i < badges.length; ++i)
    {
        var badge   = badges[i];
        console.log(badge);

        var row     = i%8;
        var segment = i%4;

        if(row == 0){
            if(!first){
                el += "</diV>";
                el += "</diV>";
            }else{
                first = false;
            }
            el += "<div class='badge-row row' style='text-align:center'>";
        }

        if(segment == 0){
            if(row != 0)
                el += "</diV>";
            el += "<div class='col-xs-12 col-md-12 col-lg-6 badge-div'>";
        }

        el += "<img src="+badge+" height='42' width='42'>";

        $('#badges').html(el);

    }
});

		</script>
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
