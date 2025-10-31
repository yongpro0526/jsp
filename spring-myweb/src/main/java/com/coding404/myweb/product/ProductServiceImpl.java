package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int prodRegist(ProductVO productVO) {
        return productMapper.prodRegist(productVO);
    }

}
