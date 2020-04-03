package cn.tsxygfy.beyond.configuration;

import cn.tsxygfy.beyond.core.BeyondConst;
import cn.tsxygfy.beyond.service.OptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.configuration
 * @since 2020-03-06 20:16:21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(OptionService optionService) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .host(optionService.getBlogBaseUrl())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("cn.tsxygfy.beyond.controller.admin.api"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BEYOND API")
                .description("beyond博客api文档")
                .contact(new Contact("ruby woo", "https://www.tsxygfy.cn", "i520gfy@gmail.com"))
                .version("1.0.0")
                .build();
    }
}
