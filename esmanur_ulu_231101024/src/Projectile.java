

import Hw1.GamePanel;

public class Projectile  extends Entity {
	
	Entity userEntity;

	public Projectile(GamePanel gamePanel) {
		super(gamePanel);
	}
	
	public void set(Float x, Float y, String direction, boolean alive, String color) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.alive = alive;
		this.life = this.maxLife;
		this.colorChange = color;
		
		
		
		
	}
	public void update() {
		
		switch (gamePanel.player.lastDirection) {
		case "right" :{
			if(x+speed <= 29*gamePanel.tileSize)
				x+=speed;
			break;
		}case "left" : {
			if(x - speed >=0)
				x-=speed;
			break;
		}
			
			

		default:
			break;
		}
	
		
		getImage();
		
		int monsterIndex = gamePanel.collisionCheck.checkEntity(this, gamePanel.monster);
			if(monsterIndex != 99) {
				gamePanel.player.damageMonster(monsterIndex);
				alive = false;
				
			}
		
		
		life--;
		if(life<=0) {
			alive = false;
		}
		
	}
	

}
