package com.springboot.goodbam.controller;

import com.google.gson.Gson;
import com.springboot.goodbam.svc.TemperatureService;

import com.springboot.goodbam.svc.UserService;
import com.springboot.goodbam.vo.TemperatureVO;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@RestController
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String testPage(@RequestParam String temperature, @RequestParam String humidty, @RequestParam String raspID, @RequestParam String time, @RequestParam String date, @RequestParam String userID) throws Exception {
        TemperatureVO temperatureVO = new TemperatureVO();
        temperatureVO.setHumidity(humidty);
        temperatureVO.setTemperature(temperature);
        temperatureVO.setRaspID(raspID);
        temperatureVO.setTime(time);
        temperatureVO.setDate(date);
        temperatureVO.setUserID(userID);
        temperatureService.insertTemperature(temperatureVO);

        return "success";
    }
    @RequestMapping("/memberData")
    public ModelAndView memberData() throws Exception {
        List<UserVO> list = userService.userList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("memberData");
        mav.addObject("list",list);
        return mav;
    }
    @RequestMapping("/temperatureList")
    public String temperatureList(Locale locale, Model model) throws Exception {
        Gson gson = new Gson();
        List<TemperatureVO> temperatureList = temperatureService.temperatureList();

        return gson.toJson(temperatureList);
    }
}
