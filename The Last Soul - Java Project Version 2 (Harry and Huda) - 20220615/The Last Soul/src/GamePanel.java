import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * this class contain all the components of the game, including the character the background the enemies.
 * 
 * @author Harry Wu
 *
 */
public class GamePanel extends JPanel implements ActionListener{
	// initialize the components
	public static final int GAME_WIDTH = 960;
	public static final int GAME_HEIGHT = 640;
	private double charX = GAME_WIDTH/2; // start of character
	private double charY = GAME_HEIGHT/2;
	private double xSpeed = 0; // speed of character
	private double ySpeed = 0 ;
	
	private BufferedImage runR_O, runL_O, jumpR_O, jumpL_O, attackR_O, attackL_O, hurt_O, stand_O;// O for original
	private BufferedImage [][] animationOrigin;
	private int tickA, indexA;
	private int speedA = 10;
	JButton backB;
	
	public GamePanel() {
		addKeyListener(new KeyboardInputs(this));
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		readImg();
		loadImg();
		
		backB = new JButton("Back");
		backB.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		backB.setFocusable(false);
		backB.setBounds(810, 570, 100, 45);
		backB.addActionListener(this);
		
		this.add(backB);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backB) {
			new TitlePage();
		}
		
	}
	/**
	 * load images
	 */
	private void readImg() {
		try {
			runR_O = ImageIO.read(new File("images/runR.png"));
			runL_O = ImageIO.read(new File("images/runL.png"));
			jumpR_O = ImageIO.read(new File("images/jumpR.png"));
			jumpL_O = ImageIO.read(new File("images/jumpL.png")); 
			attackR_O = ImageIO.read(new File("images/attackR.png"));
			attackL_O = ImageIO.read(new File("images/attackL.png")); 
			hurt_O = ImageIO.read(new File("images/hurt.png")); 
			stand_O = ImageIO.read(new File("images/stand.png"));
		} catch (Exception e) {
			System.out.print("Error" + e);
		}
	}
	
	private void loadImg() {
		animationOrigin = new BufferedImage[8][5];
		animationOrigin[0][0] = runR_O.getSubimage(0,0,128,128);
		animationOrigin[0][1] = runR_O.getSubimage(128,0,128,128);
		animationOrigin[0][2] = runR_O.getSubimage(256,0,128,128);
		animationOrigin[0][3] = runR_O.getSubimage(384,0,128,128);
		animationOrigin[0][4] = runR_O.getSubimage(512,0,128,128);
		animationOrigin[1][0] = runL_O.getSubimage(0,0,128,128);
		animationOrigin[1][1] = runL_O.getSubimage(128,0,128,128);
		animationOrigin[1][2] = runL_O.getSubimage(256,0,128,128);
		animationOrigin[1][3] = runL_O.getSubimage(384,0,128,128);
		animationOrigin[1][4] = runL_O.getSubimage(512,0,128,128);
		animationOrigin[2][0] = jumpR_O.getSubimage(0,0,128,128);
		animationOrigin[2][1] = jumpR_O.getSubimage(128,0,128,128);
		animationOrigin[2][2] = jumpR_O.getSubimage(256,0,128,128);
		animationOrigin[3][0] = jumpL_O.getSubimage(0,0,128,128);
		animationOrigin[3][1] = jumpL_O.getSubimage(128,0,128,128);
		animationOrigin[3][2] = jumpL_O.getSubimage(256,0,128,128);
		animationOrigin[4][0] = attackR_O.getSubimage(0,0,128,160);
		animationOrigin[4][1] = attackR_O.getSubimage(140,0,128,160);
		animationOrigin[4][2] = attackR_O.getSubimage(270,0,128,160);
		animationOrigin[4][3] = attackR_O.getSubimage(380,0,160,160);
		animationOrigin[4][4] = attackR_O.getSubimage(512,0,127,160);
		animationOrigin[5][0] = attackL_O.getSubimage(0,0,128,160);
		animationOrigin[5][1] = attackL_O.getSubimage(140,0,128,160);
		animationOrigin[5][2] = attackL_O.getSubimage(270,0,128,160);
		animationOrigin[5][3] = attackL_O.getSubimage(380,0,160,160);
		animationOrigin[5][4] = attackL_O.getSubimage(512,0,127,160);
		animationOrigin[6][0] = hurt_O.getSubimage(0,0,128,128);
		animationOrigin[6][1] = hurt_O.getSubimage(128,0,128,128);
		animationOrigin[7][0] = stand_O.getSubimage(0,0,128,128);
		animationOrigin[7][1] = stand_O.getSubimage(128,0,128,128);

		
	}
	
	private void update() {
		tickA++; 
		if(tickA >= speedA) {
			tickA = 0;
			indexA++;
			if (indexA >= animationOrigin[0].length) {indexA = 0;}
		}
	}
	
	/**
	 * change the character place in x-axis
	 * @param move the amount of pixel movement 
	 */
	public void changeXMove(int move) {
		this.charX += move;
	}
	
	/**
	 * change the character place in y-axis
	 * @param move the amount of pixel movement 
	 */
	public void changeYMove(int move) {
		this.charY += move;
	}
	
	/**
	 * draw images
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		update();
		g.drawImage(animationOrigin[0][indexA], (int)charX, (int)charY, null);
		
	}

}
