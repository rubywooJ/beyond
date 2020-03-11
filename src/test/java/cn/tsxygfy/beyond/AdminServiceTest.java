package cn.tsxygfy.beyond;

import cn.tsxygfy.beyond.model.po.User;
import cn.tsxygfy.beyond.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author feiyang
 * @version v1.0
 * @className AdminServiceTest
 * @description
 * @date 2020/02/09 周日 16:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void TestGetByUsername() {
        User beyond = userService.getByUsernameOfNonNull("beyond1");
        System.out.println(beyond);
    }
}
