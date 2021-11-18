package com.callor.jc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml 을 대신할 config 클래스
public class AppWebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    // <context-param> 에 설정한 root-context.xml 을 초기화 할 method
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    // <servlet> 에 설정한 servlet-context.xml 을 초기화 할 method
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{
                ServletConfig.class,
                MyBatisConfig.class
        };
    }

    @Override
    // resources mapping 에 설정한 static 폴더들에 대한 초기화
    protected String[] getServletMappings() {

        String[] mapping = new String[]{"/"};

        return mapping;
    }
}
