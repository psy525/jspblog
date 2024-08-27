<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영메인</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="css/signMain.css">
</head>
<body class="body">

	<!-- 시작 문구 -->
	<section class="form-container">
		<span id="arrowClick" class="form-container__arrow"><i
			class="fa fa-arrow-circle-left" aria-hidden="true"></i></span>
		<div class="overlay"></div>
		<div class="choose-form">
			<div class="title">
				<h1 class="title__h1">
					환영합니다<br>아마도 블로그입니다.
				</h1>
			</div>
			<div class="buttons">
				<a id="signUp" class="buttons__signup" href="/blog/sign">Sign up</a> <a
					id="login" class="buttons__signup buttons__signup--login" href="/blog/login">Login</a>
			</div>
		</div>
	</section>
</body>
</html>