package com.springboot.goodbam.svc;


import com.springboot.goodbam.mapper.OndoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OndoService {

    @Autowired
    public OndoMapper ondoMapper;

    public List<Map<String, Object>> selectOndo() throws Exception {

        return ondoMapper.selectOndo();
    }
}
