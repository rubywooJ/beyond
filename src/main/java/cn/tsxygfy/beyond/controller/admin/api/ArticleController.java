package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.model.dto.PageParam;
import cn.tsxygfy.beyond.model.dto.PageResult;
import cn.tsxygfy.beyond.model.po.Article;
import cn.tsxygfy.beyond.model.po.Tag;
import cn.tsxygfy.beyond.model.vo.ArticleTagsVO;
import cn.tsxygfy.beyond.service.ArticleService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("分页查询全部文章")
    @GetMapping
    public PageResult getAll(PageParam pageParam) {
        Assert.notNull(pageParam, "Page param must be not null.");
        return articleService.fndAllWithTagsByPage(pageParam);
    }

    @ApiOperation("根据文章id查对应的文章")
    @GetMapping("{id:\\d+}")
    public Article getById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }

    @ApiOperation("查询对应id文章下的所有标签")
    @GetMapping("tags/{id:\\d+}")
    public List<Tag> getTagsByArticleId(@PathVariable Long id) {
        return articleService.getTags(id);
    }

    @ApiOperation("发布一个文章")
    @PostMapping
    public ArticleTagsVO createArticle(@RequestBody ArticleTagsVO articleTagsVO) {
        Assert.isNull(articleTagsVO.getId(), "New article id must be empty");
        return articleService.createOrUpdateArticle(articleTagsVO);
    }

    @ApiOperation("根据id修改文章")
    @PutMapping("{id:\\d+}")
    public ArticleTagsVO updateArticle(@PathVariable Long id, @RequestBody ArticleTagsVO articleTagsVO) {
        articleTagsVO.setId(id);
        return articleService.createOrUpdateArticle(articleTagsVO);
    }

    @ApiOperation("根据id删除文章")
    @DeleteMapping("{id:\\d+}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

}
