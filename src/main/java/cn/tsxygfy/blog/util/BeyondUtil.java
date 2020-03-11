package cn.tsxygfy.blog.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.util
 * @since 2020-03-08 21:42:49
 */
public class BeyondUtil {

    private BeyondUtil() {
    }

    public static String buildUUIDWithoutDash() {
        return StringUtils.remove(UUID.randomUUID().toString(), "-");
    }
}
