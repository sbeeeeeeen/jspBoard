<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags" %>
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
 	function btn_click(index) {
 		if(index=="comsave"){
 			document.frm.division.value="insertcom";
 		}
 		if(index=="deletecom"){
 			document.frm.division.value="deletecom";
 		}
 		if(index=="postsEdit"){
 			document.frm.division.value="postsEdit";
			document.frm.action="/postsEdit";	
	 		document.frm.submit();
	 		return;
 		}
 		if(index=="postsDelete"){
 			document.frm.division.value="postsDelete";
 		}
 		if(index=="rePostWrite"){
 			document.frm.division.value="rePostWrite";
 		}
		document.frm.action="/postsComment";	
 		document.frm.submit();
 	}
</script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/common/left.jsp"%>
			<div class="container-fluid">
				<div class="row">
					<%@include file="/common/left.jsp"%>
					<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<form class="form-horizontal" name="frm" method="get">
							<input type="hidden" name="posts_id" value="${posts.posts_id }">
							<input type="hidden" name="division" value="">
							<input type="hidden" name="board_id" value="${param.board_id }">
							<input type="hidden" name="board_title" value="${param.board_title }">
							<h3>${param.board_title }</h3>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label class="control-label" >${posts.posts_title }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									${posts.posts_content }
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">작성자ID</label>
								<div class="col-sm-10">
									<label class="control-label" >${posts.std_id }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
									<c:if test="${posts!=null }">
										<c:forEach items="${fileList}" var="vo">
											<a href="/fileDownload?fileName=${vo.file_name }&un=${vo.file_upload_name}">${vo.file_upload_name}</a><br>
										</c:forEach>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">댓글</label>
								<div class="col-sm-10">
									<c:forEach items="${postCommentList }" var="vo">
										<c:choose>
											<c:when test="${vo.com_status=='Y' }">
												${vo.com_content }
												[${vo.std_id }/<fmt:formatDate value="${vo.com_date}" pattern="yyyy-MM-dd" />]
												<c:if test="${vo.std_id==std_id }">
												<input type="hidden" name="com_id" value="${vo.com_id }">
												<input type="button" class="btn btn-default" value="삭제" onClick='btn_click("deletecom");'>
												</c:if>
												<br>
											</c:when>
											<c:otherwise>
												삭제된 댓글입니다. <br>
											</c:otherwise>
										</c:choose>											
									</c:forEach>
									<input type="text" name="comContent">
									<input type="button" class="btn btn-default" value="댓글저장" onClick='btn_click("comsave");'>
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<c:if test="${posts.std_id==std_id }">
										<input type="button" class="btn btn-default" value="수정" onClick='btn_click("postsEdit");'>
										<input type="button" class="btn btn-default" value="삭제" onClick='btn_click("postsDelete");'>
									</c:if>
									<input type="button" class="btn btn-default" value="답글" onClick='btn_click("rePostWrite");'>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
