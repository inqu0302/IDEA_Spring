package com.callor.sec.service.auth;

import com.callor.sec.config.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

// exception 핸들러 import
import org.springframework.security.authentication.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service("loginFailService")
public class LoginFailService implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        log.debug("로그인 실패 처리 시작");
        log.debug("Exception {}", exception.getClass().getName());

        String exceptionClassName = exception.getClass().getName();

        // 어떤 문제가 발생하여 LoginFail 이 작동되었는지 알기위해
        // 1. exception 클래스 이름을 문자열로 확인
        //      type 오류로 인한 문제가 발생할수 있다
        if(exceptionClassName
                .equalsIgnoreCase("credentialsExpiredException")){

        }

        // 2. exception 객체가 어떤 클래스의 인스턴스인가 확인하고
        //      exception 확인하기
        String error_msg = "";
        if(exception instanceof CredentialsExpiredException){

            error_msg = Message.ERROR.CredentialsExpired;

        } else if(exception instanceof AccountExpiredException){

            error_msg = Message.ERROR.AccountExpired;

        } else if(exception instanceof DisabledException){

            error_msg = Message.ERROR.Disabled;

        } else if(exception instanceof LockedException){

            error_msg = Message.ERROR.Locked;

        } else if(exception instanceof SessionAuthenticationException){

            error_msg = Message.ERROR.SessionAuthentication;

        } else {

            error_msg = Message.ERROR.BadCredentials;

        }

        /**
         * GET /member/login URL 은 login.jsp 를 열기 위한 요청
         * login.jsp 에서 "로그인" 버튼을 클릭(submit) 하면
         * POST /login URL 로 요청이 전달된다
         *
         * 로그인이 실패했을때
         * 다시 /member/login 으로 forwarding 을 수헹
         * 이때 /member/login 은 POST 방식으로 호출이 된다
         * 만약 redirect 로 진행한다면 GET 으로 호출이 된다
         */
        request.setAttribute("ERROR_MSG",error_msg);

        // /member/login URL 로 forwarding 을 수행
        request.getRequestDispatcher("/member/login?error")
                .forward(request,response);

    }
}
