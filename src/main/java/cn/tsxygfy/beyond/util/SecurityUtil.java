package cn.tsxygfy.beyond.util;

import cn.tsxygfy.beyond.model.po.User;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.util
 * @since 2020-03-18 13:06:44
 */
public class SecurityUtil {

    private SecurityUtil() {
    }

    private static final String ACCESS_TOKEN_CACHE_PREFIX = "beyond.admin.access_token";
    private static final String REFRESH_TOKEN_CACHE_PREFIX = "beyond.admin.refresh_token";

    private static final String TOKEN_ACCESS_CACHE_PREFIX = "beyond.admin.access.token";
    private static final String TOKEN_REFRESH_CACHE_PREFIX = "beyond.admin.refresh.token";

    public static String buildAccessTokenKey(User user) {
        return ACCESS_TOKEN_CACHE_PREFIX + user.getId();
    }

    public static String buildRefreshTokenKey(User user) {
        return REFRESH_TOKEN_CACHE_PREFIX + user.getId();
    }

    public static String buildTokenAccessKey(String token) {
        return TOKEN_ACCESS_CACHE_PREFIX + token;
    }

    public static String buildTokenRefreshKey(String token) {
        return TOKEN_REFRESH_CACHE_PREFIX + token;
    }
}
