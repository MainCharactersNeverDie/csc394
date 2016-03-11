<!DOCTYPE html>
<html>
    <head>
        <title>Post Job</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <%@ include file="webParts/coBar.jsp" %>

        <h3 align="center"> Post a Job</h3>

        <section class="loginform cf">
            <form class="form-horizontal" name="login" action="postJob" method="POST" accept-charset="utf-8">
                <div class="form-group">
                    <label for="title">Job Title</label>
                    <input class="form-control"  type="title" name="title" placeholder="Job Title" required>
                </div>
                <div class="form-group">
                    <label for="desc">Brief Description</label>
                    <input class="form-control"  type="desc" name="desc" placeholder="Brief Description" required></div>
                <div class="form-group">
                    <label for="address">Location</label>
                    <input class="form-control"  type="address" name="address" placeholder="Address of Job Location" required></div>
                <div class="form-group">
                    <label for="culscore">Culture Score Needed</label>
                    <input class="form-control"  type="culscore" name="culscore" placeholder="Optimal Culture Score" required></div>
                <div class="form-group">
                    <label for="education">Education Level Needed</label>
                    <select class="form-control" name="ed">
                        <option value="undergrad">Undergrad</option>
                        <option value="graduate">Graduate</option>
                        <option value="no diploma">No Diploma</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="experience">Experience Level Needed</label>
                    <select class="form-control" name="exp">
                        <option value="no experience">No Experience</option>
                        <option value="novice">Novice</option>
                        <option value="Experienced">Experienced</option>
                    </select>
                </div><br />
                <div class="form-group">
                    <input class="btn btn-primary"  type="submit" value="Post Job">
                </div>
            </form>
        </section>
    </body>
</html>
