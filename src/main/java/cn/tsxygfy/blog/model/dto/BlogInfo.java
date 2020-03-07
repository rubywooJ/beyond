package cn.tsxygfy.blog.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.model.pojo
 * @since 2020-02-21 15:03:20
 */
@Getter
@Setter
public class BlogInfo {
    //总文章
    private long articleCount;
    //总评论
    private long commentCount;
    //总附件
    private long attachmentCount;
    //生日
    private long birthday;
    //建立天数
    private long establishDays;
    //总友链
    private long linkCount;
    //总访问
    private long visitedCount;

}
