<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>

    <%@ include file="../include/static-head.jsp" %>

    <style>

        label {
            display: block;
        }
        .score-list > li {
            margin-bottom: 10px;
        }
        .score-list > li:first-child {
            font-size: 1.2em;
            color: blue;
            font-weight: 700;
            border-bottom: 1px solid skyblue;
        }

        .del-btn {
            width: 10px;
            height: 10px;
            background: red;
            color: #fff;
            border-radius: 5px;
            margin-left: 5px;
            text-decoration: none;
            font-size: 0.7em;
            padding: 6px;
        }
        .del-btn:hover{
            background: orangered;
        }

        section.score {
            padding: 200px 50px 100px;
            font-size: 1.5em;
        }

    </style>
    
</head>
<body>

    <div class="wrap">

        <!-- header -->
        <%@ include file="../include/header.jsp" %>
        <!-- //header -->

        <section class="score">
            <h1>시험 점수 등록</h1>
            <form action="/score/register" method="POST">
                <label>
                    # 이름: <input type="text" name="name">
                </label>
                <label>
                    # 국어: <input type="text" name="kor">
                </label>
                <label>
                    # 영어: <input type="text" name="eng">
                </label>
                <label>
                    # 수학: <input type="text" name="math">
                </label>
                <label>
                    <button type="submit">확인</button>
                    <button id="go-home" type="button">홈화면으로</button>
                </label>
            </form>

            <hr>

            <ul class="score-list">
                <li>총 학생 수 : ${scores.size()}명</li>
                <c:forEach var="s" items="${scores}">
                    <li>
                        # 학번 : ${s.stuNum}, 이름 : <a href="/score/detail?stuNum=${s.stuNum}">${s.markName}</a>, 국어 : ${s.kor}점,
                        영어 : ${s.eng}점, 수학 : ${s.math}점, 총점 : ${s.total}점,
                        평균 : ${s.average}점
                        <a href="/score/delete?stuNum=${s.stuNum}" class="del-btn">삭제</a>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <!-- footer-->
        <%@ include file="../include/footer.jsp" %>
        <!-- //footer-->

    </div>

    <script>
        const $ul = document.querySelector('.score-list');
        $ul.addEventListener('click', e => {
            if (!e.target.matches('a.del-btn')) return;
            e.preventDefault();
            console.log('클릭이벤트 발동!');
            if (confirm('정말로 삭제하시겠습니까?')) {
                // 삭제 진행
                location.href = e.target.getAttribute('href');
            } else {
                // 삭제 취소
                return;
            };
        });

        const $homeBtn = document.getElementById('go-home');
        $homeBtn.onclick = e => {
            location.href = '/';
        };

    </script>
</body>
</html>