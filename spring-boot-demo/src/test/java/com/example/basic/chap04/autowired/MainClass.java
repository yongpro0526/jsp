package com.example.basic.chap04.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class MainClass {

    // IOC 컨테이너
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

    @Test
    public void test01() {

        applicationContext.scan("com.example.basic.chap04.autowired"); // 이 패키지(폴더)를 읽을라는 뜻
        applicationContext.refresh();

        String[] arr = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(arr)); // printer와 document가 있는지 확인
    }

    // AutoWired 확인하기
    @Autowired
    ApplicationContext context;

    @Autowired
    Printer printer;

    @Test
    public void test02() {
        Document doc = printer.getDocument();
        System.out.println(doc.data);
    }
}
