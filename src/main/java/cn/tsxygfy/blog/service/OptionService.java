package cn.tsxygfy.blog.service;

import java.util.Map;

/**
 * @author feiyang
 * @version v1.0
 * @className OptionService
 * @description
 * @date 2020/01/30 周四 23:02
 */
public interface OptionService {

    int DEFAULT_POST_PAGE_SIZE = 10;

    int DEFAULT_COMMENT_PAGE_SIZE = 10;

    int DEFAULT_RSS_PAGE_SIZE = 20;

    String OPTIONS_KEY = "options";

    String getBlogBaseUrl();

    Map<String, Object> listOptions();
}
