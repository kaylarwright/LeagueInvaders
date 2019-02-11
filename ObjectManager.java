import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship ship;
ArrayList<Projectile> project = new ArrayList<Projectile>();
ArrayList<Alien> AN = new ArrayList<Alien>();
long enemyTimer = 0;
int enemySpawnTime = 1000;

ObjectManager(Rocketship r){
	ship = r;
}
void update() {
	ship.update();
	for(int i = 0; i < project.size(); i ++) {
		Projectile pro = project.get(i);
		pro.update();
	}
	for(int j = 0; j < AN.size(); j++) {
		Alien enemies = AN.get(j);
		enemies.update();
	}
	
}
void draw( Graphics g) {
	ship.draw(g);
	for(int i = 0; i < project.size(); i ++) {
		Projectile pro = project.get(i);
		pro.draw(g);
	}
	for(int j = 0; j < AN.size(); j++) {
		Alien enemies = AN.get(j);
		enemies.draw(g);
		}
	
}
void addProjectile(Projectile p) {
	project.add(p);
}
void addAlien(Alien a) {
	AN.add(a);
}
public void manageEnemies() {
	if(System.currentTimeMillis()-enemyTimer>=enemySpawnTime) {
		addAlien(new Alien(new Random().nextInt(LeagueInvader.x), 0,50,50));
		enemyTimer = System.currentTimeMillis();
	}
}
void  purgeObjects() {
	for(int j = 0; j < AN.size(); j++) {
		Alien enemies = AN.get(j);
		if(enemies.isAlive == false) {
			AN.remove(enemies);
		}
	}
	for(int j = 0; j < project.size(); j++) {
		Projectile pro = project.get(j);
		if(pro.isAlive == false) {
			project.remove(pro);
		}
	}
}
void checkCollision() {
	for(Alien a : AN) {
		if(ship.collisionBox.intersects(a.collisionBox)) {
			ship.isAlive = false;
		}
	}
	for(int i = 0; i < project.size(); i++) {
		Projectile pro = project.get(i);
		for(int j = 0; j < AN.size(); j++) {
			Alien enemis = AN.get(j);
			if(pro.collisionBox.intersects(enemis.collisionBox)) {
				pro.isAlive = false;
				enemis.isAlive = false;
			}
		}
	}
}
}
