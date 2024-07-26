

import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class OBJ_Skor extends SuperObject {
public Rectangle solidArea = new Rectangle(0,0,16,16);  
	
	public OBJ_Skor() {
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("skor.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		collision = true;
		
	}

}
