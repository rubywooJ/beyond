package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.dto.ModifyPasswordParam;
import cn.tsxygfy.beyond.model.dto.UserInfo;
import cn.tsxygfy.beyond.model.po.User;

import java.util.Optional;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-02-21 15:05:49
 */
public interface UserService {

    Optional<User> getCurrentUser();

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    User getByUsernameOfNonNull(String username);

    User getByEmailOfNonNull(String email);

    boolean passwordMatch(User user, String password);

    User getById(Long userId);

    UserInfo getUserInfo();

    void modifyPassword(ModifyPasswordParam param);
}
