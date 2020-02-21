package cn.tsxygfy.blog.properties;

import cn.tsxygfy.blog.core.BeyondConst;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.properties
 * @since 2020-02-21 15:04:00
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "beyond.config")
public class BeyondProperties {

    private boolean openAopLog = true;

    /**
     * 从该请求头中获取 token  默认 Authorization
     */
    private String header = BeyondConst.API_ACCESS_KEY_HEADER_NAME;

    /**
     * 解析token的前缀 默认无
     */
    private String prefix = "";

    /**
     * 秘钥  默认 beyond
     */
    private String key = "beyond";

    /**
     * 过期时间  默认7天 单位 秒s
     */
    private Long ttl = 3600*24*7L;

    /**
     * Admin path.
     */
    private String adminPath = "admin";

}
