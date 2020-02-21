package cn.tsxygfy.blog.freemarker;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.service.ArticleService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author feiyang
 * @version v1.0
 * @className ArticleTagDirective
 * @description
 * @date 2020/02/03 周一 20:14
 */
@Component
public class ArticleTagDirective implements TemplateDirectiveModel {

    private final ArticleService articleService;

    public ArticleTagDirective(Configuration configuration, ArticleService articleService) {
        this.articleService = articleService;
        configuration.setSharedVariable("postTag", this);
    }

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {
        final DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        String methodName = map.get(BeyondConst.METHOD_KEY).toString();
        switch (methodName) {
            case "archiveYear":
                env.setVariable("archives", builder.build().wrap(articleService.listYearArchives()));
                break;
            default:
                break;
        }
        body.render(env.getOut());
    }
}
