package cn.tsxygfy.blog.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:03:09
 * @see cn.tsxygfy.blog.model.pojo
 *
 */
@Data
public class AuthToken {

    @JsonProperty("asses_token")
    private String assesToken;

    @JsonProperty("expired_in")
    private int expiredIn;
}
