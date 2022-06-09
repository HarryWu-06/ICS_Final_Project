/**
 * 
 */
package main;

public class Game implements Runnable{
	private GameFrame gameFrame;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS = 120;
	
	public Game() {
		gamePanel = new GamePanel();
		gameFrame = new GameFrame(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	/**
	 * This is an game loop cited from YouTube
	 * RyiSnow. (2021, October 9). Game loop and key input - how to make a 2D game in java #2. 
	 * YouTube. Retrieved June 7, 2022, from https://www.youtube.com/watch?v=VpH33Uw-_0E 
	 */
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	} 
	
	/**
	 * Same as startGameLoop(), this is the game loop cited from YouTube
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
