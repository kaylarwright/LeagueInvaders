import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font tFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	GamePanel() {
		time = new Timer(1000 / 60, this);
		titleFont = new Font("Aril", Font.PLAIN, 48);
		tFont = new Font("Aril", Font.PLAIN, 35);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		}catch(IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
			if(currentState == MENU_STATE) {
				rocket = new Rocketship(250,700,50,50);
				manager = new ObjectManager(rocket);
			}
		}
		if( currentState == MENU_STATE) {
		if(e.getKeyCode()== KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null, "Use the arrow keys to go up, down and side to side");
			JOptionPane.showMessageDialog(null, "Press space to kill the aliens");
			JOptionPane.showMessageDialog(null, "Do not touch the aliens");
		}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectile(rocket.x+25, rocket.y, 10,10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("are");
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = false;
		}
		if(e.getKeyCode () == KeyEvent.VK_LEFT) {
			rocket.left = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("you");
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(rocket.isAlive == false) {
			currentState = END_STATE;
		}
		
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		System.out.println("bye");
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvader.x, LeagueInvader.y);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("League Invaders", 80, 100);
		g.setFont(tFont);
		g.drawString("Press ENTER to start", 95, 400);
		g.drawString("Press SPACE for instructions", 20, 700);

	}

	void drawGameState(Graphics g) {
	g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvader.x, LeagueInvader.y, null); 
		manager.draw(g);
		
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvader.x, LeagueInvader.y);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 130, 100);
		g.setFont(tFont);
		g.drawString("You killed " + manager.getScore() + " enemines", 95, 400);
		g.drawString("Press ENTER to restart", 80, 700);

	}

}
