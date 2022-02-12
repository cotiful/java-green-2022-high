package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable { // 15. extends JLabel 상태에서 MoveAble 인플리먼트. 16. add
															// unimplemented left, right,up.
	private static final String TAG = "Player"; // 17. TAG를 설정해서 어디에서 돌아가는지 쉽게 알 수 있도

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	private BackgroundMap backgroundMap; // 29-1: 컴포지션해줘서 의존하게 해줌.

	private ImageIcon playerR, playerL; // 2
	private int x, y; // 5
	private boolean isRight, isLeft, isUp, isDown; // 25_1, 25_2: getter, setter 만들어주기, down은 나중에 만들어
	private boolean leftWallCrash, rightWallCrash; // 32. 충돌하는 상태값 만들어주기.
	private static final int JUMPSPEED = 2; // 28. 점프 만들어주기

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public Player(BackgroundMap backgroundMap) { // 3, 29-2: backgroundMap을연결시켜준다. 이전에()안 아무것도 안들어가있었음.
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
		this.backgroundMap = backgroundMap; // 29-2 만들 때 같이 만들어줘야겠쬬??

		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // 4

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;// 26. 초기값 생성.
		leftWallCrash = false; // 32 -1 초기값 만들어주기
		rightWallCrash = false;

	}

	// 36 바닥충돌감지 만들기,left(), right(),down()할 때 다 감지해야함.
	private void 바닥충돌감지() {
		System.out.println(TAG + "바닥충돌감지");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX() + 50 - 10, getY() + 50 + 5); // -1 ///37번 int를 가져온다.

		// 38번 바닥이 흰색인지 확인해보기
		if (bottomColor == -2) { // 바닥이 흰색이에
			// System.out.println("바닥이 흰색이에요"); 테스트해보기 x, y 값 상태에서 바꿔서 비교해
			if (!isUp && isDown)
				down(); // 39

		} else if (bottomColor != -2) { // 바닥에 장애물이 있다는 것
			System.out.println("바닥에 장애물이 있어요.");
			isDown = false;
		}
	}

	private void 왼쪽벽충돌감지() { // 29번 의존을 시켜줘야 왼쪽벽 충돌감지!!!
		// System.out.println(TAG + "왼쪽충돌계산");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25)); // 32 그림 넣어주기.
		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { // 33백그라운드의 값을 넣어줘서
																									// 조건문 실
			System.out.println("왼쪽 벽에 충돌함");
			leftWallCrash = true;
			isLeft = false; // 30~32 완료하면 작성 가능해짐!!! 앞에서 만들어줘야 하잖아!
		}
	}

	private void 오른쪽벽충돌감지() { // 왼쪽벽 충돌감지와 똑같다.
		// System.out.println(TAG + "오른쪽충돌계산");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));
		if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println("오른쪽 벽에 충돌함");
			rightWallCrash = true;
			isRight = false;
		}
	}

	@Override
	public void left() {
		isLeft = true;
		leftWallCrash = false;
		setIcon(playerL);
		System.out.println(TAG + ":left()"); // 18. 태그를 해주면 잘 보이겠죠??
		new Thread(() -> {
			try {
				while (isLeft) {

					x = x - 4;
					setLocation(x, y);
					Thread.sleep(10);

					왼쪽벽충돌감지(); // 29. 충돌감지 만들기.
					바닥충돌감지(); // 바닥이 흰색이에요~

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	}

//27. right에 while로 해서 만들어주기
	@Override
	public void right() {
		isRight = true;
		rightWallCrash = false; //// 여기에 35번 충돌하면 멈추게 감지하는거 만들어야 함!!!
		setIcon(playerR);
		System.out.println(TAG + ":right()");
		new Thread(() -> {
			try {
				while (isRight) { // isRight를 적지 않고,true를 넣으면 끝없이 간다. 변수로 true를 해줘야 한다.

					x = x + 4;
					setLocation(x, y);
					Thread.sleep(10);

					오른쪽벽충돌감지(); // 34번
					바닥충돌감지(); // 37
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

		// 22. x와 setLocition을 작성해줌 !! 그래야 키보드를 누를 때 움직이니깐 !! player가 reapint됨.
		// paintcomponent()자동 호출

	} // 23. for 구문이 생기면 메서드가 안 끝났기 때문에 그림을 그리지 못 한다!<규칙> 그래서 main thread가 다른 스레드에 넘기고
		// 도망감.. setLocition이 for 구문 밖과 안에 있으면 자연스러운 움직임에 차이가 있을 거라고 생각할 수 있으나, 메서드가 다
		// 끝나야 set이 실

	// 24 thread 생성!! 하지만 sleep이 없어서 아직 부드럽지 않다.
	// 25. for에서 while로 구문을 바꿔보자 !!! 그러면 먼저 left, right상태를 만들어줘야 한다. 위로 올라가서 상태를 만들자

	@Override
	public void up() {
		isUp = true;
		System.out.println(TAG + ":up()");

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			isUp = false;
		}).start();

	}

	@Override

	// 40 만들 때 위에도 상태, 선언, 초기화 해주기!!
	public void down() {
		System.out.println("바닥충돌감지");
		isDown = true;
		new Thread(() -> {

			while (isDown) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			isDown = false;
		}).start();

	}

}
