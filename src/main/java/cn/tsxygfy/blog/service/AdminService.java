package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.dto.AuthToken;
import cn.tsxygfy.blog.model.dto.LoginParam;

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
    AuthToken authenticate(LoginParam loginParam);
}
