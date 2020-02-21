package cn.tsxygfy.blog.service;

import cn.tsxygfy.blog.model.vo.LinkTeamVO;

import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @interfaceName LinksService
 * @description
 * @date 2020/02/04 周二 20:36
 */
public interface LinksService {

    List<LinkTeamVO> listTeamLinks();

}
