<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        label {
            display: block;
        }
    </style>
</head>
<body>
    <% for (int i=0; i < 3; i++) { %>
        <h1>Hello JSP!!</h1>
    <% } %>

    <form action="/login.jsp" method="post">
        <label for="">
            # 아이디 : <input type="text" name="id">
        </label>
        <label for="">
            # 비밀번호 : <input type="password" name="pw">
        </label>
        <label for="">
            <button type="submit">로그인</button>
        </label>
    </form>
</body>
</html>