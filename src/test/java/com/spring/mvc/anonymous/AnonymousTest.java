package com.spring.mvc.anonymous;

import org.junit.jupiter.api.Test;

public class AnonymousTest {

    @Test
    void test1() {
        Car sonata = new Sonata();
        sonata.run();

        // 익명 클래스
        Car ferrari = new Car()  {
            @Override
            public void run() {
                System.out.println("페라리가 달립니다.");
            }
        };

        ferrari.run();

        Car avante = () -> System.out.println("아반테가 달립니다.");
        avante.run();

        Dealer pororo = new Dealer();
        pororo.getCar(ferrari);
        pororo.getCar(() -> System.out.println("투싼이 달립니다."));
    }


    @Test
    void test2() {

        Calculator sum = new Calculator() {

            @Override
            public double operate(int n1, int n2) {
                return n1 + n2;
            }
        };


        Calculator multi = new Calculator() {

            @Override
            public double operate(int n1, int n2) {
                return n1 * n2;
            }
        };


        Calculator sum2 = (n1, n2) -> n1 + n2;
        Calculator multi2 = (n1, n2) -> {
            System.out.println("테스트");
            return  n1 * n2;
        };

        System.out.println(sum2.operate(10,20));
        System.out.println(multi2.operate(10,20));



    }
}
