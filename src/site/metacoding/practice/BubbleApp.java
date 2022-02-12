package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	private static final String TAG = "BubbleApp : ";

	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap; // 8
	private Player player; // 9

	public BubbleApp() {
		// System.out.println(TAG + "생성자");
		initObject();
		initSetting();
		initListner();
		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp();

	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap(); // 10 백그라운드맵 자체가 label로 돼있따,.
		setContentPane(backgroundMap);

		player = new Player(backgroundMap); // 11 , 31 player가 backgroundMap을 알아야 색깔을 알 수 있따.

		// add(backgroundMap); // 12 add 할 필요없
		add(player); // 13

	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void initListner() {
		mContext.addKeyListener(new KeyAdapter() { // 19 keyListner 생성,ADapter는마우스, 키보드 다 있음.

			@Override
			public void keyPressed(KeyEvent e) { // 20 , 21 오른쪽 키가 누르면 right가 호출되도록 !!
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					if (!player.isRight()) // 26: 키값에 조건문 넣어주기. 한번에 실행되게 해줌! 이벤트에 쌓이지 않도록
						player.right();

					break; // switch 종료,break 없으면 밑에껄 계속 검사함. if, else if 와 다르게 if, if, if 구문이기 때문에
				case KeyEvent.VK_LEFT:
					if (!player.isLeft())
						player.left(); // if는 한줄이면 중괄호 없이 사용가능. !는 false를 의미한다.
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp())
						player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { // 27_1. 떗다가 누르면 다시 움직이게, false로 만들어주기. 즉 true로 움직이고 있었떤걸 FAlse로 바꿈.

				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					player.setRight(false);

					break; // switch 종료,break 없으면 밑에껄 계속 검사함. if, else if 와 다르게 if, if, if 구문이기 때문에
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				}
			}
		});

	}

}