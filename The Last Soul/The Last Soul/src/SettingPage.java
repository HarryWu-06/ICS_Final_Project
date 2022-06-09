import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class SettingPage implements ActionListener{
	ImageIcon gameIcon;
	JFrame settingPageF;
	
	SettingPage(){
		
		settingPageF = new JFrame();
		
		gameIcon = new ImageIcon("images\\gameIcon.png");
		settingPageF.setIconImage(gameIcon.getImage());
		
		settingPageF.setTitle("Setting");
		settingPageF.setSize(400, 300);
		settingPageF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settingPageF.setLocationRelativeTo(null);
		settingPageF.setResizable(false);
		settingPageF.setLayout(null);
		settingPageF.getContentPane().setBackground(Color.pink);
		
		settingPageF.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
