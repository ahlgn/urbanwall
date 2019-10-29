package cn.urbanwall.config;

import cn.urbanwall.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
        // 这个方法才能在拦截器中自动注入查询数据库的对象
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/user/**");
        //配置生成器：添加一个拦截器，拦截路径为API以后的路径
    }

    @Value("${application.profile}")
    private String UPLOAD_PATH;

    @Value("${application.profileicon}")
    private String UPLOAD_ICON;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/wallImages/**").addResourceLocations("file:"+UPLOAD_PATH);
        registry.addResourceHandler("/wallImagesIcon/**").addResourceLocations("file:"+UPLOAD_ICON);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/index.html" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        WebMvcConfigurer.super.addViewControllers( registry );
    }

}
