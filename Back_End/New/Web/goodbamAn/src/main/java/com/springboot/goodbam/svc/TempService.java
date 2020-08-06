package com.springboot.goodbam.svc;

import com.springboot.goodbam.mapper.TempMapper;
import com.springboot.goodbam.vo.TempVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TempService {

    @Autowired
    TempMapper tempMapper;

    @Autowired
    @Qualifier("TempVO")
    public TempVO tempVO;

}
