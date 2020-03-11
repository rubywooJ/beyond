package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.model.dto.PageParam;
import cn.tsxygfy.beyond.model.dto.PageResult;
import cn.tsxygfy.beyond.model.po.Article;
import cn.tsxygfy.beyond.model.po.Tag;
import cn.tsxygfy.beyond.model.vo.ArticleTagsVO;
import cn.tsxygfy.beyond.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.controller.admin
 * @since 2020-03-06 21:20:18
 */
@RestController
@RequestMapping("/api/admin/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public PageResult getAll(PageParam pageParam) {
        Assert.notNull(pageParam, "Page param must be not null.");
        return articleService.fndAllWithTagsByPage(pageParam);
    }

    @GetMapping("{id:\\d+}")
    public Article getById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }

    @GetMapping("tags/{id:\\d+}")
    public List<Tag> getTagsByArticleId(@PathVariable Long id) {
        return articleService.getTags(id);
    }

    @PostMapping
    public ArticleTagsVO createArticle(@RequestBody ArticleTagsVO articleTagsVO) {
        Assert.isNull(articleTagsVO.getId(), "New article id must be empty");
        return articleService.createOrUpdateArticle(articleTagsVO);
    }

    @PutMapping("{id:\\d+}")
    public ArticleTagsVO updateArticle(@PathVariable Long id, @RequestBody ArticleTagsVO articleTagsVO) {
        articleTagsVO.setId(id);
        return articleService.createOrUpdateArticle(articleTagsVO);
    }

    @DeleteMapping("{id:\\d+}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

}
