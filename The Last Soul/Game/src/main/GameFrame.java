package main;
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	private ImageIcon gameIcon;
	
	public GameFrame(GamePanel gamePanel){
		gameIcon = new ImageIcon("images\\gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(gamePanel);
		
		
		this.setVisible(true);
	}
}
