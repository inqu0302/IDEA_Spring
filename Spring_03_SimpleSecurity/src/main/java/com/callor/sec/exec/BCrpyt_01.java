package com.callor.sec.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrpyt_01 {

    public static void main(String[] args) {

        /**
         * 암호화, 복호화
         *
         * 보안과 관련 용어중 "인가"
         * username, password 를 입력받아
         * 정상적인 사용자 인지 검사를하고
         * 접속을 허가하는 절차
         *
         * 양방향 암호화를 이용한 보안
         *  username 은 일반 문자열로 전달하지만
         *  password 는 노출이 되지않도록 "암호화(encrypt)"를 한다
         *
         *  암호화된 password 를 DB에 저장하고
         *  저장된 password 를 다시 "복호화" 하여 로그인 정보와 비교
         *
         *  단방향 암호화를 이용한 보안
         *  PasswordEncoder(BCryptPasswordEncoder 로 구현)
         *  회원가입을 할 때 암호화 하여 저장
         *
         *  로그인시 DB 에서 회원 정보를 select 후 전달된 password 와 비교하는데
         *  DB 에 저장된 password 를 복호화 하지 않고
         *  login 을 통해 전달된 password 를 암호화 하여 두값을 비교
         */

        PasswordEncoder pass = new BCryptPasswordEncoder(4);
        String password = "1234";
        String encPassword = "$2a$04$76rY/vSPg/6kocmBLJrxd.SuGHuA3hg54YUFixa.3bCSK/EXDhPS2";

        String bcPassword = pass.encode(password);
        System.out.println("생성된 비밀번호 : " + bcPassword);
        System.out.println("문자열의 길이 : " + bcPassword.length());
        System.out.println("저장된 비밀번호 : " + encPassword);

        // 두값 비교하기
        // matches(rowPassword, encPassword)
        boolean loginOk = pass.matches(password, encPassword);

        if(loginOk){
            System.out.println("일치합니다");
        }else{
            System.out.println("일치하지 않습니다");
        }
    }
}
