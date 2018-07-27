<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/design/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<script>
	$(function() {
		$(".goDetail").on("click", function() {
			$("#posts_id").val($(this).data("posts_id"));
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<form id="frm" action="/postsDetail" method="get">
		<input type="hidden" name="posts_id" id="posts_id">
		<input type="hidden" name="board_id" id="board_id" value="${board_id }">
		<input type="hidden" name="board_title" id="board_title" value="${board_title }">
	</form>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board_title }</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>게시글번호</th>
										<th>제목</th>
										<th>작성자 아이디</th>
										<th>작성일시</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${postsList}" var="vo">
										<c:choose>
											<c:when test="${vo.posts_status == 'Y'}">
												<tr data-posts_id="${vo.posts_id }" class="goDetail">
													<td>${vo.posts_id}</td>
													<td>${vo.posts_title}</td>
													<td>${vo.std_id}</td>
													<td><fmt:formatDate value="${vo.posts_date}" pattern="yyyy-MM-dd" /></td>
												<tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="4">삭제된 게시글입니다.</td>
												<tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
						<a class="btn btn-default pull-right" href="/posts/postsWrite.jsp?board_title=${board_title }&board_id=${board_id }">새글쓰기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
