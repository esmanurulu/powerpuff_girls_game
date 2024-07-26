

import java.security.PublicKey;

import Entity.Projectile;
import Hw1.GamePanel;

public class OBJ_redFireball  extends OBJ_Fireball{

	
	GamePanel gamePanel;
	
	public OBJ_redFireball(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
		
		name = "red fireball";
		

		speed = 6; 
		maxLife = 80;
		life = maxLife;
		alive = false;
		getImage();
		
		
		
	}
	public void getImage() {
		
		if( gamePanel.playerColor.equals("red")) {
			redLImage = setup("/obj/redFireball");
			blueLImage = setup("/obj/redFireball");
			blueLImage = setup("/obj/redFireball");
			blueRImage = setup("/obj/redFireball");
		}else if( gamePanel.playerColor.equals("blue")) {
			blueLImage = setup("/obj/blueFireball");
			blueRImage = setup("/obj/blueFireball");
			redLImage = setup("/obj/blueFireball");
			blueLImage = setup("/obj/blueFireball");
		}
		
		
	}
	

}
