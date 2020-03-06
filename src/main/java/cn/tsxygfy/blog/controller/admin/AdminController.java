package cn.tsxygfy.blog.controller.admin;

import cn.tsxygfy.blog.Application;
import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.model.pojo.AuthToken;
import cn.tsxygfy.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.controller.admin
 * @since 2020-02-29 22:45:31
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("login")
    public AuthToken login(@RequestBody LoginParam loginParam) {
        return adminService.authenticate(loginParam);
    }

    @PostMapping("/beyond-shutdown")
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

    @PostMapping("/beyond-restart")
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
}
