package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.dto.PageParam;
import cn.tsxygfy.beyond.model.dto.PageResult;
import cn.tsxygfy.beyond.model.po.Article;
import cn.tsxygfy.beyond.model.po.Tag;
import cn.tsxygfy.beyond.model.vo.ArticleTagsVO;
import cn.tsxygfy.beyond.model.vo.ArticleYearVO;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-02-21 15:05:14
 */
public interface ArticleService {

    /**
     * 查询所有的文章包含对应标签   首页展示用   已弃用
     *
     * @return
     */
    @Deprecated
    List<ArticleTagsVO> findAllWithTags();

    /**
     * 分页查询全部的文章包含对应标签  首页展示用
     *
     * @param pageParam
     * @return
     */
    PageResult fndAllWithTagsByPage(@NonNull PageParam pageParam);

    /**
     * 根据文章标题查询对应的文章包含对应标签（精确）  单个文章详情用
     *
     * @param title
     * @return
     */
    ArticleTagsVO findArticleWithTagsByTitle(@NonNull String title);

    /**
     * 对文章按照年份归档
     *
     * @return
     */
    List<ArticleYearVO> listYearArchives();

    /**
     * 根据文章的id查询文章的信息
     *
     * @param id
     * @return
     */
    Article findArticleById(@NonNull Long id);

    /**
     * 获取文章对应的标签
     *
     * @param id
     * @return
     */
    List<Tag> getTags(@NonNull Long id);

    /**
     * 发布文章
     *
     * @param articleTagsVO
     * @return
     */
    ArticleTagsVO createOrUpdateArticle(@NonNull ArticleTagsVO articleTagsVO);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    void deleteArticle(Long id);

    /**
     * 文章总数
     *
     * @return
     */
    Long getCount();
}
