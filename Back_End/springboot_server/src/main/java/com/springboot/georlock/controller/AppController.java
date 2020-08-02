package com.springboot.georlock.controller;



import com.springboot.georlock.dto.Member;
import com.springboot.georlock.svc.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    AppService appService;


    // 회원가입 컨트롤러
    @GetMapping(value = "/SignUp")
    public void signup(@RequestParam String userID,@RequestParam String userPass,@RequestParam String userName,
                       @RequestParam String userQue,@RequestParam String userAns) throws Exception{
        appService.signupis(userID,userPass, userName, userQue, userAns);
    }

    // 아이디찾기 컨트롤러
    @GetMapping(value = "/IdSearch")
    public List<Member> idsearch(@RequestParam String userName, @RequestParam String userQue, @RequestParam String userAns) throws Exception {
        List<Member> temp = appService.idsearch(userName,userQue,userAns);

        return temp;


    }

    // 비밀번호 찾기 컨트롤러
    @GetMapping(value = "/PassSearch")
    public List<Member> passsearch(@RequestParam String userName, @RequestParam String userID, @RequestParam String userQue, @RequestParam String userAns) throws Exception {

        return appService.passsearch(userName, userID, userQue, userAns);
    }

}

