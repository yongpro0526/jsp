package com.example.basic.chap04.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// @Controller
// @Service
// @Repository
@Component
public class Printer {

    // @AutoWired - IOC 컨테이너 안에 있는 적합한 Bean을 자동으로 주입
    //            - 타입으로 검색 -> 이름으로 검색
    //            - 필드, 생성자, 세터에 적용가능
    // @Resource, @Inject - 자바에서 제공하는 자동 주입명령 (java version 1.8 이상에서만 동작)

    // 1st - 멤버변수 주입
    private Document document;

    // 생성자
    @Autowired // 2nd - 생성자가 한개 라면 AutoWired 생략 가능
    public Printer(Document document) {
        this.document = document;
    }

    // getter
    public Document getDocument() {
        return document;
    }

    // 3rd - setter주입
    @Autowired
    public void setDocument(Document document) {
        this.document = document;
    }
}
