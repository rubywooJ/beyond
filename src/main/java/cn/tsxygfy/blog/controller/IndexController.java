package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.Application;
import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.model.dto.PageParam;
import cn.tsxygfy.blog.model.dto.PageResult;
import cn.tsxygfy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController extends BaseController {

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

    @PostMapping("/shutdown")
    @ResponseBody
    public String shutdown(String key, HttpServletResponse response) {
        Assert.hasText(key, "key is not available");
        Assert.state("yes".equals(key), "key is not available");
        try {
            response.setContentType("application/json;charset=utf-8");
            return "{\"message\":\"Shutting down, bye...\"}";
        } finally {
            Application.shutdown();
        }
    }

    @PostMapping("/restart")
    @ResponseBody
    public String restart(String key, HttpServletResponse response) {
        Assert.hasText(key, "key is not available");
        Assert.state("yes".equals(key), "key is not available");
        try {
            response.setContentType("application/json;charset=utf-8");
            return "{\"message\":\"Application is restarting...Please wait a moment.\"}";
        } finally {
            Application.restart();
        }
    }

    @GetMapping("/version")
    @ResponseBody
    public String version() {
        return BeyondConst.BEYOND_VERSION;
    }
}
