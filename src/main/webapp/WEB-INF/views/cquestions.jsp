<!DOCTYPE html>
<html>
    <head>
        <title>Post Job</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

		<%@ include file="webParts/coBar.jsp" %>

        <h3 align="center"> Submit a Question</h3>

        <section class="loginform cf">
            <form name="login" action="createQuestions" method="post" accept-charset="utf-8">
                <ul class="questions">
                    <div>

                        <label for="question">Question</label>
                        <input type="question" name="question" placeholder="Question" required>

                    </div>
                    <div>
                        <label for="q1a">Answer 1 (correct)</label>
                        <input type="q1a" name="a1" id="a1" placeholder="option 1 (correct)" required>
                    </div>
                    <div>
                        <label for="q1b">Answer 2</label>
                        <input type="q1b" name="a2" id ="a2" placeholder="option 2 (wrong)" required>
                    </div>
                    <div>
                        <label for="q1c">Answer 3</label>
                        <input type="q1c" name="a3" id ="a3" placeholder="option 3 (wrong)">
                    </div>
                    <div>
                        <label for="q1d">Answer 4</label>
                        <input type="q1d" name="qa4" id="a4" placeholder="option 3 (wrong)">
                    </div>
                    <div>
                        <div class="type-div">
                            <label for="type" name="type" id="type">Which type?</label>
                            <select name="type" id="type">
                                <option value="culture" >Culture</option>
                                <option value="tech">Technical</option>
                            </select>

                        </div>
                        <div class="submit-div">
                            <input type="submit" value="Submit Question">
                        </div>
                    </div>
                </ul>
            </form>
        </section>
    </body>
</html>
