package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.model.po.Links;
import cn.tsxygfy.beyond.model.vo.LinkTeamVO;
import cn.tsxygfy.beyond.service.LinksService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.controller.admin.api
 * @since 2020-03-08 20:20:21
 */
@RestController
@RequestMapping("/api/admin/links")
public class LinksController {

    @Autowired
    private LinksService linksService;

    @ApiOperation("分组列出所有的友情链接")
    @GetMapping
    public List<LinkTeamVO> getAll() {
        return linksService.listTeamLinks();
    }

    @ApiOperation("新增一个友情链接")
    @PostMapping
    public Links createLink(@RequestBody Links links) {
        return linksService.createOrUpdateLink(links);
    }

    @ApiOperation("更新对应id的友情链接")
    @PutMapping("{id:\\d+}")
    public Links updateLinks(@PathVariable Long id, @RequestBody Links links) {
        links.setId(id);
        return linksService.createOrUpdateLink(links);
    }

    @ApiOperation("删除对应id的友情链接")
    @DeleteMapping("{id:\\d+}")
    public void deleteById(@PathVariable Long id) {
        linksService.deleteById(id);
    }


}
