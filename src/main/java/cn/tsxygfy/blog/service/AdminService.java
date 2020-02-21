package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.dto.LoginParam;
import cn.tsxygfy.blog.model.pojo.AuthToken;

/**
 * @author feiyang
 * @version v1.0
 * @className AdminService
 * @description
 * @date 2020/02/09 周日 15:36
 */
public interface AdminService {
    AuthToken authenticate(LoginParam loginParam);
}
