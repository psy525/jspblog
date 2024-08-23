<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입/로그인</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" , href="/css/login.css">
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
				<a id="signUp" class="buttons__signup" href="#">Sign up</a> <a
					id="login" class="buttons__signup buttons__signup--login" href="#">Login</a>
			</div>
		</div>

		<!-- Login Form -->

		<div class="login-form">
			<div class="form-wrapper">
				<form action="/blog/login" method="post">
					<label class="form-wrapper__label" for="login-username">UserId</label>
					<input id="login-username" class="form-wrapper__input" type="text"
						placeholder="아이디를 입력하세요" name="username" required> <label
						class="form-wrapper__label" for="login-password">Password</label>
					<input id="login-password" class="form-wrapper__input"
						type="password" placeholder="비밀번호를 입력하세요" name="password"
						pattern=".{3,}"
						title="Password must contain at least 3 characters" required>
					<button class="buttons__signup buttons__signup--login-form"
						type="submit" href="#">Login</button>
				</form>
			</div>
		</div>

		<!-- Register Form -->

		<div class="login-form login-form--register">
			<div class="form-wrapper">
				<form  action="/blog/sing"  method="post">
					<label class="form-wrapper__label" for="signup-userId">Id</label> <input
						id="signup-email" class="form-wrapper__input" type="text"
						placeholder="닉네임으로 사용할 아이디를 입력해주세요." name="userId" required>
					<label class="form-wrapper__label" for="signup-password">Password</label>
					<input id="signup-password" class="form-wrapper__input"
						type="password" placeholder="Password" name="password"
						pattern=".{3,}"
						title="Password must contain at least 3 characters" required>
					<label class="form-wrapper__label" for="signup-username">Username</label>
					<input id="signup-username" class="form-wrapper__input" type="text"
						placeholder="Username" name="username" required> <label
						class="form-wrapper__label" for="signup-email">Email</label> <input
						id="signup-email" class="form-wrapper__input" type="email"
						placeholder="example@hotmail.com" name="email" required>

					<button class="buttons__signup buttons__signup--sign-up-form"
						type="submit">Sign up</button>
				</form>
			</div>
		</div>
	</section>

</body>
</html>