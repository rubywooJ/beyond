package cn.tsxygfy.blog.security.authentication;

import cn.tsxygfy.blog.security.support.UserDetail;
import org.springframework.lang.NonNull;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.security.authentication
 * @since 2020-03-08 21:33:25
 */
public interface Authentication {

    @NonNull
    UserDetail getUserDetail();

}
