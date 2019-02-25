import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	void update() {
		super.update();
		y++;
		x++;
		
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x,y, width, height, null);
	}
	Alien(int x, int y, int width, int height){
		super(x,y,width,height);
	}
}
