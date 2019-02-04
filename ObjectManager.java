import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Rocketship ship;
ArrayList<Projectile> project = new ArrayList<Projectile>();

ObjectManager(Rocketship r){
	ship = r;
}
void update() {
	ship.update();
	for(int i = 0; i < project.size(); i ++) {
		Projectile pro = project.get(i);
		pro.update();
	}
}
void draw( Graphics g) {
	ship.draw(g);
	for(int i = 0; i < project.size(); i ++) {
		Projectile pro = project.get(i);
		pro.draw(g);
	}
	
}
void addProjectile(Projectile p) {
	project.add(p);
}
}
