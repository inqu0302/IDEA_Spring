package com.callor.sec.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * spring security 에서 회원 인증 정보(회원정보)를
 * 담아서 사용할 UserVO는 반드시 UserDetails 인터페이스를
 * 상속받아 작성하도록 하고있다
 *
 * 인터페이스를 상속받으면 method 를 정해진 이름으로 선언해야 하지만
 * lombok 의 기능을 사용하기 위하여 정해진 이름으로 각각 변수를 선언하고
 * lombok 을 이용하여 getter, setter 를 선언했다
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsVO implements UserDetails {

    private static final long serialVersionID = 1L;

    // 필수 선언 변수들
    private String username;
    private String password;

    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    private Collection<? extends GrantedAuthority> authorities;

    // 필요에따라 추가하여 사용하는 변수들
    private String email;
    private String tel;
    private String address;

}
