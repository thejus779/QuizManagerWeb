<% 
//[ FRONT-END SAURABH ]%>

<%@page import="fr.epita.quiz.datamodel.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Question</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

    <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">

    <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">

    <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">

    <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">

    <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">

    <link rel="stylesheet" type="text/css" href="assets/css/util.css">
    <link rel="stylesheet" type="text/css" href="assets/css/main.css">

</head>

<body>

    <div class="limiter">
        <div class="container-login100" style="background-image: url('assets/images/bg-01.jpg');">
            <div class="wrap-login100">
                <form class="login100-form validate-form flex-sb flex-w" method="POST" id="myform" action ="updateQuestion">
                    <span class="login100-form-title">
						UPDATE STEP 1 OF 2
					</span>
                    <div class="username">
                        <span class="txt1">
							Question
						</span>
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Question must required">
                        <input class="input100" type="text" name="questionString" value = "${test_attribute_update_question.question}">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="password">
                        <span class="txt1">
							Select Type
						</span>
                    </div>
                    <input type="hidden" name="questionId" value="${test_attribute_update_question.id} ">
                    <div class="wrap-type100 validate-input">
                        <select class="input100" id="tp" name="type">
                            <option>${test_attribute_update_question.type}</option>
                            <option>OPEN</option>
                            <option>MCQ</option>
                            <option>ASSOCIATIVE</option>
                            </select>
                        <span class="focus-input100"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit">
							Next
						</button>
                    </div>


                </form>
            </div>
        </div>
    </div>


        <div id="dropDownSelect1"></div>

    <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>

    <script src="assets/vendor/animsition/js/animsition.min.js"></script>

    <script src="assets/vendor/bootstrap/js/popper.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>

    <script src="assets/vendor/select2/select2.min.js"></script>

    <script src="assets/vendor/daterangepicker/moment.min.js"></script>
    <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>

    <script src="assets/vendor/countdowntime/countdowntime.js"></script>

    <script src="assets/js/main.js"></script>


</body>

</html>