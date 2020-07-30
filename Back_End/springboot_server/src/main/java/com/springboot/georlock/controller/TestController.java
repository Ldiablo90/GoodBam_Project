package com.springboot.georlock.controller;



import com.springboot.georlock.svc.SignupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    SignupService signupService;

    @GetMapping(value = "/SignUp")
    public void signup(@RequestParam String userID,@RequestParam String userPass,@RequestParam String userName,
                       @RequestParam String userQue,@RequestParam String userAns) throws Exception{
        System.out.println("Controller");
        System.out.println("ID : "+userID);

        signupService.signupis(userID,userPass, userName, userQue, userAns);
    }

}

