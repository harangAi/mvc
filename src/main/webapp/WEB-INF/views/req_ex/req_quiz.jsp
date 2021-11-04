<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
    <form action="/req/quiz" method="post">
        <div>
            <input type="text" name="userAccount" placeholder="계정명을 입력하세요">
        </div>
        <div>
            <input type="password" name="userPassword" placeholder="비밀번호를 입력하세요">
        </div>
        <button type="submit">로그인</button>
    </form>
</body>
</html>