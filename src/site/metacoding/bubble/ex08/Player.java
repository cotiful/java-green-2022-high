package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author codingfarm 플레이어는 좌우 이동이 가능하다. 점프가 가능하다 방울 발
 * 
 */

public class Player extends JLabel { // Player가 label의 상속을 받고 있으니, seticon 사용할 수 있다.
	private BubbleFrame context;
	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	private boolean isRight;
	private boolean isLeft;
	private boolean up;
	private boolean down;
	private int direction; // -1은 왼쪽방향, 1은 오른쪽 방향, 0 초기

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	private boolean leftWallCrash;
	private boolean rightWallCrash;

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

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;

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

	public Player(BubbleFrame context) {
		this.context = context;
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");
	}

	private void initSetting() {
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌
		isRight = false;
		isLeft = false;
		up = false;
		down = false;
		leftWallCrash = false;
		rightWallCrash = false;
		direction = 0;
	}

	public void attack() {
		// 1. 버블 new
		Bubble bubble = new Bubble(context);
		// 2. 화면에 붙여야함
		context.add(bubble);
		// 3. 수평 이동 (플레이어의 방향)
		if (direction == 1) {
			bubble.right();
		} else if (direction == 0) {
			bubble.left();
		}
	}

	public void left() {
		isLeft = true;
		direction = -1;
		setIcon(playerL);
		System.out.println("왼쪽이동");
		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void right() {
		isRight = true;
		direction = 1;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

	}

	public void up() {

		System.out.println("업");

		// 점프는 for 문 돌리기.

		// up일때는 sleep(5) ->for
		// down일때는 sleep(3) ->for
		up = true;

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
			up = false;
			down(); // 메서드 재활용 !
		}).start();

	}

	public void down() {

		System.out.println("다운");
		down = true;

		new Thread(() -> {

			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			down = false;
		}).start();

	}
}