package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.po.Links;
import cn.tsxygfy.beyond.model.vo.LinkTeamVO;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-02-21 15:05:23
 */
public interface LinksService {

    List<LinkTeamVO> listTeamLinks();

    void deleteById(Long id);

    Links createOrUpdateTag(Links links);
}
