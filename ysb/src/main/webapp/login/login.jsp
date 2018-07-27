<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/bootstrap/css/signin.css" rel="stylesheet">
    <%@include file="/common/jquery.jsp" %>
    <script>
    	function getCookie(name){
    		var cookies = document.cookie;
			var cookieArr = cookies.split("; ");
			var cookieResult = "";    
			
			for(var i in cookieArr){
				var cookie = cookieArr[i];
				var cookieNameValue = cookie.split("=");
				
				var cookieName = cookieNameValue[0];
				var cookieValue = cookieNameValue[1];
				
				if(name == cookieName){
					cookieResult = cookieValue;
					break;
				}
			}
			return cookieResult;
    	}
    	
    	function setCookie(cookieName, cookieValue, expires){
    		var dt = new Date();
			dt.setDate(dt.getDate() + parseInt(expires));
			document.cookie = cookieName + "=" + cookieValue 
				+ "; path=/; expries=" + dt.toGMTString();
    	}
    	
    	function deleteCookie(cookieName){
    		setCookie(cookieName, "", -1);
    	}
    	
    	//문서 로딩 완료 후 실행
    	$(function(){
	    	if(getCookie("rememberMe")=="y"){
	    		//userId input에 userId cookie값을 설정
	    		$("#std_id").val(getCookie("std_id"));
				$("#rememberMe").attr("checked",true);	
				$("#rememberMe").val(getCookie("rememberMe"));
	    	}
	    	
	    	//rememberMe 체크박스 클릭 이벤트
	    	$("#rememberMe").on("click",function(){
	    		if($(this).is(":checked")){
	    			//rememberMe cookie 설정
	    			setCookie("rememberMe","y",30); //30일동안 유효하게
	    			setCookie("std_id", $("#std_id").val(), 30);
	    		}else{
	    			//쿠키 제거
	    			deleteCookie("rememberMe");
	    		}
	    	});
    	});
    </script>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<!--
		1.사용자가 로그인 화면을 접속한다(localhost:8180/login/login.jsp)
		2.사용자가 아이디, 비밀번호를 입력 후 Sign in 버튼을 클릭
		 -> Sign in버튼이 속한 form태그의 action속성에 설정된 url로 요청
		3.LoginServlet파라미터(userId, password)를 확인 후 고정된 값을 비교
		  같을 경우 response 객체의 writer 객체를 이용하여 화면에 "접속 성공", 틀릴 경우 "접속 실패" 메시지 출력
	 -->
    <div class="container">
      <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="std_id" class="sr-only">std_id</label>
        <input type="text" id="std_id" name="std_id" class="form-control" 
        placeholder="std_id" required autofocus value="${param.std_id}">
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberMe" name="rememberMe" value=""> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<!--     <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
  </body>
</html>
