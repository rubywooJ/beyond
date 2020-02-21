package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @className ArticleYearVO
 * @description
 * @date 2020/02/03 周一 21:01
 */
@Data
@ToString
@EqualsAndHashCode
public class ArticleYearVO {

    private List<Article> articles;

    private Integer year;

    public static class ArchiveComparator implements Comparator<ArticleYearVO> {
        @Override
        public int compare(ArticleYearVO o1, ArticleYearVO o2) {
            return o2.year - o1.year;
        }
    }
}
