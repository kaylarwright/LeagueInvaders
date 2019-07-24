import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Mouse OUSE;
ArrayList<Cat> tac = new ArrayList<Cat>();
long enemyTimer = 0;
int enemySpawnTime = 500;



ObjectManager(Mouse m){
	OUSE = m;
}
void update(){
	OUSE.update();
	for (int i = 0; i < tac.size(); i++) {
		Cat enemies = tac.get(i);
		enemies.update();
	}
}
void draw(Graphics g){
	OUSE.draw(g);
	for(int i = 0; i < tac.size(); i ++) {
		Cat enemies = tac.get(i);
		enemies.draw(g);
	}
}
void addCat(Cat c) {
	tac.add(c);
}
public void manageEnemies() {
	if(System.currentTimeMillis()- enemyTimer >= enemySpawnTime) {
		addCat(new Cat(new Random().nextInt(Game.WIDTH), 0, 50,50));
		enemyTimer = System.currentTimeMillis();
	}
}
void purgeObject() {
	for(int i =0; i < tac.size(); i++) {
		Cat enemies = tac.get(i);
		if(enemies.isAlive == false) {
			tac.remove(enemies);
			
		}
	}
}
void checkCollision() {
	for(Cat c : tac) {
		if(OUSE.collisionBox.intersects(c.collisionBox)){
			System.out.println("j");
			OUSE.isAlive = false;
		}
	}
	
}

}
