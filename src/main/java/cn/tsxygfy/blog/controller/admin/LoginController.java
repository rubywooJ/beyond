package cn.tsxygfy.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.controller.admin
 * @since 2020-02-29 22:45:55
 */
@Controller
public class LoginController {

    @GetMapping("/admin")
    public String adminLogin() {
        return "redirect:/admin/index.html";
    }

}
