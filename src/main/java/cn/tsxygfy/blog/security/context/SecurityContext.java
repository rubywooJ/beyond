package cn.tsxygfy.blog.security.context;

import cn.tsxygfy.blog.security.authentication.Authentication;
import org.springframework.lang.Nullable;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.security.context
 * @since 2020-03-08 21:29:33
 */
public interface SecurityContext {

    @Nullable
    Authentication getAuthentication();

    void setAuthentication(@Nullable Authentication authentication);

    default boolean isAuthenticated() {
        return getAuthentication() != null;
    }
}

