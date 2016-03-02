<!DOCTYPE html>
<html>
<head>
	<title>User Profile Manager</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1 align="center"> Welcome to Jobscam.ru! </h1>

<%@ include file="webParts/appBar.jsp" %>

	<section class="loginform cf">
		<form name="login" action="index_submit" method="get" accept-charset="utf-8">
		          <!-- Image 
		          <center><img class="portrait" src="image.jpg" alt="John Smith"/></center>
         End Image -->
          <!-- Contact-->
          <div class="self" align="center">
            <h3 class="name">John Smith <br />
              <span>Professional Hamster</span></h1>
            <ul>
              <li class="ad">- 111 Lorem Street, 34785, Ipsum City</li><br />
              <li class="mail">- hamsterface@hamsterbusiness.com</li><br />
              <li class="tel">- +11 444 555 22 33</li><br />
              <li class="web">- www.hamster.com</li> <br />
            </ul>
          </div><br />
          <!-- End Contact -->

          <!-- Culture -->
          <h3 class="culture" align="center">Culture<br /></h3>
          <div class="culture" align="center">
          <ul>
          <li> Hamster Culture 4 lyfe sonnnnn</li>
          </div> <br />
          <!-- End Culture -->
        </div>
        <!-- Begin 1st Row -->
        <div class="entry" align="center">
          <h3>Profile Information</h3>
          <p> hamster profile, i love eating seeds and crashing webpages with my sicc pix</p>
        </div><br />
        <!-- End 1st Row -->

        <!-- Begin 2nd Row -->
        <div class="entry" align="center">
          <h3>Education</h3>
          <div class="content">
            <h3>Sep 2005 - Feb 2007</h3>
            <p>Academy of Hamstery, London <br />
              <em>Master in Being Fluffy and Cute</em></p>
          </div>
          <div class="content" align="center">
            <h3>Sep 2001 - Jun 2005</h3>
            <p>University of Hamming &amp; Twitching, New York <br />
              <em>Bachelor of Science in Eating all the Seeds</em></p>
          </div>
        </div>
        <!-- End 2nd Row -->

        <!-- Begin 3rd Row -->
        <div class="entry"  align="center">
          <h3>Experience</h3>
          <div class="content">
            <h3>May 2009 - Feb 2010</h3>
            <p>Creative Hamster Agency, London <br />
              <em>Senior Hamster</em></p>
            <ul class="info">
              <li>brief info on hamster exp and leveling.</li> <br />
              <li>I am lvl32 and know flamethrower</li> <br />
            </ul>
          </div>
          <div class="content">
            <h3>Jun 2007 - May 2009</h3>
            <p>Junior Hamster <br />
              <em>Bachelor of Getting Mad Petting</em></p>
            <ul class="info">
              <li>moar hamster exp  </li> <br />
              <li>I am a fairy type, 10/10 would destory all dragon types again</li> <br />
            </ul>
          </div>
        </div>
        <!-- End 3rd Row -->
        <!-- Begin 4th Row -->
        <div class="entry"  align="center">
          <h3>Skills</h3>
          <div class="content">
            <h3>Software Knowledge</h3>
            <ul class="skills">
              <li>- Photoshop</li><br />
              <li>- Illustrator</li><br />
              <li>- InDesign</li><br />
              <li>- Flash</li><br />
              <li>- Fireworks</li><br />
              <li>- Dreamweaver</li><br />
              <li>- After Effects</li><br />
              <li>- Cinema 4D</li><br />
              <li>- Maya</li><br />
            </ul>
          </div>
          <div class="content">
            <h3>Languages</h3>
            <ul class="skills">
              <li>- CSS/XHTML</li><br />
              <li>- PHP</li><br />
              <li>- JavaScript</li><br />
              <li>- Ruby on Rails</li><br />
              <li>- ActionScript</li><br />
              <li>- C++</li><br />
            </ul>
          </div>
        </div>
        <!-- End 4th Row -->
         <!-- Begin 5th Row -->
        <div class="entry"  align="center">
        <h3>Misc</h3>
        	<ul class="works">
        		<li>more hamser stuff if needed idk</li>
        	</ul>
        </div>
      </div>
    </div><br />
    <!-- End Paper -->

    <input type="submit" value="Do not hire"> or <input type="submit" value="Hire">
    </form>

</body>
</html>