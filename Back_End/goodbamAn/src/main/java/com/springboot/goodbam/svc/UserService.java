package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.UserMapper;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    @Autowired
    @Qualifier("userVO")
    public UserVO userVO;

    public ArrayList<UserVO> userList() throws Exception{
        System.out.println("서비스 들어옴");
        return userMapper.userList();
    }

    //로그인 서비스
    public String Login(String userID, String userPW) throws Exception{

        System.out.println("서비스 들어옴");
        userVO.setUserID(userID);
        userVO.setUserPass(userPW);
        String loginSuccess ;

        if(userMapper.login(userVO)==1){
            loginSuccess = "로그인 성공";
        }
        else {
            loginSuccess = "로그인 실패";
        }

        return loginSuccess;
    }

    //회원가입 서비스
    public String signupis(String userID, String userPass, String userName, String userQue, String userAns) throws Exception{
        System.out.println("서비스 들어옴");
        userVO.setUserID(userID);
        userVO.setUserPass(userPass);
        userVO.setUserName(userName);
        userVO.setUserQue(userQue);
        userVO.setUserAns(userAns);
        userVO.setUserEmail("들어가라");

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        userVO.setUserSignupdate(date.format(today));

        String signUpResult = "";

        System.out.println("매퍼 들어감");
        userMapper.signUpis(userVO);
        System.out.println("매퍼 나옴");

        return signUpResult = "회원가입 성공";


    }

    //아이디 중복확인 서비스
    public String idCheck(String userID) throws Exception {
        System.out.println("서비스 들어옴");
        String result = "";
        int count = userMapper.idCheck(userID);

        if(count == 0){
            result = "사용가능한 ID";
        }else {
            result = "중복된 ID";
        }


        return result;
    }


    // 아이디 찾기 서비스
    public String searchID(String userName, String userQue, String userAns)throws Exception{

        System.out.println("서비스 들어옴");
        userVO.setUserName(userName);
        userVO.setUserQue(userQue);
        userVO.setUserAns(userAns);

        System.out.println(userVO.getUserName());
        String userID = userMapper.searchID(userVO);
        System.out.println(userID);
        if(userID.equals("")){
            return "";
        }else{
            return userID;
        }
    }

    // 비밀번호 찾기 서비스
    public String searchPass(String userID, String userName, String userQue, String userAns)throws Exception{

        System.out.println("서비스 들어옴");
        userVO.setUserID(userID);
        userVO.setUserName(userName);
        userVO.setUserQue(userQue);
        userVO.setUserAns(userAns);
        String userPass = userMapper.searchPass(userVO);
        if(userPass.equals("")){
            return "";
        }else{
            return userPass;
        }
    }


    public int loginService(String userPW) throws Exception {

        return userMapper.loginWeb(userPW);
    }


    public void Userdelete(String userNum)throws Exception {
        System.out.println(userNum + "userdelete");
        userMapper.userDelete(userNum);
    }


    public String insertSensor(String ledSensor)throws Exception {

        System.out.println("굿밤 서비스 들어옴");
        try {
            userMapper.insertSensorValue(ledSensor);
            System.out.println("DB들어감");
            return "정상작동";
        }catch (SQLException e){
            System.out.println("DB안들어감");
            return "xxxx";
        }

    }
}



