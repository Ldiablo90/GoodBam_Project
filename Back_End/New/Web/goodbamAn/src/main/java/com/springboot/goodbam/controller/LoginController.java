package com.springboot.goodbam.controller;



import com.springboot.goodbam.svc.UserService;
import com.springboot.goodbam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    //로그인 페이지
    @RequestMapping("/")
    public ModelAndView mainPage() throws Exception {
        ModelAndView mav = new ModelAndView("loginForm");

        return mav;
    }

    //로그인
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @RequestParam("userPW") String userPW) throws Exception{
        ModelAndView mav = new ModelAndView();

        int result = userService.loginService(userPW);
        if(result ==1){
           mav.setViewName("redirect:/dataTable/");
        }else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('존재하지 않는 password입니다.'); history.go(-1);</script>");
            out.flush();
        }

        return mav;

    }

  /*  @RequestMapping("/index")
    public ModelAndView indexPage()throws Exception {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }
*/


    @RequestMapping("/logOut")
    public  ModelAndView logOut(HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginForm");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('로그아웃 되었습니다.'); ;</script>");
        out.flush();


        return mav;
    }


    @RequestMapping("/dataTable")
    public  ModelAndView loginform() throws Exception {
        List<UserVO> list = userService.userList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dataTable");
        mav.addObject("list",list);
        return mav;
    }


/*

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
*/






}
