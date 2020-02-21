package cn.tsxygfy.blog.util;

/**
 * @author feiyang
 * @version v1.0
 * @className EmailUtil
 * @description
 * @date 2020/02/09 周日 16:33
 */
public class EmailUtil {

    private EmailUtil() {
    }

    public static boolean isEmail(String email) {
        return email.matches("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$\n");
    }
}
