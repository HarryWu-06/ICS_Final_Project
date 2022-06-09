package main;
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	private ImageIcon gameIcon;
	
	public GameFrame(GamePanel gamePanel){
		gameIcon = new ImageIcon("images\\gameIcon.png");
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
