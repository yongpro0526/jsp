package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int prodRegist(ProductVO productVO);

}
