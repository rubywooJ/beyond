package cn.tsxygfy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/links")
public class LinksController extends BaseController {

    @GetMapping
    public String links() {
        return BASE_DIR + "links";
    }

}
