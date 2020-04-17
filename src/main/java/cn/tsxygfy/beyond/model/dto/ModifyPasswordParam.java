package cn.tsxygfy.beyond.model.dto;

import lombok.Data;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.model.dto
 * @since 2020-04-06 16:46:17
 */
@Data
public class ModifyPasswordParam {

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;
}
