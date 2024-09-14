package com.example.campusexchange.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    /**
     * @param registry 注册表对象
     *
     * 这个方法覆盖了WebMvcConfigurer接口的addResourceHandlers方法。
     * 它用于定义静态资源的映射。在这里，任何以 /file/ 开头的URL都会被映射到类路径下的 /static/ 目录。
     *
     * 若以 file: 为前缀输入 addResourceLocations 的参数  则代表映射系统的绝对路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


    /**
     * @param registry 注册表对象
     *
     * 这个方法覆盖了WebMvcConfigurer接口的addCorsMappings方法。
     * 它用于配置跨域资源共享（CORS），允许不同域之间的HTTP请求。在这里，它设置了以下规则：
     *
     * addMapping("/**"): 为所有的URL路径添加CORS配置。
     * allowCredentials(true): 允许浏览器发送和接收认证信息（如Cookies）。
     * allowedOrigins("http://localhost:8080"): 允许来自http://localhost:8080的跨域请求。
     * allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE"): 允许这些HTTP方法进行跨域请求。
     * allowedHeaders("*"): 允许所有HTTP请求头。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*");
    }
}

