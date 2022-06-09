package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel{
	
	private double xMove = 0;
	private double yMove = 0;
	private double xSpeed = 3;
	private double ySpeed = 3 ;
	public final int GAME_WIDTH = 960;
	public final int GAME_HEIGHT = 640;
	
	public GamePanel() {
		addKeyListener(new KeyboardInputs(this));
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
	}
	
	public void changeXMove(int move) {
		this.xMove += move;
	}
	
	public void changeYMove(int move) {
		this.yMove += move;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		moveUpdate();
		g.setColor(new Color(255, 0, 0));
		g.fillRect((int)xMove, (int)yMove, 100, 100);
	}

	public void moveUpdate() {
		xMove += xSpeed;
		if(xMove >= GAME_WIDTH-100 || xMove <= 0) {
			xSpeed *= -1;
		}
		
		yMove += ySpeed;
		if(yMove >= GAME_HEIGHT-100 || yMove <= 0) {
			ySpeed *= -1;
		}
	}

}
