package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.Links;

import java.util.List;

public interface LinksMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Links record);

    Links selectByPrimaryKey(Long id);

    List<Links> selectAll();

    Long updateByPrimaryKey(Links record);

    Long getCount();
}
