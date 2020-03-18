package cn.tsxygfy.beyond.security.filter;


import cn.tsxygfy.beyond.cache.store.InMemoryCacheStore;
import cn.tsxygfy.beyond.exception.AuthenticationException;
import cn.tsxygfy.beyond.model.po.User;
import cn.tsxygfy.beyond.security.authentication.AuthenticationImpl;
import cn.tsxygfy.beyond.security.context.SecurityContextHolder;
import cn.tsxygfy.beyond.security.context.SecurityContextImpl;
import cn.tsxygfy.beyond.security.support.UserDetail;
import cn.tsxygfy.beyond.service.UserService;
import cn.tsxygfy.beyond.util.SecurityUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static cn.tsxygfy.beyond.core.BeyondConst.ADMIN_TOKEN_HEADER_NAME;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.security.filter
 * @since 2020-03-08 21:27:25
 */
public class AdminAuthenticationFilter extends AbstractAuthenticationFilter {

    private InMemoryCacheStore inMemoryCacheStore;

    private UserService userService;

    public AdminAuthenticationFilter(InMemoryCacheStore inMemoryCacheStore, UserService userService) {
        this.inMemoryCacheStore = inMemoryCacheStore;
        this.userService = userService;
    }

    @Override
    protected String getTokenFromRequest(HttpServletRequest request) {
        return getTokenFromRequest(request, ADMIN_TOKEN_HEADER_NAME);
    }

    @Override
    protected void doAuthenticate(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // token
        String token = getTokenFromRequest(request);

        if (StringUtils.isBlank(token)) {
            getAuthenticationFailureHandler().onFailure(request, response, new AuthenticationException("You have not logged in. Please login first."));
            return;
        }

        // 从缓存中查 token 是否存在 得到 user id
        Optional<Long> optionalUserId = inMemoryCacheStore.getAny(SecurityUtil.buildTokenAccessKey(token), Long.class);
        if (!optionalUserId.isPresent()) {
            getAuthenticationFailureHandler().onFailure(request, response, new AuthenticationException("Token has expired or does not exist"));
            return;
        }
        // 根据 user id 查 user
        User user = userService.getById(optionalUserId.get());
        // 设置 context上下文
        SecurityContextHolder.setContext(new SecurityContextImpl(new AuthenticationImpl(new UserDetail(user))));
        // 执行过滤器链
        filterChain.doFilter(request, response);
    }
}
