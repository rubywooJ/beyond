package cn.tsxygfy.beyond.configuration;

import cn.tsxygfy.beyond.properties.BeyondProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.configuration
 * @since 2020-03-13 16:12:42
 */
@Configuration
public class WebMvcAutoConfig implements WebMvcConfigurer {

    private static final String FILE_PROTOCOL = "file:///";

    @Autowired
    private BeyondProperties beyondProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // file:///{user.home}/.beyond/
        String workDir = FILE_PROTOCOL + beyondProperties.getWorkDir();

        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/theme/");
        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/admin/");
        registry.addResourceHandler("/upload/**").addResourceLocations(workDir + "upload/");
    }

}
