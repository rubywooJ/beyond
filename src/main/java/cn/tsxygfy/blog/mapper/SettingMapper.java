package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Setting;
import java.util.List;

public interface SettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Setting record);

    Setting selectByPrimaryKey(Integer id);

    List<Setting> selectAll();

    int updateByPrimaryKey(Setting record);
}