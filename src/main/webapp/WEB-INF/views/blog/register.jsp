<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="/blog/register" method="post" enctype="multipart/form-data">
		<div>
			<label> 제목: <input type="text" name="title">
			</label>
		</div>
		<div>
			<label> 내용: <textarea rows="4" , cols="30" name="content"></textarea>
			</label>
		</div>
		<div>
			<label> 작성자: <input type="text" name="writer" value="${sessionScope.user.userId}"  readonly="readonly">
			</label>
		</div>
		<div>	
			<label>첨부파일:
				<input type="file"  name="files"  multiple="multiple">
			</label>
		</div>
		<div>
			<button>등록</button>
		</div>
	</form>

</body>
</html>