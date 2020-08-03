package com.springboot.goodbam.mapper;

import com.springboot.goodbam.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("")
public interface MemberMapper {
    //회원 목록
    public List<UserVO> memberList() throws Exception;

    //회원 삭제
    public int memberDelete(int bno) throws Exception;


}