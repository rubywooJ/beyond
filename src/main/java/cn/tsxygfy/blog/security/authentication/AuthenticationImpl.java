package cn.tsxygfy.blog.security.authentication;

import cn.tsxygfy.blog.security.support.UserDetail;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.security.authentication
 * @since 2020-03-08 21:36:04
 */
public class AuthenticationImpl implements Authentication {

    private final UserDetail userDetail;

    public AuthenticationImpl(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public UserDetail getUserDetail() {
        return this.userDetail;
    }
}
