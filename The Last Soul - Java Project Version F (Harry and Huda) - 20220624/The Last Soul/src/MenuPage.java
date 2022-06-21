import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * This class is the menu page for the game (the page before the game officially starts). 
 * The user will be able to know the background and objective of the game.
 * And also the user will enter his or her name in this page.
 * @author Harry Wu
 * @version 2022-06-11
 */

public class MenuPage extends JFrame implements ActionListener{
	// initialize the components of game menu page
	ImageIcon gameIcon;
	JPanel leftP;
	JLabel nameL;
	JTextField nameTF;
	JLabel diffL;
	JRadioButton diffB_N; // difficulty-normal
	JRadioButton diffB_H; // difficulty-hell
	ButtonGroup diffBG;
	JPanel easyP, hellP;
	JLabel easyIntroL, easyGifL, hellIntroL, hellGifL;
	JButton confirmB;
	JButton continueB;
	JButton backB;
	JLabel introL;
	ImageIcon introII;
	JPanel frameP;
	public final int GAME_WIDTH = 960;
	public final int GAME_HEIGHT = 640;
	
	public MenuPage() {
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
		
		this.setTitle("The Last Soul");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// make a panel that holds all the changeable options
		leftP = new JPanel();
		leftP.setBackground(SettingPage.backgroundColor);
		leftP.setLayout(null);
		leftP.setBounds(20, 20, 510, 600);
		
		// set details for the components
		nameL = new JLabel("NAME");
		nameL.setFont(new Font("Minecraft", Font.BOLD, 64));
		nameL.setBounds(25, 20, 360, 80);
		nameTF = new JTextField();
		nameTF.setFont(new Font("Minecraft", Font.PLAIN, 42));
		nameTF.setBounds(15, 100, 450, 55);
		diffL = new JLabel("Difficulty");
		diffL.setFont(new Font("Minecraft", Font.BOLD, 48));
		diffL.setBounds(20, 170, 360, 60);
		diffB_N = new JRadioButton("Normal", true);
		diffB_N.setFont(new Font("Minecraft", Font.PLAIN, 28));
		diffB_N.setBounds(20, 225, 160, 40);
		diffB_N.setFocusable(false);
		diffB_N.setBackground(SettingPage.backgroundColor);
		diffB_H = new JRadioButton("Hell!");
		diffB_H.setFont(new Font("Minecraft", Font.PLAIN, 28));
		diffB_H.setBounds(190, 225, 100, 40);
		diffB_H.setFocusable(false);
		diffB_H.setBackground(SettingPage.backgroundColor);
		diffBG = new ButtonGroup();
		diffBG.add(diffB_N);
		diffBG.add(diffB_H);
		
		easyP = new JPanel();
		easyP.setBackground(SettingPage.backgroundColor);
		easyP.setLayout(null);
		easyP.setBounds(5, 270, 500, 200);
		easyIntroL = new JLabel(new ImageIcon("images/easyIntro.png"));
		easyIntroL.setBounds(0, 45, 279, 111);
		easyGifL = new JLabel(new ImageIcon("images/easyDance.gif"));
		easyGifL.setBounds(278, 0, 222, 200);
		easyP.add(easyIntroL);
		easyP.add(easyGifL);
		
		hellP = new JPanel();
		hellP.setBackground(SettingPage.backgroundColor);
		hellP.setLayout(null);
		hellP.setBounds(5, 270, 500, 200);
		hellIntroL = new JLabel(new ImageIcon("images/hellIntro.png"));
		hellIntroL.setBounds(15, 35, 250, 132);
		hellGifL = new JLabel(new ImageIcon("images/hellSuffer.gif"));
		hellGifL.setBounds(278, 0, 233, 200);
		hellP.add(hellIntroL);
		hellP.add(hellGifL);
		hellP.setVisible(false);
		
		confirmB = new JButton("Confirm");
		confirmB.setFont(new Font("Minecraft", Font.PLAIN, 18));
		confirmB.setBounds(300, 225, 110, 30);
		confirmB.setFocusable(false);
		confirmB.addActionListener(this);
		
		
		//easyIntroL, easyGifL, hellIntroL, hellGifL
		continueB = new JButton("Continue");
		continueB.setBounds(20, 505, 150, 40);
		continueB.setFont(new Font("Minecraft", Font.PLAIN, 24));
		continueB.setFocusable(false);
		continueB.addActionListener(this);
		backB = new JButton("Back");
		backB.setBounds(20, 555, 100, 35);
		backB.setFont(new Font("Minecraft", Font.PLAIN, 24));
		backB.setFocusable(false);
		backB.addActionListener(this);
		
		introL = new JLabel(new ImageIcon("images/introduction.png"));
		introL.setBounds(543, 20, 397, 600);
		
		// add all editable options to panel
		leftP.add(nameL);
		leftP.add(nameTF);
		leftP.add(diffL);
		leftP.add(diffB_N);
		leftP.add(diffB_H);
		leftP.add(easyP);
		leftP.add(hellP);
		leftP.add(confirmB);
		leftP.add(continueB);
		leftP.add(backB);
		
		// add option panel to the panel frame
		frameP.add(leftP);
		frameP.add(introL);
		
		// make frame visible
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmB) {
			if (diffB_N.isSelected()) {
				easyP.setVisible(true);
				hellP.setVisible(false);
			}
			else if (diffB_H.isSelected()) {
				easyP.setVisible(false);
				hellP.setVisible(true);
			}
		}
		if (e.getSource() == continueB) {
			new Game();
			this.dispose();
		}
		if (e.getSource() == backB) {
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
