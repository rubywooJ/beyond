package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.po.Links;
import cn.tsxygfy.blog.model.vo.LinkTeamVO;

import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:23
 * @see cn.tsxygfy.blog.service
 *
 */
public interface LinksService {

    List<LinkTeamVO> listTeamLinks();

    void deleteById(Long id);

    Links createOrUpdateTag(Links links);
}
