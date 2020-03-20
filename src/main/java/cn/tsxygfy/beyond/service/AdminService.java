package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.dto.LoginParam;
import cn.tsxygfy.beyond.security.token.AuthToken;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-02-21 15:05:07
 */
public interface AdminService {

    /**
     * access_token 过期时间 一天
     */
    int ACCESS_TOKEN_EXPIRE_SECOND = 24 * 3600;

    /**
     * refresh_token 过期时间 三十天
     */
    int REFRESH_TOKEN_EXPIRE_DAY = 30;

    AuthToken authenticate(LoginParam loginParam);

    void clearToken();

    AuthToken refreshToken(String refreshToken);
}
