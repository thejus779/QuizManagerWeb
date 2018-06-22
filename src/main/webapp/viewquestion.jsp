<% 
//[ FRONT-END SAURABH ]%>

<%@page import="fr.epita.quiz.datamodel.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Question View</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="icon" type="image/png" href="assets/images/icons/favicon.ico" />

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
            <div class="wrap-type100">
                <form class="login100-form validate-form flex-sb flex-w" method="POST" action="">
                    <span class="login100-form-title">
						Question
					</span>



                    <div class="username">
                        <span class="txt3">
							Question
						</span>
                    </div>


                    <div class="wrap-input-display validate-input" data-validate="">
                        <textarea class="left50" > ${test_attribute_question.question}</textarea>
                        <span class="focus-input100"></span>

                    </div>

                    <div class="password1">
                        <span class="txt3">
							Answers
						</span>
                    </div>

                    <div class="wrap-input-display validate-input" data-validate="">
                        <p class="left50">${test_attribute_choices[0].choice}</p>
						<span class="focus-input100"></span>
                        <p class="right50">
                            ${test_attribute_choices[0].valid}
                        </p>
                    </div>

                    <div class="wrap-input-display validate-input" data-validate="">
                        <p class="left50">${test_attribute_choices[1].choice}</p>
                        <span class="focus-input100"></span>
                        <p class="right50">
                            ${test_attribute_choices[1].valid}
                        </p>
                    </div>

                    <div class="wrap-input-display validate-input" data-validate="">
                        <p class="left50">${test_attribute_choices[2].choice}</p>
                        <span class="focus-input100"></span>
                        <p class="right50">
                            ${test_attribute_choices[2].valid}
                        </p>

                    </div>
                    <div class="wrap-input-display validate-input" data-validate="">
                        <p class="left50">${test_attribute_choices[3].choice}</p>
                        <span class="focus-input100"></span>
                        <p class="right50">
                            ${test_attribute_choices[3].valid}
                        </p>

                    </div>
                    <div class="wrap-input-display validate-input" data-validate="">
                        <p class="left50">${test_attribute_choices[4].choice}</p>
                        <span class="focus-input100"></span>
                        <p class="right50">
                            ${test_attribute_choices[4].valid}
                        </p>

                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit">
                                Back
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

    </script>

</body>

</html>