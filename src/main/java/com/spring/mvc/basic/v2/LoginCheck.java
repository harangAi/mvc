package com.spring.mvc.basic.v2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-check")
public class LoginCheck extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 아이디 패스워드 읽기
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        if (id.equals("banana")) {
            if (pw.equals("1234")) {
                // 로그인성공
                req.setAttribute("result","success");
            } else {
                // 비밀번호 틀림
                req.setAttribute("result","pwFail");
            }
        } else {
            // 아이디 없음
            req.setAttribute("result", "idFail");
        }
        // jsp 파일 열기
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/result.jsp");
        requestDispatcher.forward(req, resp);
    }
}
