package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.TagArticlesVO;
import cn.tsxygfy.blog.model.vo.TagsVO;

import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:37
 * @see cn.tsxygfy.blog.service
 *
 */
public interface TagsService {

    List<TagsVO> findAllWithArticleCount();

    List<TagArticlesVO> findArticlesByTagName(String name);

    Tag findTagIfExist(String name);
}
