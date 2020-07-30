package com.springboot.georlock.svc;


import com.springboot.georlock.dto.Member;
import com.springboot.georlock.mapper.SignupMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SignupService {

    @Autowired
    SignupMapper signupMapper;

    public void signupis(String userID, String userPass, String encoName, String encoQue, String encoAns) throws Exception{
        Member member = new Member();
        member.setUserID(userID);
        member.setUserPass(userPass);
        member.setUserName(encoName);
        member.setUserQue(encoQue);
        member.setUserAns(encoAns);
        signupMapper.signUpis(member);
    }
}