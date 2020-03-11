package cn.tsxygfy.blog.util;

import cn.tsxygfy.blog.model.dto.PageResult;
import com.github.pagehelper.PageInfo;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:06:48
 * @see cn.tsxygfy.blog.util
 *
 */
public class PageUtil {

    private PageUtil() {
    }

    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult pageInfo2PageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
