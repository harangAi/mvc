package com.spring.mvc.score.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
public class Score {
    // 클라이언트에서 전달한 데이터
    private String name;
    private int kor, eng, math;

    // 자체 생성 데이터
    private int stuNum; // 학번
    private int total; // 총점
    private double average; // 평균
    private Grade grade; // 등급
    private String markName; // 마킹된 이름

    //누적되는 순차번호를 만들기 위함
    private static int seq;

    public Score() {
        System.out.println("스코어 객체 생성!!!");
        this.stuNum = ++seq;
    }

    public Score(String name, int kor, int eng, int math) {
        this();
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calcTotal();
    }

    public Score(ResultSet resultSet) throws SQLException {
        this.stuNum = resultSet.getInt("stu_num");
        this.name = resultSet.getString("stu_name");
        this.kor = resultSet.getInt("kor");
        this.eng = resultSet.getInt("eng");
        this.math = resultSet.getInt("math");
        this.total = resultSet.getInt("total");
        this.average = resultSet.getDouble("average");
    }

    // 총점 평균을 구해주는 메서드
    public void calcTotal() {
        this.total = kor + eng + math;
        this.average = Math.round((total / 3.0) * 100) / 100.0;
    }
}
