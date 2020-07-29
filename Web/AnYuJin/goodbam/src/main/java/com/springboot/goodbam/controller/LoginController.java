package com.springboot.goodbam.controller;



import com.springboot.goodbam.svc.UserService;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @RequestMapping("/")
    public ModelAndView mainPage() throws Exception {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }

    @RequestMapping("/login")
    public  String loginPage() throws Exception {
        String page="login";

        return page;
    }
    @RequestMapping("/logOut")
    public  String logOut() throws Exception {
        String page="index";

        return page;
    }

    @RequestMapping("/dataTable")
    public  String dataTable() throws Exception {
        String page="dataTable";

        return page;
    }


    @RequestMapping("/memberList")
    public  ModelAndView memberList() throws Exception {

        List<UserVO> list = userService.userList();
        System.out.println("컨트롤러 들어옴");
//        ArrayList<UserVO> list = userService.userList();
        System.out.println("list가지고 컨트롤러로 나옴");
        System.out.println(list);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("memberList");
//        model.addAttribute("list", list);
        mav.addObject("list",list);
        System.out.println("mav");
        return mav;
    }


    @RequestMapping("/memberData")
    public  String loginform() throws Exception {
        String page="memberData";

        return page;
    }





}
