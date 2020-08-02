package com.springboot.georlock.svc;


import com.springboot.georlock.dto.Member;
import com.springboot.georlock.mapper.MemberMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppService {

    @Autowired
    MemberMapper memberMapper;

    // 회원가입 서비스
    public void signupis(String userID, String userPass, String encoName, String encoQue, String encoAns) throws Exception{
        Member member = new Member();
        member.setUserID(userID);
        member.setUserPass(userPass);
        member.setUserName(encoName);
        member.setUserQue(encoQue);
        member.setUserAns(encoAns);
        memberMapper.signUpis(member);
    }
    // 아이디 찾기 서비스
    public List<Member> idsearch(String userName, String userQue, String userAns) throws Exception {
        Member member = new Member();
        member.setUserName(userName);
        member.setUserQue(userQue);
        member.setUserAns(userAns);
        return memberMapper.idsearch(member);
    }
    // 비밀번호 찾기 서비스
    public void passsearch(String userName, String userID, String userQue, String userAns) throws Exception {
        Member member = new Member();
        member.setUserName(userName);
        member.setUserID(userID);
        member.setUserQue(userQue);
        member.setUserAns(userAns);
        memberMapper.passsearch(member);
    }
}