<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set value="${ pageContext.servletContext.contextPath }" var="contextPath" scope="application"/>
	<nav class="navbar navbar-expand navbar-dark bg-dark" aria-label="Second navbar example">
		<div class="container-fluid">
			<a class="navbar-brand" href="${ contextPath }">Spring project</a>
			<div class="collapse navbar-collapse" id="navbarsExample02">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="${ contextPath }">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Board</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Photo</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>