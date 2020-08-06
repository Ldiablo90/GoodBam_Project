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
}
