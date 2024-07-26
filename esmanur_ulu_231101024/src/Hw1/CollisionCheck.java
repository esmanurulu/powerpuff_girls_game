

import java.util.ArrayList;

import Entity.Entity;
import Entity.Player;


public class CollisionCheck {
	
	GamePanel gamePanel;
	Player player;
	public static boolean rightCheck = false;
	
	public CollisionCheck(GamePanel gPanel) {
		
		this.gamePanel = gPanel;
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		 int index = 99;
		
		for(int i = 0; i<gamePanel.obj.length; i++) {
			
			if(gamePanel.obj[i] != null) {
				
				entity.solidArea.x = (int)entity.x + entity.solidArea.x;
				entity.solidArea.y = (int)entity.y + entity.solidArea.y;
				
				gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
				gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;
				
				
				switch (entity.direction) {
				case "right" :{
					entity.solidArea.x +=entity.speed;
					if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
						if(gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						
						if(player == true) {
							index = i;
						}
					}
					break;
				}
		 		case "jump" :{
					
					
				}
				case "left" :{
					entity.solidArea.x -=entity.speed;
					if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
						if(gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						
						if(player == true) {
							index = i;
						}
					}
					break;
					
				}
				case "down" : {

					break;
					
					
				}
				
				
			}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
				gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
			}
		}
		
		return index;
		
		
	}
	public boolean checkCollisionRight (Entity entity) {
		
		
		int entityRightX = (int)entity.x + (int)entity.solidArea.x;
		int entityBottomY = (int)entity.y +(int) entity.solidArea.y + (int)entity.solidArea.height;
		int entityTopY = (int)entity.y + (int)entity.solidArea.y;
		int entityRightCol = (int)entityRightX / gamePanel.tileSize;
		
		int entityBottomRow = entityBottomY / gamePanel.tileSize;
		int entityTopRow = entityTopY / gamePanel.tileSize;
		int middle = (entityBottomRow + entityTopRow) /2 ;
		boolean collided = false;
		if (entity.direction.equals("right")){
			if(entityRightCol<gamePanel.tileManager.mapTile[0].length) {
				if(entityRightCol<23) {
				collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol+1][middle]].collision;
				}else if(entityRightCol==24) {
					collided=true;
					
				}else {
					collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol][middle]].collision;
				}	
			}
			
		}
		
		
		return collided;
	}
	
	
	public boolean checkCollisionLeft(Entity entity) {
		int entityLeftX = (int)entity.x + (int)entity.solidArea.x;
		int entityBottomY = (int)entity.y +(int) entity.solidArea.y + (int)entity.solidArea.height;
		int entityTopY = (int)entity.y + (int)entity.solidArea.y;
		int entityLeftCol = (int)entityLeftX / gamePanel.tileSize;
		
		int entityBottomRow = entityBottomY / gamePanel.tileSize;
		int entityTopRow = entityTopY / gamePanel.tileSize;
		int middle = (entityBottomRow + entityTopRow) /2;
		
		boolean collided = false;
		
		if(entity.direction.equals("left")) {
			if(entityLeftCol>=0) {
				collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityLeftCol][middle]].collision;
			}
	
		}else {
			collided =false;
		}
		

		return collided;
		
	}
	public boolean checkDownTile(Entity entity) {
		boolean collided = false;
		
		int entityLeftx = (int) (entity.x + entity.solidArea.x);
		int entityBottomy = (int) (entity.y + entity.solidArea.y + entity.solidArea.height);
	
		int entityLeftCol = entityLeftx/gamePanel.tileSize;
		int entityBottomRow = entityBottomy/gamePanel.tileSize;
		
		int tileN = gamePanel.tileManager.mapTile[entityLeftCol][entityBottomRow];
		String playerColor = gamePanel.playerColor;
		
		if( ( tileN  == 2 || tileN  == 5 || tileN == 8) 
			&& (playerColor.equals("red") || playerColor.equals("purple")) ) {
			gamePanel.player.life -=1;
		}
		if((tileN ==1 || tileN == 4 || tileN == 7) 
				&& (playerColor.equals("blue") || playerColor.equals("purple"))) {
			gamePanel.player.life -=1;
		}
			
		
		for(int i = 0; i<gamePanel.monster.size(); i++) {
			
			
			if(gamePanel.monster.get(i) != null ) {
			if( entityBottomRow == 2) {
				

				if( (!gamePanel.collisionCheck.checkPlayer(gamePanel.monster.get(1)) && ((int) entity.x == (int)gamePanel.monster.get(1).x || (int) entity.x == (int)gamePanel.monster.get(0).x)) ) {
					
					collided=true;
					entity.collisionOn = true;
					
					if(gamePanel.monster.get(1).direction.equals("right")) {
						
						gamePanel.player.x += gamePanel.monster.get(0).speed/5;
						gamePanel.player.y = 2*gamePanel.tileSize - 30f;
						gamePanel.player.collisionOn = true;
					}
					if(gamePanel.monster.get(1).direction.equals("left")) {
						gamePanel.player.x -= gamePanel.monster.get(0).speed/5;
						gamePanel.player.y = 2*gamePanel.tileSize - 30f;
						gamePanel.player.collisionOn = true;
					
					}
				
			}else {
				collided = false;
			}
		}
			}
		}
		
		
		return collided;
		
	}
	public void checkTile(Entity entity) {
		int entityLeftx = (int) (entity.x + entity.solidArea.x);
		int entityRightx = (int) (entity.x + entity.solidArea.x + entity.solidArea.width);
		
		int entityTopy = (int) (entity.y + entity.solidArea.y);
		int entityBottomy = (int) (entity.y + entity.solidArea.y + entity.solidArea.height);
	
		int entityLeftCol = entityLeftx/gamePanel.tileSize;
		int entityRightCol = entityRightx/gamePanel.tileSize;
		int entityTopRow = entityTopy/gamePanel.tileSize;
		int entityBottomRow = entityBottomy/gamePanel.tileSize;
		
		
	

		
		

		 boolean collided = false;
		 switch (entity.direction) {
			case "up":
		        if (entityTopy > 0) {
		            collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityLeftCol][entityTopRow]].collision ||
		                       gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol][entityTopRow]].collision;
		        }
		        break;
		    case "down":
		    	//System.out.println(gamePanel.tileManager.mapTile[entityLeftCol][entityBottomRow]);
		        collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityLeftCol][entityBottomRow]].collision ||
		                   gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol][entityBottomRow]].collision;
		        break;
		    case "left":
		        if (entityLeftx > 0 && entityLeftCol > 0) {
		            collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityLeftCol][entityTopRow]].collision ||
		                       gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityLeftCol][entityBottomRow]].collision;
		        
		        }
		        break;
		    case "right":
		        if (entityRightx < gamePanel.screenWidth && entityRightCol < gamePanel.tileManager.mapTile.length) {
		            collided = gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol][entityTopRow]].collision ||
		                       gamePanel.tileManager.tile[gamePanel.tileManager.mapTile[entityRightCol ][entityBottomRow]].collision;
		       
		  
		        }
		        break;
		}
		
		    entity.collisionOn = collided;
		
		
		
		
	
	}
	
	public int checkEntity(Entity entity, ArrayList<Entity> target) {
		int index = 99;
		
		for(int i = 0; i<target.size(); i++) {
			
			if(target.get(i) != null && !target.get(i).name.equals("tile")) {
				
				entity.solidArea.x = (int)entity.x + entity.solidArea.x;
				entity.solidArea.y = (int)entity.y + entity.solidArea.y;
				
				target.get(i).solidArea.x = (int) (target.get(i).x + target.get(i).solidArea.x);
				target.get(i).solidArea.y = (int) (target.get(i).y + target.get(i).solidArea.y);
				
				
				switch (entity.direction) {
				case "right" :{
					entity.solidArea.x +=entity.speed;
					
					break;
				}
		 		case "jump" :{
		 
		 			break;
					
					
				}
				case "left" :{
					entity.solidArea.x -=entity.speed;
							
					break;
					
				}
				case "down" : {
			
					break;
					
					
				}
				
			
			}
				
				if(entity.solidArea.intersects(target.get(i).solidArea)) {
					if(target.get(i) != entity) {
						entity.collisionOn = true;
						index = i;
						
					}
				
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target.get(i).solidArea.x = target.get(i).solidAreaDefaultX;
				target.get(i).solidArea.y = target.get(i).solidAreaDefaultY;
			}
		}
		
		return index;
		
	}
	public boolean checkPlayer(Entity entity) {
		
	
		boolean contactPlayer = false;
		
		entity.solidArea.x = (int)entity.x + entity.solidArea.x;
		entity.solidArea.y = (int)entity.y + entity.solidArea.y;
		
		gamePanel.player.solidArea.x = (int) (gamePanel.player.x + gamePanel.player.solidArea.x);
		gamePanel.player.solidArea.y = (int) (gamePanel.player.y + gamePanel.player.solidArea.y);
		
		
		switch (entity.direction) {
		case "right" :{
			if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
				entity.collisionOn = true;
				if(entity.name.equals("tile") || entity.y == 2*gamePanel.tileSize) {
					contactPlayer = false;
					
				}else {
					contactPlayer = true;
				
				}
				
			
			}	
			entity.solidArea.x +=entity.speed;
			
			break;
		}
 		case "jump" :{
 			if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
 				entity.collisionOn = true;
 				if(entity.name.equals("tile") || entity.y == 2*gamePanel.tileSize)   {
					contactPlayer = false;
					
				}else {
					contactPlayer = true;
				
				}
 			
 			}	
 		
		break;
			
			
		}
		case "left" :{
			if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
				entity.collisionOn = true;
				if(entity.name.equals("tile") || entity.y == 2*gamePanel.tileSize) {
					contactPlayer = false;
					
				}else {
					contactPlayer = true;
				}
			
			}	
			entity.solidArea.x -=entity.speed;
			
			break;
			
		}
		case "down" : {
			if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
				entity.collisionOn = true;
				if(entity.name.equals("tile") || entity.y == 2*gamePanel.tileSize ) {
					contactPlayer = false;
					
				}else {
					contactPlayer = true;
					
				}
			
			}	
			
			break;
			
			
		}
		
		
	}
		
	
		entity.solidArea.x = entity.solidAreaDefaultX;
		entity.solidArea.y = entity.solidAreaDefaultY;
		gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
		gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
	
		return contactPlayer;
	}
}
