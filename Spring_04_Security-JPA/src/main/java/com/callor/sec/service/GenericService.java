package com.callor.sec.service;

import java.util.List;

/**
 * 여러 service interface 를 만들기 위한 구조형 interface
 * Generic 을 사용하여 interface 를 선언
 * 기본 CRUD 를 구현하여 다른 service 에서 기본적으로 사용가능
 */
public interface GenericService <VO, PK>{

    public List<VO> selectAll();
    public VO findById(PK pk);

    public void insert(VO vo);
    public void update(VO vo);
    public void delete(PK pk);
}
