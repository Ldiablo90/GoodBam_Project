package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.OndoService;
import com.springboot.goodbam.svc.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OndoController {

    @Autowired
    OndoService ondoService;
    //안드로이드로 온습도 값 보냄
    @GetMapping( value = "/ondoPrint" )
    public List<Map<String, Object>> seleteondo() throws Exception{
        return ondoService.selectOndo();
    }

}
