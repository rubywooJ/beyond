package cn.tsxygfy.blog.model.pojo;

import lombok.Getter;
import lombok.Setter;

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
