package cn.tsxygfy.beyond;

import cn.tsxygfy.beyond.model.vo.LinkTeamVO;
import cn.tsxygfy.beyond.service.LinksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author feiyang
 * @version v1.0
 * @className LinksServiceTest
 * @description
 * @date 2020/02/04 周二 21:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LinksServiceTest {

    @Autowired
    LinksService linksService;

    @Test
    public void testListTeamLinks() {
        List<LinkTeamVO> linkTeamVOS = linksService.listTeamLinks();
        System.out.println(linkTeamVOS);
    }

}
