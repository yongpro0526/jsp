package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 홈화면
    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
