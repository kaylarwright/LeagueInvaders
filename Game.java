import java.awt.Dimension;

import javax.swing.JFrame;

public class Game {
	JFrame frame; 
	public final static int WIDTH = 500;
	public final static int HEIGHT = 800;
	GamePanel GPanel;
	
public static void main(String[] args) {
	Game GAME = new Game();
	GAME.setup();
	
	
	
}
Game(){
	frame = new JFrame();
	GPanel = new GamePanel();
}
void setup() {
	frame.add(GPanel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(WIDTH,HEIGHT));
	frame.pack();
	GPanel.startGame();
	frame.addKeyListener(GPanel);
}
}
