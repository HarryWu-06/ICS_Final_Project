import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main{
	public static void main(String [] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		new TitlePage();
		playMusic("audios/The Merchant.wav");
	}
	
	public static void playMusic(String musicLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		File file = new File(musicLocation);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);

		clip.start();
	}
}