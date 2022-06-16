import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

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
		frameP.setBackground(Color.pink);
		
		// set up the frame of menu page
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// make a panel that holds all the changeable options
		leftP = new JPanel();
		leftP.setLayout(null);
		leftP.setBounds(20, 20, 400, 600);
		
		// set details for the components
		nameL = new JLabel("NAME");
		nameL.setFont(new Font("MV Boli", Font.BOLD, 64));
		nameL.setBounds(20, 20, 360, 60);
		nameTF = new JTextField("?");
		nameTF.setFont(new Font("MV Boli", Font.PLAIN, 42));
		nameTF.setBounds(20, 100, 360, 40);
		diffL = new JLabel("Difficulty");
		diffL.setFont(new Font("MV Boli", Font.BOLD, 48));
		diffL.setBounds(20, 160, 360, 55);
		diffB_N = new JRadioButton("Normal", true);
		diffB_N.setFont(new Font("MV Boli", Font.PLAIN, 24));
		diffB_N.setBounds(20, 215, 120, 40);
		diffB_N.setFocusable(false);
		diffB_H = new JRadioButton("Hell!");
		diffB_H.setFont(new Font("MV Boli", Font.PLAIN, 24));
		diffB_H.setBounds(160, 215, 120, 40);
		diffB_H.setFocusable(false);
		diffBG = new ButtonGroup();
		diffBG.add(diffB_N);
		diffBG.add(diffB_H);
		continueB = new JButton("Continue");
		continueB.setBounds(20, 470, 200, 50);
		continueB.setFocusable(false);
		continueB.addActionListener(this);
		backB = new JButton("Back");
		backB.setBounds(20, 540, 80, 40);
		backB.setFocusable(false);
		backB.addActionListener(this);
		
		introL = new JLabel(new ImageIcon("images/introduction.png"));
		introL.setBounds(440, 20, 500, 600);
		
		// add all editable options to panel
		leftP.add(nameL);
		leftP.add(nameTF);
		leftP.add(diffL);
		leftP.add(diffB_N);
		leftP.add(diffB_H);
		leftP.add(continueB);
		leftP.add(backB);
		
		// add option panel to the panel frame
		frameP.add(leftP);
		frameP.add(introL);
		
		// make frame visible
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == continueB) {
			new Game();
			this.dispose();
		}
		else if(e.getSource() == backB) {
			new TitlePage(); 
			this.dispose();
		}
	}
}
