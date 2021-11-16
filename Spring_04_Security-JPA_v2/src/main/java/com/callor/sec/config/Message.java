package com.callor.sec.config;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class Message {

    public static class ERROR{

        public final static String BadCredentials
                = "ID 또는 비밀번호가 일치하지 않습니다";

        public final static String Disabled
                = "계정이 비활성화 되었습니다. 관리자에게 문의하세요";

        public final static String CredentialsExpired
                = "비밀번호 유효기간이 만료되었습니다. 비밀번호를 변경해 주세요";

        public final static String Locked
                = "계정이 잠겨있습니다. 관리자에게 문의하세요";

        public final static String AccountExpired
                = "계정 사용기간이 만료되었습니다. 관리자에게 문의하세요";

        public final static String SessionAuthentication
                = "인증 세션에 문제가 있습니다. 관리자에게 문의하세요";
    }

}
