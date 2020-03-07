package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.exception.BadRequestException;
import cn.tsxygfy.blog.exception.NotFoundException;
import cn.tsxygfy.blog.model.dto.AuthToken;
import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.model.po.User;
import cn.tsxygfy.blog.service.AdminService;
import cn.tsxygfy.blog.service.UserService;
import cn.tsxygfy.blog.util.EmailUtil;
import cn.tsxygfy.blog.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:04:18
 * @see cn.tsxygfy.blog.service.impl
 *
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
        String token = JwtUtil.createJwt(user.getId().toString(), user.getUsername());
        AuthToken authToken = new AuthToken();
        authToken.setAssesToken(token);
        authToken.setExpiredIn(3600 * 24 * 7 * 1000);
        return authToken;
    }
}
