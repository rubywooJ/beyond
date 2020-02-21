package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Links;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:03:41
 * @see cn.tsxygfy.blog.model.vo
 *
 */
@Setter
@Getter
public class LinkTeamVO {

    private String team;

    private List<Links> links;

}
