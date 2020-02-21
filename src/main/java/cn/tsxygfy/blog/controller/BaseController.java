package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.core.BeyondConst;

/**
 * @author feiyang
 * @version v1.0
 * @className BaseController
 * @description
 * @date 2020/01/30 周四 21:58
 */
public class BaseController {
    final String THEME_DIR = BeyondConst.DEFAULT_THEME_ID + "/";
    final String BASE_DIR = "theme/"+THEME_DIR;
    final Integer PAGE_SIZE = 4;
}
