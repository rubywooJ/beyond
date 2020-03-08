package cn.tsxygfy.blog.controller.admin.api;

import cn.tsxygfy.blog.model.po.Links;
import cn.tsxygfy.blog.model.vo.LinkTeamVO;
import cn.tsxygfy.blog.service.LinksService;
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
 * @see cn.tsxygfy.blog.controller.admin.api
 * @since 2020-03-08 20:20:21
 */
@RestController
@RequestMapping("/api/admin/links")
public class LinksController {

    @Autowired
    private LinksService linksService;

    @GetMapping
    public List<LinkTeamVO> getAll() {
        return linksService.listTeamLinks();
    }

    @PostMapping
    public Links createTag(@RequestBody Links links) {
        return linksService.createOrUpdateTag(links);
    }

    @PutMapping("{id:\\d+}")
    public Links updateLinks(@PathVariable Long id, @RequestBody Links links) {
        links.setId(id);
        return linksService.createOrUpdateTag(links);
    }

    @DeleteMapping("{id:\\d+}")
    public void deleteById(@PathVariable Long id) {
        linksService.deleteById(id);
    }


}
