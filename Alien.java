import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	void update() {
		super.update();
		y++;
		x++;
		
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	Alien(int x, int y, int width, int height){
		super(x,y,width,height);
	}
}
