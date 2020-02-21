package cn.tsxygfy.blog.util;

import cn.tsxygfy.blog.model.dto.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @author feiyang
 * @version v1.0
 * @className PageUtil
 * @description
 * @date 2020/02/01 周六 20:04
 */
public class PageUtil {

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
