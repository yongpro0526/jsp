package com.coding404.myweb.controller;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.TopicService;
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

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    @Qualifier("topicService")
    private TopicService topicService;

    @GetMapping("/topicListAll")
    public String topicListAll(Criteria criteria, Model model) {
        List<TopicVO> topicList = topicService.getListAll(criteria);
        int total = topicService.getTotalAll(criteria);
        PageVO pageVO = new PageVO(criteria,total);

        model.addAttribute("topicList", topicList);
        model.addAttribute("pageVO", pageVO);
        return "topic/topicListAll";
    }

    @GetMapping("/topicListMe")
    public String topicListMe(Criteria criteria, Model model) {
        String topicWriter = "abc123";
        List<TopicVO> topicList = topicService.getList(topicWriter, criteria);
        int total = topicService.getTotal(topicWriter);
        PageVO pageVO = new PageVO(criteria, total);

        model.addAttribute("topicList", topicList);
        model.addAttribute("pageVO", pageVO);
        return "topic/topicListMe";
    }

    @GetMapping("/topicDetail")
    public String topicDetail(@RequestParam("topicId") long topicId, Model model) {
        TopicVO vo = topicService.getModify(topicId);
        model.addAttribute("vo", vo);
        return "topic/topicDetail";
    }

    @GetMapping("/topicModify")
    public String topicModify(@RequestParam("topicId") long topicId, Model model) {
        TopicVO vo = topicService.getModify(topicId);
        model.addAttribute("vo", vo);
        return "topic/topicModify";
    }

    @GetMapping("/topicReg")
    public String topicReg(){
        return "topic/topicReg";
    }

    // 토픽 등록
    @PostMapping("/topicRegist")
    public String topicRegist(TopicVO topicVO,
                              RedirectAttributes ra) {
        int result = topicService.topicRegist(topicVO);
        if (result == 1) {
            ra.addFlashAttribute("msg", "게시글이 등록되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "게시글 등록에 실패하였습니다. 관리자에게 연락요망.");
        }
        return "redirect:/topic/topicListAll";
    }

    @PostMapping("/topicUpdate")
    public String topicUpdate(TopicVO vo, RedirectAttributes ra) {
        int result = topicService.topicUpdate(vo);
        if (result == 1) {
            ra.addFlashAttribute("msg", "수정이 완료되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "수정에 실패하였습니다. 관리자 연락 요망");
        }
        return "redirect:/topic/topicListMe";
    }

    @GetMapping("/topicDelete")
    public String topicDelete(@RequestParam("topicId") long topicId, RedirectAttributes ra) {
        int result = topicService.topicDelete(topicId);
        if (result == 1) {
            ra.addFlashAttribute("msg", "게시글이 삭제되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "게시글 삭제에 실패하였습니다. 관리자 연락 요망");
        }
        return "redirect:/topic/topicListMe";
    }
}
