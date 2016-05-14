package com.roget;

import java.awt.Graphics;

public class BossBattle {
	
	private EnemyBoss enemyBoss;
	private Handler handler;
	private HUD hud;
	
	private int x = (int) enemyBoss.getX();
	private int y = (int) enemyBoss.getY();
	
	public BossBattle()
	{
		new EnemyBoss(x, y, ID.EnemyBoss, handler);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		hud.render(g);
	}
}
