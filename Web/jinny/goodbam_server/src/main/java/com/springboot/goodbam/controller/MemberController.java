package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/list")//멤버 리스트
    private String memberList(Model model)throws Exception{
        model.addAttribute("list", memberService.memberListService());
        return "list";
    }

    @RequestMapping("/delete/{userNum}")
    private String memberDelete(@PathVariable int userNum)throws Exception{
        memberService.memberDeleteService(userNum);

        return "redirect:/list";
    }
}
