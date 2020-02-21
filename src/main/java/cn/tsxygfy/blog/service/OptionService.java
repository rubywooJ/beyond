package cn.tsxygfy.blog.service;

import java.util.Map;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:05:31
 * @see cn.tsxygfy.blog.service
 *
 */
public interface OptionService {

    int DEFAULT_POST_PAGE_SIZE = 10;

    int DEFAULT_COMMENT_PAGE_SIZE = 10;

    int DEFAULT_RSS_PAGE_SIZE = 20;

    String OPTIONS_KEY = "options";

    String getBlogBaseUrl();

    Map<String, Object> listOptions();
}
