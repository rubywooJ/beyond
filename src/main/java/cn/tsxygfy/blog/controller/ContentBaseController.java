package cn.tsxygfy.blog.controller;

import cn.tsxygfy.blog.core.BeyondConst;

/**
 *
 * <p>
 * Description: BaseController
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 14:59:05
 * @see cn.tsxygfy.blog.controller
 *
 */
public class ContentBaseController {
    final String THEME_DIR = BeyondConst.DEFAULT_THEME_ID + "/";
    final String BASE_DIR = "theme/" + THEME_DIR;
    final Integer PAGE_SIZE = 4;
}
