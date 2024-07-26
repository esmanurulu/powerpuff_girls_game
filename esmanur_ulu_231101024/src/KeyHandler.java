

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gamePanel;
	int count = 0;
	
	public boolean jumpPressed, downPressed, leftPressed, rightPressed, onePressed, spacePressed, twoPressed, threePressed;
	
	
	public KeyHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		 
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
			
		
		if(code == KeyEvent.VK_W) {
			jumpPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
			
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			
		}
		if(code == KeyEvent.VK_1) {
			onePressed = true;
		}
		if(code == KeyEvent.VK_2) {
			twoPressed = true;
		}
		if(code == KeyEvent.VK_3) {
			threePressed = true;
		}
		if(code == KeyEvent.VK_P) {
			if(gamePanel.gameState == gamePanel.playState) {
				gamePanel.gameState = gamePanel.pauseState;
			}else if(gamePanel.gameState == gamePanel.pauseState) {
				gamePanel.gameState = gamePanel.playState;
			}
			
		}
		

		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
		
		if(code == KeyEvent.VK_W) {
			jumpPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
			
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
			
		}
		if(code == KeyEvent.VK_1) {
			onePressed = false;
		}
		if(code == KeyEvent.VK_2) {
			twoPressed = false;
		}
		if(code == KeyEvent.VK_3) {
			threePressed = false;
		}
		
		
		
	}
	

}
