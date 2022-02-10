package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//백그라운드 서비스(독립적인 스레드로 돌려야 함)
public class BackgroundMapService implements Runnable {

	// composition
	private Player player;
	private BufferedImage image;

	// 컴포지션을 위한 기술=> 의존성 주입(생성자를 통해서 주입)=dependeny injection.
	public BackgroundMapService(Player player)// main에서 받는게 아니니깐, bufferedimage는 변수필요없
	{
		this.player = player;
		try {
			// ImageIO,,bufferedreader로 읽으면 raw 하게 읽음: 낡것 그대로 읽는 것. 이미지 크기를 모르니깐.

			image = ImageIO.read(new File("image/test.png"));
			// System.out.println(image);
			// System.out.println(image.getRGB(10, 10));,x,y가 위치돼있는 색깔을 알려줌.
			// Color color = new Color(image.getRGB(10, 10));

			// 플레이어가 있는 위치의 색상 알아보기!! (플레이어의 위치는 label의 왼쪽상단에 위치해 있음)

			// 색상 계산을 위해서 (while구문) 넣어주기!, 재워야 하니 sleep해주

			/**
			 * runnable 타입을 implemnet를 해주고 나면 run 메서드로 주석된 값을 넣는다.
			 * 
			 * while (true) { Color color = new Color(image.getRGB(player.getX() + 50,
			 * player.getY())); System.out.println(color.getRed());
			 * System.out.println(color.getGreen()); System.out.println(color.getBlue());
			 * System.out.println("============"); Thread.sleep(1000); //현재 main thread가
			 * while구문 작동하고 있다. main thread가 이 일 밖에 안하고 있어서 아직까진 가능하다. }
			 */
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BackgroundMapService() {

	}

	@Override
	public void run() {
		while (true) {
			try {
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				System.out.println(color.getRed());
				System.out.println(color.getGreen());
				System.out.println(color.getBlue());
				System.out.println("============");
				Thread.sleep(10); // 충돌감지를 미세하게 조절하는 방법.
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
