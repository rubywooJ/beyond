package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.Setting;

import java.util.List;

public interface SettingMapper {
    Long deleteByPrimaryKey(Integer id);

    Long insert(Setting record);

    Setting selectByPrimaryKey(Integer id);

    List<Setting> selectAll();

    Long updateByPrimaryKey(Setting record);
}