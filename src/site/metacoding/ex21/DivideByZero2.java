package site.cotiful.ex21;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class DivideByzero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException

        // 통신, 사용자입력 예외처리 !!
        boolean check = true;

        try {
            while (check) {
                int x = sc.nextInt();
                StringBuffer sb = new StringBuffer();
                sb.append(x);
                int result = x / 0;
                if (result != 0) {
                    break;
                }
                System.out.println("받은 값:" + x);
            }
        } catch (InputMismatchException e) {
            System.out.println("===========");
            System.out.println("문자를 넣지마!");
            System.out.println("==========");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("===========");
            System.out.println("0 넣지마!");
            System.out.println("==========");
            e.printStackTrace();

        }
    }

}
