package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.model.vo.ArticleTagsVO;
import cn.tsxygfy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.controller
 * @since 2020-03-06 20:54:57
 */
@Controller
@RequestMapping("/archives")
public class ContentArchivesController extends ContentBaseController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String archives() {

        return BASE_DIR + "archives";
    }

    @GetMapping("/{title}")
    public String showOne(@PathVariable String title, Model model, HttpServletResponse response) {
        ArticleTagsVO vo = articleService.findArticleWithTagsByTitle(title);
        // TODO 下个版本优化处理404逻辑
        if (vo == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return BASE_DIR + "404";
        }
        model.addAttribute("post", vo);
        return BASE_DIR + "post";
    }
}
