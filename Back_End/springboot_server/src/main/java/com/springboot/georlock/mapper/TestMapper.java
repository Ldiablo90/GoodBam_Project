package com.springboot.georlock.mapper;

import com.springboot.georlock.dto.Login;
import com.springboot.georlock.dto.Test;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

public interface TestMapper {
    public List<Login> getAll() throws Exception;;
}