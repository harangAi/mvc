package com.spring.mvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCBasicCRUD {
    //DB 접속 정보 설정
    private String id = "spring4";
    private String pw = "1234";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    @DisplayName("product데이터를 추가해야 한다.")
    void insertTest() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, id, pw);
            String sql = "INSERT INTO product VALUES(seq_product.nextval, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"공기청정기");
            pstmt.setInt(2, 670000);
            //SQL 실행명령
            //1. INSERT, UPDATE, DELETE : executeUpdate()
            //2. SELECT : executeQuery()
            int resultNum = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴 1:true, 2:false
            if (resultNum == 1) {
                System.out.println("입력성공!");
            }
            Assertions.assertTrue(resultNum == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("product데이터를 수정해야 한다.")
    void updateTest() {
        try(Connection connection = DriverManager.getConnection(url, id, pw)) {
            Class.forName(driver);
            String sql = "UPDATE product SET product_name=?, product_price=? WHERE product_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"텔레비전_fix");
            pstmt.setInt(2, 2000000);
            pstmt.setInt(3, 2);
            //SQL 실행명령
            //1. INSERT, UPDATE, DELETE : executeUpdate()
            //2. SELECT : executeQuery()
            int resultNum = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴 1:true, 2:false
            if (resultNum == 1) {
                System.out.println("수정성공!");
            }
            Assertions.assertTrue(resultNum == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("product데이터를 삭제해야 한다.")
    void deleteTest() {
        try(Connection connection = DriverManager.getConnection(url, id, pw)) {
            Class.forName(driver);
            String sql = "DELETE FROM product WHERE product_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);
            //SQL 실행명령
            //1. INSERT, UPDATE, DELETE : executeUpdate()
            //2. SELECT : executeQuery()
            int resultNum = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴 1:true, 2:false
            if (resultNum == 1) {
                System.out.println("삭제성공!");
            }
            Assertions.assertTrue(resultNum == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
