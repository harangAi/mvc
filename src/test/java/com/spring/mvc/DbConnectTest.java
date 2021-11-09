package com.spring.mvc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Class.forName;

public class DbConnectTest {
    //DB 접속 정보 설정
    private String id = "hr";
    private String pw = "hr";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";

    @Test
    void connectTest() {
        try {
            //1. 드라이버 커넥터 공적 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2. 연결정보 생성
            Connection connection = DriverManager.getConnection(url, id, pw);

            System.out.println("DB 연결 성공! = " + connection);

            //3. sql실행하기
            String sql = "SELECT first_name, salary FROM employees";
            // preparedStatement sql실행객체
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                int salary = resultSet.getInt("salary");
                System.out.println("first_name = " + first_name + ", salary = " + salary);
            }


        } catch (Exception e) {
            System.out.println("DB 연결 실패!");
            e.printStackTrace();
        }
    }
}
