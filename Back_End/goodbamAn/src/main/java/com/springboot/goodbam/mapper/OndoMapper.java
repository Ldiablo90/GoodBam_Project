package com.springboot.goodbam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OndoMapper {
    public List<Map<String, Object>> selectOndo() throws Exception;
}
