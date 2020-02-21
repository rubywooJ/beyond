package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUserName(String username);

    User selectByEmail(String email);
}