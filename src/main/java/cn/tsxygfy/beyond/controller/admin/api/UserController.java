package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.model.dto.UserInfo;
import cn.tsxygfy.beyond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.controller.admin.api
 * @since 2020-03-22 15:30:55
 */
@RestController
@RequestMapping("api/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("info")
    public UserInfo getUserInfo() {
        return userService.getUserInfo();
    }

}
