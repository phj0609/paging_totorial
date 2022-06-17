<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../layout/header.jsp" %>
<div class="jumbotron">
	<h2>게시글 작성</h2>
</div>
<div class="container">
	<form:form action="register" modelAttribute="board">
		제목 : <form:input type="text" path="title"/><br>
		<form:errors path="title" class="error" element="div"/><br>
		내용 : <br>
		<form:textarea rows="30" cols="50" path="content"/></textarea><br>
		작성자 : <form:input type="text" path="writer"/>
		<form:errors path="writer" class="error"/>
		<br>
		<button class="btn btn-primary">등록</button>
	</form:form>
</div>
</body>
<style>
.error {color : red;}
</style>
</html>