import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;
import javax.sound.sampled.*;

/**
 * This is the main method that the computer will open at first
 * @author Harry Wu
 * @version final
 *
 */
public class Main{
	
	public static void main(String [] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		new TitlePage(); // Start the game
		
		try { // add in custom font - mincraft.ttf
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font/Minecraft.ttf")).deriveFont(12f);
		     ge.registerFont(font);
		} catch (IOException|FontFormatException e) {
			System.out.println("Error reading ttf file");
		}
		
		String musicInput = null;
		try { // load the music
			BufferedReader reader = new BufferedReader(new FileReader("audio/bgm.txt"));
			musicInput = reader.readLine();
			reader.close();
			}
		catch (IOException err) {
			System.out.println("Error reading file bgm.txt");
		}
		
		// play the music
		File file = new File(musicInput);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Global.clip = AudioSystem.getClip();
		Global.clip.open(audioStream);

		Global.clip.start();
		Global.clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
}