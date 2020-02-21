package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.mapper.ArticleMapper;
import cn.tsxygfy.blog.mapper.TagMapper;
import cn.tsxygfy.blog.model.dto.PageParam;
import cn.tsxygfy.blog.model.dto.PageResult;
import cn.tsxygfy.blog.model.po.Article;
import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.ArticleTagsVO;
import cn.tsxygfy.blog.model.vo.ArticleYearVO;
import cn.tsxygfy.blog.service.ArticleService;
import cn.tsxygfy.blog.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author feiyang
 * @version v1.0
 * @className ArticleServiceImpl
 * @description
 * @date 2020/01/31 周五 20:55
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<ArticleTagsVO> findAllWithTags() {
        List<ArticleTagsVO> articleTagsVOS = articleMapper.selectAllWithTags();
        return articleTagsVOS;
    }

    @Override
    public PageResult fndAllWithTagsByPage(PageParam pageParam) {
        // 非按文章分页
        // return PageUtil.pageInfo2PageResult(getPageInfo(pageParam));

        //先查 pageSize 篇文章
        PageInfo<Article> info = getPageInfo(pageParam);
        List<ArticleTagsVO> vos = new ArrayList<>();
        List<Article> articles = info.getList();
        for (Article article : articles) {
            Long id = article.getId();
            //再找每个文章的标签
            List<Tag> tags = tagMapper.selectByArticleId(id);
            ArticleTagsVO vo = new ArticleTagsVO(article);
            vo.setTags(tags);
            vos.add(vo);
        }
        // 重新构造分页数据
        PageInfo<ArticleTagsVO> pageInfo = new PageInfo<>(vos);
        pageInfo.setPageNum(info.getPageNum());
        pageInfo.setPageSize(info.getPageSize());
        pageInfo.setTotal(info.getTotal());
        pageInfo.setPages(info.getPages());

        return PageUtil.pageInfo2PageResult(pageInfo);
    }

    @Override
    public ArticleTagsVO findArticleWithTagsByTitle(String title) {
        Article article = articleMapper.selectArticleByTitle(title);
        if (article == null) return null;
        List<Tag> tags = tagMapper.selectByArticleId(article.getId());
        ArticleTagsVO vo = new ArticleTagsVO(article);
        vo.setTags(tags);
        return vo;
    }

    @Override
    public List<ArticleYearVO> listYearArchives() {
        // 查全部
        List<Article> articles = articleMapper.selectArticleYear();
        Map<Integer, List<Article>> yearArticleMap = new HashMap<>(8);
        articles.forEach(article -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(article.getCreateTime());
            yearArticleMap.computeIfAbsent(calendar.get(Calendar.YEAR), year -> new LinkedList<>())
                    .add(article);
        });

        List<ArticleYearVO> archives = new LinkedList<>();

        yearArticleMap.forEach((year, articleList) -> {
            // Build archive
            ArticleYearVO archive = new ArticleYearVO();
            archive.setYear(year);
            archive.setArticles(articleList);

            // Add archive
            archives.add(archive);
        });

        // Sort this list
        archives.sort(new ArticleYearVO.ArchiveComparator());

        return archives;
    }

    /**
     * 使用分页插件完成分页
     *
     * @param pageParam
     * @return
     */
    private PageInfo<Article> getPageInfo(PageParam pageParam) {
        int pageNum = pageParam.getPageNum();
        int pageSize = pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> all = articleMapper.selectAll();
        return new PageInfo<>(all);
    }

    @Deprecated
    private PageInfo<ArticleTagsVO> getPageInfo2(PageParam pageParam) {
        int pageNum = pageParam.getPageNum();
        int pageSize = pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleTagsVO> all = articleMapper.selectAllWithTags();
        return new PageInfo<>(all);
    }
}
