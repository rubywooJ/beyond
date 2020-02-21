package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Article;
import cn.tsxygfy.blog.model.vo.ArticleTagsVO;
import cn.tsxygfy.blog.model.vo.TagArticlesVO;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    /**
     * 查询所有的文章+对应的标签
     * @return
     */
    @Deprecated
    List<ArticleTagsVO> selectAllWithTags();

    /**
     * 根据文章的标题查文章
     *
     * @param title
     * @return
     */
    Article selectArticleByTitle(String title);


    List<Article> selectArticleYear();

    List<TagArticlesVO> selectArticleByTagName(String name);
}