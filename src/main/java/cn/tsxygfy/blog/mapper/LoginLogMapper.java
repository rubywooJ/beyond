package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.LoginLog;
import java.util.List;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog record);

    LoginLog selectByPrimaryKey(Long id);

    List<LoginLog> selectAll();

    int updateByPrimaryKey(LoginLog record);
}