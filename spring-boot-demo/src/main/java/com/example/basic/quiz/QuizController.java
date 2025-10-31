package com.example.basic.quiz;

import com.example.basic.quiz.command.QuizVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @GetMapping("/quiz01")
    public String quiz01(){
        return "quiz/quiz01";
    }

    @PostMapping("/join")
    public String quiz01_ok(@ModelAttribute("info") QuizVO vo) {

        if ("y".equals(vo.getAgree())) {
            vo.setAgree("예");
        } else {
            vo.setAgree("아니오");
        }
        return "quiz/quiz01_ok";
    }

    @GetMapping("/terms")
    public String terms(Model model) {
        String termsContent = "제1조 (목적)\n" +
                "이 약관은 서비스 이용에 관한 사항을 규정함을 목적으로 합니다.\n\n" +
                "제2조 (정의)\n" +
                "이 약관에서 사용하는 용어의 정의는 다음과 같습니다.\n" +
                "1. '서비스'란 회사가 제공하는 모든 서비스를 의미합니다.\n" +
                "2. '이용자'란 서비스를 이용하는 자를 의미합니다.\n\n" +
                "제3조 (약관의 효력)\n" +
                "이 약관은 이용자가 동의함으로써 효력을 발생합니다.";

        model.addAttribute("termsContent", termsContent);
        return "quiz/terms";
    }

//    @PostMapping("/terms_ok")
//    public String terms_ok(@ModelAttribute("terms") QuizVO vo, RedirectAttributes re) {
//        if (vo.getAgreement() == null || vo.getPhoneNumber() == null) {
//            re.addFlashAttribute("msg", "전화번호, 동의");
//            return "redirect:/quiz/terms";
//        }
//        return "quiz/terms_ok";
//    }


    // 강사님 풀이
    @PostMapping("/terms_ok")
    public String terms_ok(@RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam(value = "agreement", required = false) String agreement,
                           RedirectAttributes re,
                           Model model) {
        if(agreement == null || !agreement.equals("y")) {
            re.addFlashAttribute("msg", "이용약관에 동의해야 합니다.");
            return "redirect:/quiz/terms";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "quiz/terms_ok";
        }
    }
}
