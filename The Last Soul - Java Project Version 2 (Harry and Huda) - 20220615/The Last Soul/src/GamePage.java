import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GamePage extends JFrame{
	ImageIcon gameIcon;
	JButton backB;
	
	public GamePage(GamePanel gamePanel){
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamePanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
}