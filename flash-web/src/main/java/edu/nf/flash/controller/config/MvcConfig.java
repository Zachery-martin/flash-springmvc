package edu.nf.flash.controller.config;/**
 * @ClassName: MvcConfig
 * @Author: Zachery
 * @Data: 15:56
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @ClassName: MvcConfig
 * @Author: Zachery
 * @Data: 15:56
 **/
@Configuration
@ComponentScan(basePackages = "edu.nf.flash.controller")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    /**
     * 方式二：使用spring mvc处理静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/page/**")
                .addResourceLocations("/static/");
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:D:/upload/");
    }

    /**
     * 配置内部资源视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 配置commons-upload上传
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //设置文件上传的大小
        resolver.setMaxUploadSize(104857600);
        //设置编码
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
}
