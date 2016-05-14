package com.roget;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5260178954964008893L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12* 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Buy buy;
	
	public int frames;
	
	/*public enum STATE 
	{
		Menu,
		Boss,
		Game,
		Help,
		Buy,
	};*/
	
	public STATE gameState = STATE.Menu;
	
	public Game()
	{
		handler = new Handler();
		menu = new Menu(this, handler);
		buy = new Buy();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Game", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		r = new Random();

		if(gameState == STATE.Game)
		{
			
		} else if (gameState == STATE.Menu) {
			for(int i = 0; i <= 10; i++)
			{
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Particle, handler));				
			}
		}
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 80.0; //Changed from 60 to 80
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		this.frames = 0;
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			
			if(running)
			{
				render();
			}
			
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		
		//Controls game states...
		if(gameState == STATE.Game || gameState == STATE.Boss)
		{
			handler.tick();
			hud.tick();
			spawner.tick();
		} else if(gameState == STATE.Menu || gameState == STATE.Help) {// Will display menu or help menu if this is the state of the game.
			handler.tick();
			menu.tick();
		} else if(gameState == STATE.Buy) {
			buy.tick();
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		if(gameState == STATE.Game || gameState == STATE.Boss)
		{
			handler.render(g);
			hud.render(g);
			g.drawString("FPS: " + frames, 578, 450);
		} else if(gameState == STATE.Menu || gameState == STATE.Help) {
			handler.render(g);
			menu.render(g);
		} else if(gameState == STATE.Buy){
			buy.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max)
	{
		if(var  >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String[] args) 
	{
		new Game();
	}
}
