package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Tag;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:03:53
 * @see cn.tsxygfy.blog.model.vo
 *
 */
@Getter
@Setter
public class TagsVO extends Tag {

    private Integer articleCount;

    public TagsVO() {
    }

    public TagsVO(Tag tag) {
        this.setId(tag.getId());
        this.setName(tag.getName());
    }

}
