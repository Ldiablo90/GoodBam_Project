package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.UserMapper;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public ArrayList<UserVO> userList() throws Exception{
        System.out.println("서비스 들어옴");
        return userMapper.userList();
    }


    public void Userdelete(String userNum)throws Exception {
        System.out.println(userNum + "userdelete");
        userMapper.userDelete(userNum);
    }
}
