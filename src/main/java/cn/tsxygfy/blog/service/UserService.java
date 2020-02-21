package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.po.User;

import java.util.Optional;

/**
 * @author feiyang
 * @version v1.0
 * @interfaceName UserService
 * @description
 * @date 2020/01/30 周四 23:03
 */
public interface UserService {

    Optional<User> getCurrentUser();

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    User getByUsernameOfNonNull(String username);

    User getByEmailOfNonNull(String email);

    boolean passwordMatch(User user, String password);
}
