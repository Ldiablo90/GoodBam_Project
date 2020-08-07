package com.springboot.goodbam.svc;


import com.springboot.goodbam.mapper.TemperatureMapper;
import com.springboot.goodbam.vo.TemperatureVO;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {
    @Autowired
    public TemperatureMapper temperatureMapper;

    public void insertTemperature(TemperatureVO temperatureVO) throws Exception{
        System.out.println("서비스 들어옴");
        temperatureMapper.insertTemperature(temperatureVO);
    }
    public List<TemperatureVO> temperatureList() throws Exception{

        return temperatureMapper.temperatureList();
    }



}
