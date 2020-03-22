package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.mapper.InfoMapper;
import cn.tsxygfy.beyond.model.po.Info;
import cn.tsxygfy.beyond.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-03-22 20:05:39
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Info getInfo() {
        List<Info> infos = infoMapper.selectAll();

        return infos.get(0);
    }

    @Override
    public void updateBlogTitle(String title) {
        Info info = getInfo();
        info.setBlogTitle(title);
        infoMapper.updateByPrimaryKey(info);
    }

    @Override
    public void createOrUpdateInfo(Info info) {
        if (info.getId() != null) {
            infoMapper.updateByPrimaryKey(info);
        } else {
            infoMapper.insert(info);
        }
    }

    @Override
    public void updateSEO(String keywords, String description) {
        Info info = getInfo();
        info.setSeoKeywords(keywords);
        info.setSeoDescription(description);
        infoMapper.updateByPrimaryKey(info);
    }
}
