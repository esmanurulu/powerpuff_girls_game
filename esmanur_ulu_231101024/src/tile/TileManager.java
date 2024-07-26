package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;

import javax.imageio.ImageIO;

import Hw1.GamePanel;

public class TileManager extends Tile {
	
	GamePanel gamePanel;
	public Tile[] tile;
	public int mapTile[][];
	
	public TileManager (GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		tile = new Tile[15];
		mapTile = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
		
		getTitleImage();
		loadMap();
	}
	public void getTitleImage() {
		
		try {
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/finisLine.png"));
			tile[10].collision = false;
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/redmiddleson.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/middleblueson.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blackMiddle.png"));
			tile[3].collision = true;
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/redrightson.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rightblueson.png"));
			tile[5].collision = true;
			

			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blackRight.png"));
			tile[6].collision =true;
			
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/reddLeft.png"));
			tile[7].collision = true;
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blueeLeft.png"));
			tile[8].collision = true;
			

			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blackLeft.png"));
			tile[9].collision =true;
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/skor.png"));
			tile[11].collision =true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/monsterGate.png"));
			tile[12].collision =false;
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blackMiddle.png"));
			tile[0].collision= false;

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		
		try {
		
			
			InputStream input = getClass().getResourceAsStream("/maps/world01.txt");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			
			int cl = 0;
			int rw = 0;
			
			while(cl < gamePanel.maxScreenCol && rw < gamePanel.maxScreenRow) {
					
				String lineString = bReader.readLine();
				
				while( cl < gamePanel.maxScreenCol) {
					
					String numbers[] = lineString.split(" ");
					int num = Integer.parseInt(numbers[cl]);
					
						mapTile[cl][rw] = num;
					
					
					cl++;
				}
				
				if(cl == gamePanel.maxScreenCol) {
					cl = 0;
					rw++;
				}
			}
			
			bReader.close();
			
		} catch (Exception e) {
			
		}
	}
	
	public void draw(Graphics2D graphics2d) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		
		while( col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow ) {
			
			
			int tileN = mapTile[col][row];
			if(tileN !=0) {
				graphics2d.drawImage(tile[tileN].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
				
			}
			col++;
			x += gamePanel.tileSize;
			
			if(col == gamePanel.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
			
			
			
		}
		
		
		
	
	}

}
