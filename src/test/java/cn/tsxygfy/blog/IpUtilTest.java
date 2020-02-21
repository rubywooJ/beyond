package cn.tsxygfy.blog;

import cn.tsxygfy.blog.util.IpUtil;
import org.junit.Test;

public class IpUtilTest {
    @Test
    public void getIpTest() {
        String machineIp = IpUtil.getMachineIp();
        System.out.println(machineIp);
    }
}
