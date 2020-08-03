package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.UserMapper;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.ArrayList;
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

    public String Login(String userID, String userPW) throws Exception{
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

    public String signupis(String userID, String userPass, String userName, String userQue, String userAns) throws Exception{
        System.out.println("서비스 들어옴");
        userVO.setUserID(userID);
        userVO.setUserPass(userPass);
        userVO.setUserName(userName);
        userVO.setUserQue(userQue);
        userVO.setUserAns(userAns);
        userVO.setUserEmail("들어가라");

        System.out.println("userVO"+userVO.getUserID());

        String signUpResult = "";

        System.out.println("매퍼 들어감");
        userMapper.signUpis(userVO);
        System.out.println("매퍼 나옴");
        return signUpResult = "회원가입 성공";


    }


    public String idCheck(String userID) throws Exception {

        String result = "";
        int count = userMapper.idCheck(userID);

        if(count == 0){
            result = "사용가능한 ID";
        }else {
            result = "중복된 ID";
        }


        return result;
    }
}



