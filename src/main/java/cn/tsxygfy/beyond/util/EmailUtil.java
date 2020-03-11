package cn.tsxygfy.beyond.util;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.util
 * @since 2020-02-21 15:06:22
 */
public class EmailUtil {

    private EmailUtil() {
    }

    public static boolean isEmail(String email) {
        return email.matches("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$\n");
    }
}
