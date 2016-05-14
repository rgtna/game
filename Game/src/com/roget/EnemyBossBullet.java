package com.roget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5)+ -5);
		velY = 4f;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.08f, handler));
		kill();
	}
	
	public void kill()
	{
		if(this.getY() > Game.HEIGHT || this.getX() > Game.WIDTH)
		{
			handler.removeObject(this);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
