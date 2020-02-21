package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.exception.BadRequestException;
import cn.tsxygfy.blog.exception.NotFoundException;
import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.model.po.User;
import cn.tsxygfy.blog.model.pojo.AuthToken;
import cn.tsxygfy.blog.service.AdminService;
import cn.tsxygfy.blog.service.UserService;
import cn.tsxygfy.blog.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author feiyang
 * @version v1.0
 * @className AdminServiceImpl
 * @description
 * @date 2020/02/09 周日 15:36
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserService userService;

    @Override
    public AuthToken authenticate(LoginParam loginParam) {
        Assert.notNull(loginParam, "Login param must not be null.");

        String username = loginParam.getUsername();

        final User user;

        try {
            user = EmailUtil.isEmail(username) ?
                    userService.getByEmailOfNonNull(username) : userService.getByUsernameOfNonNull(username);
        } catch (NotFoundException e) {
            throw new BadRequestException("Wrong with username or password!");
        }
        // 账户没有过期
        // userService.mustNotExpire(user);
        // 密码比对
        if (!userService.passwordMatch(user, loginParam.getPassword())) {
            throw new BadRequestException("Wrong with username or password!");
        }
        // 之前还没登录、重复登录

        // 构建token并返回
        return buildAuthToken(user);
    }

    private AuthToken buildAuthToken(User user) {
        AuthToken authToken = new AuthToken();
        authToken.setAssesToken("asses-token");
        authToken.setExpiredIn(123 * 321);
        return authToken;
    }
}
