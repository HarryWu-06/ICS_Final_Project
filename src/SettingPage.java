import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

import javax.sound.sampled.*;
import javax.swing.*;

public class SettingPage extends JFrame implements ActionListener{
	// initialize variables
	ImageIcon gameIcon;
	JLabel titleL, bgmL, bgcL;
	JPanel bgmP, controlP;
	JRadioButton bgmB1, bgmB2, bgmB3, bgmB4;
	boolean[] isPlayingIndex;
	String isPlaying = "";
	JButton bgcB, backB, confirmB, stopB, continueB, restartB, changeBgcB;
	ButtonGroup bgmBG;
	JColorChooser colorChooser;
	long timePosition; // paused time for the song
	
	public SettingPage() {
		// set game icon
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		// set setting page frame
		this.setTitle("Setting");
		this.setSize(500, 350);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		// input title
		titleL = new JLabel("Settings");
		titleL.setFont(new Font("Minecraft", Font.BOLD, 50));
		titleL.setBounds(10, 5, 250, 60);
		
		// input "Background Music" section title
		bgmL = new JLabel("Background Music");
		bgmL.setFont(new Font("Minecraft", Font.BOLD, 24));
		bgmL.setBounds(10, 70, 400, 30);
		
		// make background music panel to hold all four musics
		bgmP = new JPanel();
		bgmP.setBackground(Global.backgroundColor);
		bgmP.setBounds(10, 100, 500, 30);
		bgmP.setLayout(new FlowLayout(FlowLayout.LEADING,5,0));
		
		// read text file to enable the playing song's corresponding radio button
		try {
			BufferedReader reader = new BufferedReader(new FileReader("audio/bgm.txt"));
			isPlaying = reader.readLine();
			reader.close();
			}
			catch (IOException err) {
				System.out.println("Error reading file audio/bgm.txt");
			}
		isPlayingIndex = new boolean [4];
		Arrays.fill(isPlayingIndex, false);
		
		if (isPlaying.equals("audio/Minecraft.wav")) {
			isPlayingIndex[0] = true;
		}
		else if (isPlaying.equals("audio/The Merchant.wav")) {
			isPlayingIndex[1] = true;
		}
		else if (isPlaying.equals("audio/Hornet.wav")) {
			isPlayingIndex[2] = true;
		}
		else if (isPlaying.equals("audio/Cold Night.wav")) {
			isPlayingIndex[3] = true;
		}
		
		// set the radio buttons 
		bgmB1 = new JRadioButton("Minecraft", isPlayingIndex[0]);
		bgmB1.setBackground(Global.backgroundColor);
		bgmB1.setFont(new Font("Minecraft", Font.PLAIN, 15));
		bgmB1.setFocusable(false);
		bgmB2 = new JRadioButton("The Merchant", isPlayingIndex[1]);
		bgmB2.setBackground(Global.backgroundColor);
		bgmB2.setFont(new Font("Minecraft", Font.PLAIN, 15));
		bgmB2.setFocusable(false);
		bgmB3 = new JRadioButton("Hornet", isPlayingIndex[2]);
		bgmB3.setBackground(Global.backgroundColor);
		bgmB3.setFont(new Font("Minecraft", Font.PLAIN, 15));
		bgmB3.setFocusable(false);
		bgmB4 = new JRadioButton("Cold Night", isPlayingIndex[3]);
		bgmB4.setBackground(Global.backgroundColor);
		bgmB4.setFont(new Font("Minecraft", Font.PLAIN, 15));
		bgmB4.setFocusable(false);
		bgmBG = new ButtonGroup(); // make a button group to hold the buttons
		// add all the buttons into the button group
		bgmBG.add(bgmB1);
		bgmBG.add(bgmB2);
		bgmBG.add(bgmB3);
		bgmBG.add(bgmB4);
		// sub all the buttons in the button panel
		bgmP.add(bgmB1);
		bgmP.add(bgmB2);
		bgmP.add(bgmB3);
		bgmP.add(bgmB4);
		
		// control panel which holds the four functionalities for operating the background music
		controlP = new JPanel();
		controlP.setBackground(Global.backgroundColor);
		controlP.setBounds(10, 130, 450, 30);
		controlP.setLayout(new FlowLayout(FlowLayout.LEADING,5,0));
		
		// button that confirms to change the song
		confirmB = new JButton("Confirm");
		confirmB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		confirmB.setFocusable(false);
		confirmB.addActionListener(this);
		// button to stop the playing song
		stopB = new JButton("Stop");
		stopB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		stopB.setFocusable(false);
		stopB.addActionListener(this);
		// button to continue the stopped song
		continueB = new JButton("Continue");
		continueB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		continueB.setFocusable(false);
		continueB.setEnabled(false);
		continueB.addActionListener(this);
		// button to restart the song
		restartB = new JButton("Restart");
		restartB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		restartB.setFocusable(false);
		restartB.addActionListener(this);
		// sub four control buttons into control panel
		controlP.add(confirmB);
		controlP.add(stopB);
		controlP.add(continueB);
		controlP.add(restartB);
		
		// input "Background Color" section title
		bgcL = new JLabel("Background Color");
		bgcL.setFont(new Font("Minecraft", Font.BOLD, 24));
		bgcL.setBounds(10, 185, 400, 30);
		
		// change background color button
		changeBgcB = new JButton("Change Background Color");
		changeBgcB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		changeBgcB.setFocusable(false);
		changeBgcB.setBounds(15, 220, 240, 35);
		changeBgcB.addActionListener(this);
		
		// button to quit setting page
		backB = new JButton("Back");
		backB.setFont(new Font("Minecraft", Font.PLAIN, 15));
		backB.setFocusable(false);
		backB.setBounds(370, 260, 100, 35);
		backB.addActionListener(this);
		
		// add all components to the frame
		this.add(titleL);
		this.add(bgmL);
		this.add(bgmP);
		this.add(controlP);
		this.add(bgcL);
		this.add(backB);
		this.add(changeBgcB);
		this.getContentPane().setBackground(Global.backgroundColor);
		this.setVisible(true);
	}

	// all action input 
	public void actionPerformed(ActionEvent e){
		// dispose frame if clicked back button
		if(e.getSource() == backB) {
			try {
				new TitlePage();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}
		
		// change song if clicked confirm button
		if(e.getSource() == confirmB) {
			if(bgmB1.isSelected()) {
				try {
					Global.restartMusic("audio/Minecraft.wav");
				} 
				catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}
			}
			if (bgmB2.isSelected()){
					try {
						Global.restartMusic("audio/The Merchant.wav");
					} 
					catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					}
				}
			if (bgmB3.isSelected()){
				try {
					Global.restartMusic("audio/Hornet.wav");
				} 
				catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}
			}
			if (bgmB4.isSelected()){
				try {
					Global.restartMusic("audio/Cold Night.wav");
				} 
				catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}
			}
			
			// also change the song in the corresponding text file so the decision will be remembered
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("audio/bgm.txt"));
				if(bgmB1.isSelected()) {
					writer.write("audio/Minecraft.wav");
				}
				if (bgmB2.isSelected()){
					writer.write("audio/The Merchant.wav");
				}
				if (bgmB3.isSelected()){
					writer.write("audio/Hornet.wav");
				}
				if (bgmB4.isSelected()){
					writer.write("audio/Cold Night.wav");
				}
				writer.close();
			}
			catch (IOException err) {
				System.out.print("Error reading file audio/bgm.txt");
			}
		}
		
		// stop song if stop button is clicked
		if (e.getSource() == stopB) {
			timePosition = Global.clip.getMicrosecondPosition();
			Global.clip.stop();
			continueB.setEnabled(true);
		}
		
		// continue the stopped song if continue button is clicked
		if (e.getSource() == continueB) {
			Global.clip.setMicrosecondPosition(timePosition);
			Global.clip.start();
			continueB.setEnabled(false);
		}
		
		// restart the song if the restart button is clicked
		if (e.getSource() == restartB) {
			Global.clip.setMicrosecondPosition(0);
			Global.clip.start();
		}
		
		// output color chooser if the change background color button is clicked
		if (e.getSource() == changeBgcB) {
			colorChooser = new JColorChooser();
			Global.backgroundColor = JColorChooser.showDialog(null, "Pick a Color", Global.backgroundColor);
			new SettingPage();
			this.dispose();
		}
	}
}
