package cn.tsxygfy.blog.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author feiyang
 * @version v1.0
 * @className ErrorPageController
 * @description
 * @date 2020/02/02 周日 21:46
 */
@Controller
public class ErrorPageController extends BaseController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404) {
            return BASE_DIR + "404";
        } else {
            return BASE_DIR + "500";
        }
    }
}
