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

@Controller
@RequestMapping("/archives")
public class ArchivesController extends BaseController {

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
