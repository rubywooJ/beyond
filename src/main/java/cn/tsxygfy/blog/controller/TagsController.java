package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.TagArticlesVO;
import cn.tsxygfy.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:00:02
 * @see cn.tsxygfy.blog.controller
 *
 */
@Controller
@RequestMapping("/tags")
public class TagsController extends BaseController {

    @Autowired
    private TagsService tagsService;

    @GetMapping
    public String tags() {
        return BASE_DIR + "tags";
    }

    @GetMapping("/{name}")
    public String showOne(@PathVariable String name, Model model, HttpServletResponse response) {
        // 先看有无这个标签
        Tag tag = tagsService.findTagIfExist(name);
        if (tag == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return BASE_DIR + "404";
        }
        List<TagArticlesVO> vos = tagsService.findArticlesByTagName(name);
        model.addAttribute("tag", tag);
        model.addAttribute("posts", vos);
        return BASE_DIR + "tag";
    }
}
