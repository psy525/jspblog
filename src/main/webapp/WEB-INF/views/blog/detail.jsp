<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>게시글 상세</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="form-floating mb-3">
			<input type="text" name="no" id="boardId" value="${board.id }"
				class="form-control"> <label for="boardId"> 게시글 번호:
			</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" name="title" id="boardTitle"
				value="${board.title }" class="form-control"> <label
				for="boardTitle"> 제목: </label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" name="writer" id="boardWriter"
				value="${board.userId }" class="form-control"> <label
				for="boardWriter"> 작성자: </label>
		</div>
		<div class="form-floating mb-3">
			<textarea style="height: 100px" name="content" id="boardContent"
				class="form-control"> ${board.content }</textarea>
			<label for="boardContent"> 내용: </label>
		</div>

		<div>
			첨부파일:
			<div>
				<c:forEach items="${board.fileList }" var="file">
					<a href="/blog/filedownload?id=${file.id }">${file.originalName }</a>
				</c:forEach>
			</div>
		</div>
		<div>
			<a href="/blog/modify?id=${board.id}" class="btn btn-primary">수정</a>
			<a href="/blog/remove?id=${board.id}" class="btn btn-success">삭제</a>
		</div>
		</div>
		<br/>
		<div>
			<h4>Comments</h4>
		</div>
		<div>
			<form action="/blog/newcomment" method="post">
				<div>
					<div>
						<textarea name="comment" id="comment">
						</textarea>
						<label for="comment">댓글</label>
					</div>
					<span>
						<button type="button" id="registerBtn">등록</button>
					</span>
				</div>
				<input type="hidden" name="boardNo" id="boardNo" value="${board.id }">
				<input type="hidden" name="writer" id="writer" value="${sessionScope.user.userId }">
				
			</form>
		</div>
		<div id="commentList" >
			<c:forEach items="${board.commentList }" var="comment" varStatus="idx">
				<div>
					<div>
						<h5>${comment.content }</h5>
						<small>${comment.registerDate }</small>
					</div>
					<p>${comment.writer }</p>
					<div>
						<button name="commentUpdateBtn">수정</button>
						<button name="commentDeleteBtn" data-id="${comment.id }">삭제</button>
					</div>
				</div>
			</c:forEach>
		</div>
	<!-- 자바스크립트 위치 -->
	<script type="text/javascript">
		const registerBtn=document.querySelector("#registerBtn")
		const commentList=document.querySelector("#commentList")
		registerBtn.addEventListener("click", (e)=>{
			fetch("/blog/newcomment", {
				method: "POST",
				headers:{
					"Content-type" : "application/x-www-form-urlencoded"
				},
				body:`boardNo=\${document.querySelector("#boardNo").value}&comment=\${document.querySelector("#comment").value}&writer=\${document.querySelector("#writer").value}`
				})
				.then(response=>response.json())
				.then(data=>{
					commentList.innerHTML +=`<div>
					<div>
						<h5>${comment.content }</h5>
						<small>${comment.registerDate }</small>
					</div>
					<p>${comment.writer }</p>
					<div>
						<button name="commentUpdateBtn">수정</button>
						<button name="commentDeleteBtn" data-id="${comment.id }">삭제</button>
					</div>
				</div>`
				document.querySelector("#comment").value="";
				})
			})
			
			//댓글 수정 및 삭제
		const commentUpdateBtns= document.querySelectorAll("[name=commentUpdateBtn]");
		const commentDeleteBtns= document.querySelectorAll("[name=commentDeleteBtn]");
		commentUpdateBtns.forEach(item=> {
			item.addEventListener("click", (ev)=>{
				const parent = ev.target.parentElement.parentElement
				let content= parent.children[0].children[0].textContent
				parent.innerHTML=`
					<div >
						<div>
							<textarea name="comment" id="comment">\${content}</textarea>
						<label for="content">댓글</label>
						</div>
						<span>
							<button style="height: 80px" type="button" id="updateBtn">수정</button>
						</span>
						<span>
							<button style="height: 80px" type="button" id="cancleBtn">취소</button>
						</span>
					</div>`
					
			})
		});
		
		commentDeleteBtns.forEach(item=>{
			item.addEventListener("click", (ev)=>{
				console.log(ev.target.dataset.id);	
				fetch("/blog/comment/rem?id="+ev.target.dataset.id)
				.then(response=>response.json())
				.then(data=>{
					
					commentList.removeChild(ev.target.parentElement.parentElement)
				});
			});
		});
	</script>
</body>
</html>