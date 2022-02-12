package site.metacoding.practice;

//14 움직임 설정해주기
public interface Moveable {
	void left();

	void right();

	void up();

	default void down() {
	}; // 버블은 다운이 없기 때문에 default 해줌.

}
