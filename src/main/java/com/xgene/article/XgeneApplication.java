package com.xgene.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
public class XgeneApplication {

    public static void main(String[] args) {
        SpringApplication.run(XgeneApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xgene.article.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Xgene 標準API")
                .description("Spring Boot中使用Swagger2构建RESTful APIs!")
                .termsOfServiceUrl("Xgene-Common-Web")
                .contact("xgene")
                .version("1.0")
                .build();
    }

    @Configuration
    public class CustomerConfig {
        @Bean
        public WebMvcConfigurer cros() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**/**")
                            .allowedOrigins("http://localhost:3006");
                }
            };
        }
    }

}
