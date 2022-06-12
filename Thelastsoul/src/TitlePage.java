import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitlePage extends JFrame implements ActionListener{
	ImageIcon gameIcon;
	JLabel titleL;
	JLabel authorL;
	JButton startB;
	JButton settingB;
	JButton exitB;
	
	public TitlePage() {
		gameIcon = new ImageIcon("images\\gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		this.setTitle("The Last Soul");
		this.setSize(960, 640);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		startB = new JButton("Start");
		startB.setFont(new Font("MV Boli", Font.BOLD, 36));
		startB.setBounds(500, 300, 250, 60);
		startB.setFocusable(false);
		startB.addActionListener(this);
		settingB = new JButton("Setting");
		settingB.setFont(new Font("MV Boli", Font.BOLD, 36));
		settingB.setBounds(500, 380, 250, 60);
		settingB.setFocusable(false);
		settingB.addActionListener(this);
		exitB = new JButton("Exit");
		exitB.setFont(new Font("MV Boli", Font.BOLD, 36));
		exitB.setBounds(500, 460, 250, 60);
		exitB.setFocusable(false);
		exitB.addActionListener(this);
		titleL = new JLabel("The Last Soul");
		titleL.setFont(new Font("MV Boli", Font.BOLD, 95));
		titleL.setBounds(50, 70, 700, 100);
		authorL = new JLabel("- Harry Wu & Huda Huda Hameed");
		authorL.setFont(new Font("MV Boli", Font.BOLD, 30));
		authorL.setBounds(80, 150, 700, 100);
		
		this.add(startB);
		this.add(settingB);
		this.add(exitB);
		this.add(titleL);
		this.add(authorL);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.pink);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startB) {
			new MenuPage();
			this.dispose();
		}
		else if(e.getSource() == settingB) {
			new SettingPage(); 
		}
		else if(e.getSource() == exitB) { 
			System.exit(0);
		}
	}
}
