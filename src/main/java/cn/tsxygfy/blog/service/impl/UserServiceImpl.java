package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.exception.NotFoundException;
import cn.tsxygfy.blog.mapper.UserMapper;
import cn.tsxygfy.blog.model.po.User;
import cn.tsxygfy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author feiyang
 * @version v1.0
 * @className UserServiceImpl
 * @description
 * @date 2020/01/30 周四 23:03
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
        // return StringUtils.hasText(password) && user.getPassword().equals(password);
        return password.equals("1");
    }
}
