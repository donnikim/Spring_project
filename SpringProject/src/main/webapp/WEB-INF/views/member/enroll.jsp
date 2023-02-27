<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="bg-light">
	<div class="container">
		<main>
			<div class="py-5 text-center">
				<a href="${ contextPath }/home.do"><img class="d-block mx-auto mb-4" src="${ contextPath }/resources/image/spring.png" alt="" width="130"></a>
				<h2>회원 등록</h2>
			</div>

			<div style="margin-left: 350px; margin-right: 350px;">
				<form class="needs-validation" action="${ contextPath }/insertMember.me" method="POST">
					<div class="row g-3">
						<div class="col-12">
							<label for="id" class="form-label">아이디</label>
							<input type="text" class="form-control" id="id" name="id" required>
							<label id="idCheckResult">아이디를 확인 해주세요</label>
						</div>
						
						<div class="col-12">
							<label for="pwd" class="form-label">비밀번호</label>
							<input type="password" class="form-control" id="pwd" name="pwd" required>
						</div>
						
						<div class="col-12">
							<label for="pwdConfirm" class="form-label">비밀번호 확인</label>
							<input type="password" class="form-control" id="pwdConfirm" required>
						</div>
						
						<div class="col-12">
							<label for="name" class="form-label">이름</label>
							<input type="text" class="form-control" id="name" name="name" required>
						</div>
						
						<div class="col-12">
							<label for="nickName" class="form-label">닉네임</label>
							<input type="text" class="form-control" id="nickName" name="nickName" required>
							<label id="nickNameCheckResult">Please check your NickName.</label>
						</div>

						<div class="col-12">
							<label for="emailId" class="form-label">이메일</label>
							<div class="input-group">
								<input type="text" class="form-control" id="emailId" name="emailId">
								<span class="input-group-text">@</span>
								<select name="emailDomain" style="width: 280px;">
									<option>naver.com</option>
									<option>gmail.com</option>
									<option>nate.com</option>
									<option>hanmail.net</option>
								</select>
							</div>
						</div>
						
						<div class="col-12">
							<label class="form-label">성별</label><br>
							<input type="radio" id="man" name="gender" value="M" checked> 남자 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" id="woman" name="gender" value="F"> 여자
						</div>
						
						<div class="col-12">
							<label for="age" class="form-label">나이</label>
							<input type="number" class="form-control" id="age" name="age" min="0" max="100" value="0">
						</div>

						<div class="col-12">
							<label for="phone" class="form-label">연락처</label>
							<input type="text" class="form-control" id="phone" name="phone">
						</div>
						
						<div class="col-12">
							<label for="address" class="form-label">주소</label>
							<input type="text" class="form-control" id="address" name="address">
						</div>
						
						<br><br><br><br><br>
						
						<button class="w-100 btn btn-primary btn-lg">회원 가입</button>
					</div>
				</form>
			</div>
		</main>

		<footer class="my-5 pt-5 text-muted text-center text-small"></footer>
	</div>
	<script>
		
	
	
	
	</script>
	
	
</body>
</html>