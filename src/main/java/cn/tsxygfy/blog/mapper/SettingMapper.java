package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Setting;

import java.util.List;

public interface SettingMapper {
    Long deleteByPrimaryKey(Integer id);

    Long insert(Setting record);

    Setting selectByPrimaryKey(Integer id);

    List<Setting> selectAll();

    Long updateByPrimaryKey(Setting record);
}