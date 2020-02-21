package cn.tsxygfy.blog.freemarker;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.service.LinksService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author feiyang
 * @version v1.0
 * @className LinksTagDirective
 * @description
 * @date 2020/02/04 周二 20:35
 */
@Component
public class LinksTagDirective implements TemplateDirectiveModel {

    private final LinksService linksService;

    public LinksTagDirective(LinksService linksService, Configuration configuration) {
        this.linksService = linksService;
        configuration.setSharedVariable("linksTag", this);
    }


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        final DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        String param = params.get(BeyondConst.METHOD_KEY).toString();
        switch (param) {
            case "listTeams":
                env.setVariable("teams", builder.build().wrap(linksService.listTeamLinks()));
                break;
            default:
                break;
        }

        body.render(env.getOut());
    }
}
