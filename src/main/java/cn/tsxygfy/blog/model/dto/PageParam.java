package cn.tsxygfy.blog.model.dto;

/**
 * @author feiyang
 * @version v1.0
 * @className PageParam
 * @description
 * @date 2020/02/01 周六 19:57
 */
public class PageParam {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
