package cn.tsxygfy.beyond.configuration;

import cn.tsxygfy.beyond.cache.store.InMemoryCacheStore;
import cn.tsxygfy.beyond.core.CorsFilter;
import cn.tsxygfy.beyond.security.filter.AdminAuthenticationFilter;
import cn.tsxygfy.beyond.security.handler.DefaultAuthenticationFailureHandler;
import cn.tsxygfy.beyond.service.UserService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.configuration
 * @since 2020-03-09 20:59:31
 */
@Configuration
public class BeyondConfig {


    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean() {
        CorsFilter corsFilter = new CorsFilter();

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(corsFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE + 5);
        return bean;
    }

    @Bean
    public InMemoryCacheStore inMemoryCacheStore() {
        return new InMemoryCacheStore();
    }

    @Bean
    public FilterRegistrationBean<AdminAuthenticationFilter> authenticationFilterRegistrationBean(
            InMemoryCacheStore inMemoryCacheStore,
            UserService userService) {

        AdminAuthenticationFilter filter = new AdminAuthenticationFilter(inMemoryCacheStore, userService);

        DefaultAuthenticationFailureHandler handler = new DefaultAuthenticationFailureHandler();

        filter.setAuthenticationFailureHandler(handler);

        filter.addExcludeUrlPatterns(
                "/api/admin/login",
                "/api/admin/refresh/*"
        );

        FilterRegistrationBean<AdminAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/admin/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

}
