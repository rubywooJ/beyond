package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Article;
import cn.tsxygfy.blog.model.po.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @className ArticleTagsVo
 * @description
 * @date 2020/01/31 周五 21:42
 */
@Getter
@Setter
public class ArticleTagsVO extends Article {

    public ArticleTagsVO() {
    }

    public ArticleTagsVO(Article article) {
        this.setId(article.getId());
        this.setAuthor(article.getAuthor());
        this.setContent(article.getContent());
        this.setContentMd(article.getContentMd());
        this.setCover(article.getCover());
        this.setCreateTime(article.getCreateTime());
        this.setEditTime(article.getEditTime());
        this.setOrigin(article.getOrigin());
        this.setState(article.getState());
        this.setSummary(article.getSummary());
        this.setTitle(article.getTitle());
        this.setType(article.getType());
        this.setViews(article.getViews());
    }

    private List<Tag> tags;

}
