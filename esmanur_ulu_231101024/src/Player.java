

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Hw1.CollisionCheck;
import Hw1.GamePanel;
import Hw1.KeyHandler;
import object.OBJ_Fireball;
import object.OBJ_blueFireball;
import object.OBJ_redFireball;
import object.SuperObject;


public class Player extends Entity {
	
	
	
	public String colorChange = "red";
	BufferedImage image;
	String lastDirection = "right";
	
	Graphics2D graphics2;
	KeyHandler keyHandler;
	public float gravity = 0.5f;
	
	int hasMushroom1 = 0;
	int hasMushroom2 = 0;
	
	public boolean isFinished = false;
	
	private int jumpHeight = 130; 
    private float jumpSpeed = 4f; 

    
    public int jumpAvailableCounter = 0;
    public boolean right = true;
    public boolean left = false;
    
    public boolean inAir = false;
    
    CollisionCheck  cccc ;
	
    public int score = 0;
    
    public int col = 0; //tile =2, mons =1
    	
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		super(gamePanel);
		
		
		this.keyHandler = keyHandler;
		
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		score = 0;
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 2*gamePanel.tileSize;
		y = 666;
		speed = 4;
		colorChange = "red";
		direction = "left";
		hasMushroom1 = 0;
		hasMushroom2 = 0;
		
		projectile = new OBJ_Fireball(gamePanel);
		maxLife  = 1;
		life = maxLife;
		score = 0;
		gamePanel.monsters = 4;
		
		
	}
	public String getPlayersColor() {
		return this.colorChange;
	}
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, solidArea.width,solidArea.height);
	}

	
	public void getPlayerImage() {
		
		try {
			
			 blueRImage = ImageIO.read(getClass().getResourceAsStream("/player/blueRightPlayer.png"));
			 redRImage = ImageIO.read(getClass().getResourceAsStream("/player/redRightPlayer.png"));
			 purpleRImage = ImageIO.read((getClass().getResourceAsStream("/player/purpleRightPlayer.png")));
			 blueLImage = ImageIO.read(getClass().getResourceAsStream("/player/blueLeftt.png"));
			 redLImage = ImageIO.read(getClass().getResourceAsStream("/player/redLeftt.png"));
			 purpleLImage = ImageIO.read((getClass().getResourceAsStream("/player/purpleLeftt.png")));
			 
		
		
		} catch (IOException e) {
			e.printStackTrace();
			
			
		}
	}
	public void applyGravity() {

		gamePanel.collisionCheck.checkTile(this);
		
		if(!gamePanel.collisionCheck.checkDownTile(this)) {
			
			if (!isJumping && !collisionOn) {
	            isFalling = true;
	            inAir = true;
			}else if (collisionOn) {
	            isFalling = false;
	            inAir = false;
	        }else {
				isFalling = false;
				inAir = true;
			}
			
			if(isFalling) {
	            y += gravity;
	            inAir = true;
	        }
		}
		
    }
	private void handleJump() {
		 
		
		gamePanel.collisionCheck.checkTile(this);

		      
		if (keyHandler.jumpPressed && !isJumping  && !inAir && !isFalling) {
			
            isJumping = true;
            direction = "up";
            inAir = true;
        }
		direction = "up";
		gamePanel.collisionCheck.checkTile(this);
		
		if(colorChange.equals("purple"))
			jumpHeight = 150;
		
		if((int)y - jumpHeight < 0  && colorChange.equals("purple")) {
			jumpHeight = (int)y;	
		}
         if (isJumping && collisionOn == false && (int)y - jumpHeight >=0 ) {
        	 
            y -= jumpSpeed;
            jumpHeight -= jumpSpeed;
            inAir = true;
            isFalling = true;
            
            if (jumpHeight <= 0) {
                isJumping = false;
                jumpHeight = 130;
                inAir = false;
            }
           
        }else {
			isJumping = false;
			isFalling = true;
			inAir = true;
		}
        if(!isJumping && inAir){
        	
        	direction = "down";
        	applyGravity();
        }
    }
	
	
	public void pickUpObject(int index) {
		
		if(index != 99) {
			String objName = gamePanel.obj[index].name;
			
			switch(objName) {
			case "Key": {
				gamePanel.playSE(1);
				score +=5;
				gamePanel.obj[index] = null;
				break;
			}case "Mantar" : {
				hasMushroom1++;
				
				score +=50;
				gamePanel.obj[index] = null;
				break;
			}case "Fire Door": {
				if(hasMushroom1 ==4) {
				gamePanel.obj[index] = null;
				}
				break;
			}case "Mantar2" : {
				hasMushroom2++;
				score +=50;
				gamePanel.obj[index] = null;
				break;
			}case "Fire Door2": {
				if(hasMushroom2 ==4) {
				gamePanel.obj[index] = null;
				
				}
				break;
			}
			
			
			}
			
			
		}
		
		
		
		
	}
	

	public void contactMonster(int i ) {
		if(i != 99) {
			
			if(invincible == false ) {
				this.life -=1;
				invincible = true;
			}
			
		
			
		}
	}
	
//	public void contactFire(int i ) {
//		if(i != 99) {
//			if(invincible == false ) {
//				this.life -=1;
//				invincible = true;
//			}
//			
//			
//		}
//	}

		
	
	public void update() {
	
		
		if( ((int)gamePanel.player.x <= 48 ) && ( (int)gamePanel.player.y <= 144) ) {
			isFinished =true;
			gamePanel.gameState = gamePanel.finishState;
		}
		
		
		String movementDirection = null;
		
		handleJump();
		applyGravity();
		
		
		if(keyHandler.jumpPressed == true) {
			movementDirection = "jump";
			
		}
		
		if(keyHandler.downPressed == true) {
			movementDirection = "down";

		} 
		
		
		if(keyHandler.rightPressed == true) {
			
			lastDirection = "right";
			movementDirection = "right";
			if(colorChange.equals("red")) {
				image = redRImage;
				
			}else if(colorChange.equals("blue")) {
				image = blueRImage;
				
			}else if(colorChange.equals("purple")) {
				image = purpleRImage;
				
			}
			
		
		} 
		if(keyHandler.leftPressed == true) {
			lastDirection = "left";
			movementDirection = "left";
			if(colorChange.equals("red")) {
				image = redLImage;
				
			}else if(colorChange.equals("blue")) {
				image = blueLImage;
				
			}else if(colorChange.equals("purple")) {
				image = purpleLImage;
	
			}
			
		}
		if(keyHandler.onePressed == true) {
			colorChange = "red";
			gamePanel.playerColor = colorChange;
			
		}
		if(keyHandler.twoPressed == true ) {
			colorChange = "blue";
			gamePanel.playerColor = colorChange;
			
		}
		if(keyHandler.threePressed == true) {
			colorChange = "purple";
			gamePanel.playerColor = colorChange;
			
		}
	
		
		if(movementDirection !=null ) {
			direction = movementDirection;
			collisionOn = false;
			
			
			//object check
			int objIndex =	gamePanel.collisionCheck.checkObject(this, true);
			pickUpObject(objIndex);
			
			
			//monster check
			int monsterIndex = gamePanel.collisionCheck.checkEntity(this, gamePanel.monster);
			if(this.y != 2*gamePanel.tileSize) {
				contactMonster(monsterIndex);
			}
				
			
			
			
			//move
			if(collisionOn == false) {
				
				
				applyGravity();
				
				switch(direction) {
				case "jump":
					
					handleJump();
					break;
				case "left":
					
					if(colorChange.equals("red")) {
						colorChange = "red";
						gamePanel.playerColor = colorChange;
						image = redLImage;
						
					}else if(colorChange.equals("blue")) {
						colorChange = "blue";
						gamePanel.playerColor = colorChange;
						image = blueLImage;
						
					}else if(colorChange.equals("purple")) {
						colorChange = "purple";
						gamePanel.playerColor = colorChange;
						image = purpleLImage;
			
					}
					
					if( gamePanel.collisionCheck.checkCollisionLeft(this) != true ) {
					
						if(x - speed >= 0) {
							x -= speed;
						}else {
							x = 0;
						}
					}
					break;
				case "right":
					
					
					if(colorChange.equals("red")) {
						colorChange = "red";
						gamePanel.playerColor = colorChange;
						image = redRImage;
						
					}else if(colorChange.equals("blue")) {
						colorChange = "blue";
						gamePanel.playerColor = colorChange;
						image = blueRImage;
						
					}else if(colorChange.equals("purple")) {
						colorChange = "purple";
						gamePanel.playerColor = colorChange;
						image = purpleRImage;
						
					}
					if( gamePanel.collisionCheck.checkCollisionRight(this) != true)	{				
					
						
						if(x + speed <= gamePanel.screenWidth - gamePanel.tileSize*2) {
							x+= speed;
						}else {
							x = gamePanel.screenWidth - gamePanel.tileSize*2 +2;
						
						}
					}
					break;
				}
			}
		} 
		
		if(keyHandler.spacePressed == true && projectile.alive == false) {
			if(gamePanel.playerColor.equals("red")) {
				projectile.set( x, y, direction, true, "red");
			}else if(gamePanel.playerColor.equals("blue")) {
				projectile.set( x, y, direction, true, "blue");
			}
			gamePanel.projectileList.add(projectile);
			
		}
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 100) {
				invincible = false;
				invincibleCounter=0;
			}
		}
		
		if(life <= 0) {
			gamePanel.gameState = gamePanel.gameOverState;
			
		}
		
		applyGravity();
		
	}
	
	
	
	public void draw(Graphics2D graphics2) {
		

		image = null;
		
		
		switch(direction) {
		case "left":
			
			if(colorChange.equals("red")) {
				image = redLImage;
				
			}else if(colorChange.equals("blue")) {
				image = blueLImage;
				
			}else if(colorChange.equals("purple")) {
				image = purpleLImage;
	
			}
		
		case "right":
			if(colorChange.equals("red")) {
				image = redRImage;
				
			}else if(colorChange.equals("blue")) {
				image = blueRImage;
				
			}else if(colorChange.equals("purple")) {
				image = purpleRImage;
				
			}
		
		}
		
			
		
		switch (colorChange) {
		case "red": 
			image = redRImage;
			break;
		case "blue":
			image = blueRImage;
			break;
		case "purple":
			image = purpleRImage;
			break;
		}
		
		switch (direction) {
		case "left":
			if(colorChange.equals("red")) {
				image = redLImage;
				break;
			}
			if(colorChange.equals("blue")) {
				image = blueLImage;
				break;
			}
			if(colorChange.equals("purple")) {
				image = purpleLImage;
				break;
			}
		case "right":
			if(colorChange.equals("red")) {
				image = redRImage;
				break;
			}
			if(colorChange.equals("blue")) {
				image = blueRImage;
				break;
			}
			if(colorChange.equals("purple")) {
				image = purpleRImage;
				break;
			}
		}
		 
		
		graphics2.drawImage(image, (int)x, (int)y, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2.drawString(Integer.toString(score) , 26*gamePanel.tileSize, 2*gamePanel.tileSize);
		
	
	}
	
}
