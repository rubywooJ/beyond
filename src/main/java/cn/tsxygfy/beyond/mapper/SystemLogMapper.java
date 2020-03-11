package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.SystemLog;

import java.util.List;

public interface SystemLogMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(SystemLog record);

    SystemLog selectByPrimaryKey(Long id);

    List<SystemLog> selectAll();

    Long updateByPrimaryKey(SystemLog record);
}