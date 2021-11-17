# Java Config type Spring project
* Java 3.x 에서 사용하기 시작한 Annotation 이 보편화 되면서 Spring framework 에서
  상당부분 context.xml 을 사용하지 않고 @Controller, @Service 등의 Annotation 으로
  bean 을 대신하게 된다
* .xml 방식의 설정에서 type 오류, tag 오류 등으로 프로젝트 전체가 문제발생 하는경우가 많다
* 그래서 java 의 class 를 사용하여 .xml 파일을 대신하는 프로젝트를 구현한다

## Java Config 를 사용한 MyBatis Project 핸들링
  spring-jdbc
  commons-dbcp2
  mybatis
  mybatis-spring
  mysql-connection-j
  
  lombok
  slf4j
  logback-classic
  jackson