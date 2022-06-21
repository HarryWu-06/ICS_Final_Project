/**
 * This class combines the game page(frame) and the game panel(drawing).
 * it also has a FPS counter and game loop to make the game flow smooth
 * @author Harry Wu
 *
 */

public class Game implements Runnable{
	// initialize the components
	private GamePage gamePage;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS = 120;
	
	public Game() {
		gamePanel = new GamePanel();
		gamePage = new GamePage(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	/**
	 * An game loop cited from YouTube
	 * RyiSnow. (2021, October 9). Game loop and key input - how to make a 2D game in java #2. 
	 * YouTube. Retrieved June 7, 2022, from https://www.youtube.com/watch?v=VpH33Uw-_0E 
	 */
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	} 
	
	/**
	 * The same game loop cited from YouTube
	 * RyiSnow. (2021, October 9). Game loop and key input - how to make a 2D game in java #2. 
	 * YouTube. Retrieved June 7, 2022, from https://www.youtube.com/watch?v=VpH33Uw-_0E 
	 */
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		int frames = 0;
		long lastCheck = System.currentTimeMillis();;
		
		while(true) {
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			
			//FPS counter
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
	}
}
