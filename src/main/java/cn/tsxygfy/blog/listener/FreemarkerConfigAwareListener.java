package cn.tsxygfy.blog.listener;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.properties.ThemeProperty;
import cn.tsxygfy.blog.service.OptionService;
import cn.tsxygfy.blog.service.ThemeService;
import cn.tsxygfy.blog.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:02:25
 * @see cn.tsxygfy.blog.listener
 *
 */
@Slf4j
@Component
public class FreemarkerConfigAwareListener {

    private final OptionService optionService;

    private final Configuration configuration;

    private final ThemeService themeService;

    private final UserService userService;

    public FreemarkerConfigAwareListener(OptionService optionService,
                                         Configuration configuration,
                                         ThemeService themeService,
                                         UserService userService) {
        this.optionService = optionService;
        this.configuration = configuration;
        this.themeService = themeService;
        this.userService = userService;
    }

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public void onApplicationStartedEvent(ApplicationStartedEvent applicationStartedEvent) throws TemplateModelException {
        log.debug("Received application started event");

        loadThemeConfig();
        loadOptionsConfig();
        loadUserConfig();
    }

    private void loadUserConfig() throws TemplateModelException {
        configuration.setSharedVariable("user", userService.getCurrentUser().orElse(null));
        log.debug("Loaded user");
    }

    private void loadOptionsConfig() throws TemplateModelException {
        configuration.setSharedVariable("options", optionService.listOptions());
        configuration.setSharedVariable("context", optionService.getBlogBaseUrl());
        configuration.setSharedVariable("version", BeyondConst.BEYOND_VERSION);
        log.debug("Loaded options");
    }

    private void loadThemeConfig() throws TemplateModelException {
        ThemeProperty activatedTheme = themeService.getActivatedTheme();
        //configuration.setSharedVariable("theme", activatedTheme);
        configuration.setSharedVariable("static", optionService.getBlogBaseUrl() + "/" + BeyondConst.DEFAULT_THEME_ID);
        //configuration.setSharedVariable("settings", themeSettingService.listAsMapBy(themeService.getActivatedThemeId()));
        log.debug("Loaded theme and settings");
    }

}
