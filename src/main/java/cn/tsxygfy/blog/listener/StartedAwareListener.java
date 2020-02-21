package cn.tsxygfy.blog.listener;

import cn.tsxygfy.blog.properties.BeyondProperties;
import cn.tsxygfy.blog.service.OptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:02:31
 * @see cn.tsxygfy.blog.listener
 *
 */
@Slf4j
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class StartedAwareListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private BeyondProperties beyondProperties;

    @Autowired
    private OptionService optionService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        this.printStartInfo();
    }

    private void printStartInfo() {
        String blogUrl = optionService.getBlogBaseUrl();

        log.info("Beyond started at         {}", blogUrl);
        log.info("Beyond admin started at   {}/{}", blogUrl, beyondProperties.getAdminPath());
        log.info("Beyond has started successfully!");
    }


    /**
     * Init internal themes
     */
    private void initThemes() {
        // Whether the blog has initialized

    }

}
