package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.model.dto.PageParam;
import cn.tsxygfy.blog.model.dto.PageResult;
import cn.tsxygfy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.controller
 * @since 2020-03-06 20:48:45
 */
@Controller
public class ContentIndexController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @GetMapping({"/", ""})
    public String index(Model model) {
        return index(model, 1);
    }

    @GetMapping("/page/{page}")
    public String index(Model model, @PathVariable Integer page) {
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(page);
        pageParam.setPageSize(PAGE_SIZE);
        PageResult pageResult = articleService.fndAllWithTagsByPage(pageParam);
        Map<String, Object> map = new HashMap<>();
        map.put("content", pageResult.getContent());
        map.put("totalPages", pageResult.getTotalPages());
        map.put("pageNum", pageResult.getPageNum());
        model.addAttribute("posts", map);

        return BASE_DIR + "index";
    }

    @GetMapping("/favicon.ico")
    public void favicon(HttpServletResponse response) throws IOException {
        response.sendRedirect(THEME_DIR + "static/images/favicon.ico");
    }

    @GetMapping("/version")
    @ResponseBody
    public String version() {
        return BeyondConst.BEYOND_VERSION;
    }
}
