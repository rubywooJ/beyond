package cn.tsxygfy.beyond.mapper;

import cn.tsxygfy.beyond.model.po.Article;
import cn.tsxygfy.beyond.model.vo.ArticleTagsVO;
import cn.tsxygfy.beyond.model.vo.TagArticlesVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    Long updateByPrimaryKey(Article record);

    /**
     * 查询所有的文章+对应的标签
     *
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

    /**
     * 对文章标签进行关联
     *
     * @param articleId
     * @param tagId
     */
    void insertArticleTag(@Param("articleId") Long articleId, @Param("tagId") Long tagId);


    /**
     * 取消关联
     *
     * @param articleId
     */
    void deleteArticleTagByArticleId(Long articleId);

    /**
     * 文章数目
     *
     * @return
     */
    Long selectCount();
}
