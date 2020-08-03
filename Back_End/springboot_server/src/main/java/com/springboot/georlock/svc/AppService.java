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

        List<Member> resurt = memberMapper.idsearch(member);


        System.out.println("resurt : "+resurt);
        // 조회가 안되면 빈칸이 오기 때문에 값을 집어 넣어 조회해도 공란이 나가게 한다.
        if(resurt.isEmpty()){
            Member temp = new Member();
            resurt.add(temp);
            return resurt;
        }
        else{
            return resurt;
        }

    }
    // 비밀번호 찾기 서비스
    public List<Member> passsearch(String userName, String userID, String userQue, String userAns) throws Exception {
        Member member = new Member();
        member.setUserName(userName);
        member.setUserID(userID);
        member.setUserQue(userQue);
        member.setUserAns(userAns);
        return memberMapper.passsearch(member);
    }

    // 아이디 체크 서비스
    public List<Member> idcheck(String userID)throws Exception{
        Member member = new Member();
        member.setUserID(userID);
        return memberMapper.idcheck(member);
    }
}