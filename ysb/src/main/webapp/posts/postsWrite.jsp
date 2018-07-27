<%@page import="ysb.posts.service.PostsService"%>
<%@page import="ysb.model.PostsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	function addBtn(){
		if(($("input:text[name='fileattachment']").length+$("input:file[name=uploadFile]").length)==5) {return;}
		$('#filesContainer').append(
			$('<input/>').attr('type', 'file').attr('name','uploadFile').attr('onclick','addBtn()')
		);
	}
	
	$(function() {
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
					$("#frm1").submit();
			}
		})
	});
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
						<form class="form-horizontal" id="frm1" method="post" action="/postsUpdate" enctype='multipart/form-data'>
							<input type="hidden" name="division" value="<c:if test="${posts==null||division=='re' }">new</c:if>">
							<input type="hidden" name="board_id" id="board_id" value="${param.board_id }">
							<input type="hidden" name="board_title" id="board_title" value="${param.board_title }">	
							<c:if test="${posts!=null }">
								<input type="hidden" name="posts_id" value="${posts.posts_id }">
								<input type="hidden" name="posts_pno" value="${posts.posts_id }">
								<input type="hidden" name="posts_gno" value="${posts.posts_gno }">
							</c:if>
							<h3>${param.board_title }</h3>
							<div class="form-group">
								<div class="col-sm-50">
								<label for="posts_title">제목  </label>
									<input type="text" class="col-sm-100" name="posts_title" value='<c:if test="${posts!=null && division != 're'}">${posts.posts_title }</c:if>'>
								</div>
							</div>
							<div class="form-group">
								<%@include file="/SE2/index.jsp"%>
							</div>
							<div class="form-group">
								<label for="fileattach" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10" id="filesContainer">
									<c:if test="${posts!=null }">
										<c:forEach items="${fileList}" var="vo">
											<input type="text" name="fileattachment" value="${vo.file_upload_name }" readonly><br>
										</c:forEach>
									</c:if>
									<input type="file" name="uploadFile">
								</div>
								<hr>
								<input type="button" value="첨부파일 추가" onclick="addBtn()">
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="button" id="savebutton" value="저장">
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
