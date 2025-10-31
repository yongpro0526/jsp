package com.example.basic.chap02;

import com.example.basic.chap01.command.ReqVO;
import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;
import java.util.Date;

@Controller
@RequestMapping("/chap02")
public class ResponseController {

    // 화면 구현
    @GetMapping("/ex01")
    public String ex01() {
        return "chap02/ex01";
    }

    //ex02
    @GetMapping("ex02")
    public String ex02(Model model){
        model.addAttribute("msg", "Hello World");
        model.addAttribute("date", new Date());
        model.addAttribute("name", "홍길동");

        return "chap02/ex02";
    }

    // ex03
    @GetMapping("ex03")
    public ModelAndView ex03() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chap02/ex03");
        mv.addObject("msg", "안녕하세요!!");

        return mv;
    }

    // ex04
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("id") String id) {

        // id를 받아서, 다음 화면에 id 이름으로 전달
        return "chap02/ex04";
    }

    // ex05
    @PostMapping("/ex05")
    public String ex05(@ModelAttribute("info") ReqVO vo) {
        // 화면에서 넘어온 값은 vo에 매핑하고 info라는 이름으로 다음 화면에 전달
        return "chap02/ex05";
    }

    // 리다이렉트 어트리뷰트
    @GetMapping("/login")
    public String login() {
        return "chap02/login";
    }

    @PostMapping("/loginForm")
    public String loginForm(ReqVO vo, RedirectAttributes re) {
        String id = vo.getId();
        String pw = vo.getPw();
        if (id.equals(pw)) {
            return "chap02/login_ok";
        } else {
            // 실패시에는 메시지를 보내고 싶음 - 리다이렉트는 데이터를 보내지 않음
            // 하지만, 스프링에서는 리다이렉트시에 1회성 데이터를 보내는 방법을 제공함
            re.addFlashAttribute("msg", "아이디와 비밀번호를 확인하세요");
            return "redirect:/chap02/login";
        }
    }
}
