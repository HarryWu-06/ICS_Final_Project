import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * This class is the title page (the page that appears the first) of the program, it will display the game name and author
 * and also accompanying with three buttons: "start", "setting", and "exit"
 * @author Harry Wu
 * @version final
 */
public class TitlePage extends JFrame implements ActionListener{
	// initialize the components
	ImageIcon gameIcon;
	JLabel titleL, authorL, gifL;
	JButton startB, settingB, exitB;
	JPanel frameP;
	Font buttonFont;
	
	public TitlePage() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// use Panel for the frame so the top of the window will be excluded from the height count
		frameP = new JPanel();
		frameP.setPreferredSize(new Dimension(Global.GAME_WIDTH, Global.GAME_HEIGHT));
		this.add(frameP);
		this.pack();
		frameP.setLayout(null);
		frameP.setBackground(Global.backgroundColor);
		
		// Set up the frame of title page
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// title and author
		titleL = new JLabel("The Last Soul");
		titleL.setFont(new Font("Minecraft", Font.BOLD, 110));
		titleL.setBounds(50, 60, 800, 130);
		authorL = new JLabel("- Harry Wu");
		authorL.setFont(new Font("Minecraft", Font.BOLD, 30));
		authorL.setBounds(80, 160, 700, 100);
		
		// set font for all buttons
		buttonFont = new Font("Minecraft", Font.PLAIN, 40);
		// buttons
		startB = new JButton("Start");
		startB.setFont(buttonFont);
		startB.setBounds(600, 280, 300, 80);
		startB.setFocusable(false);
		startB.addActionListener(this);
		settingB = new JButton("Settings");
		settingB.setFont(buttonFont);
		settingB.setBounds(600, 380, 300, 80);
		settingB.setFocusable(false);
		settingB.addActionListener(this);
		exitB = new JButton("Exit");
		exitB.setFont(buttonFont);
		exitB.setBounds(600, 480, 300, 80);
		exitB.setFocusable(false);
		exitB.addActionListener(this);
		
		// add gif for better appearance
		gifL = new JLabel(new ImageIcon("images/creeper.gif"));
		gifL.setBounds(100, 230, 400, 400);

		//add the components 
		frameP.add(startB);
		frameP.add(settingB);
		frameP.add(exitB);
		frameP.add(titleL);
		frameP.add(authorL);
		frameP.add(gifL);
		// make the frame visible
		this.setVisible(true);
	}
	
	/**
	 * The method that return different results based on different buttons being clicked
	 * @param e the component that gets the button input
	 */
	public void actionPerformed(ActionEvent e) { // start the game
		if(e.getSource() == startB) {
			new MenuPage();
			this.dispose();
		}
		else if(e.getSource() == settingB) { // go the setting page
			new SettingPage(); 
			this.dispose();
		}
		else if(e.getSource() == exitB) { // exit the whole game
			System.exit(0);
		}
	}
}
