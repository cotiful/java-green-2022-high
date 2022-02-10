package site.metacoding.bubble.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	// 컴포지션
	private Player player; // 플레이어가 많을경우 List사용
	private BufferedImage image;

	// 컴포지션을 위한 기술 => 의존성 주입 (생성자를 통해서 주입) = DI (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw 하게 읽는다는 뜻 : 날것 그대로 읽는 것
			// 화면에 붙일게 아니라서 JLabel로 읽을 필요 x
			image = ImageIO.read(new File("image/backgroundMapService.png"));
			// System.out.println(image);
			// System.out.println(image.getRGB(10, 10));
			System.out.println("플레이어 위치 x : " + player.getX());
			System.out.println("플레이어 위치 y : " + player.getY());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			// System.out.println("leftColor : "+leftColor);
			// System.out.println("rightColor : "+rightColor);

			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

			// 바닥 충돌
			if (bottomColor != -2) {
				player.setDown(false);
			} else if (bottomColor == -2) { // 바닥으로 바로 떨어지게 만듦..
				if (player.isUp() == false && player.isDown() == false) {
					player.down();
				}
			}

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				{
					player.setRightWallCrash(false);
					player.setLeftWallCrash(false);
				}
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}