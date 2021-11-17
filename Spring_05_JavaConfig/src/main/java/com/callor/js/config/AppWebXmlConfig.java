package com.callor.js.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletConfig;

// web.xml 을 대신할 config 클래스
public class AppWebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // <context-param> 에 설정한 root-context.xml 을 초기화 할 method
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // <servlet> 에 설정한 servlet-context.xml 을 초기화 할 method
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // resources mapping 에 설정한 static 폴더들에 대한 초기화
    @Override
    protected String[] getServletMappings() {

        String[] mapping = new String[]{"/"};

        return mapping;
    }
}
