package com.example.basic.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.Buffer;

@Aspect // 이 클래스가 aop 공통 클래스로 사용하겠다는 뜻
@Component
public class LogAdvice {

    // 로그 팩토리 선언
    private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

    // 메서드 이전에 실행
//    @Before("execution(* com.example.basic.chap04.BookServiceImpl*.*(..))")
    public void beforeLog() {
        System.out.println("메서드 실행전에 동작함");
    }

    // 메서드 이후에 실행
//    @After("execution(* com.example.basic.chap04.BookServiceImpl*.*(..))")
    public void afterLog() {
        System.out.println("메서드 실행후에 동작함");
    }

    // 메서드에서 에러가 발생하면 동작됨
//    @AfterThrowing(pointcut = "execution(* com.example.basic.chap04.BookServiceImpl*.*(..))",
//                   throwing = "e")
    public void errorLog(Exception e) {

    }

    // Around - before, after, throwing을 한번에 처리
//    @Around("execution(* com.example.basic.chap04.BookServiceImpl*.*(..))")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 전
//        System.out.println("실행클래스" + joinPoint.getTarget());
//        System.out.println("싫행메서드" + joinPoint.getSignature().getName());
//        System.out.println("메서드매개변수" + joinPoint.getArgs());

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // 타겟 메서드의 실행함

        // 후
        long end = System.currentTimeMillis();

        log.info("실행소요시간" + (end - start) * 0.001);

        try {
            String path = "C:\\Users\\user\\Desktop\\course\\spring_log.txt";
            BufferedWriter bf = new BufferedWriter(new FileWriter(path, true));

            bf.write(joinPoint.getSignature().getName() + "\n");
            bf.write("실행 소요시간: " + (end - start) * 0.001 + "\n");
            bf.flush();
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result; // 메서드의 정상적인 흐름으로 다시 돌아감
    }
}

