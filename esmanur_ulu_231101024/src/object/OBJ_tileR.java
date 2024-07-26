

import java.awt.Rectangle;

import Entity.Entity;
import Hw1.GamePanel;

public class OBJ_tileR extends Entity {


GamePanel gamePanel;
	public OBJ_tileR(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
		
		name = "tile";
		speed = 1;
		maxLife = 3;
		life = maxLife;
		direction = "right";
		
		collisionOn = true;
		type = 4;
		solidArea.x = 1;
		solidArea.y = 1;
		solidArea.width = 46;
		solidArea.height = 45;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		invincible = true;
		getImage();
	
	
	}
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, solidArea.width,solidArea.height);
	}
	
	public void getImage() {
		

//		if(this.direction.equals("left")) {
//			blueRImage = setup("/obj/blackLeft");
//			blueLImage = setup("/obj/blackLeft");
//			
//		}
//		if(this.direction.equals("right")) {
//			blueRImage = setup("/obj/blackRight");
//			blueLImage = setup("/obj/blackRight");
//						
//		}
//		
		
		if(this.direction.equals("right")) {
			blueRImage = setup("/obj/blackLeft");
			blueLImage = setup("/obj/blackLeft");
			
		}
		if(this.direction.equals("left")) {
			blueRImage = setup("/obj/blackRight");
			blueLImage = setup("/obj/blackRight");
			
		}
		
	}
	public void setAction() {
		collisionOn = true;
		//gamePanel.collisionCheck.checkTile(this);
		
		//System.out.println(gamePanel.collisionCheck.checkCollisionRight(this));
		if(gamePanel.collisionCheck.checkCollisionLeft(this) || gamePanel.collisionCheck.checkCollisionRight(this) || (int)x == gamePanel.screenWidth - gamePanel.tileSize*2 || x ==0  || x==29) {
			
			if(direction.equals("right")) {
				direction = "left";
			}else if(direction.equals("left")) {
				direction = "right";
			}
			
			
			
	}

		if(this.direction.equals("left")) {
			blueRImage = setup("/obj/blackRight");
			blueLImage = setup("/obj/blackRight");
						
			
			
		}
		if(this.direction.equals("right")) {
			blueRImage = setup("/obj/blackLeft");
			blueLImage = setup("/obj/blackLeft");
			
		}
	
	
	}
	
	}
	
