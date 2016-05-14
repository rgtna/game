package com.roget;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	
	private float greenValue = 255f;
	
	private int score = 0;
	private int level = 1;
	
	private Handler handler;
	
	private int coins = 0;
	
	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0f, 100f);
		greenValue = Game.clamp(greenValue, 0f, 255f);
		
		//Increase score
		score++;
		//addCoin();
		greenValue = HEALTH*2;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		//Display score and level
		g.drawString("Score: " + score, 10, 64);
		g.drawString("Level: " + level, 10, 80);
		g.drawString("ALPHA Ver. 0.1.3", 7, 445);
		
		//Developer options
		//g.drawString("Dev: cmd + esc to exit game...", 50, 60);
	}
	
	public void score(int score)
	{
		this.score = score;
	}
	
	public int score()
	{
		return score;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
}
