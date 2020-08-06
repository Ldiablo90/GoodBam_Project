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

    //로그인
    @GetMapping("/login")
    public String login(String userID, String userPW) throws Exception{
        System.out.println("컨트롤러 들어옴");
        String loginSuccess = userService.Login(userID,userPW);
        System.out.println("DB에 넣음");

        return loginSuccess;
    }

    //아이디 중복 확인
    @GetMapping(value = "/idCheck")
    public  String idCheck(String userID) throws Exception{
        System.out.println("컨트롤러 들어옴");

        String idCheckResult =
                userService.idCheck(userID);
        System.out.println("컨트롤러로 나옴");

        return idCheckResult;
    }

    //회원가입
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


    // 아이디 찾기 컨트롤러
    @GetMapping(value = "/SearchID")
    public String searchID(String userName, String userQue, String userAns) throws Exception {

        System.out.println("컨트롤러 들어옴");
        String userID = userService.searchID(userName, userQue, userAns);

        System.out.println("컨트롤러로 나옴");
        return userID;
    }

    // 비밀번호 찾기 컨트롤러
    @GetMapping(value = "/SearchPass")
    public String searchPass(String userID, String userName, String userQue, String userAns) throws Exception {

        System.out.println("컨트롤러 들어옴");
        String userPass = userService.searchPass(userID, userName, userQue, userAns);
        System.out.println("컨트롤러로 나옴");

        return userPass;
    }

    // 현제 온도띄우기!!!!
    @GetMapping(value = "/userTempNow")
    public String usertempNow(String userID) throws Exception {
        return "";
    }
    // 현제온,습도 조절
    @GetMapping(value = "/userEditTemp")
    public String userEditTemp(String userID) throws Exception {
        return "";
    }
    // 나이트모드
    @GetMapping(value = "/nightMode")
    public String nightMode(String userID) throws Exception {
        return "";
    }
    // 그래프 온도띄우기
    @GetMapping(value = "/userChart")
    public String userChart(String userID) throws Exception {
        return "";
    }






}
