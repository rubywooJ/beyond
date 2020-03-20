package cn.tsxygfy.beyond.properties;

import cn.tsxygfy.beyond.core.BeyondConst;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static cn.tsxygfy.beyond.core.BeyondConst.FILE_SEPARATOR;
import static cn.tsxygfy.beyond.core.BeyondConst.USER_HOME;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.properties
 * @since 2020-02-21 15:04:00
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "beyond.config")
public class BeyondProperties {

    private boolean openAopLog = true;

    /**
     * 从该请求头中获取 token  默认 API-Authorization
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
    private Long ttl = 3600 * 24 * 7L;

    /**
     * Admin path.
     */
    private String adminPath = "admin";

    /**
     * work dir {user.home}/.beyond/
     */
    private String workDir = USER_HOME + FILE_SEPARATOR + ".beyond" + FILE_SEPARATOR;

    public BeyondProperties() throws IOException {
        Files.createDirectories(Paths.get(workDir));
    }
}
