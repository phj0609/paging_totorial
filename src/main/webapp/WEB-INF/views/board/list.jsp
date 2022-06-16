<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="jumbotron">
		<div class="container">
			<h2>자유게시판</h2>
		</div>
	</div>
	<div class="container">
		<a href="register" class="btn btn-primary">글쓰기</a>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>수정일</th>
			</tr>
			<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.bno}</td>
				<td>
				<a href="${contextPath}/board/get?bno=${b.bno}">${b.title}</a>
				</td>
				<td>${b.writer}</td>
				<td>
					<fmt:parseDate var="regDate" value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일 HH시mm분ss초"/>
				</td>
				<td>
					<fmt:parseDate var="updateDate" value="${b.updateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일 HH시mm분ss초"/>
				</td>
			</tr>
			</c:forEach>
		</table>
		<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li class="page-item"><a class="page-link" href="?page=${pageMaker.startPage-1}">이전페이지</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="pageNum">
					<li class="page-item ${param.page == pageNum ? 'active':''}">
						<a href="?page=${pageNum}" class="page-link">${pageNum}</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next}">
					<li class="page-item"><a class="page-link" href="?page=${pageMaker.endPage+1}">다음페이지</a></li>
				</c:if>
				<br>
			</ul>
		</div>
<%@ include file="../layout/footer.jsp" %>