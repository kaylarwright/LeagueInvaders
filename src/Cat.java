import java.awt.Color;
import java.awt.Graphics;

public class Cat extends GameObject{
Cat(int x, int y, int width, int height){
	super(x,y,width,height);
}

int angle = 0;
void update() {
	super.update();
	y += 5;
	x += Math.sin(angle++ * 0.1) * 10;
}
void draw(Graphics g) {
	g.drawImage(GamePanel.catImg, x, y, width, height, null);
}
}
