 import java.awt.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This is the Global class which holds most of the static variables and methods
 * @author Harry Wu
 * @version final
 *
 */
public class Global {
	// width and height of the frames, except the setting page
	public static final int GAME_WIDTH = 960;
	public static final int GAME_HEIGHT = 640;
	
	// background music
	static Clip clip;
	// background color
	static Color backgroundColor = new Color(150, 255, 150);
	
	// two movements that needs to record
	public static boolean isRight = true;
	public static boolean jump = false;
	
	// the name of character
	public static String charName;
	
	// characters current movement
	public static int playerAction = Global.STANDR;
	
	// different movements
	public static final int RUNR = 0;
	public static final int RUNL = 1;
	public static final int JUMPR = 2;
	public static final int JUMPL = 3;
	public static final int ATTACKR = 4;
	public static final int ATTACKL = 5;
	public static final int HURTR = 6;
	public static final int HURTL = 7;
	public static final int STANDR = 8;
	public static final int STANDL = 9;
	
	/**
	 * This method stops the playing music and starts a new one
	 * 
	 * @param musicLocation the path to the music
	 * @throws LineUnavailableException unable to read file
	 * @throws IOException unable to read file
	 * @throws UnsupportedAudioFileException unable to read file
	 */
	public static void restartMusic(String musicLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		clip.close();
		File file = new File(musicLocation);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);

		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * a method that return the number of sprite each movements have 
	 * @param action the movement
	 * @return the number of sprite
	 */
	public static int getSpriteNum(int action) {
		switch(action) {
		case RUNR:
			return 5;
		case RUNL:
			return 5;
		case JUMPR:
			return 3;
		case JUMPL:
			return 4;
		case ATTACKR:
			return 5;
		case ATTACKL:
			return 5;
		case HURTR:
			return 1;
		case HURTL:
			return 1;
		case STANDR:
			return 1;
		case STANDL:
			return 1;
		default:
			return 0;
		}
	} 
}
