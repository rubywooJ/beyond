package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.exception.BadRequestException;
import cn.tsxygfy.beyond.exception.NotFoundException;
import cn.tsxygfy.beyond.model.dto.LoginParam;
import cn.tsxygfy.beyond.model.po.User;
import cn.tsxygfy.beyond.security.authentication.Authentication;
import cn.tsxygfy.beyond.security.context.SecurityContextHolder;
import cn.tsxygfy.beyond.security.token.AuthToken;
import cn.tsxygfy.beyond.service.AdminService;
import cn.tsxygfy.beyond.service.UserService;
import cn.tsxygfy.beyond.util.BeyondUtil;
import cn.tsxygfy.beyond.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-02-21 15:04:18
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

        // 密码比对
        if (!userService.passwordMatch(user, loginParam.getPassword())) {
            throw new BadRequestException("Wrong with username or password!");
        }
        // 之前还没登录、重复登录
        if (SecurityContextHolder.getContext().isAuthenticated()) {
            throw new BadRequestException("You had logged in. Don't repeat login");
        }
        // 构建token并返回
        return buildAuthToken(user);
    }

    @Override
    public void clearToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new BadRequestException("You are not logged in. Can't log out");
        }

        User user = authentication.getUserDetail().getUser();
        //TODO 清除缓存中的 access_token  refresh_token

    }

    @Override
    public AuthToken refreshToken(String refreshToken) {
        Assert.hasText(refreshToken, "Refresh token must not be blank");
        //TODO 从缓存中取 userId 判断是否已过期 过期则重新登录
        Long userId = 1L;
        // 没有过期
        User user = userService.getById(userId);

        // 清空缓存


        return buildAuthToken(user);
    }

    private AuthToken buildAuthToken(User user) {
        AuthToken authToken = new AuthToken();
        authToken.setAssesToken(BeyondUtil.buildUUIDWithoutDash());
        authToken.setExpiredIn(ACCESS_TOKEN_EXPIRE_SECOND);
        authToken.setRefreshToken(BeyondUtil.buildUUIDWithoutDash());
        //TODO 存 token 进缓存
        return authToken;
    }
}
