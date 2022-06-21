import java.awt.event.*;

/**
 * This class is for receiving all the input from the keyboard and give data to GamePanel.java to control the game
 * @author Harry Wu
 * @version 2022-06
 */

public class KeyboardInputs implements KeyListener{
	
	// 
	private GamePanel gamePanel;
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.changeYMove(-10);
			break;
		case KeyEvent.VK_A:
			gamePanel.changeXMove(-10);
			break;
		case KeyEvent.VK_S:
			gamePanel.changeYMove(10);
			break;
		case KeyEvent.VK_D:
			gamePanel.changeXMove(10);
			break;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
