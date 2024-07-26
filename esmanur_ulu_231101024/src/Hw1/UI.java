

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import object.SuperObject;

public class UI {
	
	GamePanel gamePanel;
	Graphics2D graphics2d;
	BufferedImage heartFull, heartHalf, heartBlank;
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	public int score2 = 0;
	JLabel jLabel = new JLabel("you win!!! " +  "\nscore: " );
	
	Font font;
	public int  time = 0;
	public int score; 
	
	public UI(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		font = new Font("Arial", Font.PLAIN, 40);
		
		

		
				
	}
	public void updatemylabel(){

		
		jLabel.setBounds(50, 50, 100, 30);
	    jLabel.setFont(new Font("Verdana", Font.PLAIN, 32));
	    jLabel.setText("you win!!! " +  "\nscore: " + gamePanel.player.score);
		
	}
	public void finished() {
		
		
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setTitle("game finished!! !!!!!!");
		
		
		jPanel.setPreferredSize(new Dimension(450,450));
		jPanel.setBackground(Color.blue);
		jPanel.setDoubleBuffered(true);
		
		jPanel.setFocusable(true);
		
		jFrame.add(jPanel);
		jFrame.pack();
		

		updatemylabel();
		jPanel.add(jLabel, BorderLayout.CENTER);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		
	}

	public void draw(Graphics2D graphics2d) {
		
		this.graphics2d = graphics2d;
		
		graphics2d.setFont(font);
		graphics2d.setColor(Color.black);
		
		if(gamePanel.gameState == gamePanel.playState) {
		}
		if(gamePanel.gameState == gamePanel.finishState) {
			score2 = gamePanel.player.score;
			finished();
		}
		if(gamePanel.gameState == gamePanel.pauseState) {
		
			drawPauseScreen();
		}
		
		if(gamePanel.gameState == gamePanel.gameOverState) {
			time ++;
			drawGameOverScreen();
			if (time==200) {
				gamePanel.gameOverState();
				gamePanel.assetSetter.setObject();
				gamePanel.assetSetter.setMonster();

				time = 0;
				
			}
			
		}
		
		
	}
	public void drawGameOverScreen() {
		time ++;
		
		graphics2d.setColor(new Color(0, 0, 0, 150));
		graphics2d.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
		
		int x;
		int y;
		String textString;
		graphics2d.setFont(graphics2d.getFont().deriveFont(Font.BOLD, 110f));
		
		textString = "!!!!Game Over!!!!";
		
		//shadow
		graphics2d.setColor(Color.yellow);
		x = getXCenter(textString);
		y = gamePanel.tileSize*10;
		graphics2d.drawString(textString, x, y);
		//main
		graphics2d.setColor(Color.pink);
		graphics2d.drawString(textString, x-4, y-4);
		
		textString =  "SCORE \n "+ Integer.toString(gamePanel.player.score);
		graphics2d.setColor(Color.pink);
		graphics2d.drawString(textString, x+60, y+200);
		
		
		if(time == 700) {
			gamePanel.gameOverState();;
		}
		
	
	}
	
	
	public void drawPauseScreen() {
		String textString = "*PAUSED*";
		int x  = getXCenter(textString);
		
		int y = gamePanel.screenHeight/2;
		
		graphics2d.drawString(textString, x, y);
		
		
	}
	public int getXCenter(String text) {
		int length = (int)graphics2d.getFontMetrics().getStringBounds(text, graphics2d).getWidth();
		int x = gamePanel.screenWidth/2 -length/2;
		return x;
	}
}
