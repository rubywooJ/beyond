package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.mapper.CommentsMapper;
import cn.tsxygfy.beyond.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-03-22 20:22:27
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public Long getCount() {
        return commentsMapper.getCount();
    }
}
