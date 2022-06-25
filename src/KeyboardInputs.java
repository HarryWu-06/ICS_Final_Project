import java.awt.event.*;

/**
 * This class is for receiving all the input from the keyboard and give data to GamePanel.java to control the character
 * @author Harry Wu
 * @version final
 */

public class KeyboardInputs implements KeyListener{
	// initializing variables
	private GamePanel gamePanel;
	
	/**
	 * this method connects the gamePanel and the keyboardInput together, it is used in the Game.java when combining all game related classes
	 * @param gamePanel the class that contains all the components of the character, including the characters
	 */
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	/**
	 * This method gives output for pressed keys
	 * @param e the component to get key inputs
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A: // running left
			Global.playerAction = Global.RUNL;
			Global.isRight = false;
			gamePanel.changeXMove(-10);
			break;
		case KeyEvent.VK_D: // running right
			gamePanel.changeXMove(10);
			Global.playerAction = Global.RUNR;
			Global.isRight = true;
			break;
		case KeyEvent.VK_J: // attacking
			if (Global.isRight == true)
				Global.playerAction = Global.ATTACKR;
			else
				Global.playerAction = Global.ATTACKL;
			break;
		case KeyEvent.VK_K: // jumpping
			Global.jump = true;
			if (Global.isRight == true)
				Global.playerAction = Global.JUMPR;
			else
				Global.playerAction = Global.JUMPL;
			break;
		default: // stand if no action is done
			if (Global.isRight == true)
				Global.playerAction = Global.STANDR;
			else
				Global.playerAction = Global.STANDL;
			break;
		}	
	}
	
	/**
	 * This method gives output for released keys, making the character to stand after releasing any key
	 * @param e the component to get key inputs
	 */
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
		case KeyEvent.VK_J:
		case KeyEvent.VK_K:
		default:
			if (Global.isRight == true)
				Global.playerAction = Global.STANDR;
			else
				Global.playerAction = Global.STANDL;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}