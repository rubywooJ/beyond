package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.cache.store.InMemoryCacheStore;
import cn.tsxygfy.beyond.exception.NotFoundException;
import cn.tsxygfy.beyond.exception.NotMatchException;
import cn.tsxygfy.beyond.mapper.UserMapper;
import cn.tsxygfy.beyond.model.dto.ModifyPasswordParam;
import cn.tsxygfy.beyond.model.dto.UserInfo;
import cn.tsxygfy.beyond.model.po.User;
import cn.tsxygfy.beyond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-02-21 15:05:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InMemoryCacheStore inMemoryCacheStore;

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
        // md5 密码比对
        String uPwd = DigestUtils.md5DigestAsHex(password.getBytes());
        return StringUtils.hasText(password) && user.getPassword().equals(uPwd);
    }

    @Override
    public User getById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserInfo getUserInfo() {
        Optional<User> user = getCurrentUser();
        if (!user.isPresent()) {
            throw new NotFoundException("No user exist.");
        }
        return new UserInfo(user.get());
    }

    @Override
    public void modifyPassword(ModifyPasswordParam param) {
        // 对比原密码
        String oldPassword = param.getOldPassword();
        User user = getCurrentUser().orElseThrow(() -> new NotFoundException("Current user not found."));
        if (!passwordMatch(user, oldPassword)) {
            throw new NotMatchException("Old password not match.").setErrorData(param.getOldPassword());
        }
        // 修改密码
        String newPassword = DigestUtils.md5DigestAsHex(param.getNewPassword().getBytes());
        user.setPassword(newPassword);
        userMapper.updateByPrimaryKey(user);
        // 使token失效
        inMemoryCacheStore.preDestroy();
    }
}
