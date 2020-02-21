package cn.tsxygfy.blog.controller.admin;

import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.model.pojo.AuthToken;
import cn.tsxygfy.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
