import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * this class contains all the components of the character, including the characters
 * 
 * @author Harry Wu
 * @version final
 */
public class GamePanel extends JPanel{
	// initialize the components
	private double charX = 20; // start of character
	private double charY = 485;
	private int jumpCount = 1;
	
	private BufferedImage runR, runL, jumpR, jumpL, attackR, attackL, hurtR, hurtL, standR, standL, background;
	private BufferedImage [][] animation;
	private int tickA, indexA;
	private int speedA = 10; // speed of image change
	
	public GamePanel() {
		addKeyListener(new KeyboardInputs(this));
		this.setPreferredSize(new Dimension(Global.GAME_WIDTH, Global.GAME_HEIGHT));
		readImg();
		loadImg();
	}
	
	/**
	 * method to read all the movements and background from folder "images"
	 */
	private void readImg() {
		try {
			runR = ImageIO.read(new File("images/runR.png"));
			runL = ImageIO.read(new File("images/runL.png"));
			jumpR = ImageIO.read(new File("images/jumpR.png"));
			jumpL = ImageIO.read(new File("images/jumpL.png")); 
			attackR = ImageIO.read(new File("images/attackR.png"));
			attackL = ImageIO.read(new File("images/attackL.png")); 
			hurtR = ImageIO.read(new File("images/hurtR.png"));
			hurtL = ImageIO.read(new File("images/hurtL.png"));
			standR = ImageIO.read(new File("images/standR.png"));
			standL = ImageIO.read(new File("images/standL.png"));
			background = ImageIO.read(new File("images/gameBG2.gif"));
		} catch (Exception e) {
			System.out.print("Error" + e);
		}
	}
	
	/**
	 *  method that puts all the movements into a 2d array
	 */
	private void loadImg() {
		animation = new BufferedImage[10][5];
		animation[0][0] = runR.getSubimage(0,0,128,128);
		animation[0][1] = runR.getSubimage(128,0,128,128);
		animation[0][2] = runR.getSubimage(256,0,128,128);
		animation[0][3] = runR.getSubimage(384,0,128,128);
		animation[0][4] = runR.getSubimage(512,0,128,128);
		animation[1][0] = runL.getSubimage(0,0,128,128);
		animation[1][1] = runL.getSubimage(128,0,128,128);
		animation[1][2] = runL.getSubimage(256,0,128,128);
		animation[1][3] = runL.getSubimage(384,0,128,128);
		animation[1][4] = runL.getSubimage(512,0,128,128);
		animation[2][0] = jumpR.getSubimage(0,0,128,128);
		animation[2][1] = jumpR.getSubimage(128,0,128,128);
		animation[2][2] = jumpR.getSubimage(128,0,128,128);
		animation[2][3] = jumpR.getSubimage(256,0,128,128);
		animation[3][0] = jumpL.getSubimage(0,0,128,128);
		animation[3][1] = jumpL.getSubimage(128,0,128,128);
		animation[3][2] = jumpL.getSubimage(128,0,128,128);
		animation[3][3] = jumpL.getSubimage(256,0,128,128);
		animation[4][0] = attackR.getSubimage(3,0,128,160);
		animation[4][1] = attackR.getSubimage(135,0,128,160);
		animation[4][2] = attackR.getSubimage(267,2,128,158);
		animation[4][3] = attackR.getSubimage(377,3,160,157);
		animation[4][4] = attackR.getSubimage(507,3,122,157);
		animation[5][4] = attackL.getSubimage(0,0,128,160);
		animation[5][3] = attackL.getSubimage(140,0,128,160);
		animation[5][2] = attackL.getSubimage(270,0,128,160);
		animation[5][1] = attackL.getSubimage(380,0,160,160);
		animation[5][0] = attackL.getSubimage(512,0,127,160);
		animation[6][0] = hurtR.getSubimage(0,0,128,128);
		animation[7][0] = hurtL.getSubimage(0,0,128,128);
		animation[8][0] = standR.getSubimage(0,0,128,128);
		animation[9][0] = standL.getSubimage(0,0,128,128);
	}
	
	/**
	 * An picture loop cited from YouTube
	 * Kaarin Gaming. (2022, January 31). IMAGES - Episode #04 - Platformer Tutorial Java. YouTube. Retrieved June 24, 2022, from
	 * https://www.youtube.com/watch?v=BT2jm74lLlg&list=PL4rzdwizLaxYmltJQRjq18a9gsSyEQQ-0&index=5
	 */
	private void update() {
		tickA++; 
		if(tickA >= speedA) {
			tickA = 0;
			indexA++;
			if (indexA >= Global.getSpriteNum(Global.playerAction)) {indexA = 0;}
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
	 * paint the name and the movement of character
	 * @param g component that draw pictures and strings
	 */
	public void paintComponent(Graphics g) {
		if (charX < -10) {charX = -10;}// add collision to the character and the left side of screen
		
		super.paintComponent(g);
		update(); // update frame
		
		// input the background
		g.drawImage(background, 0, 0, Global.GAME_WIDTH, Global.GAME_HEIGHT, null);
		
		// set attributes of name
		g.setFont(new Font("Minecraft", Font.BOLD, 14));
		g.setColor(Color.cyan);
		
		// draw character movement
		if (Global.jump == true) { // jump
			if (Global.isRight)
				charX += 10;
			else 
				charX -= 10;
			if (jumpCount <= 10) {
				charY -= 7;
			}
			else if (jumpCount < 20) {
				charY += 7;
			}
			else {
				jumpCount = 1;
				Global.jump = false;
			}
			jumpCount++;
		}
		if (Global.playerAction == Global.ATTACKL || Global.playerAction == Global.ATTACKR) { // attack
			g.drawImage(animation[Global.playerAction][indexA], (int)charX, (int)charY-30, null);
			g.drawString(Global.charName, (int)charX+50, (int)charY); // print name
		}
		else { // other
			g.drawImage(animation[Global.playerAction][indexA], (int)charX, (int)charY, null);
			g.drawString(Global.charName, (int)charX+50, (int)charY); // print name
		}
	}
}