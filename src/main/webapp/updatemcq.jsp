<%@page import="fr.epita.quiz.datamodel.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <div class="wrap-type100">
                <form class="login100-form validate-form flex-sb flex-w" method="POST" action="mcqCreate">
                    <span class="login100-form-title">
						STEP 2 OF 2
					</span>


                    <div class="password">
                        <span class="txt3">
							Answer
						</span>
                    </div>


                    <div id="addmore" class="wrap-input validate-input" data-validate="">
                        <input class="left100" type="text" name="mcqOption" value="${mcq_update_attribute[0].choice}">
                        <span class="focus-input100"></span>

                        <select class="right100" name="valid">
                                Current:<option>${mcq_update_attribute[0].valid}</option>
                                <option>true</option>
                                <option>false</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                    <div id="addmore" class="wrap-input validate-input" data-validate="">
                        <input class="left100" type="text" name="mcqOption" value="${mcq_update_attribute[1].choice}">
                        <span class="focus-input100"></span>

                        <select class="right100" name="valid">
                                <option>${mcq_update_attribute[1].valid}</option>
                                <option>true</option>
                                <option>false</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                    <div id="addmore" class="wrap-input validate-input" data-validate="">
                        <input class="left100" type="text" name="mcqOption" value="${mcq_update_attribute[2].choice}">
                        <span class="focus-input100"></span>

                        <select class="right100" name="valid">
                                <option>${mcq_update_attribute[2].valid}</option>
                                <option>true</option>
                                <option>false</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                    <div id="addmore" class="wrap-input validate-input" data-validate="">
                        <input class="left100" type="text" name="mcqOption" value="${mcq_update_attribute[3].choice}">
                        <span class="focus-input100"></span>

                        <select class="right100" name="valid">
                                <option>${mcq_update_attribute[3].valid}</option>
                                <option>true</option>
                                <option>false</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                    <div id="addmore" class="wrap-input validate-input" data-validate="">
                        <input class="left100" type="text" name="mcqOption" value="${mcq_update_attribute[4].choice}">
                        <span class="focus-input100"></span>

                        <select class="right100" name="valid">
                                <option>${mcq_update_attribute[4].valid}</option>
                                <option>true</option>
                                <option>false</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit">
                                Done
                            </button>
                    </div>


                </form>
            </div>
        </div>
    </div>


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