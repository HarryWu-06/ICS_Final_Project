import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;
import javax.sound.sampled.*;

public class Main{
	
	public static void main(String [] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		new TitlePage();
		
		try {
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font/Minecraft.ttf")).deriveFont(12f);
		     ge.registerFont(font);
		} catch (IOException|FontFormatException e) {
			System.out.println("Error reading ttf file");
		}
		
		String musicInput = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("audio/bgm.txt"));
			musicInput = reader.readLine();
			reader.close();
			}
		catch (IOException err) {
			System.out.println("Error reading file bgm.txt");
		}
		
		SettingPage.playMusic(musicInput);
	}
}