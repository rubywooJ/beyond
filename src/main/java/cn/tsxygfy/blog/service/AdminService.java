package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.security.token.AuthToken;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:07
 * @see cn.tsxygfy.blog.service
 *
 */
public interface AdminService {

    int ACCESS_TOKEN_EXPIRE_SECOND = 24 * 3600;

    int REFRESH_TOKEN_EXPIRE_DAY = 30;

    AuthToken authenticate(LoginParam loginParam);

    void clearToken();

    AuthToken refreshToken(String refreshToken);
}
