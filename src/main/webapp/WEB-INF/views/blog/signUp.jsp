<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="css/signUp.css">
</head>
<body class="body">

	<!-- 시작 문구 -->
	<section class="form-container">
		<!-- Register Form -->
		<div class="login-form--register">
			<div class="form-wrapper">
				<form action="/blog/sign" method="post">
					<label class="form-wrapper__label" for="signup-userId" >Id</label> 
					<input id="signup-userId" class="form-wrapper__input" type="text" placeholder="닉네임으로 사용할 아이디를 입력해주세요." name="userId"  value="${sign.userId}" required  >
					<label class="form-wrapper__label" for="signup-password" >Password</label>
					<input id="signup-password" class="form-wrapper__input"
						type="password" placeholder="Password" name="password"
						pattern=".{3,}"
						title="Password must contain at least 3 characters"   value="${sign.password }" required>
					<label class="form-wrapper__label" for="signup-username">Username</label>
					<input id="signup-username" class="form-wrapper__input" type="text"
						placeholder="Username" name="username" value="${sign.userName }"  required> 
					<label class="form-wrapper__label" for="signup-email">Email</label>
					<input
						id="signup-email" class="form-wrapper__input" type="email"
						placeholder="example@hotmail.com" name="email" value="${sign.email }"  required>
					<button id="signUpBtn"class="buttons__signup buttons__signup--sign-up-form" type="submit">Sign up</button>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" >
// 		document.getElementById("signup-userId").addEventListener("input", function(){
// 			const userId = encodeURIComponent(document.querySelector("#signup-userId").value);
// 			 fetch("/blog/sign", {
// 				 method:"POST",
// 				 headers: {
// 				            "Content-Type": "application/x-www-form-urlencode"
// 				 }, 
// 			 	body: `userId=\${userId}`
// 			}).then(response=>response.json())
// 			.then(data=>{
// 				if(data.idExists){
// 					alert("이미 존재하는 아이디 입니다")
// 				} else{
// 					// id 사용가능
// 				}
// 			});
// 		});
		
// 		document.getElementById("signup-email").addEventListener("input", function() {
// 			const email = encodeURIComponent(document.querySelector("#signup-email").value);
// 		    fetch("/blog/sign", {
// 		        method: "POST",
// 		        headers: {
// 		            "Content-Type": "application/x-www-form-urlencoded"
// 		        },
// 		        body: `email=\${email}`
// 		    })
// 		    .then(response => response.json())
// 		    .then(data => {
// 		        if (data.emailExists) {
// 		            alert("이미 등록된 메일입니다.");
// 		            // 여기에서 Sign up 버튼 비활성화 또는 경고 표시
// 		        } else {
// 		            // 이메일 사용 가능
// 		        }
// 		    });
// 		});
	</script>
</body>
</html>