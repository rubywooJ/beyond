package cn.tsxygfy.beyond.model.dto;

import cn.tsxygfy.beyond.model.po.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.model.dto
 * @since 2020-03-22 15:26:42
 */
@Data
@NoArgsConstructor
public class UserInfo {
    private Long id;
    private String username;
    private String nickname;
    private String avatar;
    private String remark;
    private String email;

    public UserInfo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
        this.remark = user.getRemark();
        this.email = user.getEmail();
    }

}
