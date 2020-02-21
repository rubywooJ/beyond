package cn.tsxygfy.blog.freemarker;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.service.ArticleService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:01:56
 * @see cn.tsxygfy.blog.freemarker
 *
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
