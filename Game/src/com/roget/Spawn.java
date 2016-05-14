package com.roget;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	//private Game game = new Game();
	
	// Keeps score, each tick it increases and adds to the HUD's score
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		scoreKeep++;
		
		if(scoreKeep >= 100)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			randomCoins();
			
			if(hud.getLevel() == 2)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
			} else if (hud.getLevel() == 15) {
				handler.clearEnemies();
				handler.addObject(new EnemyBoss((Game.WIDTH /2) - 69, -120, ID.EnemyBoss, handler));
			} else if (hud.getLevel() == 30) {
				handler.clearEnemies();
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
		}
	}
	
	private void randomCoins()
	{
		int v = r.nextInt(4);
		int s = r.nextInt(2);
		
		for(int i = 0; i < v; i++)
		{
			handler.addObject(new Coin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Coin, handler));
		}
	}
}
