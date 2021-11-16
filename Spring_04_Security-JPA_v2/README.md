# Spring Security 를 사용한 회원가입 및 로그인

## 회원가입시
* 사용자의 비밀번호를 BCryptPasswordEncoder 를 사용하여 암호화 후 저장
* 일반적인 CRUD 구현중 insert, update 등에서 암호화 과정을 수행

## 로그인 정책 설정
* security-context.xml 에 로그인이 필요한 URL pattern 설정
* login form 을 만들어서 로그인 수행
* login submit 은 security 에서 제공하는 기본 설정 기능을 사용

## 로그인 과정의 Custom 정책
* UserDetails(service)를 impl 하여 클래스 생성 : LoginService.java
* PasswordEncoder(BCryptPasswordEncoder) 를 security-context.xml bean 에 등록

## UserDetails(LoginService).loadUserByUsername()
* DB(Dao) 로 부터 사용자 정보를 findById() 
* 사용자 정보가 있으면 사용자 정보를 return
* 정보가 없으면 UserNameNotFound exception 발생

## UserDetails 에서 구현한 로그인의 문제점
* 사용자의 로그인이 어떤 이유로 실패했는지 알수없다
* 모든 exception 은 BadCredential 로 처리되어 view 에서 적절한 처리가 어렵다

## LoginFail Custom 