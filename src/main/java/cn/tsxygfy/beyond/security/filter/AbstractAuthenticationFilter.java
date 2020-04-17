package cn.tsxygfy.beyond.security.filter;

import cn.tsxygfy.beyond.security.context.SecurityContextHolder;
import cn.tsxygfy.beyond.security.handler.AuthenticationFailureHandler;
import cn.tsxygfy.beyond.security.handler.DefaultAuthenticationFailureHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.security.filter
 * @since 2020-03-08 21:25:48
 */
@Slf4j
public abstract class AbstractAuthenticationFilter extends OncePerRequestFilter {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    private AuthenticationFailureHandler authenticationFailureHandler;

    private Set<String> excludeUrlPatterns = new HashSet<>(2);

    @Nullable
    protected abstract String getTokenFromRequest(@NonNull HttpServletRequest request);

    protected abstract void doAuthenticate(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (shouldNotFilter(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            doAuthenticate(request, response, filterChain);
        } finally {
            // ???
            SecurityContextHolder.clearContext();
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        Assert.notNull(request, "Request must not be null");
        return excludeUrlPatterns.stream().anyMatch(url -> antPathMatcher.match(url, request.getServletPath()));
    }

    public void addExcludeUrlPatterns(@NonNull String... excludeUrlPatterns) {
        Assert.notNull(excludeUrlPatterns, "Exclude url patterns must not be null");
        Collections.addAll(this.excludeUrlPatterns, excludeUrlPatterns);
    }

    String getTokenFromRequest(HttpServletRequest request, String headerName) {
        String accessKey = request.getHeader(headerName);
        log.info("Got access key from header: [{}: {}]", headerName, accessKey);
        return accessKey;
    }

    // ===================================================================================
    // ============================    getters and setters    ============================
    // ===================================================================================

    public Set<String> getExcludeUrlPatterns() {
        return excludeUrlPatterns;
    }

    public void setExcludeUrlPatterns(Set<String> excludeUrlPatterns) {
        this.excludeUrlPatterns = excludeUrlPatterns;
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        if (this.authenticationFailureHandler == null) {
            authenticationFailureHandler = new DefaultAuthenticationFailureHandler();
        }
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
}
