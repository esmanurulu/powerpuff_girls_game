

import java.awt.Rectangle;

import Entity.Entity;
import Hw1.GamePanel;

public class MON_RedMon extends Entity {
	GamePanel gamePanel;

	public MON_RedMon(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
		
		name = "Red Monster";
		speed = 1;
		maxLife = 3;
		life = maxLife;
		direction = "right";
		
		type = 1;
		solidArea.x = 1;
		solidArea.y = 3;
		solidArea.width = 32;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();
		
	}
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, solidArea.width,solidArea.height);
	}
	
	public void getImage() {
		
		
		blueRImage = setup("/monsters/redEnemy");
		blueLImage = setup("/monsters/redLeftEnemy");
		
	}
	public void setAction() {
		collisionOn = false;

		if(gamePanel.collisionCheck.checkCollisionLeft(this) || gamePanel.collisionCheck.checkCollisionRight(this) || (int)x == gamePanel.screenWidth - gamePanel.tileSize*2 || x ==0  || gamePanel.collisionCheck.checkPlayer(this) || x==29) {
			
			if(direction.equals("right")) {
				direction = "left";
			}else if(direction.equals("left")) {
				direction = "right";
			}
			
			
			
	}
	

}

}
