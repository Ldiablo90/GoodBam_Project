package com.goodbam.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.goodbam.web.service.TestService;
import com.goodbam.web.vo.TestVO;

@RestController
public class GoodBamController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView home() throws Exception{
		ModelAndView mav = new ModelAndView();
		List<TestVO> testList = testService.getTestList();
		mav.setViewName("index");
		mav.addObject("list",testList);
		return mav;
		
	
		
	}
	

}
