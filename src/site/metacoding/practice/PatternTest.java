package site.metacoding.practice;

interface Knife {
	void attack();

	void cook();
}

abstract class 요리사어댑터 implements Knife {
	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}
}

abstract class 싸움꾼 implements Knife {
	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}
}

class 백종원 extends 요리사어댑터 {

	// @Override
	// public void attack() {} //사용 안함. 어댑터 사용하면 모든 인터페이스를 구현하지 않아도 된.

	@Override
	public void cook() {
		System.out.println("요리합니다.");

	}

}

class 검투사 implements Knife {

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}

}

public class PatternTest {

}
