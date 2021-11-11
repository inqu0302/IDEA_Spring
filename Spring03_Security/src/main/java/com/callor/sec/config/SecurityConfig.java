package com.callor.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();

        http.formLogin();
        /**
         * Spring Security 에서 form 으로 데이터를 전송할때
         * POST 로 전송을 하는데 POST 로 전송할때는 반드시
         * _csrf.token 값을 데이터에 포함하여 전송해야 한다
         *
         * form 을 만들때, JSP, thymeleaf 등의 taglibs 등을 사용하면
         * 자동으로 _csrf.token 을 form 에 포함 시킨다
         *
         * 최근 Security 정책이 https(Hyper Text Transfer Protocol Sec) 가 적용된 곳에서는
         * 정상적으로 _csrf.token 을 form 에 추가를한다
         *
         * 하지만 http 로 되어있는 곳에서는 정삭적으로 추가하지 않는다
         * 그래서 테스트 환경(http)에서는 whitHttpOnlyFalse() 를 추가한다
         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("inqu0302")
                .password("{noop}1234")
                .roles("ADMIN");

    }

}
