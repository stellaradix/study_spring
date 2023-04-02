package com.example.spring.core.container;

public class ContainerTests {
}

/*

클래스간 관계
1. 상속 Inheritance : 자녀클래스가 부모클래스를 상속해 필드 변수와 메소드 물려받아 사용
2. 구현 Implementation : 클래스가 인터페이스를 구현
3. 의존 dependency : 한 클래스가 다른 클래스 사용
4. 연관 Association : 두 클래스가 연관되어 있지만 강한 의존성 없는 경우
5. 집합 Composition : 클래스간에 전체 또는 부분 관계가 있는 경우
6. 집약 Aggregation : 집합과 비슷하지만 부분 객체가 전체 객체에 속하지 않은 경우
전체 객체가 소멸되어도 부분객체 유지
7. 사용 Realization : 클래스가 추상 클래스를 상속받는 경우

@Bean : 설정된 메서드가 생성한 객체를 스프링이 관리할 빈 객체로 등록

*/