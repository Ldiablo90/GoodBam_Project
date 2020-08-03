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



    // 로그인 컨트롤러
    @GetMapping("/login")
    public String login(String userID, String userPW) throws Exception{
        System.out.println("컨트롤러 들어옴");
        String loginSuccess = userService.Login(userID,userPW);
        System.out.println("DB에 넣음");


        return loginSuccess;
    }

    // 아이디 중복 확인 컨트롤러
    @GetMapping(value = "/idCheck")
    public  String idCheck(String userID) throws Exception{
        System.out.println("컨트롤러 들어옴");

        String idCheckResult =
                userService.idCheck(userID);


        return idCheckResult;
    }

    // 회원가입 컨틀롤러
    @GetMapping(value = "/SignUp")
    public String signup(String userID, String userPass,String userName,
                       String userQue, String userAns) throws Exception{
        System.out.println("Controller");
        System.out.println("ID : "+userID);

        String signUpResult =
                userService.signupis(userID, userPass, userName, userQue, userAns);

        return signUpResult;
    }

    // 아이디 찾기 컨트롤러
    @GetMapping(value = "/SearchID")
    public String searchID(String userName, String userQue, String userAns) throws Exception {
        String userID = userService.searchID(userName, userQue, userAns);
        return userID;
    }

    // 비밀번호 찾기 컨트롤러
    @GetMapping(value = "/SearchPass")
    public String searchPass(String userID, String userName, String userQue, String userAns) throws Exception {
        String userPass = userService.searchPass(userID, userName, userQue, userAns);
        return userPass;
    }
}
