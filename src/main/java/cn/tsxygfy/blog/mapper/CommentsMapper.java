package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Comments;
import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comments record);

    Comments selectByPrimaryKey(Long id);

    List<Comments> selectAll();

    int updateByPrimaryKey(Comments record);
}