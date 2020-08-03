package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.UserService;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AndroidController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(String userID, String userPW) throws Exception{
        System.out.println("컨트롤러 들어옴");
        String loginSuccess = userService.Login(userID,userPW);
        System.out.println("DB에 넣음");

        return loginSuccess;
    }

    @GetMapping(value = "/idCheck")
    public  String idCheck(String userID) throws Exception{
        System.out.println("컨트롤러 들어옴");

        String idCheckResult =
                userService.idCheck(userID);


        return idCheckResult;
    }


    @GetMapping("/SignUp")
    public String signup(String userID, String userPass,String userName,
                       String userQue, String userAns) throws Exception{
        System.out.println("Controller");
        System.out.println("ID : "+userID);

        String signUpResult =
                userService.signupis(userID, userPass, userName, userQue, userAns);

        System.out.println("서비스 나옴");

        return signUpResult;
    }











}
