import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvader.x, LeagueInvader.y);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvader.x, LeagueInvader.y);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 130, 100);
		g.setFont(tFont);
		g.drawString("You killed 0 enemines", 95, 400);
		g.drawString("Press ENTER to restart", 80, 700);

	}
}
