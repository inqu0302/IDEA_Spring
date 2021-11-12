package com.callor.sec.service.impl;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import com.callor.sec.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memServiceV1")
public class MemberServiceImplV1 implements MemberService {

    private final MemberDao memDao;

    public MemberServiceImplV1(MemberDao memDao) {
        this.memDao = memDao;
    }

    @Override
    public List<UserDetailsVO> selectAll() {

        List<UserDetailsVO> memberList = memDao.findAll();

        return memberList;
    }

    @Override
    public UserDetailsVO findById(String username) {

        /**
         * JpaRepository 에 선언된 findById(PK)는
         * SELECT * FROm (table) WHERE PK = (PK) 를 실행하고
         * 결과를 Optional<UserDetailsVO> type 으로 return
         * Optional 로 감싸진 데이터는 null safe 데이터이다
         * 그렇기 때문에 null 값을 이용한 검사를 할때는 문제가 생길수 있다.
         *
         * 결과값.orElse(리턴값) method 를 사용하여
         * 결과값이 null 이 되면 리턴값을 연산결과로 return 하게 된다
         *
         * 이렇게 하면 findById() 의 결과가 없으면 null 값을 return 하게 된다다
        */
        UserDetailsVO userVO = memDao.findById(username).orElse(null);

        return userVO;
    }

    @Override
    public void insert(UserDetailsVO userDetailsVO) {
        memDao.save(userDetailsVO);
    }

    @Override
    public void update(UserDetailsVO userDetailsVO) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<UserDetailsVO> findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDetailsVO> findByTel(String tel) {
        return null;
    }

    @Override
    public int userCount() {
        return 0;
    }
}
