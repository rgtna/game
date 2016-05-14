package com.roget;

import java.util.Scanner;

public class CommandLine {
	
	Scanner in = new Scanner(System.in);
	private int X;
	private int Y;
	
	public CommandLine()
	{

	}
	
	public void getCommand(Scanner in, int X, int Y, BasicEnemy bm, FastEnemy fm, SmartEnemy sm)
	{
		this.X = X;
		this.Y = Y;
		
		if(in.nextLine() == "/set BasicEnemy speed " + X + " " + Y)
		{
			increaseSpeed_BasicEnemy(bm, X, Y);
		} else if(in.nextLine() == "/set FastEnemy speed" + X + " " + Y) {
			increaseSpeed_FastEnemy(fm, X, Y);
		} else if(in.nextLine() == "/set SmartEnemy speed" + X + " " + Y) {
			increaseSpeed_SmartEnemy(sm, X, Y);
		}
			
	}
	
	private void increaseSpeed_BasicEnemy(BasicEnemy bm, int X, int Y)
	{
		bm.setVelX(X);
		bm.setVelY(Y);
	}
	
	private void increaseSpeed_FastEnemy(FastEnemy fm, int X, int Y)
	{
		fm.setVelX(X);
		fm.setVelY(Y);
	}
	
	private void increaseSpeed_SmartEnemy(SmartEnemy sm, int X, int Y)
	{
		sm.setVelX(X);
		sm.setVelY(Y);
	}
	
	private void increaseSpeed_Player(Player p, int X, int Y)
	{
		p.setVelX(X);
		p.setVelY(Y);
	}
	
	private void deleteEnemy()
	{
		
	}
}
