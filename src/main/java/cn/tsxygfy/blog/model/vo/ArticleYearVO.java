package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:03:35
 * @see cn.tsxygfy.blog.model.vo
 *
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
