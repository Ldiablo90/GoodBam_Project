package com.springboot.goodbam.mapper;

import com.springboot.goodbam.vo.SensorVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SensorMapper {
    public List<Map<String, Object>> selectSensor() throws Exception;

}
