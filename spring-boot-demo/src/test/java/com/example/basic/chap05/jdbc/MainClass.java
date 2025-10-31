package com.example.basic.chap05.jdbc;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainClass {

    // 멤버객체를 얻을때 sqlSession객체를 사용함
//    @Autowired
//    SqlSession sqlSession;

    @Autowired
    TestMapper testMapper;

    @Test
    public void test01() {
//        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        System.out.println(testMapper.getTime());
    }
}
