package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.Application;
import cn.tsxygfy.beyond.model.dto.BlogInfo;
import cn.tsxygfy.beyond.model.dto.LoginParam;
import cn.tsxygfy.beyond.security.token.AuthToken;
import cn.tsxygfy.beyond.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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

    @ApiOperation("获取博客信息")
    @GetMapping("info")
    public BlogInfo getBlogInfo() {
        return adminService.getBlogInfo();
    }

    @ApiOperation("用户登录")
    @PostMapping("login")
    public AuthToken login(@RequestBody LoginParam loginParam) {
        Assert.notNull(loginParam, "Username or password must be not null!");
        return adminService.authenticate(loginParam);
    }

    @ApiOperation("用户登出")
    @PostMapping("logout")
    public void logout() {
        adminService.clearToken();
    }

    @ApiOperation("刷新token")
    @PostMapping("refresh/{refreshToken}")
    public AuthToken refresh(@PathVariable String refreshToken) {
        return adminService.refreshToken(refreshToken);
    }

    @ApiOperation("关闭应用")
    @PostMapping("beyond-shutdown")
    public String shutdown() {
        try {
            return "{\"message\":\"Shutting down, bye...\"}";
        } finally {
            Application.shutdown();
        }
    }

    @ApiOperation("重启应用")
    @PostMapping("beyond-restart")
    public String restart() {
        try {
            return "{\"message\":\"Application is restarting...Please wait a moment.\"}";
        } finally {
            Application.restart();
        }
    }
}
