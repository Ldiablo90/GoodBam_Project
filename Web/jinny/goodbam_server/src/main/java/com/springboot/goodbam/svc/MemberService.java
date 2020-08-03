package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.MemberMapper;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public List<UserVO> memberListService() throws Exception {
        return memberMapper.memberList();
    }

    public int memberDeleteService(int userNum) throws Exception {

        return memberMapper.memberDelete(userNum);
    }


}
