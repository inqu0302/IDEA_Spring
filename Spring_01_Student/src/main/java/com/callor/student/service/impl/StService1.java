package com.callor.student.service.impl;

import com.callor.student.repository.StDaoImpl;
import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;
import com.callor.student.service.StService;

import java.util.Collections;
import java.util.List;

/**
 * StDao 형 객체를 생성하고 인스턴스가 만들어지는 순간
 * StDao, StDaoImpl, StService 는 결합도가 높아진다
 *
 * StDaoImpl 클래스의 변화(변경, 업데이트)가 발생하면
 * StService 에게 영향이 미치게 된다.
 *
 * 1번 코드는 StDaoImpl 클래스로 선언후 클래스로 직접 객체 생성
 * 2번 코드는 StDao 인터페이스로 선언후 클래스로 간접 객체 생성
 *
 * 1번 코드는 2번 코드보다 결합도가 높다
 *
 * 2번의 코드같은 경우 StDaoImpl 에 새로운 method가 추가되도 StDao 가 변경되지 않으면
 * 사용할수 없다. 즉 StDao 가 변경되지 않으면 큰 영향을 받지 않는다
 *
 * Sub 로 작성된 클ㄹ래스 모듈은 반드시 인터페이스로 선언하여
 * 결합도를 낮추는 작업이 필요하다
 */
public class StService1 implements StService {

    // interface 로 선언후 상송받은 class 로 초기화(생성)
    // StDaoImpl 클래스를 사용하여 StDao 형(type)의 stDao 객체 생성
    // 클래스의 생성자를 호출하여 객체를 생성하면
    // 이 객체는 StDao 형 인스턴스가 된다
    // private StDaoImpl stDao = new StDaoImpl() // 1번
    private StDao stDao = new StDaoImpl(); // 2번

    public List<StudentVO> selectAll(){

        List<StudentVO> stList = stDao.selectAll();
        Collections.shuffle(stList);
        return stList;
    }
}
