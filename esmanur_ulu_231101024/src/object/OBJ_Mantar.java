

import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class OBJ_Mantar extends SuperObject {
public Rectangle solidArea = new Rectangle(0,0,16,16);  
	
	public OBJ_Mantar() {
		
		name = "Mantar";
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/obj/mantar.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		collision = true;
		
	}

}
