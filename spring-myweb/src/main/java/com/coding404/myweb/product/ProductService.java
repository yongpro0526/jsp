package com.coding404.myweb.product;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    int prodRegist(ProductVO productVO); //  상품 등록
//    List<ProductVO> getList(String prodWriter); // 조회
    List<ProductVO> getList(String prodWriter, Criteria criteria);
    int getTotal(String prodWriter, Criteria criteria); // 내가 작성한 게시글 수
    ProductVO getDetail(long prodId); // 상세조회
    int prodUpdate(ProductVO productVO); // 상품 수정
    int prodDelete(long prodId); // 상품 삭제

    List<CategoryVO> getCategory(); // 1단 카테고리(대분류)
    List<CategoryVO> getCategoryChild(CategoryVO categoryVO); // 2단 카테고리(중분류)
}
