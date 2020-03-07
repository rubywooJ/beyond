package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Article;
import cn.tsxygfy.blog.model.po.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.model.vo
 * @since 2020-02-21 15:03:29
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

    public Article toArticle() {
        Article article = new Article();
        if (this.getId() != null) {
            article.setId(this.getId());
        }
        if (this.getAuthor() != null) {
            article.setAuthor(this.getAuthor());
        }
        if (this.getContent() != null) {
            article.setContent(this.getContent());
        }
        if (this.getContentMd() != null) {
            article.setContentMd(this.getContentMd());
        }
        if (this.getCover() != null) {
            article.setCover(this.getCover());
        }
        if (this.getCreateTime() != null) {
            article.setCreateTime(this.getCreateTime());
        }
        if (this.getEditTime() != null) {
            article.setEditTime(this.getEditTime());
        }
        if (this.getOrigin() != null) {
            article.setOrigin(this.getOrigin());
        }
        if (this.getState() != null) {
            article.setState(this.getState());
        }
        if (this.getSummary() != null) {
            article.setSummary(this.getSummary());
        }
        if (this.getTitle() != null) {
            article.setTitle(this.getTitle());
        }
        if (this.getType() != null) {
            article.setType(this.getType());
        }
        if (this.getViews() != null) {
            article.setViews(this.getViews());
        }
        return article;
    }

}
