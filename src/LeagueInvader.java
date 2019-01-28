import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvader {
	public final static int x = 500;
	public  final static int y = 800;
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
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(x,y));
	frame.pack();
	frame.addKeyListener(game);
	game.startGame();
	
	
}
}





