package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.mapper.LinksMapper;
import cn.tsxygfy.beyond.model.po.Links;
import cn.tsxygfy.beyond.model.vo.LinkTeamVO;
import cn.tsxygfy.beyond.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-02-21 15:04:34
 */
@Service
public class LinksServiceImpl implements LinksService {

    @Autowired
    private LinksMapper linksMapper;

    @Override
    public List<LinkTeamVO> listTeamLinks() {
        // 数据库全部的 link
        List<Links> links = linksMapper.selectAll();

        if (links == null) {
            return null;
        }

        Map<String, List<Links>> map = new HashMap<>();
        if (links.size() > 0) {
            Links link1 = links.get(0);
            List<Links> list = new ArrayList<>();
            list.add(link1);
            map.put(link1.getTeam(), list);
        }
        for (int i = 1; i < links.size(); i++) {
            Links link = links.get(i);
            String team = link.getTeam();
            if (map.containsKey(team)) {
                List<Links> list = map.get(team);
                list.add(link);
                map.put(team, list);
            } else {
                List<Links> list = new ArrayList<>();
                list.add(link);
                map.put(link.getTeam(), list);
            }
        }

        List<LinkTeamVO> vos = new ArrayList<>();

        Set<Map.Entry<String, List<Links>>> entries = map.entrySet();
        Iterator<Map.Entry<String, List<Links>>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<Links>> next = iterator.next();
            LinkTeamVO vo = new LinkTeamVO();
            String key = next.getKey();
            vo.setTeam(key);
            vo.setLinks(next.getValue());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "Id must be not null");
        linksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Links createOrUpdateTag(Links links) {
        if (links.getId() == null) {
            // 新增
            Long id = linksMapper.insert(links);
            links.setId(id);
        } else {
            // 修改
            linksMapper.updateByPrimaryKey(links);
        }
        return links;
    }
}
