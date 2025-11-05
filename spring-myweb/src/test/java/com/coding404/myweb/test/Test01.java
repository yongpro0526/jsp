package com.coding404.myweb.test;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

    @Autowired
    ProductMapper productMapper;

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

//    @Test
//    public void test02() {
//        for (int i = 1; i <= 100; i++) {
//            ProductVO vo = ProductVO.builder().
//                    prodName("admin" + i).
//                    prodWriter("abc123").
//                    prodPrice(1000 * i).
//                    prodCount(100 * i).
//                    prodDiscount(i).
//                    prodComment("admin" + i).
//                    prodContent("admin" + i).
//                    build();
//            productMapper.prodRegist(vo);
//        }
//    }
}
