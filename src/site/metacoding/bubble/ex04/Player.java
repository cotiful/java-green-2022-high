package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author codingfarm 플레이어는 좌우 이동이 가능하다. 점프가 가능하다 방울 발
 * 
 */

public class Player extends JLabel { // Player가 label의 상속을 받고 있으니, seticon 사용할 수 있다.
	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	private boolean isRight;
	private boolean isLeft;

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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌
		isRight = false;
		isLeft = false;
	}

	public void left() {
		setIcon(playerL);
		System.out.println("왼쪽이동");
		x = x - 10;
		setLocation(x, y); // paintcomponent 하는 중.

	}

	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		new Thread(() -> {
			while (isRight) {
				x = x + 10;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}
