package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
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

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerL = new ImageIcon("Image/playerL.png");
		playerR = new ImageIcon("Image/playerR.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
		isRight = false;
		isLeft = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽이동.");
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
		setIcon(playerR);
		System.out.println("오른쪽이동");
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

	public void jump() {
		isJump = true;
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
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isJump = false;
		}).start();
	}

}