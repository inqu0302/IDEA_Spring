package com.callor.jc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration  // context.xml 을 대신하는 파일
@EnableWebMvc   // servlet-context, dispatcher-servlet.xml 등을 대신하는 파일
                // servlet 의 시작점을 지정
@ComponentScan(basePackages = {"com.callor.jc.config.beans",
                                "com.callor.jc.controller",
                                "com.callor.jc.service"
                                })
// servlet-context.xml 파일을 대신할 Java Config 클래스
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * Bean Annotation 을 부착하면
     * 이 method 는 반드시 객체를 생성해서 return 해야한다.
     *
     * Spring 컨테이너는 프로젝트가 시작되는 시점에 이 method 를 자동으로 실행하고
     * 생성된 객체를 컨테이너에 보관하여 다른 곳에서 주입하도록 준비한다
     */
    @Bean
    public ViewResolver getViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        // tiles 랑 같이 사용할 경우 tiles 는 1로 설정하고 viewResolver 는 1보다 큰수로 설정해야한다
        viewResolver.setOrder(2);

        return viewResolver;
    }
}
