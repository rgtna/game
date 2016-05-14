package com.roget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	private HUD hud = new HUD();
	
	private boolean isMoving = false;
	
	private int timesvely = -1;
	private int timesvelx = -1;
	
	private int timer = 100;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2.5f;
		velY = 2.5f;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= timesvely;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= timesvelx;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
		if(hud.getLevel() == 10)
		{
			int red = 255;
			for(int i = 0; i < timer; i++)
			{
				g.setColor(new Color(red -= 5, 0, 0));
			}
		}
	}
	
}
