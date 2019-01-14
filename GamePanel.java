import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.Messaging.SyncScopeHelper;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	@Override
	public void paintComponent(Graphics g) {
	if(currentState == MENU_STATE) {
		drawMenuState(g);
	}else if(currentState == GAME_STATE) {
		drawGameState(g);
	}else if(currentState == END_STATE) {
		drawEndState(g);
	}
	}

	GamePanel() {
		time = new Timer(1000 / 60, this);
	
	}

	void startGame() {
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(currentState == MENU_STATE) {
			updateMenuState();
		}else if(currentState == GAME_STATE) {
			updateGameState();
		}else if(currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		currentState++;
		if(currentState > END_STATE) {
			currentState = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("are");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("you");
	}
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		System.out.println("bye");
		g.setColor(Color.BLUE);
		g.fillRect(0,0,LeagueInvader.x, LeagueInvader.y);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
}
