package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private BubbleFrame context; // composition
	private Player player;

	private int x;
	private int y;
	private static final int SPEED = 1;

	private ImageIcon bubble, bomb;

	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();
	}

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 방향체크

	public void left() {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				x = x - SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void right() {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				x = x + SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
