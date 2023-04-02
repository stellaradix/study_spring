package com.example.spring5.other;

import org.junit.jupiter.api.Test;

public class Chapter03Tests {

/*

Dependency 의존 관계: A가 B를 의존한다.
= 의존 대상 B 가 변하면, 그것이 A 에 영향을 미친다.

단점 1. 결합도가 높아짐
- 하나의 클래스를 수정하면 의존하는 다른 클래스들도 수정: 유지보수 난이도 상승

단점 2. 유연성 떨어짐
- 객체를 사용하기 위해 다른 객체들도 모두 존재: 유연한 코드 작성 방해
- 새로운 기능 추가나 수정이 어려워짐

단점 3. 테스트가 어려워짐
- 해당 객체를 테스트하기 위해 많은 객체 필요: 테스트 및 유지보수 난이도 상승

단점 4. 객체 생성 어려워짐
- 하나의 객체를 생성하기 위해 다른 객체들의 생성 순서등을 고려해야 함

DI (Dependency Injection): 의존 주입
- 객체가 의존하는 또 다른 객체를 외부에서 선언하고 이를 주입받아 사용



*/

	@Test
	public void test() {

	}
}
