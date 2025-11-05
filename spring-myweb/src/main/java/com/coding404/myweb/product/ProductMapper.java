package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    int prodRegist(ProductVO productVO); //  상품 등록
//    List<ProductVO> getList(String prodWriter); // 조회
    List<ProductVO> getList(@Param("prodWriter") String prodWriter,
                            @Param("criteria") Criteria criteria);
    int getTotal(@Param("prodWriter") String prodWriter,
                 @Param("criteria") Criteria criteria); // 내가 작성한 게시글 수
    ProductVO getDetail(long prodId); // 상세조회
    int prodUpdate(ProductVO productVO); // 상품 수정
    int prodDelete(long prodId); // 상품 삭제
}
