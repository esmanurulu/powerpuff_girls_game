

import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {
	public Rectangle solidArea = new Rectangle(0,0,16,16);  
	
	public OBJ_Key() {
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/obj/New Piskel.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		collision = true;
		
	}

}
