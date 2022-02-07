package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	JPanel myPanel;
	JButton btn1, btn2;
	JCheckBox checkBox1;
	JLabel labelText, labellmg;

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();
		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initObject() {
		myPanel = new JPanel();
		btn1 = new JButton("클릭하세요");
		btn2 = new JButton("클릭하세요 22");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("레이블1");
		// 내 프로젝트 위치부터 상대경로가 지정되어 있다.
		labellmg = new JLabel(new ImageIcon("image/dog.jpeg"));
	}

	private void initAssign() {
		myPanel.add(btn1);
		myPanel.add(btn2);
		add(myPanel);
		myPanel.add(checkBox1);
		myPanel.add(labelText);
		myPanel.add(labellmg);
	}

	private void initListener() {
		checkBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				System.out.println(e.toString());

				if (e.getStateChange() == 1) {
					System.out.println("체크되었습니다.");
				} else {
					System.out.println("체크되지 않았습니다.");
				}
			}
		});

		// 윈도우야 지켜봐줘 이 버튼을!!..null을 넣으면 우짜라고 이러면서 반응 못 해줌 !!. Event programming
		btn1.addActionListener(new ActionListener() {

			// 버튼이 클릭되면 윈도우가 해당 메서드를 콜백해준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭이되었습니다.");

			}
		});

		// 윈도우야 지켜봐줘 이 버튼을!!..null을 넣으면 우짜라고 이러면서 반응 못 해줌 !!. Event programming
		btn2.addActionListener((ActionEvent e) -> {

			System.out.println("액션2가 실행되었습니다");
		});
	}

	public static void main(String[] args) {
		new EventEx01();

	}
}
