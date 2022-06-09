package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MenuPage extends JFrame implements ActionListener{
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
	JLabel introduction;
	
	public MenuPage() {
		gameIcon = new ImageIcon("images\\gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setSize(960, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.pink);
		
		leftP = new JPanel();
		leftP.setLayout(null);
		leftP.setBounds(20, 20, 400, 525);
		//leftP.setBackground(Color.red);
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
		continueB.setBounds(20, 410, 200, 50);
		continueB.setFocusable(false);
		continueB.addActionListener(this);
		backB = new JButton("Back");
		backB.setBounds(20, 470, 80, 40);
		backB.setFocusable(false);
		backB.addActionListener(this);
		
		leftP.add(nameL);
		leftP.add(nameTF);
		leftP.add(diffL);
		leftP.add(diffB_N);
		leftP.add(diffB_H);
		leftP.add(continueB);
		leftP.add(backB);
		this.add(leftP);
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
