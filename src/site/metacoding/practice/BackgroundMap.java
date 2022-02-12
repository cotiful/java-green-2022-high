package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel {
	private ImageIcon backgroundMap; // 1 눈에 보이는
	private BufferedImage image; // 30 눈에 안보이는 계산

	public BufferedImage getImage() { // 30-1 플레어와 백그라운드맵이연동게 게터세터 만들어주기.
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BackgroundMap() { // 6
		try { // 31
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap);

	}

}
