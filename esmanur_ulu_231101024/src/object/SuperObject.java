

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Hw1.GamePanel;

public  class SuperObject {
	
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);  
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/obj/New Piskel.png"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		g2.drawImage(image, worldX, worldY, gamePanel.tileSize, gamePanel.tileSize, null);
		
	}

}
