package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/productList")
    public String productList(){
        return "product/productList";
    }

    @GetMapping("/productReg")
    public String product(){
        return "product/productReg";
    }

    @GetMapping("/productDetail")
    public String productDetail(){
        return "product/productDetail";
    }

    // 상품 등록
    @PostMapping("/prodRegist")
    public String prodRegist(ProductVO productVO) {

        productService.prodRegist(productVO);

        return "redirect:/product/productList";
    }
}
