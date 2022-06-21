import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * This class is the title page (the page that appears the first) of the program, it will display the game name and author
 * and also accompanying with three buttons: "start", "setting", and "exit"
 * @author Harry Wu
 * @version 2022-06-11
 */
public class TitlePage extends JFrame implements ActionListener{
	// initialize the components
	ImageIcon gameIcon;
	JLabel titleL;
	JLabel authorL;
	JButton startB;
	JButton settingB;
	JButton exitB;
	JButton leaderB;
	JPanel frameP;
	JLabel gifL;
	Font buttonFont;
	private final int GAME_WIDTH = 960;
	private final int GAME_HEIGHT = 640;
	
	public TitlePage() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// use Panel for the frame so the top of the window will be excluded from the height count
		frameP = new JPanel();
		frameP.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.add(frameP);
		this.pack();
		frameP.setLayout(null);
		frameP.setBackground(SettingPage.backgroundColor);
		
		// Set up the frame of title page
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// set details for the components
		titleL = new JLabel("The Last Soul");
		titleL.setFont(new Font("Minecraft", Font.BOLD, 110));
		titleL.setBounds(50, 60, 800, 130);
		authorL = new JLabel("- Harry Wu & Huda Hameed");
		authorL.setFont(new Font("Minecraft", Font.BOLD, 30));
		authorL.setBounds(80, 160, 700, 100);
		buttonFont = new Font("Minecraft", Font.PLAIN, 30);
		startB = new JButton("Start");
		startB.setFont(buttonFont);
		startB.setBounds(600, 240, 300, 80);
		startB.setFocusable(false);
		startB.addActionListener(this);
		settingB = new JButton("Settings");
		settingB.setFont(buttonFont);
		settingB.setBounds(600, 340, 300, 80);
		settingB.setFocusable(false);
		settingB.addActionListener(this);
		leaderB = new JButton("Leaderboard");
		leaderB.setFont(buttonFont);
		leaderB.setBounds(600, 440, 300, 80);
		leaderB.setFocusable(false);
		leaderB.addActionListener(this);
		exitB = new JButton("Exit");
		exitB.setFont(buttonFont);
		exitB.setBounds(600, 540, 300, 80);
		exitB.setFocusable(false);
		exitB.addActionListener(this);
		
		gifL = new JLabel(new ImageIcon("images/creeper.gif"));
		gifL.setBounds(100, 230, 400, 400);

		//add the components 
		frameP.add(startB);
		frameP.add(settingB);
		frameP.add(leaderB);
		frameP.add(exitB);
		frameP.add(titleL);
		frameP.add(authorL);
		frameP.add(gifL);
		// make the frame visible
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startB) {
			new MenuPage();
			this.dispose();
		}
		else if(e.getSource() == settingB) {
			new SettingPage(); 
			this.dispose();
		}
		else if(e.getSource() == leaderB) {
			new LeaderboardPage(); 
			this.dispose();
		}
		else if(e.getSource() == exitB) { 
			System.exit(0);
		}
	}
}
