package cn.tsxygfy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.controller
 * @since 2020-03-06 20:55:03
 */
@Controller
@RequestMapping("/links")
public class ContentLinksController extends ContentBaseController {

    @GetMapping
    public String links() {
        return BASE_DIR + "links";
    }

}
