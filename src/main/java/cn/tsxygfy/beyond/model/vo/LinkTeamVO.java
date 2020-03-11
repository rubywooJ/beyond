package cn.tsxygfy.beyond.model.vo;

import cn.tsxygfy.beyond.model.po.Links;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.model.vo
 * @since 2020-02-21 15:03:41
 */
@Setter
@Getter
public class LinkTeamVO {

    private String team;

    private List<Links> links;

}
