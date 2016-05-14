package com.roget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler)
	{
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState != STATE.Game)
		{
			if(mouseOver(mx, my, 220, 100, 200, 64))
			{
				game.gameState = STATE.Game;
				handler.addObject(new Player(game.WIDTH/2-32, game.HEIGHT/2-32,ID.Player, handler));
				handler.clearEnemies();
				// Enemies
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				handler.addObject(new Coin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Coin, handler));
			}
			
			// Help Button
			if(mouseOver(mx, my, 220, 200, 200, 64))
			{
				game.gameState = STATE.Help;
				
			}
			
			// Back button for help
			if(mouseOver(mx, my, 35, 360, 200, 64))
			{
				game.gameState = STATE.Menu;
				
			}
			
			// Exit Button
			if(mouseOver(mx, my, 220, 300, 200, 64))
			{
				System.exit(1);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		// If Mouse X is > X, and Mouse X is < X + the width of the rectangle -- X being the position of rectangle
		if(mx > x && mx < x + width)
		{
			// If Mouse Y is > Y, and Mouse Y is < Y + the width of the rectangle -- Y being the position of rectangle
			if(my > y && my < y + height)
			{
				/*
				 * We are checking if the mouse is within these parameters... in this case the rectangle
				 */
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(game.gameState == STATE.Menu)
		{
			Font fnt = new Font("arial", 1 , 50);
			Font fnt2 = new Font("arial", 1 , 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("BULLET HELL", 155, 70);
			
			// Make menu buttons
			
			g.setFont(fnt2);
			
			g.setColor(Color.WHITE);
			g.drawRect(220, 100, 200, 64);
			g.drawString("Play", 290, 140);
			
			g.setColor(Color.WHITE);
			g.drawRect(220, 200, 200, 64);
			g.drawString("Help", 290, 243);
			
			g.setColor(Color.WHITE);
			g.drawRect(220, 300, 200, 64);
			g.drawString("Quit", 290, 343);
			
		} else if(game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1 , 50);
			Font fnt2 = new Font("arial", 1 , 30);
			Font fnt3 = new Font("Helvetica Neue", 1, 11);
			
			System.out.println("IT WORKS");
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 255, 70);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("WHY ARE YOU HERE GET OUT GO BACK SHOO. THERE IS NOTHING TO BE HELPED WITH YOUR WELCOME BYE", 25, 100);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawRect(35, 360, 200, 64);
			g.drawString("Back", 99, 403);
		}
		
		
	}
}
