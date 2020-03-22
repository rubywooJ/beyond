package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.cache.store.InMemoryCacheStore;
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
import cn.tsxygfy.beyond.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

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

    @Autowired
    private InMemoryCacheStore inMemoryCacheStore;

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

        inMemoryCacheStore.getAny(SecurityUtil.buildAccessTokenKey(user), String.class).ifPresent(aToken -> {
            inMemoryCacheStore.delete(SecurityUtil.buildTokenAccessKey(aToken));
            inMemoryCacheStore.delete(SecurityUtil.buildAccessTokenKey(user));
        });
        inMemoryCacheStore.getAny(SecurityUtil.buildRefreshTokenKey(user), String.class).ifPresent(rToken -> {
            inMemoryCacheStore.delete(SecurityUtil.buildTokenRefreshKey(rToken));
            inMemoryCacheStore.delete(SecurityUtil.buildRefreshTokenKey(user));
        });

        log.info("you have been logged out.");
    }

    @Override
    public AuthToken refreshToken(String refreshToken) {
        Assert.hasText(refreshToken, "Refresh token must not be blank");

        Long userId = inMemoryCacheStore.getAny(SecurityUtil.buildTokenRefreshKey(refreshToken), Long.class).orElseThrow(() ->
                new BadRequestException("Login status has expired, please login again"));
        // 没有过期
        User user = userService.getById(userId);
        // 删除token
        inMemoryCacheStore.getAny(SecurityUtil.buildAccessTokenKey(user), String.class).ifPresent(accessToken ->
                inMemoryCacheStore.delete(SecurityUtil.buildTokenAccessKey(accessToken)));
        inMemoryCacheStore.delete(SecurityUtil.buildTokenRefreshKey(refreshToken));
        inMemoryCacheStore.delete(SecurityUtil.buildAccessTokenKey(user));
        inMemoryCacheStore.delete(SecurityUtil.buildRefreshTokenKey(user));

        return buildAuthToken(user);
    }

    private AuthToken buildAuthToken(User user) {
        AuthToken authToken = new AuthToken();
        authToken.setAccessToken(BeyondUtil.buildUUIDWithoutDash());
        authToken.setExpiredIn(ACCESS_TOKEN_EXPIRE_SECOND);
        authToken.setRefreshToken(BeyondUtil.buildUUIDWithoutDash());
        // 将tokens放入缓存
        inMemoryCacheStore.putAny(SecurityUtil.buildAccessTokenKey(user), authToken.getAccessToken(), ACCESS_TOKEN_EXPIRE_SECOND, TimeUnit.SECONDS);
        inMemoryCacheStore.putAny(SecurityUtil.buildRefreshTokenKey(user), authToken.getRefreshToken(), REFRESH_TOKEN_EXPIRE_DAY, TimeUnit.DAYS);
        inMemoryCacheStore.putAny(SecurityUtil.buildTokenAccessKey(authToken.getAccessToken()), user.getId(), ACCESS_TOKEN_EXPIRE_SECOND, TimeUnit.SECONDS);
        inMemoryCacheStore.putAny(SecurityUtil.buildTokenRefreshKey(authToken.getRefreshToken()), user.getId(), REFRESH_TOKEN_EXPIRE_DAY, TimeUnit.DAYS);
        return authToken;
    }
}
