

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedHashSet;

import Entity.Entity;
import Hw1.GamePanel;

public class MON_BlueMon extends Entity {
	
	GamePanel gamePanel;

	public MON_BlueMon(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
		
		
		name = "Blue Monster";
		speed = 1;
		maxLife = 3;
		life = maxLife;
		direction = "right";
		
		
		type = 1;
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();
		
	}
	public void getImage() {
		
		
		blueRImage = setup("/monsters/blueEnemy");
		
		blueLImage = setup("/monsters/blueLeftEnemy");
		
	}
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, solidArea.width,solidArea.height);
	}

	public void setAction() {
		collisionOn = false;
		
		if(gamePanel.collisionCheck.checkCollisionLeft(this) || gamePanel.collisionCheck.checkCollisionRight(this) || (int)x == gamePanel.screenWidth - gamePanel.tileSize*2 || x == 0  || gamePanel.collisionCheck.checkPlayer(this) || x==29) {
			
			if(direction.equals("right")) {
				direction = "left";
			}else if(direction.equals("left")) {
				direction = "right";
			}
			
			
			
	}
	

}
}