package cn.tsxygfy.blog.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * <p>
 * Description: ErrorPageController
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 14:59:27
 * @see cn.tsxygfy.blog.controller
 *
 */
@Controller
public class ErrorPageController extends ContentBaseController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404) {
            return BASE_DIR + "404";
        } else {
            return BASE_DIR + "500";
        }
    }
}
