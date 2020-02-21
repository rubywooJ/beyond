package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Links;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @className LinkTeamVO
 * @description
 * @date 2020/02/04 周二 20:45
 */
@Setter
@Getter
public class LinkTeamVO {

    private String team;

    private List<Links> links;

}
