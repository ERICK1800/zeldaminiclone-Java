package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritsheet {
	
	public static BufferedImage spritsheet;
	public static BufferedImage[] player_front;
	public static BufferedImage[] inimigo_front;
	public static BufferedImage tileWall;
	
	public Spritsheet() {
		try {
			spritsheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		player_front[0] = Spritsheet.getSprint(0, 11, 16, 16);
		player_front[1] = Spritsheet.getSprint(16, 11, 16, 16);
		
		inimigo_front = new BufferedImage[2];
		inimigo_front[0] = Spritsheet.getSprint(297, 221, 16, 16);
		inimigo_front[1] = Spritsheet.getSprint(313, 221, 16, 16);
		
		tileWall = Spritsheet.getSprint(280, 221, 16, 16);
	}
	
	public static BufferedImage getSprint(int x, int y, int width, int height) {
		return spritsheet.getSubimage(x, y, width, height);
	}
}
