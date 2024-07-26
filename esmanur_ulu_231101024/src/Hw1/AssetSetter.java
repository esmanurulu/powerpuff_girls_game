




import java.util.Random;

import Entity.Entity;
import Monster.MON_BlueMon;
import Monster.MON_PurpleMon;
import Monster.MON_RedMon;


import object.OBJ_Key;
import object.OBJ_Mantar;
import object.OBJ_Mantar2;

import object.OBJ_fireDoor;
import object.OBJ_fireDoor2;

import object.OBJ_tile;
import object.OBJ_tileR;

public class AssetSetter {
	
	int count = 0;
	int monster = 0;
	int time = 0;
	int countFire=0;
	GamePanel gamePanel;
	
	public AssetSetter(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
	} 
	public void setObject() {
		
		int setX = 6;
		int setY = 22;
		
		for(int i = 0; i<14; i++) {
			
			gamePanel.obj[i] = new OBJ_Key();
			gamePanel.obj[i].worldX = setX*gamePanel.tileSize;
			gamePanel.obj[i].worldY = setY*gamePanel.tileSize;
			
			setX++;
			if(i==13) {
				break;
			}
		}
		
		
		
		gamePanel.obj[14] = new OBJ_Mantar();
		gamePanel.obj[14].worldX = 4*gamePanel.tileSize;
		gamePanel.obj[14].worldY = 18*gamePanel.tileSize;
		
		gamePanel.obj[15] = new OBJ_Mantar();
		gamePanel.obj[15].worldX = 9*gamePanel.tileSize;
		gamePanel.obj[15].worldY = 22*gamePanel.tileSize;
		
		gamePanel.obj[29] = new OBJ_Mantar();
		gamePanel.obj[29].worldX = 15*gamePanel.tileSize;
		gamePanel.obj[29].worldY = 22*gamePanel.tileSize;
		
		gamePanel.obj[16] = new OBJ_Mantar();
		gamePanel.obj[16].worldX = 18*gamePanel.tileSize;
		gamePanel.obj[16].worldY = 22*gamePanel.tileSize;
		
		
		
		gamePanel.obj[28] = new OBJ_fireDoor();
		gamePanel.obj[28].worldX = 25*gamePanel.tileSize;
		gamePanel.obj[28].worldY = 15*gamePanel.tileSize;
		
		gamePanel.obj[17] = new OBJ_fireDoor();
		gamePanel.obj[17].worldX = 25*gamePanel.tileSize;
		gamePanel.obj[17].worldY = 16*gamePanel.tileSize;
		
		gamePanel.obj[18] = new OBJ_fireDoor();
		gamePanel.obj[18].worldX = 25*gamePanel.tileSize;
		gamePanel.obj[18].worldY = 17*gamePanel.tileSize;
		
		gamePanel.obj[19] = new OBJ_fireDoor();
		gamePanel.obj[19].worldX = 25*gamePanel.tileSize;
		gamePanel.obj[19].worldY = 18*gamePanel.tileSize;
		
		
		
		
		
		
		gamePanel.obj[20] = new OBJ_Mantar2();
		gamePanel.obj[20].worldX = 12*gamePanel.tileSize;
		gamePanel.obj[20].worldY = 11*gamePanel.tileSize;
		
		gamePanel.obj[21] = new OBJ_Mantar2();
		gamePanel.obj[21].worldX = 20*gamePanel.tileSize;
		gamePanel.obj[21].worldY = 11*gamePanel.tileSize;
		
		gamePanel.obj[22] = new OBJ_Mantar2();
		gamePanel.obj[22].worldX = 27*gamePanel.tileSize;
		gamePanel.obj[22].worldY = 11*gamePanel.tileSize;
		
		gamePanel.obj[23] = new OBJ_Mantar2();
		gamePanel.obj[23].worldX = 28*gamePanel.tileSize;
		gamePanel.obj[23].worldY = 14*gamePanel.tileSize;
		
		
		gamePanel.obj[24] = new OBJ_fireDoor2();
		gamePanel.obj[24].worldX = 5*gamePanel.tileSize;
		gamePanel.obj[24].worldY = 11*gamePanel.tileSize;
		
		gamePanel.obj[25] = new OBJ_fireDoor2();
		gamePanel.obj[25].worldX = 5*gamePanel.tileSize;
		gamePanel.obj[25].worldY = 12*gamePanel.tileSize;
		
		gamePanel.obj[26] = new OBJ_fireDoor2();
		gamePanel.obj[26].worldX = 5*gamePanel.tileSize;
		gamePanel.obj[26].worldY = 13*gamePanel.tileSize;
		
		gamePanel.obj[27] = new OBJ_fireDoor2();
		gamePanel.obj[27].worldX = 5*gamePanel.tileSize;
		gamePanel.obj[27].worldY = 14*gamePanel.tileSize;
		
		setX = 7;
		setY = 14;

		for(int i = 30; i<43; i++) {
			gamePanel.obj[i] = new OBJ_Key();
			gamePanel.obj[i].worldX = setX*gamePanel.tileSize;
			gamePanel.obj[i].worldY = setY*gamePanel.tileSize;
			setX++;
		}
		setX = 8;
		setY = 9;
		for(int i = 43; i<58;i++) {
			gamePanel.obj[i] = new OBJ_Key();
			gamePanel.obj[i].worldX = setX*gamePanel.tileSize;
			gamePanel.obj[i].worldY = setY*gamePanel.tileSize;
			setX++;
			
		}
		
		gamePanel.obj[58] = new OBJ_Key();
		gamePanel.obj[58].worldX = 16*gamePanel.tileSize;
		gamePanel.obj[58].worldY = 4*gamePanel.tileSize;
		
		gamePanel.obj[60] = new OBJ_Key();
		gamePanel.obj[60].worldX = 17*gamePanel.tileSize;
		gamePanel.obj[60].worldY = 4*gamePanel.tileSize;
		
		gamePanel.obj[59] = new OBJ_Key();
		gamePanel.obj[59].worldX = 21*gamePanel.tileSize;
		gamePanel.obj[59].worldY = 4*gamePanel.tileSize;
		
		gamePanel.obj[61] = new OBJ_Key();
		gamePanel.obj[61].worldX = 12*gamePanel.tileSize;
		gamePanel.obj[61].worldY = 4*gamePanel.tileSize;
		
		gamePanel.obj[62] = new OBJ_Key();
		gamePanel.obj[62].worldX = 11*gamePanel.tileSize;
		gamePanel.obj[62].worldY = 4*gamePanel.tileSize;
		
		gamePanel.obj[63] = new OBJ_Key();
		gamePanel.obj[63].worldX = 22*gamePanel.tileSize;
		gamePanel.obj[63].worldY = 4*gamePanel.tileSize;
		
		
		

	}

	
	public void setMonster() {
		
		
		
		gamePanel.monster.clear();
	
		gamePanel.monster.add(0, new OBJ_tileR(gamePanel));
		gamePanel.monster.get(0).x = gamePanel.tileSize*5;
		gamePanel.monster.get(0).y = gamePanel.tileSize*2;
		
		
	
		gamePanel.monster.add(1, new OBJ_tile(gamePanel));
		gamePanel.monster.get(1).x = gamePanel.tileSize*6;
		gamePanel.monster.get(1).y = gamePanel.tileSize*2;
		

		gamePanel.monster.add(2, new MON_BlueMon(gamePanel));
		gamePanel.monster.get(2).x = gamePanel.tileSize*28;
		gamePanel.monster.get(2).y = gamePanel.tileSize*18;
		
		
	
		gamePanel.monster.add(2,new MON_RedMon(gamePanel));
		gamePanel.monster.get(2).x = gamePanel.tileSize*2;
		gamePanel.monster.get(2).y = gamePanel.tileSize*11;
			

		gamePanel.monster.add(2,new MON_PurpleMon(gamePanel));
		gamePanel.monster.get(2).x = gamePanel.tileSize*16;
		gamePanel.monster.get(2).y = gamePanel.tileSize*0;
		
		
		
		
	}
	public Entity monsterSpawner() {
		Entity monster = null;
		
		Random random = new Random();
		int randomNum = random.nextInt(3);
		if(randomNum == 0) {
			monster = new MON_PurpleMon(gamePanel);
			monster.x = 1*gamePanel.tileSize;
			monster.y = 16*gamePanel.tileSize;
			monster.direction = "right";
			
		}
		if(randomNum==1) {
			monster = new MON_BlueMon(gamePanel);
			monster.x = 28*gamePanel.tileSize;
			monster.y = 6*gamePanel.tileSize;
			monster.direction = "left";
		}
		if(randomNum == 2) {
			monster = new MON_RedMon(gamePanel);
			monster.x = 1*gamePanel.tileSize;
			monster.y = 3*gamePanel.tileSize;
			monster.direction = "right";
		}
		
		
		return monster;
	}


}
