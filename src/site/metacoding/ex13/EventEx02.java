package site.metacoding.ex13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	int x = 100;
	int y = 200;

	@Override
	protected void paintComponent(Graphics g) { // g는 붓이다.
		// TODO Auto-generated method stub
		super.paintComponent(g);
		System.out.println("패널다시그려");
		g.drawLine(10, 20, x, y);
	}
}
//기존 패널 안쓰고 덮어쓰겠다 !

public class EventEx02 extends JFrame implements UserInterface {

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1, btn2;

	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListner();

		setVisible(true);
	}

	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("첫글자");
		btn1 = new JButton("글자변경");
		btn2 = new JButton("그림변경");

	}

	@Override
	public void initAssign() {
		add(myPanel);
		myPanel.add(labelText);
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListner() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setText 메서드는 부분 변경!!
				labelText.setText("두번째글자"); // setText 메서드는 내부 paintComponent를 재호출 해준다.paintComponent는 f5처럼 도화지를 새로 만드는

				// 도화지를 전부 다 바꾸다 보니 매우 비효율적 labeltext가 바낀게 아닌 panel이 바뀜.

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30;

				System.out.println(myPanel.x);
				System.out.println(myPanel.y);
				repaint();
			}
		});

	}

	public static void main(String[] args) {
		new EventEx02();
	}

}
