package com.example.basic.chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chap05")
public class MemoController {

    private final MemoService memoService;
    @Autowired
    public MemoController(@Qualifier("memoService") MemoService memoService) {
        this.memoService = memoService;
    }

    // 메모목록
    @GetMapping("/memoList")
    public String memoList(Model model) {
        List<MemoVO> list = memoService.memoList();
        model.addAttribute("list", list);
        return "chap05/memoList";
    }

    // 메모작성
    @GetMapping("/memoWrite")
    public String memoWrite() {
        return "chap05/memoWrite";
    }

    @PostMapping("/memoRegist")
    public String memoRegist(MemoVO memoVO) {
        memoService.memoRegist(memoVO);
        return "redirect:/chap05/memoList";
    }
}
