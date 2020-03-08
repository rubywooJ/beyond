package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.mapper.ArticleMapper;
import cn.tsxygfy.blog.mapper.TagMapper;
import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.TagArticlesVO;
import cn.tsxygfy.blog.model.vo.TagsVO;
import cn.tsxygfy.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.service.impl
 * @since 2020-02-21 15:04:48
 */
@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<TagsVO> findAllWithArticleCount() {
        List<TagsVO> vos = tagMapper.selectAllWithArticleCount();
        return vos;
    }

    @Override
    public List<TagArticlesVO> findArticlesByTagName(String name) {
        return articleMapper.selectArticleByTagName(name);
    }

    @Override
    public Tag findTagIfExist(String name) {
        return tagMapper.selectByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return tagMapper.selectAll();
    }

    @Override
    public void deleteById(Long id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Tag createOrUpdateTag(Tag tag) {
        if (tag.getId() == null) {
            // 新增
            Long id = tagMapper.insert(tag);
            tag.setId(id);
        } else {
            // 修改
            tagMapper.updateByPrimaryKey(tag);
        }
        return tag;
    }
}
