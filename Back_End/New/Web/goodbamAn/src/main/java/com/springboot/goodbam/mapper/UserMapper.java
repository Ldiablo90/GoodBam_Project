package com.springboot.goodbam.mapper;

import com.springboot.goodbam.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    public ArrayList<UserVO> userList() throws Exception;

    //로그인 메퍼
    public int login(UserVO userVO) throws Exception;

    //회원가입 메퍼
    public void signUpis(UserVO userVO) throws Exception;

    //아이디 중복확인 메퍼
    public int idCheck(String userID) throws Exception;

    // 아이디 찾기 맵버
    public  String searchID(UserVO userVO) throws Exception;

    // 비밀번호 찾기 맵퍼
    public  String searchPass(UserVO userVO) throws Exception;



}
