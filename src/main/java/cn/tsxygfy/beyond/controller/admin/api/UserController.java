package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.model.dto.BaseResponse;
import cn.tsxygfy.beyond.model.dto.ModifyPasswordParam;
import cn.tsxygfy.beyond.model.dto.UserInfo;
import cn.tsxygfy.beyond.service.UserService;
import io.swagger.annotations.ApiOperation;
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
 * @see cn.tsxygfy.beyond.controller.admin.api
 * @since 2020-03-22 15:30:55
 */
@RestController
@RequestMapping("api/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("获取当前用户的信息")
    @GetMapping("info")
    public UserInfo getUserInfo() {
        return userService.getUserInfo();
    }

    @ApiOperation("修改用户密码")
    @PostMapping("restPassword")
    public BaseResponse<String> modifyPassword(@RequestBody ModifyPasswordParam param) {
        Assert.isTrue(param.getNewPassword().equals(param.getConfirmPassword()), "Passwords entered twice are inconsistent。");
        userService.modifyPassword(param);
        return BaseResponse.ok("You have successfully changed your password, please log in again。");
    }

}
