package com.springboot.goodbam.mapper;

import com.springboot.goodbam.vo.TemperatureVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TemperatureMapper {
    public void insertTemperature(TemperatureVO temperatureVO) throws Exception;

    public List<TemperatureVO> temperatureList() throws Exception;

    public void delete(String userNum)throws Exception;


}
