package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.SensorMapper;
import com.springboot.goodbam.vo.SensorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SensorService {
    @Autowired
    public SensorMapper sensorMapper;

    public List<Map<String, Object>> selectSensor()throws Exception {
        return sensorMapper.selectSensor();
    }




}
