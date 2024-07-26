

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sql.rowset.JoinRowSet;
import javax.swing.JPanel;

import Entity.Entity;
import Entity.Player;
import Monster.MON_BlueMon;
import Monster.MON_PurpleMon;
import Monster.MON_RedMon;

import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTitleSize = 16;
	public final int scale = 2; 
	public final int tileSize = originalTitleSize * scale ;
	
	public final int maxScreenCol = 30; // 96x96 ===60 48x48
	public final int maxScreenRow = 24; //
	
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	public int count = 0;
	public int monsters = 4;
	
	public int fire = 1;
	public String playerColor = "red";
	

	int countMonster = 0;
	
	
	int FPS = 60;
	
	
	//system
	TileManager tileManager = new TileManager(this);
	KeyHandler keyHandler = new KeyHandler(this);
	
	Sound sound = new Sound();
	
	public CollisionCheck collisionCheck = new CollisionCheck(this);
	
	public AssetSetter assetSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	

	
	// entity and object
	public Player player = new Player(this, keyHandler);
	public ArrayList<Entity> monster = new ArrayList<Entity>();
	
	public SuperObject obj[] = new SuperObject[68];
	
	public Entity npc[] = new Entity[10];
	
	public  ArrayList<Entity> fireList = new ArrayList<Entity>();
	
	public ArrayList<Entity> projectileList = new ArrayList<Entity>();
	
	//game state
	public int gameState = 1;
	public final int gameOverState = 6;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int finishState = 3;
	
	
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.LIGHT_GRAY);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}
	public void setupGame() {
		
		assetSetter.setObject();
		assetSetter.setMonster();
		playMusic(0);
		
	}
//	public void reStart() {
//		
//		player.setDefaultValues();
//		assetSetter.setObject();
//		assetSetter.setMonster();
//		
//		
//	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
		gameState = playState;
		
	}

	
	public void gameOverState() {
		
		
		player.setDefaultValues();
		gameState = playState;
	
		
	}
	public void run() {
				
		  double drawInterval = 1000000000 / FPS; 
		  double nextDrawTime = System.nanoTime() + drawInterval;

		  while(gameThread != null) {
			
			  

			
			update();
		
			repaint();
		
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
                Thread.sleep((long) remainingTime); 
            
                nextDrawTime += drawInterval;
                
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}
		 
		
		
	}
	
	public void update() {
		
		
		if(gameState == playState) {
			
			
			player.update();
		
			countMonster++;
			if(countMonster == 320) {
				monster.add(assetSetter.monsterSpawner());
				countMonster = 0;
			}
			for(int i = 0; i<monster.size(); i++) {
				if(monster.get(i) != null) {
					if(monster.get(i).alive == false) {
						player.score += 10;
						monster.remove(i);
					}
					if(monster.get(i).alive == true && monster.get(i).dying == false) {
						monster.get(i).update();
					}
					
					
				}
			}
			
		
			for(int i = 0; i<projectileList.size(); i++) {
				if(projectileList.get(i) != null) {
					if(projectileList.get(i).alive == true) {
						projectileList.get(i).update();
					}
					if(projectileList.get(i).alive == false) {
						projectileList.remove(i);
					}
					
				}
			}
		
		
		
		if(gameState == pauseState) {
			

		}
		}
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D graphics2 = (Graphics2D)graphics; 
		
		
		
		tileManager.draw(graphics2);
		
		for(int i =0 ; i<obj.length; i++) {
			if(obj[i]!=null) {
				obj[i].draw(graphics2, this); 
			}
		}
		
		count++;
		
		for(int i = 0; i<monster.size(); i++) {
			if(monster.get(i) != null) {
				
				monster.get(i).draw(graphics2);
			}
		}
		
	
		for(int i = 0; i<projectileList.size(); i++) {
			if(projectileList.get(i) != null) {
				projectileList.get(i).draw(graphics2);
			}
		}
		
		
		
		player.draw(graphics2);
		
		ui.draw(graphics2);
		graphics2.dispose();
		
	}
	
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
		
	}
	public void stopMusic() {
		sound.stop();
	}
	public void playSE(int i) {
		
		sound.setFile(i);
		sound.play();
		
	}
	

}
