package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Comments;

import java.util.List;

public interface CommentsMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Comments record);

    Comments selectByPrimaryKey(Long id);

    List<Comments> selectAll();

    Long updateByPrimaryKey(Comments record);
}