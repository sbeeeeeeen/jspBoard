<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main/main.jsp">Main</a></li>
		<li class="active"><a href="/board/createBoard.jsp">게시판 생성</a></li>
		<c:forEach items="${boardList }" var="board">
			<c:if test="${board.board_status == 'Y'}">
				<li><a href="/viewBoard?board_id=${board.board_id }&board_title=${board.board_title}">${board.board_title }</a></li>
			</c:if>
		</c:forEach>
	</ul>
</div>