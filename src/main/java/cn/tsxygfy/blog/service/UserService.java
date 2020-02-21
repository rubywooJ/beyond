package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.po.User;

import java.util.Optional;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:49
 * @see cn.tsxygfy.blog.service
 *
 */
public interface UserService {

    Optional<User> getCurrentUser();

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    User getByUsernameOfNonNull(String username);

    User getByEmailOfNonNull(String email);

    boolean passwordMatch(User user, String password);
}
