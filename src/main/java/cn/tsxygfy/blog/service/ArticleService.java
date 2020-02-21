package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.dto.PageParam;
import cn.tsxygfy.blog.model.dto.PageResult;
import cn.tsxygfy.blog.model.vo.ArticleTagsVO;
import cn.tsxygfy.blog.model.vo.ArticleYearVO;

import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:14
 * @see cn.tsxygfy.blog.service
 *
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
    PageResult fndAllWithTagsByPage(PageParam pageParam);

    /**
     * 根据文章标题查询对应的文章包含对应标签（精确）  单个文章详情用
     *
     * @param title
     * @return
     */
    ArticleTagsVO findArticleWithTagsByTitle(String title);

    /**
     * 对文章按照年份归档
     *
     * @return
     */
    List<ArticleYearVO> listYearArchives();
}
