package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.User;

import java.util.List;

public interface UserMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    Long updateByPrimaryKey(User record);

    User selectByUserName(String username);

    User selectByEmail(String email);
}