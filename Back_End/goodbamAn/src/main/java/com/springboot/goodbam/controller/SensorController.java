package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.SensorService;
import com.springboot.goodbam.vo.SensorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SensorController {

    @Autowired
    SensorService sensorService;



    @GetMapping("/sensor")
    public List<Map<String, Object>> selectSensor() throws Exception{

        return sensorService.selectSensor();
    }

}
