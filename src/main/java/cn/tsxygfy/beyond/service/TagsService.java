package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.po.Tag;
import cn.tsxygfy.beyond.model.vo.TagArticlesVO;
import cn.tsxygfy.beyond.model.vo.TagsVO;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-02-21 15:05:37
 */
public interface TagsService {

    List<TagsVO> findAllWithArticleCount();

    List<TagArticlesVO> findArticlesByTagName(String name);

    Tag findTagIfExist(String name);

    List<Tag> findAll();

    void deleteById(Long id);

    Tag createOrUpdateTag(Tag tag);
}
