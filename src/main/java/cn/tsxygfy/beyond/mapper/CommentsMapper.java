package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.Comments;

import java.util.List;

public interface CommentsMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Comments record);

    Comments selectByPrimaryKey(Long id);

    List<Comments> selectAll();

    Long updateByPrimaryKey(Comments record);
}