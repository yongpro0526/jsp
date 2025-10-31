package com.example.basic.chap04.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainClass {

    /*
    TODO
    1. IBattery 인터페이스를 구현하는 Battery01 클래스를 작성.
    2. MainClass에서 IBattery 타입의 멤버변수 선언하고, Battery01 객체를 주입해서 Test메서드에서 정상적으로 동작하는지 확인.
    */

//    @Autowired
//    @Qualifier("y") // 연결할 빈 이름
//    private IBattery battery;

    private IBattery battery;
    @Autowired
    public MainClass(@Qualifier("y") IBattery battery) {
        this.battery = battery;
    }

    @Test
    public void test() {
        System.out.println(battery.getInfo());
    }
}
