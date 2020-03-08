package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Links;

import java.util.List;

public interface LinksMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Links record);

    Links selectByPrimaryKey(Long id);

    List<Links> selectAll();

    Long updateByPrimaryKey(Links record);
}