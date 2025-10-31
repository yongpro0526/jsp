package com.coding404.myweb.test;

import com.coding404.myweb.command.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

    @Test
    public void test01(){
        new ProductVO();

        // 빌더패턴
        ProductVO vo = ProductVO.builder()
                .prodPrice(1000)
                .prodEnddate("2020-10-20")
                .prodWriter("테스트")
                .prodName("상품명")
                .build();
    }

}
