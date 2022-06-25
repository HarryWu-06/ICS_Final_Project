import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This is the Frame of the game page, containing the icon, title, and holding the drawing(GamePanel.java)
 * @author Harry Wu
 * @version final
 */
public class GamePage extends JFrame{
	// initialize the icon
	ImageIcon gameIcon;
	
	public GamePage(GamePanel gamePanel){
		// load the icon
		gameIcon = new ImageIcon("images/gameIcon.png");
		
		// set the other frame status
		this.setTitle("The Last Soul");
		this.setIconImage(gameIcon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamePanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		// make frame visible
		this.setVisible(true);
	}
}