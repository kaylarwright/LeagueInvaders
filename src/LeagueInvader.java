import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvader {
	final static int x = 500;
	final static int y = 800;
	JFrame frame = new JFrame();
	GamePanel game;
public static void main(String[] args) {
	LeagueInvader LI = new LeagueInvader();
	LI.setup();
	
}
LeagueInvader(){
	game = new GamePanel();
	
	}
void setup() {
	frame.add(game);
	frame.setSize(x,y);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(500,500));
	frame.pack();
	game.startGame();
	frame.add(game);
}
}





