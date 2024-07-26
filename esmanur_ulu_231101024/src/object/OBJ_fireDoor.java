

import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class OBJ_fireDoor extends SuperObject{
public Rectangle solidArea = new Rectangle(0,0,16,16);  
	
	public OBJ_fireDoor() {
		
		name = "Fire Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/obj/fire.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		collision = true;
		
	}
	

}
