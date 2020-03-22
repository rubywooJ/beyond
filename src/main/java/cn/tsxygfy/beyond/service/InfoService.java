package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.model.po.Info;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-03-22 20:03:00
 */
public interface InfoService {

    Info getInfo();

    void updateBlogTitle(String title);

    void createOrUpdateInfo(Info info);

    void updateSEO(String keywords, String description);

}
