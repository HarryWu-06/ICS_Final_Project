import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class SettingPage extends JFrame implements ActionListener{
	ImageIcon gameIcon;
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	JLabel titleL, bgmL;
	JPanel bgmP;
	JRadioButton bgmB1, bgmB2, bgmB3;
	JButton backB;
	ButtonGroup bgmBG;
	
	public SettingPage() {
		gameIcon = new ImageIcon("images/gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("Setting");
		this.setSize(500, 350);	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		titleL = new JLabel("Settings");
		titleL.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		titleL.setBounds(10, 0, 250, 60);
		bgmL = new JLabel("Background Music");
		bgmL.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bgmL.setBounds(10, 60, 200, 30);
		
		bgmP = new JPanel();
		bgmP.setBackground(Color.pink);
		bgmP.setBounds(10, 90, 450, 30);
		bgmP.setLayout(new FlowLayout(FlowLayout.LEADING,5,0));
		bgmB1 = new JRadioButton("Minecraft", true);
		bgmB1.setBackground(Color.pink);
		bgmB1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bgmB1.setFocusable(false);
		bgmB2 = new JRadioButton("The Merchant");
		bgmB2.setBackground(Color.pink);
		bgmB2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bgmB2.setFocusable(false);
		bgmB3 = new JRadioButton("BGM3");
		bgmB3.setBackground(Color.pink);
		bgmB3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bgmB3.setFocusable(false);
		bgmBG = new ButtonGroup();
		bgmBG.add(bgmB1);
		bgmBG.add(bgmB2);
		bgmBG.add(bgmB3);
		bgmP.add(bgmB1);
		bgmP.add(bgmB2);
		bgmP.add(bgmB3);
		
		backB = new JButton("Back");
		backB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backB.setFocusable(false);
		backB.setBounds(370, 260, 100, 35);
		backB.addActionListener(this);
		
		this.add(titleL);
		this.add(bgmL);
		this.add(bgmP);
		this.add(backB);
		this.getContentPane().setBackground(Color.pink);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == backB) {
			this.dispose();
		}
	}


}