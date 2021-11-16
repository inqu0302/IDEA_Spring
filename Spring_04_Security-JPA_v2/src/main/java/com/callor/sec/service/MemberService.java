package com.callor.sec.service;

import com.callor.sec.models.UserDetailsVO;

import java.util.List;

public interface MemberService extends GenericService<UserDetailsVO, String> {

    // GenericService 를 상속받아 기본 CRUD 이외의 추가 기능만 작성

    // 추가적인 method 설정
    public List<UserDetailsVO> findByEmail(String email);
    public List<UserDetailsVO> findByTel(String tel);

    // DB에 저장된 사용자 수
    public int userCount();
}
