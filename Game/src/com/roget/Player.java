package com.roget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	PlaySound ps = new PlaySound();
	
	private int hit = 0;
	private boolean inCollide = false;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y , 32 , 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 54);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.15f, handler));
		
		collision();
	}
	
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
					//inCollide = true;
					//hit += 1;
					//if(hit == 1 && inCollide == true){
						try {
							ps.playSoundHurt();
						} catch (IOException e) {
						e.printStackTrace();
						}
					//}
				}
				/*if(getBounds().intersects(tempObject.getBounds()) == false){
					inCollide = false;
					hit = 0;
				}*/
				//HUD.HEALTH -= 2;
				//hi
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	
	

}
