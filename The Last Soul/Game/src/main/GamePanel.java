package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel{
	
	private double xMove = 0;
	private double yMove = 0;
	private double xSpeed = 60;
	private double ySpeed = 60;
	
	private Color color = new Color(0, 0, 0);
	private Random random;
	
	public GamePanel() {
		addKeyListener(new KeyboardInputs(this));
		random =new Random();
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
		g.setColor(color);
		g.fillRect((int)xMove, (int)yMove, 100, 100);
	}

	public void moveUpdate() {
		xMove += xSpeed;
		if(xMove >= 690 || xMove <= 0) {
			xSpeed *= -1;
			color = getRanColor();
		}
		
		yMove += ySpeed;
		if(yMove >= 465 || yMove <= 0) {
			ySpeed *= -1;
			color = getRanColor();
		}
	}

	private Color getRanColor() {
		int r = random.nextInt(255);
		int b = random.nextInt(255);
		int g = random.nextInt(255);
				
		return new Color(r, b, g);
	}
}
