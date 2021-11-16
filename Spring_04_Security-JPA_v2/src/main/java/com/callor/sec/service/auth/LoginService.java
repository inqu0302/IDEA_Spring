package com.callor.sec.service.auth;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security 에서 login 서비스를 수행하는 방법이 다양
 * DB와 연동을 하여 로그인을 수행하는 비교적 쉬운방법으로
 * UserDetailService 를 상속받아 클래스를 만들고 수행한다
 *
 * UserDetailService uds = new LoginService()
 * uds.loadUserByUsername(username)
 */
@Slf4j
@Service("loginService")
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$76rY/vSPg/6kocmBLJrxd.SuGHuA3hg54YUFixa.3bCSK/EXDhPS2";
    private final MemberDao memberDao;
    public LoginService(MemberDao memberDao) {

        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. dao 에서 사용자 정보 가져오기
        // username 으로 member table 에서 findById(username)
        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("inqu0302")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(false)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();

//        UserDetailsVO userVO = memberDao.findById(username).get();

        // 2. dao 에서 받은 사용자 정보가 없으면
        // Exception 을 발생시킨다
        if(userVO == null){
          log.debug("{} 사용자 이름 없음", username);

          throw new UsernameNotFoundException(username + "사용자 없음");
        }

        // security 에 내장된 코드의 흐름
//        try{
//            UserDetails vo = loadUserByUsername("inqu0302");
//            // 비밀번호를 검사하는 코드가 자체 내장
//        } catch (UsernameNotFoundException e){
//            //redirect "/member/login?error=xxxx";
//        }

        return userVO;

    }
}
