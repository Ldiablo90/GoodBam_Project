package com.springboot.georlock.mapper;


import com.springboot.georlock.dto.Member;

import java.util.List;


public interface MemberMapper {


    // 회원가입 쿼리로 이동하는 곳
    public void signUpis(Member member) throws Exception;

    // 아이디 찾기 쿼리로 이동하는 곳
    public List<Member> idsearch(Member member) throws Exception;

    // 비밀번호 찾기로 이동하는 곳
    public void passsearch(Member member) throws Exception;
}
