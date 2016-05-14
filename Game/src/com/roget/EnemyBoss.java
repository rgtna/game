package com.roget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
	
	private Handler handler;
	
	private int timer = 80;
	private int timer2 = 20; //Changed from 50 to 20
	
	Random r = new Random();
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 150, 150);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 150) velX *= -1;

		if(timer <= 0){
			velY = 0;
		} else timer--;
		
		if(timer <= 0) timer2 --;
		if(timer2 <= 0) 
		{
			if(velX == 0) velX = 5;
			int spawn = r.nextInt(5);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
		}
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 150, 150, 0.1f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
