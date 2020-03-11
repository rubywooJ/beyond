package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.Application;
import cn.tsxygfy.beyond.model.dto.LoginParam;
import cn.tsxygfy.beyond.security.token.AuthToken;
import cn.tsxygfy.beyond.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.controller.admin
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

    @PostMapping("logout")
    public void logout() {
        adminService.clearToken();
    }

    @PostMapping("refresh/{refreshToken}")
    public AuthToken refresh(@PathVariable String refreshToken) {
        return adminService.refreshToken(refreshToken);
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
