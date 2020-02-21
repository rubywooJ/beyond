package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.TagArticlesVO;
import cn.tsxygfy.blog.model.vo.TagsVO;

import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @className TagsService
 * @description
 * @date 2020/02/04 周二 18:19
 */
public interface TagsService {

    List<TagsVO> findAllWithArticleCount();

    List<TagArticlesVO> findArticlesByTagName(String name);

    Tag findTagIfExist(String name);
}
