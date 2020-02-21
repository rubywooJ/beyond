package cn.tsxygfy.blog.model.vo;

import cn.tsxygfy.blog.model.po.Tag;
import lombok.Getter;
import lombok.Setter;

/**
 * @author feiyang
 * @version v1.0
 * @className TagsVO
 * @description
 * @date 2020/02/04 周二 18:22
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
