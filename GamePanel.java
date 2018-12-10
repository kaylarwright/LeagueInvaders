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
Font title;
Font tf;
Font font;
Font killed;
Font restart;
int score = 0;
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(currentState);
if (currentState == MENU_STATE) {
	drawMenuState(g);
}else if (currentState == GAME_STATE) {
	drawGameState(g);
}else if (currentState == END_STATE) {
	drawEndState(g);
}
	}

	GamePanel() {
		time = new Timer(1000 / 6, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		title = new Font("Arial", Font.PLAIN, 25);
		tf = new Font("Arial", Font.PLAIN, 25);
		font = new Font ("Arial", Font.PLAIN, 48);
		killed = new Font ("Arial", Font.PLAIN, 25);
		restart = new Font ("Arial", Font.PLAIN, 25);
	}

	void startGame() {
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		repaint();
		if (currentState == MENU_STATE) {
		updateMenuState();	
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("how");
		if (e.getKeyCode()== KeyEvent.VK_ENTER) {
			currentState++;
		}
		if(currentState > END_STATE){
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
	void updateMenuState(){
		
	}
	void updateGameState(){
		
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvader.WIDTH, LeagueInvader.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 80, 100);
		g.setFont(title);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 130, 400);
		g.setFont(tf);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructiopns", 80, 700);
		
	}
	void drawGameState(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvader.WIDTH, LeagueInvader.HEIGHT);
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvader.WIDTH, LeagueInvader.HEIGHT);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 130, 100);
		g.setFont(killed);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + score + " enemies", 130, 400);
		g.setFont(restart);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 110, 700);
	}
}
