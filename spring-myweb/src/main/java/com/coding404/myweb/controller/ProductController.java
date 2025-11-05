package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.ListResourceBundle;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/productList")
    public String productList(Criteria criteria, Model model) {
        String prodWriter = "abc123"; // 본인의 아이디라고 가정
//        List<ProductVO> prodList = productService.getList(prodWriter); // 조회
        List<ProductVO> prodList = productService.getList(prodWriter, criteria);
        int total = productService.getTotal(prodWriter, criteria); // 전체 게시글 수.
        PageVO pageVO = new PageVO(criteria, total);

        model.addAttribute("prodList", prodList); // 모델에 저장
        model.addAttribute("pageVO", pageVO);

        return "product/productList";
    }

    @GetMapping("/productReg")
    public String product(){
        return "product/productReg";
    }

    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") long prodId, Model model){
        ProductVO vo =  productService.getDetail(prodId);
        model.addAttribute("vo", vo);
        return "product/productDetail";
    }

    // 상품 등록
    @PostMapping("/prodRegist")
    public String prodRegist(ProductVO productVO,
                             RedirectAttributes ra) {

        int result = productService.prodRegist(productVO); // 성공 시 1, 실패 시 0
        if (result == 1) {
            ra.addFlashAttribute("msg", "상품이 정상등록 되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "상품 등록에 실패하였습니다. 관리자에게 문의해주세요.");
        }
        return "redirect:/product/productList";
    }

    // 상품 수정
    @PostMapping("/productUpdate")
    public String prodUpdate(ProductVO vo, RedirectAttributes ra) {
        int result = productService.prodUpdate(vo); // 성공시 1, 실패시 0
        if (result == 1) {
            ra.addFlashAttribute("msg", "수정되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "수정되지 않았습니다. 관리자에게 문의해주세요.");
        }
        return "redirect:/product/productDetail?prodId=" + vo.getProdId(); // 수정 이후에 다시 상세 화면
    }

    // 상품 삭제
    @PostMapping("/productDelete")
    public String prodDelete(@RequestParam("prodId") long prodId, RedirectAttributes ra) {
        int result = productService.prodDelete(prodId);
        if (result == 1) {
            ra.addFlashAttribute("msg", "상품이 삭제되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "상품 삭제에 실패했습니다. 관리자에게 문의해주세요.");
        }
        return "redirect:/product/productList";
    }
}