package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Links;
import java.util.List;

public interface LinksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Links record);

    Links selectByPrimaryKey(Long id);

    List<Links> selectAll();

    int updateByPrimaryKey(Links record);
}