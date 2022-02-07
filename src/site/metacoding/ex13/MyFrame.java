package site.metacoding.ex13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Ctrl + Shift + O
public class MyFrame extends JFrame{
    public MyFrame() {
        setSize(600, 400); // w, h
        setLocationRelativeTo(null); // 프레임 화면 중앙 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료

    }
    public MyFrame(int w, int h) {
        setSize(w, h); // w, h
        setLocationRelativeTo(null); // 프레임 화면 중앙 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료

    }
}