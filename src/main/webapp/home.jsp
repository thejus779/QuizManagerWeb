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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/vendor/animate/animate.css">

<link rel="stylesheet" type="text/css"
	href="assets/vendor/css-hamburgers/hamburgers.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/vendor/animsition/css/animsition.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/vendor/daterangepicker/daterangepicker.css">

<link rel="stylesheet" type="text/css" href="assets/css/util.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css">
<link rel="stylesheet" type="text/css" href="assets/css/table.css">
</head>

<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('assets/images/bg-01.jpg');">
			<div class="wrap-type100">
				<span class="login100-form-title"> Welcome to Quiz-Manager </span>


				<form class="login100-form validate-form flex-sb flex-w"
					method="POST" action="searchByString">
					<div id="addmore" class="wrap-input70 validate-input"
						data-validate="">
						
						<input class="left100" type="search" name="search_parameter"
							placeholder="Search..."> <span class="focus-input100"></span>
						
						<div class="right20 search">
						<button type="submit" name="search_button" value="search_button">
												<i class="fa fa-search"></i>
						</button>
	
						</div>
					</div>
				</form>

				<div class="container-table100">
					<div class="wrap-table100">
						<div class="table">

							<div class="row header">
								<div class="cell">Question</div>
								<div class="cell">View</div>
								<div class="cell">Edit</div>
								<div class="cell">Remove</div>
							</div>

							<c:forEach items="${test_attribute}" var="qs">

								<div class="row">

									<div class="cell" data-title="Question">${qs.question}</div>

									<div class="cell" data-title="View">
										<form method="POST" action="view">
											<input type="hidden" name="questionId" value="${qs.id} ">
											<input type="hidden" name="questionString"
												value="${qs.question}"> <input type="hidden"
												name="type" value="${qs.type}">
											<button type="submit" name="view_button" value="view_button">
												<i class="fa fa-eye"></i>
											</button>
										</form>
									</div>


									<div class="cell" data-title="Edit">
										<form method="POST" action="update">
											<input type="hidden" name="questionId" value="${qs.id} ">
											<input type="hidden" name="questionString"
												value="${qs.question}"> <input type="hidden"
												name="type" value="${qs.type}">
											<button type="submit" name="edit_button" value="edit_button">
												<i class="fa fa-edit"></i>
											</button>
										</form>

									</div>
									<div class="cell" data-title="Remove">
										<form method="POST" action="delete">
											<input type="hidden" name="questionId" value="${qs.id} ">
											<input type="hidden" name="questionString"
												value="${qs.question}"> <input type="hidden"
												name="type" value="${qs.type}">
											<button type="submit" name="delete_button"
												value="delete_button">
												<i class="fa fa-remove"></i>
											</button>
										</form>

									</div>
								</div>
								<%-- <li>${qs.question}&nbsp;&nbsp;<a
									href="delete-todo.do?todoToDel=${qs.type}"></a>
								</li> --%>
							</c:forEach>
						</div>
					</div>
				</div>

				<form class="login100-form validate-form flex-sb flex-w"
					action="createNew" method="GET">
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn"
							style="color: white;">Create A New Test</button>
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