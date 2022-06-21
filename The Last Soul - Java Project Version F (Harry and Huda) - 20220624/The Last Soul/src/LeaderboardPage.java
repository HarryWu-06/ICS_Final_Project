import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;

public class LeaderboardPage extends JFrame implements ActionListener{
	JPanel frameP;
	JLabel temp;
	JButton backB;
	ImageIcon gameIcon;
	public final int GAME_WIDTH = 960;
	public final int GAME_HEIGHT = 640;
	
	public LeaderboardPage() {
		// use Panel for the frame so the top of the window will be excluded from the height count
		frameP = new JPanel();
		frameP.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.add(frameP);
		this.pack();
		frameP.setLayout(null);
		frameP.setBackground(SettingPage.backgroundColor);
		
		// set up the frame of menu page
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("LeaderBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Setting components of frame 
		temp = new JLabel("404  Nothing has been added in yet");
		temp.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		temp.setBounds(45, 270, 960, 100);
		
		backB = new JButton("Back");
		backB.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		backB.setFocusable(false);
		backB.setBounds(810, 570, 100, 45);
		backB.addActionListener(this);
		
		// adding components to the frame
		frameP.add(temp);
		frameP.add(backB);
		this.add(frameP);
		this.setVisible(true);
	}

	// getting action
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backB) {
			try {
				new TitlePage();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}
	}
}
