package cn.tsxygfy.blog.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.util
 * @since 2020-02-21 15:15:36
 */
public class IpUtil {

    private IpUtil() {
    }

    public static String getMachineIp() {
        InetAddress machineAddress;
        try {
            machineAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            machineAddress = InetAddress.getLoopbackAddress();
        }
        return machineAddress.getHostAddress();
    }

}
