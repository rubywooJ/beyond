package cn.tsxygfy.blog.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author feiyang
 * @version v1.0
 * @className AuthToken
 * @description
 * @date 2020/02/09 周日 20:36
 */
@Data
public class AuthToken {

    @JsonProperty("asses_token")
    private String assesToken;

    @JsonProperty("expired_in")
    private int expiredIn;
}
