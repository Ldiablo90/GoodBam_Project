package com.springboot.goodbam.controller;

import com.springboot.goodbam.svc.TemperatureService;
import com.springboot.goodbam.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    TemperatureService temperatureService;
    @Autowired
    UserService userService;


    @RequestMapping("/temperaturedelete")
    public String temperaturedelete(@RequestParam String userNum) throws Exception{
        System.out.println(userNum+"svc");
        temperatureService.Temperaturedelete(userNum);
        return "redirect:dataTable";
    }


    @RequestMapping("/userdelete")
    public String userdelete(@RequestParam String userNum) throws Exception{
        System.out.println("userdelete");
        userService.Userdelete(userNum);
        return "redirect:memberList";

    }



}
