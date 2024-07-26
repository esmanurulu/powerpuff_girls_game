

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.Utilities;

import Hw1.GamePanel;
import Hw1.KeyHandler;

public class Entity {
	
	
	GamePanel gamePanel;
	public float x = 500f;
	public float y= 500f;
	public float speed;	
	public BufferedImage blueLImage, redLImage, purpleLImage, blueRImage, redRImage, purpleRImage;
	public String direction;
	public float gravity = 1f;
	public String name;
	public String colorChange = "red";
	KeyHandler keyHandler;
	
	
	
	public Rectangle solidArea = new Rectangle(0, 0, 32, 32);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn ;
	public boolean isFalling = true;
	public boolean isJumping = false;
	
	
	public boolean alive = true;
	public boolean dying = false;
	public int dyingCounter = 0;
	
	public boolean invincible = false;
	public int invincibleCounter = 0;
	
	public Projectile projectile;

	
	public int actionCounter = 0;
	
	
	public int maxLife;
	public int life;
	
	
	public int type; // 0 =player, 1 = monster
	public Entity(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
	}
	
	public void setAction() {
		
	}
	public String getPlayersColor() {
		
		return this.colorChange;
	}
	
	public void applyGravity() {
		gamePanel.collisionCheck.checkTile(this);
		if (!collisionOn && !isJumping) {
            isFalling = true;
		}else {
            isFalling = false;
        }
		
		if(isFalling) {
            y += gravity;
       
        } 
    }
	public void getImage() {
		
	}
	public void damageMonster(int i ) {
		if(i != 99) {
			if(gamePanel.monster.get(i).invincible == false) {
				
				
				if(gamePanel.monster.get(i).name.equals("Red Monster")  && gamePanel.playerColor.equals("blue") ) {
					gamePanel.monster.get(i).life -= 1;
				}else if(gamePanel.monster.get(i).name.equals("Red Monster") && gamePanel.playerColor.equals("red")) {
					gamePanel.monster.get(i).life += 1;
				}else if(gamePanel.monster.get(i).name.equals("Blue Monster") && gamePanel.playerColor.equals("blue")) {
					gamePanel.monster.get(i).life += 1;
				}else if(gamePanel.monster.get(i).name.equals("Blue Monster")  &&  gamePanel.playerColor.equals("red") ) {
					gamePanel.monster.get(i).life -= 1;
				}
				
				
				
				if(gamePanel.monster.get(i).life <=0) {
					gamePanel.monster.get(i).dying = true;
				}
			}
		}
	}
	
	
	public void update() {
		
		setAction();
		
		collisionOn = false;
		gamePanel.collisionCheck.checkTile(this);
		gamePanel.collisionCheck.checkEntity(this, gamePanel.monster);
		
		boolean contactPlayer = gamePanel.collisionCheck.checkPlayer(this);
		
		if(this.type == 1 && contactPlayer == true) {
			damagePlayer();
			
		}
		if(!this.name.equals("tile"))
			applyGravity();
			switch (direction) {
			case ("left"): {
				if(x-speed >= 0) {
					x-=speed;
				}
				break;
			}case ("right"): {
				if(x + speed<= gamePanel.screenWidth - gamePanel.tileSize*2) {
					x +=speed;
				}
				break;
			}
			}
		
		
	}
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, solidArea.width,solidArea.height);
	}
	public void damagePlayer() {
		
			if(gamePanel.player.invincible == false ) {
				gamePanel.player.life -= 1;
				gamePanel.player.invincible = true;
			}
			
		
		
	}
	
	public void draw(Graphics2D graphics2d) {
		

		if(direction.equals("left") || gamePanel.player.lastDirection.equals("left")) {
			
			graphics2d.drawImage(blueLImage,(int)x, (int)y, gamePanel.tileSize, gamePanel.tileSize, null);
		}else if (direction.equals("right") || gamePanel.player.lastDirection.equals("right")) {
			
			graphics2d.drawImage(blueRImage,(int)x, (int)y, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		
		if(dying == true) {
			dyingAnimation(graphics2d);
		}
		
	}
	
	public void dyingAnimation(Graphics2D graphics2d) {
		dyingCounter++;
		
		if(dyingCounter <= 5) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
		}
		
		if(dyingCounter > 5 && dyingCounter <= 10) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
		
		if(dyingCounter > 10 && dyingCounter <=15) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
		}
		
		if(dyingCounter > 15 && dyingCounter <= 20) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
		if(dyingCounter >20 && dyingCounter <= 25) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
		}
		
		if(dyingCounter > 25 && dyingCounter <= 30) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
		if(dyingCounter > 30 && dyingCounter <= 35) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
		}
		
		if(dyingCounter > 35 && dyingCounter <= 40) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
			if(dyingCounter>40) {
				dying = false;
				alive = false;
			}
		
	}
	public BufferedImage setup(String imagePath) {
		
	
		BufferedImage image = null;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream( imagePath + ".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;

	}

}
