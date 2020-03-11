package cn.tsxygfy.blog.security.filter;


import cn.tsxygfy.blog.exception.AuthenticationException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.tsxygfy.blog.core.BeyondConst.ADMIN_TOKEN_HEADER_NAME;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.security.filter
 * @since 2020-03-08 21:27:25
 */
public class AdminAuthenticationFilter extends AbstractAuthenticationFilter {

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

        // TODO 认证
        // 从缓存中查 token 是否存在 得到 user id

        // 根据 user id 查 user

        // 构造 UserDetail

        // 设置 context上下文

        // 执行过滤器链

    }
}
