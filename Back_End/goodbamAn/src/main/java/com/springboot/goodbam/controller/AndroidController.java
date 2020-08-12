package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.UserService;
import com.springboot.goodbam.vo.TemperatureVO;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AndroidController {

    @Autowired
    UserService userService;

    //로그인
    @GetMapping("/applogin")
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

    //LedSensor 작동 goodbam모드
    @GetMapping(value = "/switch")
    public String goodbamMode(String ledSensor) throws Exception{

        System.out.println("굿밤모드 컨트롤러 들어옴");
        System.out.println(ledSensor);
            String result = userService.insertSensor(ledSensor);
            return result;

    }
    // 차트 값 가져오기
    @GetMapping(value = "/chartlist")
    public List<TemperatureVO> chartlist(String raspID) throws Exception {
        TemperatureVO raspid = new TemperatureVO();
        raspid.setRaspID(raspID);
        return userService.chartlist(raspid);
    }






}
