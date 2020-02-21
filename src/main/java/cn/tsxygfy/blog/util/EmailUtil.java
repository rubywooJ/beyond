package cn.tsxygfy.blog.util;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:06:22
 * @see cn.tsxygfy.blog.util
 *
 */
public class EmailUtil {

    private EmailUtil() {
    }

    public static boolean isEmail(String email) {
        return email.matches("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$\n");
    }
}
