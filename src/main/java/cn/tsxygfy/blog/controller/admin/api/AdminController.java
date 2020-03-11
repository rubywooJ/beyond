package cn.tsxygfy.blog.controller.admin.api;

import cn.tsxygfy.blog.Application;
import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.security.token.AuthToken;
import cn.tsxygfy.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("login")
    public AuthToken login(@RequestBody LoginParam loginParam) {
        return adminService.authenticate(loginParam);
    }

    @PostMapping("beyond-shutdown")
    public String shutdown() {
        try {
            return "{\"message\":\"Shutting down, bye...\"}";
        } finally {
            Application.shutdown();
        }
    }

    @PostMapping("beyond-restart")
    public String restart() {
        try {
            return "{\"message\":\"Application is restarting...Please wait a moment.\"}";
        } finally {
            Application.restart();
        }
    }
}
