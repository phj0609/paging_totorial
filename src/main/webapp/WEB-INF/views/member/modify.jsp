<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<form action="modify" method="post">
	<input type="hidden" name="id" value="${member.id}"><br>
	회원아이디 : ${member.id}<br>
	회원이름 : ${member.userName}"><br>
	이메일 : ${member.email}<br>
	비밀번호 : ${member.password}<br>
	<button>수정하기</button>
</form>
<%@ include file="../layout/footer.jsp" %> 