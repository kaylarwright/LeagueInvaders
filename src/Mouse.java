import java.awt.Color;
import java.awt.Graphics;

public class Mouse extends GameObject{
int speed;
boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;
	Mouse(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 10;
	}
	void update(){
		super.update();
	if(up == true){
		y -= speed;
	}
	if (down == true){
		y += speed;
	}
	if (right == true){
		x += speed;
	}
	if (left == true){
		x -= speed;
	}
	if (x <= 0) {
		x = 0;
	}
	if ( x >= Game.WIDTH) {
		x = Game.WIDTH;
	}
	
	
	
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.mouseImg, x, y, width, height, null);
	}
}
