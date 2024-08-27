<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="css/login.css">
</head>
<body class="body">

    <section class="form-container">
      <div class="login-form--register"  style="margin-top:30px">
        <div class="form-wrapper">
          <form action="/blog/login" method="post">
            <label class="form-wrapper__label" for="login-userId">Id</label>
            <input id="login-userId" class="form-wrapper__input" type="text" placeholder="Username" name="userId"  value="${sign.userId}" required>
            <label class="form-wrapper__label" for="login-password">Password</label>
            <input id="login-password" class="form-wrapper__input" type="password" placeholder="Password" name="userPassword" pattern=".{3,}" title="Password must contain at least 3 characters"  value="${sign.password }" required>
            <input type="checkbox"  name="rememberMe" value="remember-me">아이디 저장
            <button class="buttons__signup buttons__signup--login-form" type="submit"  style="margin-top:200px;text-align: center">Login</button>
          </form>
        </div>
      </div>
    </section>  
</body>
</html>