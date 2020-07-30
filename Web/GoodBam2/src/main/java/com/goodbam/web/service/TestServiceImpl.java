package com.goodbam.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbam.web.dao.TestMapper;
import com.goodbam.web.vo.TestVO;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	@Override
	public List<TestVO> getTestList() {
		// TODO Auto-generated method stub
		return testMapper.testList();
	}

}
