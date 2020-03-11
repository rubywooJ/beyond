package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.Info;

import java.util.List;

public interface InfoMapper {
    Long deleteByPrimaryKey(Integer id);

    Long insert(Info record);

    Info selectByPrimaryKey(Integer id);

    List<Info> selectAll();

    Long updateByPrimaryKey(Info record);
}