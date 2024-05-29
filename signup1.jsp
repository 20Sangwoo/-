<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	  <link rel="stylesheet" href="signup.css" >
</head>
<body>
	<img id="logo" src="./img/logo.png" class="content-image">
<div class="container">
    <h2>회원가입</h2>
    <form action="signupPro.jsp" method="post">
        <label for="username">닉네임</label>
        <input type="text" id="username" name="username" required>

        <label for="email">이메일</label>
        <input type="text" id="email" name="email" required>
    
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" required>

        <label for="pwd">비밀번호</label>
        <input type="password" id="pwd" name="password" required>


        <input type="submit" value="회원가입" >
    </form>
</div>
	
</body>
</html>