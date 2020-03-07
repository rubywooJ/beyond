package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.exception.NotFoundException;
import cn.tsxygfy.blog.mapper.UserMapper;
import cn.tsxygfy.blog.model.po.User;
import cn.tsxygfy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:01
 * @see cn.tsxygfy.blog.service.impl
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> getCurrentUser() {
        List<User> users = userMapper.selectAll();
        if (CollectionUtils.isEmpty(users)) {
            return Optional.empty();
        }

        return Optional.of(users.get(0));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        User user = userMapper.selectByUserName(username);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        User user = userMapper.selectByEmail(email);
        return Optional.ofNullable(user);
    }

    @Override
    public User getByUsernameOfNonNull(String username) {
        return getByUsername(username).orElseThrow(() -> new NotFoundException("The username does not exist.").setErrorData(username));
    }

    @Override
    public User getByEmailOfNonNull(String email) {
        return getByEmail(email).orElseThrow(() -> new NotFoundException("The email does not exist.").setErrorData(email));
    }

    @Override
    public boolean passwordMatch(User user, String password) {
        Assert.notNull(user, "User must be not null.");
        //TODO 密码比对
        return StringUtils.hasText(password) && user.getPassword().equals(password);
    }
}
